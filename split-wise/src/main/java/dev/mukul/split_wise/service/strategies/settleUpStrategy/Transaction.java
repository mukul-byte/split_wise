package dev.mukul.split_wise.service.strategies.settleUpStrategy;

import dev.mukul.split_wise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User from;
    private User to;
    private Long amount;
}
