package com.example.addressbook.service;

import com.example.addressbook.model.Contact;
import com.example.addressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }
    public Contact updateContact(Long id, Contact contact) {
        Contact existingContact = contactRepository.getById(id);
        existingContact.setName(contact.getName());
        existingContact.setAddress(contact.getAddress());
        return contactRepository.save(existingContact);
    }
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
