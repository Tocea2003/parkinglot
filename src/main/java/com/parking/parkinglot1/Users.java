package com.parking.parkinglot1;

import com.parking.parkinglot1.common.UserDto;
import com.parking.parkinglot1.ejb.InvoiceBean;
import com.parking.parkinglot1.ejb.UserBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@DeclareRoles({"READ_USERS", "WRITE_USERS", "INVOICING"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_USERS"}),
        httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed = {"WRITE_USERS"})})
@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {

    @Inject
    UserBean userBean;

    @Inject
    private InvoiceBean invoiceBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> users = userBean.findAllUsers();
        request.setAttribute("users", users);
        if (request.isUserInRole("INVOICING") && !invoiceBean.getUserIds().isEmpty()) {
            Collection<String> usernames = userBean.findUsernamesByUserIds(invoiceBean.getUserIds());
            request.setAttribute("invoices", usernames);
        } else {
            request.setAttribute("invoices", new ArrayList<>());
        }
        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.isUserInRole("INVOICING")) {
            String[] userIdsAsString = request.getParameterValues("user_ids");
            if (userIdsAsString != null) {
                List<Long> userIds = new ArrayList<>();
                for (String userIdAsString : userIdsAsString) {
                    userIds.add(Long.parseLong(userIdAsString));
                }
                invoiceBean.getUserIds().addAll(userIds);
            }
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "You do not have permission to perform this action.");
            return;
        }
        response.sendRedirect(request.getContextPath() + "/Users");
    }
}