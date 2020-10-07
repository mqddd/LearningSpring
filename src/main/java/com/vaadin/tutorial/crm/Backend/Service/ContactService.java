package com.vaadin.tutorial.crm.Backend.Service;


import com.vaadin.tutorial.crm.Backend.Model.Contact;
import com.vaadin.tutorial.crm.Backend.Repository.CompanyRepository;
import com.vaadin.tutorial.crm.Backend.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.datatransfer.FlavorEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ContactService {

    private static final Logger LOGGER = Logger.getLogger(ContactService.class.getName());

    private ContactRepository contactRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository, CompanyRepository companyRepository){
        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public long count() {
        return contactRepository.count();
    }

    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    public void save(Contact contact) {
        if (contact == null) {
            LOGGER.log(Level.SEVERE, "Contact is null. Are you sure you have connected your form\n" +
                    "to the application?");
            return;
        }
        contactRepository.save(contact);
    }

}
