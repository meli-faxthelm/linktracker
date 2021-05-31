package com.linktracker.linktracker.model;

public class Link {
    private String link;
    private Long counter;

    public Link(String link) {
        this.link = link;
        this.counter = 0L;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }
    public void addCounter(){
        this.counter += 1;
    }
}
