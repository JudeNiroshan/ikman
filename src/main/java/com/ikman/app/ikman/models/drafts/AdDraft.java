package com.ikman.app.ikman.models.drafts;

import com.ikman.app.ikman.models.Ad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class AdDraft {

    private String name;

    private String popUrl;

    private String description;

    private String price;

    private Set<ImageDraft> imageDrafts;

    private Set<ContactDraft> contactDrafts;

    private CategoryDraft categoryDraft;

    private LocationDraft locationDraft;

    private String status;

    public static AdDraft getDraftByModel(Ad ad) {
        Hibernate.initialize(ad.getImages());
        Hibernate.initialize(ad.getCategory());
        Hibernate.initialize(ad.getContacts());
        Hibernate.initialize(ad.getLocation());

        Set<ImageDraft> imageDrafts = ad.getImages().stream()
                .map(ImageDraft::getDraftByModel)
                .collect(Collectors.toSet());

        Set<ContactDraft> contactDrafts = ad.getContacts().stream()
                .map(ContactDraft::getDraftByModel)
                .collect(Collectors.toSet());


        return new AdDraftBuilder()
                .name(ad.getName())
                .popUrl(ad.getPop_url())
                .description(ad.getDescription())
                .price(ad.getPrice())
                .status(ad.getStatus())
                .imageDrafts(imageDrafts)
                .contactDrafts(contactDrafts)
                .categoryDraft(CategoryDraft.getDraftByModel(ad.getCategory()))
                .locationDraft(LocationDraft.getDraftByModel(ad.getLocation()))
                .build();
    }
}
