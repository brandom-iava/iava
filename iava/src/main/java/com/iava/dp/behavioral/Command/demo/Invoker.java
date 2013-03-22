package com.iava.dp.behavioral.Command.demo;

import java.util.*;

public class Invoker {
    private Map commands;
    
    public Invoker() {
        commands = new HashMap();
    }
    
    public void addCommand(String commName,
                           ICommand command) {
        commands.put(commName, command);
    }
    
    public void request(String commName) {
        ICommand command = (ICommand) commands.get(commName);
        command.execute();
    }
} 