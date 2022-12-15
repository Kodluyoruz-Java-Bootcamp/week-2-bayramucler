package emlakcepte;

import emlakcepte.model.User;
import emlakcepte.service.RealtyService;
import emlakcepte.service.ServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import emlakcepte.service.UserService;



@Configuration

public class BeanConfig {
	
	@Bean
	public UserService userService() {
		return (UserService) ServiceFactory.getService("userService");
	}

	@Bean
	public RealtyService realtyService() {
		return (RealtyService) ServiceFactory.getService("realtyService");
	}
	
	

}
