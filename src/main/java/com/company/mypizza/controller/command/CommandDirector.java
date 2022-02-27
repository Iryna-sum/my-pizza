package com.company.mypizza.controller.command;

import java.util.EnumMap;
import java.util.Map;

public class CommandDirector {
    private Map<CommandTypeEnum, Command> commands = new EnumMap<>(CommandTypeEnum.class);

    public CommandDirector() {
        commands.put(CommandTypeEnum.ADD_PIZZA_FORM, new AddPizzaFormCommand());
        commands.put(CommandTypeEnum.REGISTRATION, new RegistrationCommand());
        commands.put(CommandTypeEnum.LOGIN, new LoginCommand());
        commands.put(CommandTypeEnum.PROFILE, new ProfileCommand());
        commands.put(CommandTypeEnum.PRODUCTS, new ProductCommand());
        commands.put(CommandTypeEnum.ADD_PIZZA_SAVE, new AddPizzaSaveCommand());
    }

    public Command getCommand(CommandTypeEnum type) {
        return commands.get(type);
    }
}
