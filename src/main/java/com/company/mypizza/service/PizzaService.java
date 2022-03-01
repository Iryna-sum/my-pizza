package com.company.mypizza.service;

import com.company.mypizza.entity.ExtendedPizza;
import com.company.mypizza.entity.Pizza;
import com.company.mypizza.exception.DAOException;
import com.company.mypizza.exception.ServiceException;

import java.util.List;

public interface PizzaService {
    void addPizza(ExtendedPizza pizza, List<String> pizzaIngredientNameList) throws ServiceException;

    Pizza getPizza(int pizzaId) throws ServiceException;

    List<Pizza> getAllPizzas() throws ServiceException;

    List<Pizza> getAllVisiblePizzas() throws ServiceException;
}
