package com.company.mypizza.main;

import com.company.mypizza.dao.IngredientDAO;
import com.company.mypizza.dao.impl.IngredientDAOImpl;
import com.company.mypizza.dao.impl.UserDAOImpl;
import com.company.mypizza.entity.Ingredient;
import com.company.mypizza.exception.DAOException;
import com.company.mypizza.exception.ServiceException;
import com.company.mypizza.service.impl.IngredientServiceImpl;
import com.company.mypizza.service.impl.UserServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DAOException, ServiceException {
        IngredientServiceImpl ingredientService = new IngredientServiceImpl();
        List<String> ingredientsNames = new LinkedList<>();
        ingredientsNames.add("Куриное филе");

        List<Ingredient> ingredients = ingredientService.addIngredientsIfAbsent(ingredientsNames);
    }
}
