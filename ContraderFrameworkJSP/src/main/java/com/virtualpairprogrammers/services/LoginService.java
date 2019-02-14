package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.LoginDAO;

import java.util.List;

public class LoginService {

    private LoginDAO loginDAO;
    private static LoginService reference;

    public static LoginService getService()
    {
        if (reference == null)
            reference = new LoginService();
        return reference;
    }

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public List<String> loginUtente (String username, String password) {
        return this.loginDAO.loginUtente(username, password);
    }
}

