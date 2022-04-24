package com.dmoreno06.retoConversorMoneda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class RetoConversorMonedaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetoConversorMonedaApplication.class, args);
	}

}
