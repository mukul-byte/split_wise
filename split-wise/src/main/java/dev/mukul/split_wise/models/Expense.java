package dev.mukul.split_wise.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private Long amount;

    @ManyToOne
    private User createdBy;

    private String description;
    private Currency currency;

    @ElementCollection
    Map<User, Long>paidBy;

    @ElementCollection
    Map<User, Long>owedBy;
}
