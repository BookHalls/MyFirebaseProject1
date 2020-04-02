package com.example.myfirebaseproject1;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Author {
private String authorId,authoreName,authorSubject;

    public Author(){

    }
    public Author(String authorId, String authoreName, String authorSubject) {
        this.authorId = authorId;
        this.authoreName = authoreName;
        this.authorSubject = authorSubject;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthoreName() {
        return authoreName;
    }

    public void setAuthoreName(String authoreName) {
        this.authoreName = authoreName;
    }

    public String getAuthorSubject() {
        return authorSubject;
    }

    public void setAuthorSubject(String authorSubject) {
        this.authorSubject = authorSubject;
    }
}
