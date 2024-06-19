package dev.mukul.split_wise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroupExpense extends BaseModel{
    @OneToOne
    private Expense expense;

    @ManyToOne
    private Group group;
}
