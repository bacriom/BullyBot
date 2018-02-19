package com.bullybot.bullybot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"me.ramswaroop.jbot", "com.bullybot.bullybot"})
public class BullybotApplication {

	public static void main(String[] args) {
		SpringApplication.run(BullybotApplication.class, args);
	}
}
