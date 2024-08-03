package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AccountNotFoundException;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;

@RestController
@RequestMapping(path = "/account")
public class AccountController {
    private UserDao userDao;
    private final TokenProvider tokenProvider;
    private AccountDao accountDao;

    public AccountController(UserDao userDao, TokenProvider tokenProvider, AccountDao accountDao){
        this.userDao = userDao;
        this.tokenProvider = tokenProvider;
        this.accountDao = accountDao;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/balance")
    public Account getAccountBalance(Principal principal) throws UsernameNotFoundException {
        Account account = accountDao.findAccountByUsername(principal.getName());
        return account;
    }
}