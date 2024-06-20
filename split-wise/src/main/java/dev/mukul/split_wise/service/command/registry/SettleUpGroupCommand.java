package dev.mukul.split_wise.service.command.registry;

import dev.mukul.split_wise.controller.GroupController;
import dev.mukul.split_wise.dto.SettleUpGroupRequestDTO;
import dev.mukul.split_wise.service.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.Long.parseLong;

@Component
public class SettleUpGroupCommand implements Command {
    @Autowired
    GroupController groupController;

    public static String name = "SettleUp";
    public static Integer inputSize = 3;

    @Override
    public void execute(String input) {
        //u1 SettleUp g1
        String[] tokens = input.split(" ");
        SettleUpGroupRequestDTO settleUpGroupRequestDTO = new SettleUpGroupRequestDTO();
        settleUpGroupRequestDTO.setGroupId(parseLong(tokens[2]));
        settleUpGroupRequestDTO.setUserId(parseLong(tokens[0]));
        this.groupController.settleUp(settleUpGroupRequestDTO);
    }

    @Override
    public boolean matches(String input) {
        String[] tokens = input.split(" ");
        if(name.toLowerCase().equals(tokens[1].toLowerCase()) && tokens.length == inputSize){
            return true;
        }
        return false;
    }
}
