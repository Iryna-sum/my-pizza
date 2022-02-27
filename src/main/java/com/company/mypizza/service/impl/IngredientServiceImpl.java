package com.company.mypizza.service.impl;

import com.company.mypizza.dao.DAOFactory;
import com.company.mypizza.dao.IngredientDAO;
import com.company.mypizza.dao.PizzaDAO;
import com.company.mypizza.entity.Ingredient;
import com.company.mypizza.entity.Pizza;
import com.company.mypizza.exception.DAOException;
import com.company.mypizza.exception.ServiceException;
import com.company.mypizza.service.IngredientService;

import java.util.ArrayList;
import java.util.List;

public class IngredientServiceImpl implements IngredientService {
    @Override
    public void addIngredient(Ingredient ingredient) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IngredientDAO ingredientDAO = factory.getIngredientDAO();
        try {
            ingredientDAO.addIngredient(ingredient);
        } catch (DAOException e) {
            throw new ServiceException("addIngredient(...) failed.", e);
        }
    }

    @Override
    public Ingredient getIngredient(int ingredientId) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IngredientDAO ingredientDAO = factory.getIngredientDAO();
        Ingredient ingredient = null;
        try {
            ingredient = ingredientDAO.getIngredient(ingredientId);
        } catch (DAOException e) {
            throw new ServiceException("getIngredient(...) failed.", e);
        }
        return ingredient;
    }

    @Override
    public List<Ingredient> getAllIngredients() throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IngredientDAO ingredientDAO = factory.getIngredientDAO();
        List<Ingredient> ingredients;
        try {
            ingredients = ingredientDAO.getAllIngredients();
        }catch (DAOException e) {
            throw new ServiceException("getAllIngredients(...) failed.", e);
        }
        return ingredients;
    }

    @Override
    public List<Ingredient> getPizzaIngredients(Pizza pizza) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IngredientDAO ingredientDAO = factory.getIngredientDAO();
        List<Ingredient> ingredients;
        try {
            ingredients = ingredientDAO.getPizzaIngredients(pizza);
        }catch (DAOException e) {
            throw new ServiceException("getPizzaIngredients(...) failed.", e);
        }
        return ingredients;
}

    @Override
    public List<Ingredient> addIngredientsIfAbsent(List<String> pizzaIngredientNameList) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        IngredientDAO ingredientDAO = factory.getIngredientDAO();
        List<Ingredient> addedIngredientsList;
        try {
            addedIngredientsList = ingredientDAO.addIngredientsIfAbsent(pizzaIngredientNameList);
        }catch (DAOException e) {
            throw new ServiceException("addIngredientsIfAbsent(...) failed.", e);
        }
        return addedIngredientsList;
    }
}
