package com.demo.zyl.helloworld.bean

import java.io.Serializable

/**
 * Created by zhaoyongliang on 2017/5/19.
 */
data class Person(
        var name: String,
        var age: Int
) : Serializable