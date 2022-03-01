package com.company.mypizza.controller.command;

import java.util.HashMap;
import java.util.Map;

public class CommandTypeMap {

    private final static CommandTypeMap instance = new CommandTypeMap();

    private final Map<String, CommandTypeEnum> stringCommands = new HashMap<>();

    private CommandTypeMap() {
        stringCommands.put("add_pizza_form", CommandTypeEnum.ADD_PIZZA_FORM);
        stringCommands.put("registration", CommandTypeEnum.REGISTRATION);
        stringCommands.put("login", CommandTypeEnum.LOGIN);
        stringCommands.put("profile", CommandTypeEnum.PROFILE);
        stringCommands.put("products", CommandTypeEnum.PRODUCTS);
        stringCommands.put("add_pizza_save", CommandTypeEnum.ADD_PIZZA_SAVE);
        stringCommands.put("index", CommandTypeEnum.INDEX);
    }

    public static CommandTypeMap getInstance() {
        return instance;
    }

    public CommandTypeEnum getCommand(String stringCommand) {
        return stringCommands.get(stringCommand);
    }


}
