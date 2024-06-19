package dev.mukul.split_wise.service.command.registry;

import dev.mukul.split_wise.service.command.Command;

public class UpdateProfileCommand implements Command {
    public static String name = "UpdateProfile";
    public static Integer inputSize = 3;

    @Override
    public void execute(String input) {
        System.out.println("executing update profile  command...");
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
