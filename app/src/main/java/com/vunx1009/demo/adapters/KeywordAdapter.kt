package com.vunx1009.demo.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vunx1009.demo.R
import com.vunx1009.demo.objects.Keyword
import com.vunx1009.demo.utils.KeywordUtil

class KeywordAdapter : RecyclerView.Adapter<KeywordAdapter.Holder>() {
    private var keywords: List<Keyword> = ArrayList()

    fun setData(keywords: List<Keyword>) {
        this.keywords = keywords;
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_keyword, parent, false)
        return KeywordAdapter.Holder(view)
    }

    override fun getItemCount(): Int {
        return keywords.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = keywords.get(position)
        holder.textView.text = KeywordUtil.parseKeyword(item.value)
        holder.view.setBackgroundColor(item.color)
    }

    class Holder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.text)
    }
}