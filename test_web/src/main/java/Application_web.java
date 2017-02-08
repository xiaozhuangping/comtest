import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2017/1/29.
 */
@SpringBootApplication(scanBasePackages = "com.web")
public class Application_web {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application_web.class, args);
    }
}
