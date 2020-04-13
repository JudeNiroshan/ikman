package com.ikman.app.ikman.init;

import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.models.drafts.AdDraft;
import com.ikman.app.ikman.transfomers.DetailedIkmanTransformer;
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

    private final String baseUrl = "https://ikman.lk";
    private final String url;
    private final IkmanTransformer transformer;
    private final DetailedIkmanTransformer detailedIkmanTransformer;

    public IkmanFetcher(@Value("${data.provider.website}") String url, IkmanTransformer transformer,
                        DetailedIkmanTransformer detailedIkmanTransformer) {
        this.url = url;
        this.transformer = transformer;
        this.detailedIkmanTransformer = detailedIkmanTransformer;
    }

    @Override
    public List<AdDraft> fetch() throws IOException {
        Document document = Jsoup.connect(url).get();

        Elements adElements = document.select("li[class~=gtm-normal-ad]");
        return adElements.stream().map(transformer::transform)
                .collect(Collectors.toList());
    }

    public AdDraft fetchDetails(AdDraft adDraft) throws IOException {
        Document document = Jsoup.connect(baseUrl + adDraft.getPopUrl()).get();
        return detailedIkmanTransformer.transform(adDraft, document);
    }
}
