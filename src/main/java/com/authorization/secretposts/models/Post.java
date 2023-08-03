package com.authorization.secretposts.models;

import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String textContent;

    @ManyToOne
    SiteUser siteUser;

    protected Post() {}

    public Post(String textContent) {
        this.textContent = textContent;
    }

    public Post(String textContent, SiteUser siteUser) {
        this.textContent = textContent;
        this.siteUser = siteUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public SiteUser getSiteUser() {
        return siteUser;
    }

    public void setSiteUser(SiteUser siteUser) {
        this.siteUser = siteUser;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", textContent='" + textContent + '\'' +
                ", siteUser=" + siteUser +
                '}';
    }
}
