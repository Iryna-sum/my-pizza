package com.company.mypizza.dao.impl;

import com.company.mypizza.dao.PizzaDAO;
import com.company.mypizza.dao.connectionpool.ConnectionPool;
import com.company.mypizza.entity.ExtendedPizza;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import com.company.mypizza.entity.Ingredient;
import org.apache.log4j.Logger;

import com.company.mypizza.entity.Pizza;
import com.company.mypizza.exception.ConnectionPoolException;
import com.company.mypizza.exception.DAOException;

public class PizzaDAOImpl implements PizzaDAO {

    private final static Logger log = Logger.getLogger(PizzaDAOImpl.class);
    private final static String SAVE_POINT_NAME = "savePoint";
    private final static String INSERT_PIZZA = "INSERT INTO pizza (name, price, image, visibility) VALUES (?, ?, ?, ?)";
    private final static String GET_PIZZA = "SELECT name, price, image FROM pizza WHERE id = ?";
    private final static String GET_ALL_PIZZAS = "SELECT pizza.id, name, price, image FROM pizza";
    private final static String INSERT_PIZZA_AND_INGREDIENT_ID = "INSERT  INTO ingredient_has_pizza (ingredient_id, pizza_id) VALUES ((SELECT i.id FROM ingredient i WHERE i.id = ?), (SELECT LAST_INSERT_ID()))\n";
    private final static String GET_ALL_VISIBLE_PIZZAS = "SELECT pizza.id, name, price, image FROM pizza WHERE visibility = '1'";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void addPizza(ExtendedPizza pizza, List<String> pizzaIngredientNameList) throws DAOException {
        Connection connection = null;
        PreparedStatement pizzaStatement = null;
        PreparedStatement ingredientHasPizzaStatement;
        Savepoint savepoint = null;
        IngredientDAOImpl ingredientDAO = new IngredientDAOImpl();
        List<Ingredient> addedIngredientList;
        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(false);

            savepoint = connection.setSavepoint(SAVE_POINT_NAME);

            pizzaStatement = connection.prepareStatement(INSERT_PIZZA);
            pizzaStatement.setString(1, pizza.getName());
            pizzaStatement.setDouble(2, pizza.getPrice());
            pizzaStatement.setString(3, pizza.getImage());
            pizzaStatement.setBoolean(4, pizza.isVisibility());
            pizzaStatement.execute();

            addedIngredientList = ingredientDAO.addIngredientsIfAbsent(pizzaIngredientNameList);

            ingredientHasPizzaStatement = connection.prepareStatement(INSERT_PIZZA_AND_INGREDIENT_ID);
            for (Ingredient ingredient : addedIngredientList){
                ingredientHasPizzaStatement.setInt(1,ingredient.getId());
            }
            ingredientHasPizzaStatement.executeBatch();
            connection.commit();
        } catch (SQLException | ConnectionPoolException e) {
        try {
            if (savepoint != null) {
                connection.rollback(savepoint);
            }
        } catch (SQLException e1) {
            log.warn("Rollback failed.", e1);
        }
            log.warn("The method was not completed.", e);
            throw new DAOException("Method addPizza(...) failed.", e);
        } finally {
            connectionPool.closeConnection(connection, pizzaStatement);
        }
    }

    @Override
    public Pizza getPizza(int pizzaId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Pizza pizza = new Pizza();
        pizza.setId(pizzaId);
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_PIZZA);
            statement.setInt(1, pizzaId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                pizza.setName(name);
                double price = resultSet.getDouble("price");
                pizza.setPrice(price);
                String image = resultSet.getString("image");
                pizza.setImage(image);
            }
        }catch (SQLException | ConnectionPoolException e) {
            log.warn("The method was not completed.", e);
            throw new DAOException("Method getPizza(...) failed.", e);
        } finally {
            connectionPool.closeConnection(connection, statement, resultSet);
        }
        return pizza;

    }

    @Override
    public List<Pizza> getAllPizzas() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Pizza> pizzas = new LinkedList<>();
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_ALL_PIZZAS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pizza pizza = new Pizza();
                pizza.setId(resultSet.getInt("id"));
                pizza.setName(resultSet.getString("name"));
                pizza.setPrice(resultSet.getDouble("price"));
                pizza.setImage(resultSet.getString("image"));
                pizzas.add(pizza);
            }
        } catch (SQLException | ConnectionPoolException e) {
            log.warn("The method was not completed.", e);
            throw new DAOException("Method getAllPizzas(...) failed.", e);
        } finally {
            connectionPool.closeConnection(connection, statement, resultSet);
        }
        return pizzas;
    }

    @Override
    public List<Pizza> getAllVisiblePizzas() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        IngredientDAOImpl ingredientDAO = new IngredientDAOImpl();
        List<Pizza> pizzas = new LinkedList<>();
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_ALL_VISIBLE_PIZZAS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pizza pizza = new Pizza();
                pizza.setId(resultSet.getInt("id"));
                pizza.setName(resultSet.getString("name"));
                pizza.setPrice(resultSet.getDouble("price"));
                pizza.setImage(resultSet.getString("image"));
                pizzas.add(pizza);
            }
        } catch (SQLException | ConnectionPoolException e) {
            log.warn("The method was not completed.", e);
            throw new DAOException("Method getAllPizzas(...) failed.", e);
        } finally {
            connectionPool.closeConnection(connection, statement, resultSet);
        }
        return pizzas;
    }

}