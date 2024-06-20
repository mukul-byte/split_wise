package dev.mukul.split_wise.dto;

import dev.mukul.split_wise.service.strategies.settleUpStrategy.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDTO {
    List<Transaction> transactions;
}
