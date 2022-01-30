package com.xu.se22.castbackend.ressources;

import com.xu.se22.castbackend.models.Account;
import com.xu.se22.castbackend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(path = "/accounts")
public class AccountController {
    @Autowired

    private AccountRepository accountRepository;

    @GetMapping
    public @ResponseBody Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping(path = "/handins")
    public @ResponseBody
    Optional<Account> getAccountWithHandins(@RequestParam() Integer accountId) {
        return  accountRepository.findById(accountId);
    }

}
