package com.portfolio.portfolio.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolio.model.Contact;
import com.portfolio.portfolio.model.Education;
import com.portfolio.portfolio.model.Person;
import com.portfolio.portfolio.repository.IContactRepository;
import com.portfolio.portfolio.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IContactService {
    @Autowired
    private IContactRepository contactRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public List<Contact> contacts() {
        List<Contact> contacts = contactRepository.findAll();

        return contacts;
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact findContact(Integer id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isPresent()){
            return mapper.convertValue(contact, Contact.class);
        }
        return null;
    }

    @Override
    public void deleteContact(Integer id) {
        contactRepository.deleteById(id);
    }
}
