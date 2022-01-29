package com.xu.se22.castbackend.repositories;

import com.xu.se22.castbackend.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}