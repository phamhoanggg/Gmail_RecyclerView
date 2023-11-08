package com.example.gmail_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Adapter(private val items: ArrayList<GmailModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item, parent, false)
            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder
        }
        viewHolder.bind(items[position])
        return itemView
    }

    class ViewHolder(private val itemView: View) {
        private val imageAvatar: ImageView = itemView.findViewById(R.id.imgAvatar)
        val imageMark: ImageView = itemView.findViewById(R.id.imgMark)
        private val sender: TextView = itemView.findViewById(R.id.txtSender)
        private val title: TextView = itemView.findViewById(R.id.txtTitle)
        private val content: TextView = itemView.findViewById(R.id.txtContent)
        private val time: TextView = itemView.findViewById(R.id.txtTime)

        fun bind(gmailModel: GmailModel) {
            Glide.with(itemView).load(gmailModel.logoPath).centerCrop()
                .placeholder(R.drawable.ic_launcher_background).into(imageAvatar)
            sender.text = gmailModel.sender
            title.text = gmailModel.title
            content.text = gmailModel.content
            time.text = gmailModel.time
        }
    }
}