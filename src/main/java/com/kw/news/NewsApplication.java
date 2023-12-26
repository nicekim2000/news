package com.kw.news;

import com.kw.news.Service.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NewsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(NewsApplication.class, args);
		KafkaProducer producer = context.getBean(KafkaProducer.class);
		producer.sendMessage("Hello from Spring Boot Kafka Producer!");
	}

}
