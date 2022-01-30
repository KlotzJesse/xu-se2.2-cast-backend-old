package com.xu.se22.castbackend.repositories;

import com.xu.se22.castbackend.models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Query("SELECT a from accounts a WHERE a.AccountID = ?1")
    Account findAccount(Integer accountId);

}