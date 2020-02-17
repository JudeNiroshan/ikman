package com.ikman.app.ikman.models.drafts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CategoryDraft {

    private String categoryName;
}
