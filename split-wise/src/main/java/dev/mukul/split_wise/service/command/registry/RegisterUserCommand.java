package dev.mukul.split_wise.service.command.registry;

import dev.mukul.split_wise.controller.UserController;
import dev.mukul.split_wise.dto.RegisterUserDTO;
import dev.mukul.split_wise.exception.InvalidCommandException;
import dev.mukul.split_wise.service.command.Command;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Command {

    @Autowired
    UserController userController;

    public static String name = "Register";
    public static Integer inputSize = 4;
    @Override
    public void execute(String input) {
        System.out.println("executing register user command...");
        String tokens[] = input.split(" ");

        if(!this.matches(input)) {
            return;
        }

        RegisterUserDTO registerUserDTO = new RegisterUserDTO();
        registerUserDTO.setPassword(tokens[3]);
        registerUserDTO.setName(tokens[1]);
        registerUserDTO.setPhone(tokens[2]);

        this.userController.register(registerUserDTO);
        System.out.println("Registering User");

    }

    @Override
    public boolean matches(String input) {
        String[] tokens = input.split(" ");
        if(name.toLowerCase().equals(tokens[0].toLowerCase()) && tokens.length == inputSize){
            return true;
        }
        return false;
    }
}
