package CO.CrossOrigin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrossOriginApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrossOriginApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean registrationBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.addUrlPatterns("/*");
		bean.setFilter(new CrosFilter());
		return bean;
	}
}
