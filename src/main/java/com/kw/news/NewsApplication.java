package com.kw.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NewsApplication {

	public static void main(String[] args) {
//		SpringApplication.run(NewsApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(NewsApplication.class, args);
		KafkaProducer producer = context.getBean(KafkaProducer.class);
		producer.sendMessage("Hello from Spring Boot Kafka Producer!");

	}

}
