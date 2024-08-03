package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AccountNotFoundException;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findAccountByUsername(String username) throws AccountNotFoundException{
        String sql = "SELECT * FROM account a JOIN tenmo_user t ON a.user_id = t.user_id WHERE username ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        if(results.next()){
          return mapRowToAccount(results);
        }
        throw new AccountNotFoundException();
    }

    @Override
    public boolean create(String username, String password) {
        return false;
    }

    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setUserId(rs.getLong("user_id"));
        account.setUsername(rs.getString("username"));
        account.setAccountId(rs.getLong("account_id"));
        account.setBalance(rs.getDouble("balance"));
        return account;
    }
}