package com.alura.literalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.alura.literalura.controller.MenuController;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LiteraluraApplication.class, args);
		MenuController menuController = context.getBean(MenuController.class);
		menuController.runMenu();
	}
}
