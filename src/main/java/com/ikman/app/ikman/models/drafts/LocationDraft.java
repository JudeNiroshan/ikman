package com.ikman.app.ikman.models.drafts;

import com.ikman.app.ikman.models.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class LocationDraft{

    private String locationName;

    public static LocationDraft getDraftByModel(Location location) {
        return new LocationDraftBuilder()
                .locationName(location.getLocationName())
                .build();
    }
}
