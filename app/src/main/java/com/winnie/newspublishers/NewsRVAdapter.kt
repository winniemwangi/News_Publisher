package com.winnie.newspublishers



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.winnie.newspublishers.databinding.NewsListItemBinding

class NewsRVAdapter( var newsList: List<News>): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var binding = NewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        var currentNews = newsList.get(position)
        holder.binding.tvCategory.text = currentNews.category
        holder.binding.tvHeadline.text = currentNews.headline
        holder.binding.tvBody.text = currentNews.body

        Picasso.get().load(currentNews.base).resize(650,400).centerCrop().into(holder.binding.imgBase)
        Picasso.get().load(currentNews.logo).resize(50, 50).centerCrop().into(holder.binding.imgLogo)




    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}

class NewsViewHolder(val binding: NewsListItemBinding):
        RecyclerView.ViewHolder(binding.root)