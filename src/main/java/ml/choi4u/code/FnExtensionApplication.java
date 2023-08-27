package ml.choi4u.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses=FnExtensionApplication.class)
@SpringBootApplication
public class FnExtensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FnExtensionApplication.class, args);
	}

}
