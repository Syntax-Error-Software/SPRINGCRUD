package org.jsp.employeedepartmentapp;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.jsp.employeedepartmentapp"})
public class Config {
	@Bean
	public EntityManager entityManager()
	{
		return Persistence.createEntityManagerFactory("dev").createEntityManager();
	}

}
