package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cats {
    private final String id, text, type, user;
    private final Integer upvotes;

    public Cats(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") Integer upvotes){
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;

    }

    public String getId(){
        return this.id;
    }

    public String getText(){
        return this.text;
    }

    public String getType(){
        return this.type;
    }

    public String getUser(){
        return this.user;
    }

    public Integer getUpvotes(){
        return this.upvotes;
    }

    @Override
    public String toString() {
        return "id = " + this.id +
                " text = " + this.text +
                " type = " + this.type +
                " user = " + this.user +
                " upvotes = " + this.upvotes;
    }
}
