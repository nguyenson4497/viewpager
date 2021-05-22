package com.example.calendar.recyclerview

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar.R
import com.example.calendar.model.DateModel


class RecyclerViewAdapter(val listener: OnClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    private var listData: MutableList<DateModel> = mutableListOf()
    private lateinit var runnable: Runnable
    private var i: Int = 0

    fun setData(calendarList: MutableList<DateModel>) {
        this.listData = calendarList
        notifyDataSetChanged()
    }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val dayOfMonth: TextView = itemView.findViewById(R.id.txtView_date)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val pos: Int = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                i++
                val mHandler = Handler()
                runnable = Runnable {
                    i = 0
                }
                if (i == 1) {
                    mHandler.postDelayed(runnable, 250)
                    listener.onClickListener(pos)
                }
                if (i == 2) {
                    i = 0
                    listener.onDoubleClickListener(pos)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_recycler, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.dayOfMonth.text = listData[position].dataDate.date.toString()
    }

    interface OnClickListener {
        fun onClickListener(position: Int)
        fun onDoubleClickListener(position: Int)
    }
}