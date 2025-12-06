package com.poc.hexaware.azurePoc.repository;

import com.poc.hexaware.azurePoc.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAccoutsRepository extends JpaRepository<Accounts,Integer> {
}
