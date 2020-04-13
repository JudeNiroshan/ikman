package com.ikman.app.ikman.service;

import com.ikman.app.ikman.models.Contact;
import com.ikman.app.ikman.models.drafts.ContactDraft;
import com.ikman.app.ikman.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact getContactByDraft(ContactDraft contactDraft) {
        Contact existingContact = contactRepository.findByContactNumber(contactDraft.getContactNumber());
        if (existingContact == null) {
            return contactRepository.save(new Contact(contactDraft.getContactNumber()));
        }

        return existingContact;
    }

}
