package emlakcepte.service;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory {

    public static EmlakCepteService getService(String service) {
        service = service.toLowerCase();

        if (service.equals("realtyService")) {
            return RealtyService.getInstance();
        } else if (service.equals("userService")) {
            return UserService.getInstance();
        } else {
            return null;
        }
    }
}