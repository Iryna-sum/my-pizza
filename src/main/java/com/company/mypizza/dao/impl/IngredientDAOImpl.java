package com.company.mypizza.dao.impl;

import com.company.mypizza.dao.IngredientDAO;
import com.company.mypizza.dao.connectionpool.ConnectionPool;
import com.company.mypizza.entity.Ingredient;
import com.company.mypizza.entity.Pizza;
import com.company.mypizza.exception.ConnectionPoolException;
import com.company.mypizza.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class IngredientDAOImpl implements IngredientDAO {
    private final static Logger log = Logger.getLogger(IngredientDAOImpl.class);
    private final static String SAVE_POINT_NAME = "savePoint";

    private final static String INSERT_INGREDIENT = "INSERT INTO ingredient (name) VALUE (?)";
    private final static String GET_INGREDIENT = "SELECT name FROM ingredient WHERE id = ?";
    private final static String GET_ALL_INGREDIENTS = "SELECT id, name FROM ingredient";
    private final static String GET_INGREDIENT_ID = "SELECT id FROM ingredient WHERE name = ?";
    private final static String GET_PIZZA_INGREDIENT = "SELECT ingredient.id, ingredient.name FROM ingredient JOIN ingredient_has_pizza ihp on ingredient.id = ihp.ingredient_id JOIN pizza p on p.id = ihp.pizza_id WHERE p.id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void addIngredient(Ingredient ingredient) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        Savepoint savepoint = null;
        try {
            connection = connectionPool.takeConnection();
            connection.setAutoCommit(false);

            savepoint = connection.setSavepoint(SAVE_POINT_NAME);

            statement = connection.prepareStatement(INSERT_INGREDIENT);
            statement.setString(1, ingredient.getName());
            statement.execute();
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
            connectionPool.closeConnection(connection, statement);
        }
    }

    @Override
    public Ingredient getIngredient(int ingredientId) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientId);
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_INGREDIENT);
            statement.setInt(1, ingredientId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                ingredient.setName(name);
            }
        } catch (SQLException | ConnectionPoolException e) {
            log.warn("The method was not completed.", e);
            throw new DAOException("Method getPizza(...) failed.", e);
        } finally {
            connectionPool.closeConnection(connection, statement, resultSet);
        }
        return ingredient;
    }

    @Override
    public List<Ingredient> getAllIngredients() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Ingredient> ingredients = new LinkedList<>();
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_ALL_INGREDIENTS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setId(resultSet.getInt("id"));
                ingredient.setName(resultSet.getString("name"));
            }
        } catch (SQLException | ConnectionPoolException e) {
            log.warn("The method was not completed.", e);
            throw new DAOException("Method getAllPizzas(...) failed.", e);
        } finally {
            connectionPool.closeConnection(connection, statement, resultSet);
        }
        return ingredients;
    }

    @Override
    public List<Ingredient> getPizzaIngredients(Pizza pizza) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Ingredient> ingredients = new LinkedList<>();
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_PIZZA_INGREDIENT);
            statement.setInt(1,pizza.getId());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient();
                ingredient.setId(resultSet.getInt("id"));
                ingredient.setName(resultSet.getString("name"));
            }
        } catch (SQLException | ConnectionPoolException e) {
            log.warn("The method was not completed.", e);
            throw new DAOException("Method getAllPizzas(...) failed.", e);
        } finally {
            connectionPool.closeConnection(connection, statement, resultSet);
        }
        return ingredients;
    }

    @Override
    public List<Ingredient> addIngredientsIfAbsent(List<String> pizzaIngredientNameList) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Ingredient> addedIngredientsList = new LinkedList<>();
        IngredientDAOImpl ingredientDAO = new IngredientDAOImpl();
        Ingredient ingredient;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_INGREDIENT_ID);

            for (String item : pizzaIngredientNameList) {
                statement.setString(1, item);
                resultSet = statement.executeQuery();
                if (!resultSet.next()){
                    ingredient = new Ingredient(item);
                    ingredientDAO.addIngredient(ingredient);
                    addedIngredientsList.add(ingredient);
                }else {
                    do{
                       int id = resultSet.getInt("id");
                       ingredient = ingredientDAO.getIngredient(id);
                        addedIngredientsList.add(ingredient);
                    }while(resultSet.next());
                }
            }
        } catch (SQLException | ConnectionPoolException e) {
        log.warn("The method was not completed.", e);
        throw new DAOException("Method addIngredientsIfAbsent(...) failed.", e);
    } finally {
        connectionPool.closeConnection(connection, statement, resultSet);
    }
        return addedIngredientsList;
    }
}

