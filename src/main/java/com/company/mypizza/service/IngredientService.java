package com.company.mypizza.service;

import com.company.mypizza.entity.Ingredient;
import com.company.mypizza.entity.Pizza;
import com.company.mypizza.exception.DAOException;
import com.company.mypizza.exception.ServiceException;

import java.util.List;

public interface IngredientService {
    void addIngredient(Ingredient ingredient) throws ServiceException;

    Ingredient getIngredient(int ingredientId) throws ServiceException;

    List<Ingredient> getAllIngredients() throws ServiceException;

    List<Ingredient> getPizzaIngredients(Pizza pizza) throws ServiceException;

    List<Ingredient> addIngredientsIfAbsent(List<String> pizzaIngredientNameList) throws ServiceException;
    
}
