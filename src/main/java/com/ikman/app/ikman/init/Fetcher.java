package com.ikman.app.ikman.init;

import com.ikman.app.ikman.models.drafts.AdDraft;

import java.util.List;

public interface Fetcher {
    List<AdDraft> fetch() throws Exception;
}
