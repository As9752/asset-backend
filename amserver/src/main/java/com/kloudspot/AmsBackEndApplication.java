package com.kloudspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AmsBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsBackEndApplication.class, args);
	}

}
