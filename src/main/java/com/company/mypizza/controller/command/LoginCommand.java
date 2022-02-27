package com.company.mypizza.controller.command;

import com.company.mypizza.controller.PageURL;
import com.company.mypizza.controller.RequestParameterName;
import com.company.mypizza.controller.SessionAttributeName;
import com.company.mypizza.entity.Role;
import com.company.mypizza.entity.User;
import com.company.mypizza.exception.ServiceException;
import com.company.mypizza.service.ServiceFactory;
import com.company.mypizza.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectPage = request.getParameter(RequestParameterName.CURRENT_PAGE);
        HttpSession session = request.getSession(true);
        int userId = 0;
        String userName = request.getParameter(RequestParameterName.USER_NAME);
        String password = request.getParameter(RequestParameterName.PASSWORD);
        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        boolean userValid = false;
        try {
            userValid = userService.userVerification(userName, password);
        } catch (ServiceException e) {
            redirectPage = PageURL.ERROR_PAGE;
        }
        int discount = 0;
        Role role = Role.GUEST;
        if (userValid) {
            try {
                    userId = userService.getUserId(userName);
                    User user = userService.getUser(userId);
                    discount = user.getDiscount();
                    role = user.getRole();
            } catch (ServiceException e) {
                redirectPage = PageURL.ERROR_PAGE;
            }
            session.setAttribute(SessionAttributeName.USER_ID, userId);
            session.setAttribute(SessionAttributeName.DISCOUNT, discount);
            session.setAttribute(SessionAttributeName.USER_ROLE, role.getName());
        }
        response.sendRedirect(redirectPage);
    }
}
