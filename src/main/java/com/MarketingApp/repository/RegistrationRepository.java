package com.MarketingApp.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.MarketingApp.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {

    List<Registration> findByfirstNameContainingIgnoreCase(String Search);
    List<Registration> findBylastNameContainingIgnoreCase(String Search);

    List<Registration> findBymobileContainingIgnoreCase(String Search);

    List<Registration> findByemailContainingIgnoreCase(String Search);
//    List<Registration> findByemailContainingIgnoreCase(String Search);

  
}
