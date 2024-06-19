package dev.mukul.split_wise.service.command;

import lombok.Getter;

public interface  Command {
    void execute(String input);
    boolean matches(String input);
}
