package com.jobapplic.jobappbyme.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.jobapplic.jobappbyme.company.Company;
import com.jobapplic.jobappbyme.company.CompanyRepository;
import com.jobapplic.jobappbyme.company.CompanyService;


@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll(); 
    }

    @Override
    public boolean updateCompany(Long id,Company company) {
        Optional<Company> cOptional = companyRepository.findById(id);
        if (cOptional.isPresent()) {
            Company companyToUpdate = cOptional.get();
            companyToUpdate.setName(company.getName());
            companyToUpdate.setName(company.getName());
            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
    
}
