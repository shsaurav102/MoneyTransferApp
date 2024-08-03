package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferNotFoundException;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserNotFoundException;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path= "/transfer")
public class TransferController {
    private UserDao userDao;
    private final TokenProvider tokenProvider;
    private AccountDao accountDao;
    private TransferDao transferDao;

    public TransferController(UserDao userDao, TokenProvider tokenProvider,
                              AccountDao accountDao, TransferDao transferDao){
        this.userDao = userDao;
        this.tokenProvider = tokenProvider;
        this.accountDao = accountDao;
        this.transferDao = transferDao;
    }
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/registeredusers")
    public List<User> listOfRegisteredUsers(Principal principal) throws UserNotFoundException {
        List<User> users = new ArrayList<>();
        for(User user : userDao.findAll()) {
            if(!user.getUsername().equals(principal.getName())) {
                users.add(user);
            }
        }
        return users;
    }
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public boolean isTransferCreationSuccessful(@RequestBody @Valid Transfer transferToCreate) throws TransferNotFoundException {
        return transferDao.createNewTransfer(transferToCreate);
    }

}