package com.lardi.app;

import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value = "com.lardi")
@EnableJpaRepositories(value = "com.lardi")
@EntityScan(basePackages = { "com.lardi" }, basePackageClasses = { Jsr310JpaConverters.class })
public class PhoneBookTest {

	@Test
	public void contextLoads() {
	}
}
