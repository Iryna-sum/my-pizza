package com.company.mypizza.dao.impl;

import com.company.mypizza.dao.UserDAO;
import com.company.mypizza.dao.connectionpool.ConnectionPool;
import com.company.mypizza.entity.Role;
import com.company.mypizza.entity.User;
import com.company.mypizza.exception.ConnectionPoolException;
import com.company.mypizza.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class UserDAOImpl implements UserDAO {
    private final static Logger log = Logger.getLogger(UserDAOImpl.class);

    private final static String INSERT_USER = "INSERT INTO user (name, last_name, user_name, password, phone_number, discount, role, is_banned) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String GET_USER = "SELECT * FROM user WHERE id = ?";
    private final static String CHECK_USER = "SELECT id FROM user WHERE user_name=? AND password=?";
    private final static String GET_USER_ID = "SELECT id FROM user WHERE user_name=?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void addUser(User user, String password) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setInt(6, user.getDiscount());
            preparedStatement.setString(7, user.getRole().toString().toLowerCase());
            preparedStatement.setBoolean(8, user.isBanned());
            preparedStatement.execute();
        } catch (ConnectionPoolException | SQLException e) {
            log.warn("The method was not completed.", e);
            throw new DAOException("Method addUser(...) failed.", e);
        } finally {
            connectionPool.closeConnection(connection, preparedStatement);
        }
    }

    @Override
    public User getUser(int userId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(GET_USER);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                user.setName(name);
                String lastName = resultSet.getString("last_name");
                user.setLastName(lastName);
                String userName = resultSet.getString("user_name");
                user.setUserName(userName);
                String phoneNumber = resultSet.getString("phone_number");
                user.setPhoneNumber(phoneNumber);
                int discount = resultSet.getInt("discount");
                user.setDiscount(discount);
                Role role = Role.valueOf(resultSet.getString("role").toUpperCase());
                user.setRole(role);
                boolean isBanned = resultSet.getBoolean("is_banned");
                user.setBanned(isBanned);
            }
        } catch (SQLException | ConnectionPoolException e) {
            log.warn("The method was not completed.", e);
            throw new DAOException("Method getUser(...) failed.", e);
        } finally {
            connectionPool.closeConnection(connection, preparedStatement, resultSet);
        }
        return user;
    }

    @Override
    public boolean userVerification(String userName, String password) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean existUser = false;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(CHECK_USER);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                existUser = true;
            }
        } catch (ConnectionPoolException | SQLException e) {
            log.warn("The method was not completed.", e);
            throw new DAOException("Method userVerification(...) failed.", e);
        } finally {
            connectionPool.closeConnection(connection, preparedStatement, resultSet);
        }
        return existUser;
    }

    @Override
    public int getUserId(String userName) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int userId = 0;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_USER_ID);
            statement.setString(1, userName);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userId = resultSet.getInt(1);
            }
        } catch (SQLException | ConnectionPoolException e) {
            log.warn("The method was not completed.", e);
            throw new DAOException("Method getUserId(...) failed.", e);
        } finally {
            connectionPool.closeConnection(connection, statement, resultSet);
        }
        return userId;
    }
}
