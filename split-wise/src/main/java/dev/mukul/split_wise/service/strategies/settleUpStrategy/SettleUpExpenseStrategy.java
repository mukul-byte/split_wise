package dev.mukul.split_wise.service.strategies.settleUpStrategy;

import dev.mukul.split_wise.models.Expense;

import java.util.List;


public interface SettleUpExpenseStrategy {

    List<Transaction> settleUp(List<Expense> expenses);
}
