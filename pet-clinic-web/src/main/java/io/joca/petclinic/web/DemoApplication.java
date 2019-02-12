package io.joca.petclinic.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({
	@ComponentScan(basePackages = "io.joca.petclinic.data"),
	@ComponentScan(basePackages = "io.joca.petclinic.data.repositories"),
	@ComponentScan(basePackages = "io.joca.petclinic.web")
	})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}