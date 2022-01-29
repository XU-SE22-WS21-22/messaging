package com.example.messaging.repository;

import com.example.messaging.dto.Accounts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountsRepository extends CrudRepository<Accounts, Long> {
    List<Accounts> findByName(String Name);

    Accounts findByAccountID(Long AccountID);
}
