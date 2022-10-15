package com.eventsourcing.retailbanking.cqrs.usercommandapi;

import com.eventsourcing.retailbanking.cqrs.usercore.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AxonConfig.class)
public class UserCommandApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCommandApiApplication.class, args);
	}

}
