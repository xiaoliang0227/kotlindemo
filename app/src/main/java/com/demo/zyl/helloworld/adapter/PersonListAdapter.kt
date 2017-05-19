package com.demo.zyl.helloworld.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.demo.zyl.helloworld.R
import com.demo.zyl.helloworld.bean.Person

/**
 * Created by zhaoyongliang on 2017/5/19.
 */
class PersonListAdapter(var context: Context? = null, var data: List<Person>? = null) : BaseAdapter() {


    override fun getView(position: Int, contentView: View?, parent: ViewGroup?): View {
        var holder: ViewHolder? = null
        var view: View? = null
        if (null == contentView) {
            holder = ViewHolder()
            view = LayoutInflater.from(context).inflate(R.layout.person_item, parent, false)
            holder.photo = view.findViewById(R.id.photo) as ImageView?
            holder.name = view.findViewById(R.id.name) as TextView?
            view.tag = holder
        } else {
            holder = contentView.tag as ViewHolder?
            view = contentView
        }
        var person: Person = data!![position]
        holder?.name?.text = person.name
        return view!!
    }

    override fun getItem(position: Int): Any? {
        return if(data == null) null else data!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return if (data == null) 0 else data!!.size
    }

    class ViewHolder {

        var photo: ImageView? = null

        var name: TextView? = null
    }
}