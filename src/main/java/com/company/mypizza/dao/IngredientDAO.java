package com.company.mypizza.dao;

import com.company.mypizza.entity.ExtendedPizza;
import com.company.mypizza.entity.Ingredient;
import com.company.mypizza.entity.Pizza;
import com.company.mypizza.exception.DAOException;
import com.company.mypizza.exception.ServiceException;

import java.util.List;

public interface IngredientDAO {

    void addIngredient(Ingredient ingredient) throws DAOException;

    Ingredient getIngredient(int ingredientId) throws DAOException;

    List<Ingredient> getAllIngredients() throws DAOException;

    List<Ingredient> getPizzaIngredients(Pizza pizza) throws DAOException;

    List<Ingredient> addIngredientsIfAbsent(List<String> pizzaIngredientNameList) throws DAOException;
}
