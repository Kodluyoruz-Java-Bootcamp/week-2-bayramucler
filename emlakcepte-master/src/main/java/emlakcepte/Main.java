package emlakcepte;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import emlakcepte.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;

public class Main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		

		User userPelin = prepareUser("Pelin", "mimar.pelin@gmail.com", "Pelin123");
		User userSami = new User("Sami", "sami@gmail.com", "123", UserType.INDIVIDUAL, Collections.emptyList());
		User userBayram = new User("Bayram", "bayram@gmail.com", "1234", UserType.INDIVIDUAL, Collections.emptyList());
		User userSefa = new User("Sefa", "sefa@gmail.com", "12346", UserType.CORPARETE, Collections.emptyList());

	    UserService userService = UserService.getInstance();
		
		userService.createUser(userPelin);
		userService.createUser(userSami);

		userService.printAllUser();

		System.out.println("-----");

		Realty realty = new Realty(123L, "ZEKERİYAKÖY ' de 1200 M2 Satılık VİLLA", LocalDateTime.now(), userSami, RealtyType.ACTIVE, "İstanbul", "Zekeriyaköy", RealtyGroupType.HOUSE, RealtyCommercialType.SALE);
		Realty realty1 = new Realty(124L, "Büyükdere Ana Cadde üstünde 16.060 m2 kapalı alanlı PLAZA", LocalDateTime.now(), userSami, RealtyType.ACTIVE,"İstanbul","Zincirlikuyu", RealtyGroupType.WORKPLACE, RealtyCommercialType.SALE);
		Realty realty2 = new Realty(126L, "Çapa''da acil kiralık daire", LocalDateTime.now(), userBayram, RealtyType.ACTIVE,"İstanbul","Fatih", RealtyGroupType.HOUSE, RealtyCommercialType.RENT);
		Realty realty3 = new Realty(125L,"Akpınar MAHALLESİNDE 2+1 80 M2 ARAKAT İSKANLI", LocalDateTime.now(), userPelin, RealtyType.ACTIVE,"Ankara", "Çankaya", RealtyGroupType.HOUSE, RealtyCommercialType.RENT);
		Realty realty4 = new Realty(127L,"Ayvalı mahallesinde 3+1 ev", LocalDateTime.now(), userBayram, RealtyType.ACTIVE,"Ankara", "Keçiören", RealtyGroupType.HOUSE, RealtyCommercialType.SALE);
		Realty realty5 = new Realty(128L, "Esentepe mahallesi kiralık iş yeri", LocalDateTime.now(), userBayram, RealtyType.ACTIVE,"İstanbul","Zincirlikuyu", RealtyGroupType.HOUSE, RealtyCommercialType.RENT);

		RealtyService realtyService = RealtyService.getInstance();
		realtyService.createRealty(realty);
		realtyService.createRealty(realty1);
		realtyService.createRealty(realty2);
		realtyService.createRealty(realty3);
		realtyService.createRealty(realty4);
		realtyService.createRealty(realty5);

		userSami.setRealtyList(List.of(realty, realty1));

		List<Realty> fovarilerim = new ArrayList<>();
		fovarilerim.add(realty3);
		userSami.setFavoriteRealtyList(fovarilerim);

		// sistemdeki bütün ilanlar
		System.out.println("Bütün ilanlar");
		realtyService.printAll(realtyService.getAll());

		// İstanbuldaki ilanların bulunması
		System.out.println("İstanbul'daki ilanlar");
		realtyService.printAllByProvince("İstanbul");

		SearchHistory searchlist = new SearchHistory("İstanbul bütün ilanlar","Şehir","İstanbul",userBayram);

		// Soru 7.1) İl ilçe bazlı ilanların bulunması
		System.out.println("İstanbul Zincirlikuyudaki ilanlar");
		realtyService.printAllByProvinceAndDistrict("İstanbul","Zincirlikuyu",userBayram);

		System.out.println("İstanbul Fatih ilanlar");
		realtyService.printAllByProvinceAndDistrict("İstanbul","Fatih",userBayram);

		// Soru 7.2) Bayram kullanıcısının aramaları:
		System.out.println("Bayram kullanıcısının aramaları");
		realtyService.printSearchHistory(userBayram);

		// Bir kullanıcının bütün ilanlarını listele
		System.out.println(userPelin.getName()+ " in ilanları");
		realtyService.printAll(realtyService.getAllByUserName(userPelin));

		System.out.println(userSami.getName()+ " in aktif ilanları");
		realtyService.printAll(realtyService.getActiveRealtyByUserName(userSami));

		//Soru 7.4) Şehir vitrini 10 ilandan oluşur. Şehir bazlı vitrinler oluşturun
		System.out.println("Şehirlere göre gruplanmış ilan vitrini: ");
		realtyService.printGroupedRealtyesByCity();

		//Soru 7.5)İstanbul, Ankara, İzmir şehirlerindeki ilanlarının sayısını bulun
		System.out.println("İllere göre ilanların sayısı: ");
		System.out.println("İstanbul: " + realtyService.getRealtyCountByProvince("İstanbul"));
		System.out.println("Ankara: " + realtyService.getRealtyCountByProvince("Ankara"));
		System.out.println("İzmir: " + realtyService.getRealtyCountByProvince("İzmir"));
		System.out.println("Adana: " + realtyService.getRealtyCountByProvince("Adana"));

		//Soru 7.6)istanbul, Ankara, İzmir şehirlerindeki satılık konut ilanlarının sayısını bulun.

		System.out.println("İstanbul, Ankara, İzmir Satılık Konut ilan sayıları: ");
		System.out.println("İstanbul: "+ realtyService.getRealtyCountByCommercialAndGroupType("İstanbul",  RealtyGroupType.HOUSE, RealtyCommercialType.SALE));
		System.out.println("Ankara: "+ realtyService.getRealtyCountByCommercialAndGroupType("Ankara",  RealtyGroupType.HOUSE, RealtyCommercialType.SALE));
		System.out.println("İzmir: "+ realtyService.getRealtyCountByCommercialAndGroupType("İzmir",  RealtyGroupType.HOUSE, RealtyCommercialType.SALE));


		Message message = new Message("acil dönüş", "ilan ile ilgili bilgilendirme verebilir misiniz?", userPelin,
				userSami);
		userSami.setMessages(List.of(message));
		userPelin.setMessages(List.of(message));
		userSami.getMessages();
	}

	private static User prepareUser(String name, String email, String password) {
		User user = new User();
		user.setName(name);
		user.setMail(email);
		user.setPassword(password);
		user.setType(UserType.INDIVIDUAL);
		user.setCreateDate(LocalDateTime.now());
		return user;
	}

}
