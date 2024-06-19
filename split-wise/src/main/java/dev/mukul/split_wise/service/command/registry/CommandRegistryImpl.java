package dev.mukul.split_wise.service.command.registry;

import dev.mukul.split_wise.service.command.Command;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistryImpl implements CommandRegistry {
    private List<Command> commandList = new ArrayList<Command>();
    @Override
    public void execute(String input) {
        for(Command c: commandList){
            if(c.matches(input)){
                c.execute(input);
                return;
            }
        }
    }


    @Override
    public void register(Command command) {
        commandList.add(command);
    }
}
