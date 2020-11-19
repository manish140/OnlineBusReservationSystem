package com.capg.brs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BusReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusReservationApplication.class, args);
	}

}
