package com.company.mypizza.controller.command;

import com.company.mypizza.controller.PageURL;
import com.company.mypizza.controller.RequestAttributeName;
import com.company.mypizza.controller.SessionAttributeName;
import com.company.mypizza.entity.Pizza;
import com.company.mypizza.entity.Role;
import com.company.mypizza.exception.ServiceException;
import com.company.mypizza.service.PizzaService;
import com.company.mypizza.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ProductCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardPage = PageURL.PRODUCT_PAGE;
        HttpSession session = request.getSession(true);
        String userRole = (String) session.getAttribute(SessionAttributeName.USER_ROLE);
        Role role = Role.GUEST;
        if (userRole != null) {
            role = Role.valueOf(userRole.toUpperCase());
        }
        ServiceFactory factory = ServiceFactory.getInstance();
        PizzaService pizzaService = factory.getPizzaService();
        List<Pizza> pizzas = null;
        try {
            pizzas = pizzaService.getAllPizzas();
        } catch (ServiceException e) {
            forwardPage = PageURL.ERROR_PAGE;
        }
        request.setAttribute(RequestAttributeName.PIZZAS, pizzas);
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPage);
        dispatcher.forward(request, response);
    }
}
