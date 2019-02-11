package io.joca.petclinic.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Joao Berardo
 * @since Feb 06 2019
 *
 */
@SpringBootApplication
@ComponentScan("io.joca.petclinic.data")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}