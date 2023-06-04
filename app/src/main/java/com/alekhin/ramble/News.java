package com.alekhin.ramble;

public class News {
    String newsPubDate;
    String newsTitle;
    String newsDescription;
    String newsAuthor;

    public News(String newsPubDate, String newsTitle, String newsDescription, String newsAuthor) {
        this.newsPubDate = newsPubDate;
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsAuthor = newsAuthor;
    }
}