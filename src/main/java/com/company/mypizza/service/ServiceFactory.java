package com.company.mypizza.service;

import com.company.mypizza.service.impl.IngredientServiceImpl;
import com.company.mypizza.service.impl.PizzaServiceImpl;
import com.company.mypizza.service.impl.UserServiceImpl;

public class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();

    private final PizzaService pizzaService = new PizzaServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final IngredientService IngredientService = new IngredientServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public PizzaService getPizzaService() {return pizzaService;}
    public UserService getUserService() {return  userService;}
    public IngredientService getIngredientService() {return  IngredientService;}

}
