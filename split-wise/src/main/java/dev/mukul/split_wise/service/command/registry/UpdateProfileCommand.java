package dev.mukul.split_wise.service.command.registry;

import dev.mukul.split_wise.controller.UserController;
import dev.mukul.split_wise.dto.UpdateProfileRequestDto;
import dev.mukul.split_wise.service.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.Long.parseLong;

@Component
public class UpdateProfileCommand implements Command {
    @Autowired
    UserController userController;

    public static String name = "UpdateProfile";
    public static Integer inputSize = 3;

    @Override
    public void execute(String input) {
        System.out.println("executing update profile  command...");
        String tokens[] = input.split(" ");

        if(!this.matches(input)){
            return;
        }

        UpdateProfileRequestDto updateProfileRequestDto = new UpdateProfileRequestDto();
        updateProfileRequestDto.setPassword(tokens[2]);
        updateProfileRequestDto.setUserId(parseLong(tokens[0]));
        this.userController.updateProfile(updateProfileRequestDto);
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
