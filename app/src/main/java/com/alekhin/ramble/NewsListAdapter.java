package com.alekhin.ramble;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alekhin.ramble.databinding.CardNewsBinding;

import java.util.ArrayList;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder> {
    ArrayList<News> newsArrayList = new ArrayList<>();

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