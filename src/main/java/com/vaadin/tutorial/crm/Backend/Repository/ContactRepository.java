package com.vaadin.tutorial.crm.Backend.Repository;

import com.vaadin.tutorial.crm.Backend.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
