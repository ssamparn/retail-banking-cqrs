package com.eventsourcing.retailbanking.cqrs.bankaccountcommandapi;

import com.eventsourcing.retailbanking.cqrs.bankaccountcore.config.BankAccountCqrsAxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import(BankAccountCqrsAxonConfig.class)
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BankAccountCommandApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountCommandApiApplication.class, args);
	}

}
