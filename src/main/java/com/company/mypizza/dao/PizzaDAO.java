package com.company.mypizza.dao;

import com.company.mypizza.entity.ExtendedPizza;
import com.company.mypizza.entity.Pizza;
import com.company.mypizza.exception.DAOException;

import java.util.List;

public interface PizzaDAO {
    void addPizza(ExtendedPizza pizza, List<String> pizzaIngredientNameList) throws DAOException;

    Pizza getPizza(int pizzaId) throws DAOException;

    List<Pizza> getAllPizzas() throws DAOException;

    List<Pizza> getAllVisiblePizzas() throws DAOException;


}
