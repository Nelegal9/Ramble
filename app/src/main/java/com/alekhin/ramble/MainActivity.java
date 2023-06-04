package com.alekhin.ramble;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.alekhin.ramble.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setDropdownMenu();
        //setSearch();
        setViewPager();
    }

    private void setDropdownMenu() {
        ArrayAdapter<String> contentVisibilityArrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.item_news_content_visibility, getResources().getStringArray(R.array.content));
        binding.newsContentVisibility.setAdapter(contentVisibilityArrayAdapter);
    }

    private void setSearch() {

    }


    private void setViewPager() {
        NewsThemeListAdapter newsThemeListAdapter = new NewsThemeListAdapter(getSupportFragmentManager(), getLifecycle());
        binding.newsThemeList.setAdapter(newsThemeListAdapter);

        new TabLayoutMediator(binding.newsThemeTab, binding.newsThemeList, (tab, position) -> tab.setText("Tab № " + (position + 1))).attach();
    }
}