package com.company.mypizza.controller.command;

import com.company.mypizza.controller.PageURL;
import com.company.mypizza.controller.RequestAttributeName;
import com.company.mypizza.controller.SessionAttributeName;
import com.company.mypizza.entity.User;
import com.company.mypizza.exception.ServiceException;
import com.company.mypizza.service.ServiceFactory;
import com.company.mypizza.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProfileCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardPage = PageURL.PROFILE_PAGE;
        HttpSession session = request.getSession(true);
        int userId = (Integer) session.getAttribute(SessionAttributeName.USER_ID);
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        User user = null;
        try {
            user = userService.getUser(userId);
        } catch (ServiceException e) {
            forwardPage = PageURL.ERROR_PAGE;
        }
        request.setAttribute(RequestAttributeName.USER, user);
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPage);
        dispatcher.forward(request, response);
    }
}
