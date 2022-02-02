package com.example.bankrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @Column(name = "account_id", nullable = false)
    private long accountId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "account_type")
    private AccountType accountType;

    @Column(name = "account_number", nullable = false)
    @Size(min = 10, max = 10)
    private long accountNumber;

    @Column(name = "balance",nullable = false)
    private long balance;
}