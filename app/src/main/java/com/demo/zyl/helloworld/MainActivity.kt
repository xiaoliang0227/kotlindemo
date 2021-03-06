package com.demo.zyl.helloworld

import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.demo.zyl.helloworld.adapter.PersonListAdapter
import com.demo.zyl.helloworld.bean.Person
import com.demo.zyl.helloworld.task.PersonDataFetchTask
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),
        PersonDataFetchTask.PersonDataFetchTaskCallback {

    var adapter: PersonListAdapter? = null

    var data: MutableList<Person>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        initView()
        initEvent()
    }

    private fun initEvent() {
        addBtnTestClickListener()
        addPersonItemClickListener()
    }

    private fun addPersonItemClickListener() {
        person_list.setOnItemClickListener {
            parent, view, position, id ->
            if (null != data) {
                var person: Person = data!![position]
                jumpToPersonDetail(person)
            }
        }
    }

    private fun  jumpToPersonDetail(person: Person) {
        var intent:Intent = Intent(MainActivity@this, PersonDetailActivity::class.java)
        intent.putExtra("person", person)
        startActivity(intent)
    }

    private fun addBtnTestClickListener() {
        btn_test.setOnClickListener {
            btnTextClicked()
        }
    }

    private fun initView() {
        initTvTest()
    }

    private fun initTvTest() {
        tv_test.text = resources.getText(R.string.tv_test)
        tv_test.textSize = 20.0f
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tv_test.setTextColor(resources.getColor(R.color.colorAccent, theme))
        } else {
            tv_test.setTextColor(resources.getColor(R.color.colorAccent))
        }
    }

    private fun btnTextClicked() {
        var task: PersonDataFetchTask = PersonDataFetchTask(this)
        task.callback = this
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
    }

    /**
     * return person data
     */
    override fun returnPersonData(data: ArrayList<Person>) {
        if (null != data) {
            this.data = data
            adapter = PersonListAdapter(this, data)
            person_list.adapter = adapter
        }
    }
}
