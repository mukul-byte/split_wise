package dev.mukul.split_wise.service;

import dev.mukul.split_wise.models.Expense;
import dev.mukul.split_wise.models.Group;
import dev.mukul.split_wise.models.GroupExpense;
import dev.mukul.split_wise.models.User;
import dev.mukul.split_wise.repository.GroupExpenseRepository;
import dev.mukul.split_wise.repository.GroupRepository;
import dev.mukul.split_wise.repository.UserRepository;
import dev.mukul.split_wise.service.strategies.settleUpStrategy.SettleUpExpenseStrategy;
import dev.mukul.split_wise.service.strategies.settleUpStrategy.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupExpenseRepository groupExpenseRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SettleUpExpenseStrategy settleUpExpenseStrategy;

    public List<Transaction> settleUp(Long userId, Long groupId) {
        //check if user is a part of the group
        Optional<User> user = this.userRepository.findById(userId);
        if(user.isEmpty()){
            //throw exception
        }

        Optional<Group> group = this.groupRepository.findById(groupId);
        if(group.isEmpty()){
            //throw exception
            return null;
        }
        List<User> members = group.get().getMembers();
        boolean isUserPartOfGroup = false;
        for(User member: members){
            if(member.getId().equals(userId)){
                isUserPartOfGroup=true;
                break;
            }
        }
        if(!isUserPartOfGroup){
            //throw exception
        }

        List<GroupExpense>groupExpenses = this.groupExpenseRepository.findAllByGroup(group.get());
        List<Expense> expenses = new ArrayList<Expense>();
        for (GroupExpense ge: groupExpenses){
            expenses.add(ge.getExpense());
        }

        return this.settleUpExpenseStrategy.settleUp(expenses);

        // find the group

        //find all expenses of that group

        //find all transactions for those expensess
    }
}
