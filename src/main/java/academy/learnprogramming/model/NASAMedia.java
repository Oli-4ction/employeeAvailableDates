package academy.learnprogramming.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NASAMedia {

    public final String date;
    public final String explanation;
    public final String hdurl;
    public final String mediaType;
    public final String serviceVersion;
    public final String title;
    public final String url;

    public NASAMedia(@JsonProperty("date") String date,
                @JsonProperty("explanation") String explanation,
                @JsonProperty("hdurl") String hdurl,
                @JsonProperty("media_type") String mediaType,
                @JsonProperty("service_version") String serviceVersion,
                @JsonProperty("title") String title,
                @JsonProperty("url") String url) {

        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

}
