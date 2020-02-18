package com.ikman.app.ikman.service;

import com.ikman.app.ikman.models.Location;
import com.ikman.app.ikman.models.drafts.LocationDraft;
import com.ikman.app.ikman.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location getLocationByDraft(LocationDraft draft) {
        Location location = locationRepository.findLocationByName(draft.getLocationName());
        if (location == null || location.getId() <= 0) {
            return locationRepository.save(new Location(draft.getLocationName()));
        }
        return location;
    }
}
