package com.company.mypizza.service.impl;

import com.company.mypizza.dao.DAOFactory;
import com.company.mypizza.dao.PizzaDAO;
import com.company.mypizza.entity.ExtendedPizza;
import com.company.mypizza.entity.Pizza;
import com.company.mypizza.exception.DAOException;
import com.company.mypizza.exception.ServiceException;
import com.company.mypizza.service.IngredientService;
import com.company.mypizza.service.PizzaService;

import java.util.List;

public class PizzaServiceImpl implements PizzaService {

    @Override
    public void addPizza(ExtendedPizza pizza,List<String> pizzaIngredientNameList) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        PizzaDAO pizzaDAO = factory.getPizzaDAO();
        try {
            pizzaDAO.addPizza(pizza,pizzaIngredientNameList);
        } catch (DAOException e) {
            throw new ServiceException("addPizza(...) failed.", e);
        }
    }

    @Override
    public Pizza getPizza(int pizzaId) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        PizzaDAO pizzaDAO = factory.getPizzaDAO();
        Pizza pizza = null;
        try {
            pizza = pizzaDAO.getPizza(pizzaId);
        } catch (DAOException e) {
            throw new ServiceException("getPizza(...) failed.", e);
        }
        return pizza;
    }

    @Override
    public List<Pizza> getAllPizzas() throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        PizzaDAO pizzaDAO = factory.getPizzaDAO();
        List<Pizza> pizzas;
        try {
            pizzas = pizzaDAO.getAllPizzas();
        }catch (DAOException e) {
            throw new ServiceException("getAllPizzaTypes(...) failed.", e);
        }
        return pizzas;
    }
}
