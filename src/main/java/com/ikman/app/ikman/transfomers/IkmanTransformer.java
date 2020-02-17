package com.ikman.app.ikman.transfomers;

import com.ikman.app.ikman.models.drafts.AdDraft;
import com.ikman.app.ikman.models.drafts.CategoryDraft;
import com.ikman.app.ikman.models.drafts.LocationDraft;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class IkmanTransformer {

    public AdDraft transform(Element element) {

        Elements adElement = element.select("a");
        String name = adElement.attr("title");
        String linkAsDescription = adElement.attr("href");
        String priceAsText = adElement.select("[class~=^price]").select("span").text();
        String locationAndCategory = element.select("div[class~=description--2]").text();

        int indexDeli = locationAndCategory.indexOf(',');
        String location = locationAndCategory.substring(0, indexDeli > 0 ?
                indexDeli : locationAndCategory.length());
        String category = locationAndCategory.substring(Math.max(indexDeli + 1, 0));

        return createAdObj(name, linkAsDescription, priceAsText, category, location);
    }

    private AdDraft createAdObj(String name, String desc, String price, String category, String location) {
        CategoryDraft categoryDraft = CategoryDraft.builder().categoryName(category).build();
        LocationDraft locationDraft = LocationDraft.builder().locationName(location).build();
        return AdDraft.builder().name(name)
                .description(desc)
                .price(price)
                .categoryDraft(categoryDraft)
                .locationDraft(locationDraft)
                .build();
    }
}
