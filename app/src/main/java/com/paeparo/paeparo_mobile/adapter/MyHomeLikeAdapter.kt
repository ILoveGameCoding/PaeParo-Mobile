package com.paeparo.paeparo_mobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.paeparo.paeparo_mobile.R
import com.paeparo.paeparo_mobile.TestMyHomeData

class MyHomeLikeAdapter(var datas: MutableList<TestMyHomeData>):RecyclerView.Adapter<MyHomeLikeAdapter.MyHomeLikeViewHoloder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHomeLikeViewHoloder {
        return MyHomeLikeViewHoloder(LayoutInflater.from(parent.context).inflate(R.layout.item_myhome_like,parent,false))
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: MyHomeLikeViewHoloder, position: Int) {
        holder.bind(datas[position])
    }

    class MyHomeLikeViewHoloder(view: View):RecyclerView.ViewHolder(view) {
        val button:TextView =view.findViewById(R.id.button)
        fun bind(position: TestMyHomeData){
            button.text= position.num.toString()
            button.setOnClickListener(){
                button.text="클릭했다!"
            }
        }
    }
}