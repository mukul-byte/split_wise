package dev.mukul.split_wise.service.strategies.settleUpStrategy;

import dev.mukul.split_wise.models.Expense;
import dev.mukul.split_wise.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LinearExpenseSettleUpStrategy implements SettleUpExpenseStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        Map<User, Long> balance = new HashMap<User, Long>();

        for(Expense e: expenses){
            for(Map.Entry<User, Long> ele: e.getOwedBy().entrySet()) {//Map<User, Long>owedBy;
                balance.put(ele.getKey(), balance.getOrDefault(ele.getKey(), 0L) - ele.getValue());
            }
        }

        for(Expense e: expenses){
            for(Map.Entry<User, Long> ele: e.getPaidBy().entrySet()) {//Map<User, Long>owedBy;
                balance.put(ele.getKey(), balance.getOrDefault(ele.getKey(), 0L) + ele.getValue());
            }
        }

        List<Transaction> transactions = new ArrayList<Transaction>();
//        List<User> users = balance.keySet().stream().toList();
        List<User> users = new ArrayList<User>();
        for(Map.Entry<User, Long> ele: balance.entrySet()){
            users.add(ele.getKey());
        }

        for(int i=0;i< users.size()-1;i++){
            Long currentBalance = balance.get(users.get(i));
            if(currentBalance==0){
                continue;
            } else if(currentBalance>0) {
                transactions.add(this.createTransaction(users.get(i + 1), users.get(i), currentBalance));
                balance.put(users.get(i + 1), balance.get(users.get(i + 1)) + currentBalance);
                balance.put(users.get(i), 0L);
            } else {
                transactions.add(this.createTransaction(users.get(i), users.get(i + 1), currentBalance));
                balance.put(users.get(i + 1), balance.get(users.get(i + 1)) + currentBalance);
                balance.put(users.get(i), 0L);
            }
        }

        return transactions;
    }

    private Transaction createTransaction(User from, User to, Long currentBalance) {
        Transaction tr = new Transaction();
        tr.setTo(to);
        tr.setFrom(from);
        tr.setAmount(currentBalance);

        return tr;
    }
}
