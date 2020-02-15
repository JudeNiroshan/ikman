package com.ikman.app.ikman.transfomers;

import com.ikman.app.ikman.models.drafts.AdDraft;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class IkmanTransformer {

    public AdDraft transform(Element element) {

        Elements adElement = element.select("a");
        String name = adElement.attr("title");
        String linkAsDescription = adElement.attr("href");

        Elements select = adElement.select("[class~=^price]").select("span");
        String priceAsText = select.text();

        return createAdObj(name, linkAsDescription, priceAsText);
    }



    private AdDraft createAdObj(String name, String desc, String price) {
        return new AdDraft(name, desc, price);
    }
}
