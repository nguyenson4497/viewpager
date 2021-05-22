package com.example.calendar.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.calendar.R
import com.example.calendar.model.DateModel
import com.example.calendar.recyclerview.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_month.*
import java.util.*


class MonthFragment : Fragment(), RecyclerViewAdapter.OnClickListener {

    private val calendar = Calendar.getInstance()
    private val listDataOfAMonth: MutableList<Date> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_month, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recyclerViewAdapter = RecyclerViewAdapter(this)

        val gridLayoutManager = GridLayoutManager(context, 7, GridLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerViewAdapter.setData(dataForCalendar())
        recyclerView.adapter = recyclerViewAdapter

    }

    private fun dataForCalendar(): MutableList<DateModel> {
        val list: MutableList<DateModel> = mutableListOf()
        val calMonth = calendar.clone() as Calendar
        calMonth.set(Calendar.DAY_OF_MONTH, 1)
        calMonth.set(Calendar.MONTH, Calendar.MAY)
        calMonth.set(Calendar.YEAR, 2021)
        calMonth.firstDayOfWeek = 3
        listDataOfAMonth.clear()
        while (true) {
            if (calMonth.time.day == 6) {
                break
            } else {
                calMonth.add(Calendar.DAY_OF_MONTH, -1)
            }
        }
        while (listDataOfAMonth.size < 42) {
            listDataOfAMonth.add(calMonth.time)
            calMonth.add(Calendar.DAY_OF_MONTH, 1)
            list.add(DateModel(calMonth.time))
        }

        return list
    }

    override fun onClickListener(position: Int) {
        val rnd = Random()
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))

    }

    override fun onDoubleClickListener(position: Int) {

    }

    fun changeColor() {

    }

    fun changeSingleColor() {

    }
}