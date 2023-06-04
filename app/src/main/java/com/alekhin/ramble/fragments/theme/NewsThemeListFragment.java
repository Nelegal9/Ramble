package com.alekhin.ramble.fragments.theme;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.alekhin.ramble.R;
import com.alekhin.ramble.databinding.FragmentNewsThemeListBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class NewsThemeListFragment extends Fragment {
    FragmentNewsThemeListBinding binding;

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
    }

    private void setSearch() {
        // TODO: ADD SEARCH
    }


    private void setViewPager() {
        NewsThemeListAdapter newsThemeListAdapter = new NewsThemeListAdapter(getChildFragmentManager(), getLifecycle());
        binding.newsThemeList.setAdapter(newsThemeListAdapter);

        new TabLayoutMediator(binding.newsThemeTab, binding.newsThemeList, (tab, position) -> tab.setText("Tab № " + (position + 1))).attach();
    }
}