package com.example.firstkafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class FirstKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstKafkaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return arg->{
			for (int i = 0; i < 5; i++) {
				kafkaTemplate.send("librarycode", "hello kafka :) " + i);
			}
		};
	}

}
