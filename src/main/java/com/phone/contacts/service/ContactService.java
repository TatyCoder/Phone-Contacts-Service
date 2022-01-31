package com.phone.contacts.service;

import com.phone.contacts.exceptions.InformationExistException;
import com.phone.contacts.exceptions.InformationNotFoundException;
import com.phone.contacts.model.Contact;
import com.phone.contacts.model.User;
import com.phone.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<Contact> getAllContacts(Long userId){
        User user = userService.getUser(userId).get();
        List<Contact> contact = contactRepository.getAllContactsByUser(user);
        return contact;
    }

    public Contact createContact(Long userId, Contact contactObject) {
        User user = userService.getUser(userId).get();
        Contact contact = contactRepository.getContactByUserAndName(user, contactObject.getName());
        if (contact == null) {
            return contactRepository.save(contactObject);
        } else {
            throw new InformationExistException("contact exists, cannot add");
        }
    }


    public Contact getContactById(Long userId, Long contactId){
        User user = userService.getUser(userId).get();
        Contact contact  = contactRepository.getContactByUserAndContactId(user, contactId);
        if (contact != null) {
            return contact;
        } else {
            throw new InformationNotFoundException("contact with id " + contactId + " not found.");
        }
    }
}
