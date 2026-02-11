package com.example;

<<<<<<< HEAD
import io.github.cdimascio.dotenv.Dotenv;
=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Unified HRMS application entry point.
// All modules live under the base package: com.example.hrms_platform
@SpringBootApplication
public class HrmsPlatformApplication {

	public static void main(String[] args) {
<<<<<<< HEAD
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        dotenv.entries().forEach(e ->
                System.setProperty(e.getKey(), e.getValue())
        );

        SpringApplication.run(HrmsPlatformApplication.class, args);

=======
		SpringApplication.run(HrmsPlatformApplication.class, args);
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
	}

}
