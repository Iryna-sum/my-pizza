package com.company.mypizza.service;

import com.company.mypizza.entity.User;
import com.company.mypizza.exception.DAOException;
import com.company.mypizza.exception.ServiceException;

public interface UserService {
    void addUser(User user, String password) throws ServiceException;

    User getUser(int userId) throws ServiceException;

    boolean userVerification(String userName, String password) throws ServiceException;

    int getUserId(String userName) throws ServiceException;
}
