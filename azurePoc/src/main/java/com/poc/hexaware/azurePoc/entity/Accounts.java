package com.poc.hexaware.azurePoc.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "accounts")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private int accountNumber;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Column(name = "branch_address", nullable = false)
    private String branchAddress;

}
