package com.vaadin.tutorial.crm.Backend.Repository;

import com.vaadin.tutorial.crm.Backend.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
