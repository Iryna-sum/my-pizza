package com.company.mypizza.dao;

import com.company.mypizza.dao.impl.IngredientDAOImpl;
import com.company.mypizza.dao.impl.PizzaDAOImpl;
import com.company.mypizza.dao.impl.UserDAOImpl;
import com.company.mypizza.service.IngredientService;
import com.company.mypizza.service.impl.IngredientServiceImpl;

public class DAOFactory {
    private final static DAOFactory instance = new DAOFactory();

    private final PizzaDAO pizzaDAO = new PizzaDAOImpl();
    private final UserDAO userDAO = new UserDAOImpl();
    private final IngredientDAO IngredientDAO = new IngredientDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public PizzaDAO getPizzaDAO() {
        return pizzaDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public IngredientDAO getIngredientDAO() {return IngredientDAO;}
}
