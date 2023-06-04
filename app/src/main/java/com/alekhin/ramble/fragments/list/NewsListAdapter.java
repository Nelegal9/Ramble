package com.alekhin.ramble.fragments.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.alekhin.ramble.News;
import com.alekhin.ramble.databinding.CardNewsBinding;
import com.alekhin.ramble.fragments.theme.NewsThemeListFragmentDirections;

import java.util.ArrayList;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder> {
    ArrayList<News> newsArrayList = new ArrayList<>();

    public NewsListAdapter(ArrayList<News> newsArrayList) {
        this.newsArrayList = newsArrayList;
    }

    public static class NewsListViewHolder extends RecyclerView.ViewHolder {
        CardNewsBinding binding;

        public NewsListViewHolder(@NonNull CardNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(News news) {
            binding.newsPubDate.setText(news.newsPubDate);
            binding.newsTitle.setText(news.newsTitle);
            binding.newsDescription.setText(news.newsDescription);
            binding.newsAuthor.setText(news.newsAuthor);
            binding.newsCard.setOnClickListener(v -> {
                NavDirections action = NewsThemeListFragmentDirections.actionNewsThemeListFragmentToNewsFragment(news);
                Navigation.findNavController(v).navigate(action);
            });
        }
    }

    @NonNull
    @Override
    public NewsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsListViewHolder(CardNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListViewHolder holder, int position) {
        holder.bind(newsArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    /* JUST IN CASE */
    @SuppressLint("NotifyDataSetChanged")
    void addNews(News news) {
        newsArrayList.add(news);
        notifyDataSetChanged();
    }
    /**/
    /* JUST IN CASE
    @SuppressLint("NotifyDataSetChanged")
    void updateNews(ArrayList<News> newsArrayList) {
        this.newsArrayList = newsArrayList;
        notifyDataSetChanged();
    }
    */
}