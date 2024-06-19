package dev.mukul.split_wise.service.command.registry;

import dev.mukul.split_wise.service.command.Command;

public interface CommandRegistry {
    public void execute(String input);
    public void register(Command command);
}
