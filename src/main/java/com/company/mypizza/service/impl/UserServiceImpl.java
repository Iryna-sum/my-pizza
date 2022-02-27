package com.company.mypizza.service.impl;

import com.company.mypizza.dao.DAOFactory;
import com.company.mypizza.dao.UserDAO;
import com.company.mypizza.entity.User;
import com.company.mypizza.exception.DAOException;
import com.company.mypizza.exception.ServiceException;
import com.company.mypizza.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user, String password) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        try {
            userDAO.addUser(user, password);
        } catch (DAOException e) {
            throw new ServiceException("addUser(...) failed.", e);
        }
    }

    @Override
    public User getUser(int userId) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        User user;
        try {
            user = userDAO.getUser(userId);
        } catch (DAOException e) {
            throw new ServiceException("getUser(...) failed.", e);
        }
        return user;
    }

    public boolean userVerification(String userName, String password) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        boolean userValid;
        try {
            userValid = userDAO.userVerification(userName, password);
        } catch (DAOException e) {
            throw new ServiceException("userVerification(...) failed.", e);
        }
        return userValid;
    }

    public int getUserId(String userName) throws ServiceException{
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        int userId = 0;
        try {
            userId = userDAO.getUserId(userName);
        } catch (DAOException e) {
            throw new ServiceException("getUserId(...) failed.", e);
        }
        return userId;
    }
}
