package com.banking_App.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long a_id;

    private long accountNo;
    private double balance;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private User user;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
    private List<Transaction> transactions;
}