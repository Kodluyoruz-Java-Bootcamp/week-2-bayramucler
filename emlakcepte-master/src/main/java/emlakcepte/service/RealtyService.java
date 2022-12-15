package emlakcepte.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import emlakcepte.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.dao.RealtyDao;


@Service
public class RealtyService implements EmlakCepteService {
	
	private RealtyDao realtyDao = new RealtyDao();

	private static RealtyService realtyServiceInstance;

	private RealtyService() {

	}

	//Singleton Pattern
	public static RealtyService getInstance() {
		if(realtyServiceInstance==null)
			realtyServiceInstance = new RealtyService();
		return realtyServiceInstance;
	}
	
	@Autowired //injection
	private UserService userService;

	private List<SearchHistory> searchHistoryList = new ArrayList<>();

	@Override
	public void printHashCode(){
		System.out.println("RealtyService hashCode " + realtyServiceInstance.hashCode());
	}
	
	public void createRealty(Realty realty) {
		//Soru 7.3) • Bireysel kullanıcılar sadece Konut tipinde ve en fazla 3 ilan yayınlayabilirler.
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType()) && getAllCountByUserName(realty.getUser()) >=3) {
			System.err.println("Bireysel kullanıcılar en fazla 3 ilan girebilirler: " + realty.getUser());
			return;
		}

		if (UserType.INDIVIDUAL.equals(realty.getUser().getType()) && !realty.getGroupType().equals(RealtyGroupType.HOUSE)) {
			System.err.println("Bireysel kullanıcılar sadece konut tipinde ilan girebilirler: " + realty.getUser() );
			return;
		}

		realtyDao.saveRealty(realty);
		System.out.println("createRealty :: " + realty.getTitle());
	}
	
	public List<Realty> getAll(){
		return realtyDao.findAll();
	}
	
	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public void printAllByProvince(String province) {
		getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		.forEach(realty -> System.out.println(realty));
	}



	public void printAllByProvinceAndDistrict(String province, String district, User user) {
		getAll().stream()
				.filter(realty -> realty.getProvince().equals(province) && realty.getDistrict().equals(district) )
				.forEach(realty -> System.out.println(realty));
		searchHistoryList.add(new SearchHistory("Şehir ve ilçeye göre arama", province,district, user));
	}

	public void printSearchHistory(User user){
		searchHistoryList.stream()
		.filter(history -> history.getUser().equals(user))
		.forEach(history -> System.out.println(history.getProvince() + " - " + history.getDistrict()));
	}
	
	public List<Realty> getAllByUserName(User user){	
		return getAll().stream()
		.filter(realty -> realty.getUser().getMail().equals(user.getMail()))
		.toList();		
	}

	public long getAllCountByUserName(User user){
		return getAll().stream()
				.filter(realty -> realty.getUser().getMail().equals(user.getMail()))
				.count();
	}

	public long getRealtyCountByProvince(String province){
		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(province))
				.count();
	}

	public long getRealtyCountByCommercialAndGroupType(String province, RealtyGroupType groupType, RealtyCommercialType commercialType){
		return getAll().stream()
				.filter(realty ->
						realty.getProvince().equals(province) &&
						realty.getCommercial().equals(commercialType) &&
						realty.getGroupType().equals(groupType)
				)
				.count();
	}

	public List<Realty> getActiveRealtyByUserName(User user) {
		return getAll().stream()
		.filter(realty -> realty.getUser().getName().equals(user.getName()))
		.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
		.toList();

	}

	//Map<String, List<Realty>> şeklinde bir map oluşturur.
	public void printGroupedRealtyesByCity() {
			getAll().stream()
				.collect(Collectors.groupingBy(Realty::getProvince))
					.forEach((city, realtyes) -> {
						System.out.println(city + ": ");
						realtyes.forEach(realty -> System.out.println(realty));
					});
	}


}
