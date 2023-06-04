package com.alekhin.ramble.fragments.theme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.alekhin.ramble.R;
import com.alekhin.ramble.databinding.FragmentNewsThemeListBinding;
import com.alekhin.ramble.fragments.list.NewsListFragment;
import com.google.android.material.tabs.TabLayoutMediator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class NewsThemeListFragment extends Fragment {
    private FragmentNewsThemeListBinding binding;

    private String[] newsTabThemes;

    private List<NewsListFragment> newsListFragments;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNewsThemeListBinding.inflate(inflater);

        // --- CONTENT --- //
        setDropdownMenu();
        //setSearch();
        setViewPager();
        // --- CONTENT --- //

        return binding.getRoot();
    }

    private void setDropdownMenu() {
        ArrayAdapter<String> contentVisibilityArrayAdapter = new ArrayAdapter<>(requireContext(), R.layout.item_news_content_visibility, getResources().getStringArray(R.array.content));
        binding.newsContentVisibility.setAdapter(contentVisibilityArrayAdapter);

        // TODO: ADD VISIBILITY STATE CHANGER
    }

    private void setSearch() {
        // TODO: ADD SEARCH
    }


    private void setViewPager() {
        newsTabThemes = new String[] {"Moscow", "Politics", "Community", "Incidents"};

        try {
            newsListFragments = Arrays.asList(
                    new NewsListFragment(new URL("https://news.rambler.ru/rss/Moscow/")),
                    new NewsListFragment(new URL("https://news.rambler.ru/rss/politics/")),
                    new NewsListFragment(new URL("https://news.rambler.ru/rss/community/")),
                    new NewsListFragment(new URL("https://news.rambler.ru/rss/incidents/")));

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        NewsThemeListAdapter newsThemeListAdapter = new NewsThemeListAdapter(getChildFragmentManager(), getLifecycle(), newsListFragments);
        binding.newsThemeList.setAdapter(newsThemeListAdapter);

        new TabLayoutMediator(binding.newsThemeTab, binding.newsThemeList, (tab, position) -> tab.setText(newsTabThemes[position])).attach();
    }
}