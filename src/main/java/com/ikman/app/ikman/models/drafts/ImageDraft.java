package com.ikman.app.ikman.models.drafts;

import com.ikman.app.ikman.models.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ImageDraft {

    private String imageUrl;

    public static ImageDraft getDraftByModel(Image image) {
        return new ImageDraftBuilder()
                .imageUrl(image.getImageUrl())
                .build();
    }
}
