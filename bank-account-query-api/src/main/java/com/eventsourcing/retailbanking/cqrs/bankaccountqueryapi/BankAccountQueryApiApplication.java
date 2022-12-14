package com.eventsourcing.retailbanking.cqrs.bankaccountqueryapi;

import com.eventsourcing.retailbanking.cqrs.bankaccountcore.config.BankAccountCqrsAxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(BankAccountCqrsAxonConfig.class)
@EntityScan(basePackages = "com.eventsourcing.retailbanking.cqrs.bankaccountcore.models")
public class BankAccountQueryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountQueryApiApplication.class, args);
	}

}
