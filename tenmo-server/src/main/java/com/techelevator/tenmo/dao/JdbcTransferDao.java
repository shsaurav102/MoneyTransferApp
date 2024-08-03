package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AccountNotFoundException;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean createNewTransfer(Transfer transfer) {
        String sql = "INSERT INTO transfer (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount)"
                     + " VALUES (DEFAULT, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,transfer.getTransferTypeId(), transfer.getTransferStatusId(),
                                    transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount()) == 1;
    }

    @Override
    public List<Transfer> listAllTransfersFromCurrentUsers(String username) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT * FROM transfer t JOIN account a ON t.account_from = a.account_id " +
                "JOIN tenmo_user tu ON a.user_id = tu.user_id WHERE tu.username ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while(results.next()){
            Transfer transfer = mapRowToTransfer(results);
            transfers.add(transfer);
        }
        return transfers;
    }


    private Transfer mapRowToTransfer(SqlRowSet rs) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getLong("transfer_id"));
        transfer.setTransferTypeId(rs.getLong("transfer_type_id"));
        transfer.setTransferStatusId(rs.getLong("transfer_status_id"));
        transfer.setAccountFrom(rs.getLong("account_from"));
        transfer.setAccountTo(rs.getLong("account_to"));
        transfer.setAmount(rs.getDouble("amount"));
        return transfer;
    }
}
