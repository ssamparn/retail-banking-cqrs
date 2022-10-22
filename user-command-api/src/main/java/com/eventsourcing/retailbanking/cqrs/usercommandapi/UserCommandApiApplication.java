package com.eventsourcing.retailbanking.cqrs.usercommandapi;

import com.eventsourcing.retailbanking.cqrs.usercore.config.UserCqrsAxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(UserCqrsAxonConfig.class)
public class UserCommandApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCommandApiApplication.class, args);
	}

}
