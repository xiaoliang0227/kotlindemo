package com.demo.zyl.helloworld.task

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import com.demo.zyl.helloworld.bean.Person
import java.lang.Math.random

/**
 * Created by zhaoyongliang on 2017/5/19.
 */
class PersonDataFetchTask(var context: Context? = null): AsyncTask<Void, Void, MutableList<Person>>() {

    var loading: ProgressDialog? = null

    private var _callback: PersonDataFetchTaskCallback? = null

    var callback: PersonDataFetchTaskCallback?
        get() = _callback
        set(value) {
            _callback = value
        }


    override fun onPostExecute(result: MutableList<Person>?) {
        super.onPostExecute(result)
        if (null != loading) {
            loading!!.dismiss()
        }
        if (null != callback) {
            callback!!.returnPersonData(result!!)
        }
    }

    override fun onPreExecute() {
        super.onPreExecute()
        loading = ProgressDialog.show(context, null, "获取数据中，请稍候")
    }

    override fun doInBackground(vararg params: Void?): MutableList<Person> {
        var data: MutableList<Person> = mutableListOf()
        val size:Int = (random() * 20).toInt()
        for (i: Int in 0..size) {
            var item: Person = Person()
            item.name = "测试" + (i + 1)
            item.age = (random() * 10).toInt() + 20
            data!!.add(item)
        }
        Thread.sleep(3000)
        return data
    }

    interface PersonDataFetchTaskCallback {

        /**
         * return person data
         */
        fun returnPersonData(data: MutableList<Person>)
    }
}
