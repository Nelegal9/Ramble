package com.alekhin.ramble.fragments.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alekhin.ramble.News;
import com.alekhin.ramble.R;
import com.alekhin.ramble.databinding.FragmentNewsListBinding;

public class NewsListFragment extends Fragment {
    private FragmentNewsListBinding binding;

    public static final String TITLE = "Title";

    private final NewsListAdapter newsListAdapter = new NewsListAdapter();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNewsListBinding.inflate(getLayoutInflater());

        // --- CONTENT --- //
        setAdapter();
        // --- CONTENT --- //

        return binding.getRoot();
    }

    private void setAdapter() {
        newsListAdapter.addNews(new News(getString(R.string.news_pub_date), getString(R.string.news_title), getString(R.string.news_description), getString(R.string.news_author)));
        binding.newsList.setAdapter(newsListAdapter);
        binding.newsList.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}