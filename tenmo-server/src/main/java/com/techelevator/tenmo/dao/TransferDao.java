package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {

    boolean createNewTransfer(Transfer transferToCreate);

    List<Transfer> listAllTransfersFromCurrentUsers(String username);

}