package com.demo.zyl.helloworld

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.demo.zyl.helloworld.bean.Person
import kotlinx.android.synthetic.main.act_person_detail.*

/**
 * Created by zhaoyongliang on 2017/5/19.
 */

class PersonDetailActivity : AppCompatActivity() {

    var person: Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_person_detail)
        init()
    }

    private fun init() {
        initData()
    }

    private fun initData() {
        var intent:Intent = intent
        if (intent.hasExtra("person")) {
            person = intent.getSerializableExtra("person") as Person?
        }
        if (null != person) {
            name.text = person!!.name
            age.text = person!!.age.toString()
        }
    }
}
