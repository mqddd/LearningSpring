package com.vaadin.tutorial.crm.Backend.Service;


import com.vaadin.tutorial.crm.Backend.Model.Company;
import com.vaadin.tutorial.crm.Backend.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Map<String, Integer> getStats() {
        HashMap<String, Integer> stats = new HashMap<>();
        findAll().forEach(company -> stats.put(company.getName(), company.getEmployees().size()));
        return stats;
    }
}
