package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entity.Library;
import com.example.service.LibraryService;

@ComponentScan({ "com.example" })
@EnableJpaAuditing
@EntityScan(basePackages = { "com.example.entity" })
@EnableJpaRepositories("com.example.dao")
@SpringBootApplication
public class LibraryManagementSystem1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(LibraryManagementSystem1Application.class, args);
		//LibraryService libser = ctx.getBean(LibraryService.class);

		/*
		 * List<Library> list = libser.fetchId(1);
		 * System.out.println("Library based on id-->" + list);
		 
		 * List<Library> listNames = libser.fetchName("A");
		 * System.out.println("Library based on Library Names-->" + listNames);
		 * 
		 * System.out.println("find library by inner join" +
		 * libser.findLibraryWithBooks());
		 */
	}
}
