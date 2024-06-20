package dev.mukul.split_wise.repository;

import dev.mukul.split_wise.models.Group;
import dev.mukul.split_wise.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Long> {
    List<GroupExpense> findAllByGroup(Group group);
}
