package com.company.mypizza.controller.command;

import com.company.mypizza.controller.PageURL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HistoryCommand implements Command{


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardPage = PageURL.HISTORY_PAGE;

    }
}
