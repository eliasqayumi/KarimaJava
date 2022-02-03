package com.example.bankrestapi.service.service;

import com.example.bankrestapi.model.AccountType;
import java.util.List;

public interface AccountTypeService {
    void createAccountType(AccountType accountType);
    void deleteAccountType(Long accountTypeId);
    AccountType updateAccountType(AccountType accountType);
    AccountType findByAccountTypeId(Long accountTypeId);
    List<AccountType> findAllAccountType();
}
