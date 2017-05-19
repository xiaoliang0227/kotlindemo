package com.demo.zyl.helloworld

import android.os.AsyncTask
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.demo.zyl.helloworld.adapter.PersonListAdapter
import com.demo.zyl.helloworld.bean.Person
import com.demo.zyl.helloworld.task.PersonDataFetchTask
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener, PersonDataFetchTask.PersonDataFetchTaskCallback {

    var adapter:PersonListAdapter? = null

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
        addBtnTestClickListener();
    }

    private fun addBtnTestClickListener() {
        btn_test.setOnClickListener(this)
    }

    private fun initView() {
        initTvTest()
    }

    private fun initTvTest() {
        tv_test.setText(R.string.tv_test)
        tv_test.setTextSize(20.0f)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tv_test.setTextColor(resources.getColor(R.color.colorAccent, theme))
        } else {
            tv_test.setTextColor(resources.getColor(R.color.colorAccent))
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.btn_test) {
                btnTextClicked()
            }
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
    override fun returnPersonData(data: MutableList<Person>) {
        if (null != data) {
            adapter = PersonListAdapter(this, data)
            person_list.adapter = adapter
        }
    }
}
