package com.company.mypizza.controller.command;

import com.company.mypizza.controller.PageURL;
import com.company.mypizza.controller.RequestParameterName;
import com.company.mypizza.entity.ExtendedPizza;
import com.company.mypizza.exception.ServiceException;
import com.company.mypizza.service.PizzaService;
import com.company.mypizza.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AddPizzaSaveCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectPage = PageURL.REQUEST_PRODUCT_PAGE;
        String name = request.getParameter(RequestParameterName.NAME);
        double price = Double.parseDouble(request.getParameter(RequestParameterName.PRICE));
        String image = request.getParameter(RequestParameterName.IMAGE);
        boolean visibility = request.getParameter(RequestParameterName.VISIBILITY) != null;
        String ingredients = request.getParameter(RequestParameterName.INGREDIENTS);

        ExtendedPizza extendedPizza = new ExtendedPizza(name, price, image, visibility);
        ServiceFactory factory = ServiceFactory.getInstance();
        PizzaService pizzaService = factory.getPizzaService();
        List<String> ingredientList = Arrays.asList(ingredients.split(","));
        try {
            pizzaService.addPizza(extendedPizza,ingredientList);
        } catch (ServiceException e) {
        redirectPage = PageURL.ERROR_PAGE;
    }
        response.sendRedirect(redirectPage);
    }
}
