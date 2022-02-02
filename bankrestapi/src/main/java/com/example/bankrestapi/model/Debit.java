package com.example.bankrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Debit {
    @Id
    @Column(name = "debit_id", nullable = false)
    private long debitId;

    @JoinColumn(name = "account_id",nullable = false)
    private long accountId;

    @Column(name = "amount", nullable = false)
    private long amount;

}
