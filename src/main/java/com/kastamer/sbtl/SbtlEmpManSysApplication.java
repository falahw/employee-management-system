package com.kastamer.sbtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.kastamer.sbtl.config.SecurityConfiguration;

@SpringBootApplication
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfiguration.class)})
public class SbtlEmpManSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbtlEmpManSysApplication.class, args);
		
		System.out.println("\nOpen Employee Management System ...");
	}

}
