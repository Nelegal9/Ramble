package com.alekhin.ramble.fragments.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.alekhin.ramble.News;
import com.alekhin.ramble.databinding.FragmentNewsBinding;

public class NewsFragment extends Fragment {
    private News news;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentNewsBinding binding = FragmentNewsBinding.inflate(inflater);

        // --- CONTENT --- //
        if (getArguments() != null) news = NewsFragmentArgs.fromBundle(getArguments()).getCurrentNews();

        binding.currentNewsPubDate.setText(news.newsPubDate);
        binding.currentNewsTitle.setText(news.newsTitle);
        binding.currentNewsDescription.setText(news.newsDescription);
        binding.currentNewsAuthor.setText(news.newsAuthor);

        binding.currentNewsShareButton.setOnClickListener(this::shareNews);
        binding.currentNewsReadFullArticleButton.setOnClickListener(this::readFullArticle);
        // --- CONTENT --- //

        return binding.getRoot();
    }

    private void shareNews(View v) {
        String newsUrl = ""; // TODO: ADD NEWS URL

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_HTML_TEXT, newsUrl);
        shareIntent.setType("text/html");
    }

    private  void readFullArticle(View v) {
        //Uri newsUri = Uri.parse(_URI_); // TODO: ADD URI

        //Intent readFullArticleIntent = new Intent(Intent.ACTION_VIEW, newsUri);
        //startActivity(readFullArticleIntent);
        // TODO: ADD READING FULL ARTICLE
    }
}