package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class NasaContent {

    private final Date date;
    private final String explanation;
    private final String hdurl;
    private final String mediaType;
    private final String serviceVersion;
    private final String title;
    private final String url;

    public NasaContent(
            @JsonProperty("date") Date date,
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

    public Date getDate() {
        return this.date;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public String getHdurl() {
        return this.hdurl;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getServiceVersion() {
        return this.serviceVersion;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    @Override
    public String toString() {
        return "date: " + this.date + "\n explanation: " + this.explanation + "\n hdurl: " +
                this.hdurl + "\n media_type: " + this.mediaType + "\n service_version: " + this.serviceVersion +
                "\n title: " + this.title + "\n url: " + this.url;
    }
}
