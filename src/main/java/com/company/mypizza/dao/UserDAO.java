package com.company.mypizza.dao;

import com.company.mypizza.exception.DAOException;
import com.company.mypizza.entity.*;

public interface UserDAO {
    void addUser(User user, String password) throws DAOException;

    User getUser(int userId) throws DAOException;

    boolean userVerification(String userName, String password) throws DAOException;

    int getUserId(String userName) throws DAOException;

    default Role getRole(int userId) throws DAOException {
        User user = getUser(userId);
        return user.getRole();
    }
}
