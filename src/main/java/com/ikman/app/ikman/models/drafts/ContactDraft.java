package com.ikman.app.ikman.models.drafts;

import com.ikman.app.ikman.models.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ContactDraft {

    private String contactNumber;

    public static ContactDraft getDraftByModel(Contact contact) {
        return new ContactDraftBuilder()
                .contactNumber(contact.getContactNumber())
                .build();
    }
}
