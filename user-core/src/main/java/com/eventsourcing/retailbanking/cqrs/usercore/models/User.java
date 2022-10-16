package com.eventsourcing.retailbanking.cqrs.usercore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;
    @NotEmpty(message = "User firstname is mandatory!")
    private String firstName;
    @NotEmpty(message = "User lastname is mandatory!")
    private String lastName;
    @Email(message = "Please provide a valid eMail address")
    private String emailAddress;
    @Valid
    @NotNull(message = "Please provide account credentials")
    private Account account;
}
