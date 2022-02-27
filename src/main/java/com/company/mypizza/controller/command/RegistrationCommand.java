package com.company.mypizza.controller.command;

import com.company.mypizza.controller.PageURL;
import com.company.mypizza.controller.RequestParameterName;
import com.company.mypizza.entity.User;
import com.company.mypizza.exception.ServiceException;
import com.company.mypizza.service.ServiceFactory;
import com.company.mypizza.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectPage = request.getParameter(RequestParameterName.CURRENT_PAGE);
        String firstName = request.getParameter(RequestParameterName.FIRST_NAME);
        String lastName = request.getParameter(RequestParameterName.LAST_NAME);
        String userName = request.getParameter(RequestParameterName.USER_NAME);
        String password = request.getParameter(RequestParameterName.PASSWORD);
        String phoneNumber = request.getParameter(RequestParameterName.PHONE_NUMBER);
        User user = new User(firstName, lastName,userName, phoneNumber);
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        try {
            userService.addUser(user, password);
        } catch (ServiceException e) {
            redirectPage = PageURL.ERROR_PAGE;
        }
        response.sendRedirect(redirectPage);
    }
}
