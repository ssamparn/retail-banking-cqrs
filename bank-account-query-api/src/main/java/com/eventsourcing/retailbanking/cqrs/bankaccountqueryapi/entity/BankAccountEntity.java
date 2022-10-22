package com.eventsourcing.retailbanking.cqrs.bankaccountqueryapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class BankAccountEntity {

    @Id
    private String id;

}
