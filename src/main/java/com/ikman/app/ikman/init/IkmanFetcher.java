package com.ikman.app.ikman.init;

import com.ikman.app.ikman.models.drafts.AdDraft;
import com.ikman.app.ikman.transfomers.IkmanTransformer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IkmanFetcher implements Fetcher {

    private final String url;
    private final IkmanTransformer transformer;

    public IkmanFetcher(@Value("${data.provider.website}") String url, IkmanTransformer transformer) {
        this.url = url;
        this.transformer = transformer;
    }

    public List<AdDraft> getAllAds() throws IOException {

        Document document = Jsoup.connect(url).get();

        Elements adElements = document.select("li[class~=gtm-normal-ad]");
        return adElements.stream().map(transformer::transform)
                .collect(Collectors.toList());
    }
}
