package com.ikman.app.ikman.transfomers;

import com.ikman.app.ikman.models.drafts.AdDraft;
import com.ikman.app.ikman.models.drafts.ContactDraft;
import com.ikman.app.ikman.models.drafts.ImageDraft;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DetailedIkmanTransformer {

    public AdDraft transform(AdDraft adDraft, Document document){
        System.out.println(document);
        String description = document.select("div[class=item-description]").text();
        String itemProperties = document.select("div[class=item-properties]").text();
        Elements imageElements = document.select("div[class=gallery-item]");
        Elements contactElements = document.select("div[class~=item-contact-more]");

        Set<ImageDraft> allImages = getAllImages(imageElements);
        Set<ContactDraft> allContacts = getAllContacts(contactElements);

        adDraft.setDescription(description);
        adDraft.setImageDrafts(allImages);
        adDraft.setContactDrafts(allContacts);
        return adDraft;
    }

    private Set<ImageDraft> getAllImages(Elements imageElements){
        Elements images = imageElements.select("img");
        return images.stream()
                .map(element -> element.attr("data-srcset"))
                .map(this::getImageUrlBySrcSetString)
                .filter(Objects::nonNull)
                .map(ImageDraft::new)
                .collect(Collectors.toSet());
    }

    private String getImageUrlBySrcSetString(String setString){
        String[] srcs = setString.split(",");
        switch (srcs.length){
            case 1: return srcs[0].trim().substring(2, srcs[0].lastIndexOf(" ")).trim();
            case 2: return srcs[1].trim().substring(2, srcs[1].lastIndexOf(" ")).trim();
        }
        return null;
    }
    private Set<ContactDraft> getAllContacts(Elements contactElements){

     return contactElements.select("span").stream()
                .map(Element::text)
                .map(ContactDraft::new)
                .collect(Collectors.toSet());
    }
}
