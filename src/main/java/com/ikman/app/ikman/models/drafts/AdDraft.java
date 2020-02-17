package com.ikman.app.ikman.models.drafts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class AdDraft {

    private String name;

    private String description;

    private String price;

    private CategoryDraft categoryDraft;

    private LocationDraft locationDraft;
}
