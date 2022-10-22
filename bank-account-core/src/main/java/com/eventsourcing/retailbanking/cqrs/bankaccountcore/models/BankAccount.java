package com.eventsourcing.retailbanking.cqrs.bankaccountcore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class BankAccount {

    @Id
    private String id;
    private String accountHolderId;
    private LocalDate creationDate;
    private AccountType accountType;
    private double balance;
 }
