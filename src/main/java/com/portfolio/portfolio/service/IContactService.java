package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Contact;

import java.util.List;

public interface IContactService {
    public Contact saveContact (Contact contact);

    public Contact updateContact (Contact contact);

    public Contact findContact (Integer id);

    public List<Contact> contacts();

    public void deleteContact (Integer id);
}
