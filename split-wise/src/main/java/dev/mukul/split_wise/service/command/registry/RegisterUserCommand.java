package dev.mukul.split_wise.service.command.registry;

import dev.mukul.split_wise.exception.InvalidCommandException;
import dev.mukul.split_wise.service.command.Command;
import lombok.Getter;

import java.util.List;

@Getter
public class RegisterUserCommand implements Command {
    public static String name = "Register";
    public static Integer inputSize = 4;
    @Override
    public void execute(String input) {
        System.out.println("executing register user command...");
        String tokens[] = input.split(" ");

        if(this.matches(input)){
            System.out.println("Executing command...");
        }

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
