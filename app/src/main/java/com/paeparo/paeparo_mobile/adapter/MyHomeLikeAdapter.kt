package com.paeparo.paeparo_mobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paeparo.paeparo_mobile.databinding.ItemMyhomeLikeBinding
import com.paeparo.paeparo_mobile.model.Post
import timber.log.Timber

class MyHomeLikeAdapter(private var likedPostList:MutableList<Post>):RecyclerView.Adapter<MyHomeLikeAdapter.MyHomeLikeViewHoloder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHomeLikeViewHoloder {
        val binding = ItemMyhomeLikeBinding.inflate(LayoutInflater.from(parent.context),parent,false,)
        return MyHomeLikeViewHoloder(binding)
    }

    override fun getItemCount(): Int = likedPostList.size

    override fun onBindViewHolder(holder: MyHomeLikeViewHoloder, position: Int) {
        holder.bind(likedPostList[position])
    }

    class MyHomeLikeViewHoloder(private  val binding: ItemMyhomeLikeBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post){
            with(binding){
                title.text = post.title

            }
        }
    }
}