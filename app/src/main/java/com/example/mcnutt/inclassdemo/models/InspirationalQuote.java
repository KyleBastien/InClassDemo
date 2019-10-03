package com.example.mcnutt.inclassdemo.models;

public class InspirationalQuote {
    private String ID;
    private InspirationalQuoteTitle title;
    private InspirationalQuoteContent content;
    private String link;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public InspirationalQuoteTitle getTitle() {
        return title;
    }

    public void setTitle(InspirationalQuoteTitle title) {
        this.title = title;
    }

    public InspirationalQuoteContent getContent() {
        return content;
    }

    public void setContent(InspirationalQuoteContent content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
