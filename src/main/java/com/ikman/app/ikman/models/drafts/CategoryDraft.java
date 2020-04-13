package com.ikman.app.ikman.models.drafts;

import com.ikman.app.ikman.models.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CategoryDraft{

    private String categoryName;

    public static CategoryDraft getDraftByModel(Category category) {
        return new CategoryDraftBuilder()
                .categoryName(category.getCategoryName())
                .build();
    }
}
