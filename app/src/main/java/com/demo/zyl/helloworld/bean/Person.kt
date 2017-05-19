package com.demo.zyl.helloworld.bean

import java.io.Serializable

/**
 * Created by zhaoyongliang on 2017/5/19.
 */
class Person: Serializable {

    private var _name: String? = null
    var name: String?
        get() = _name
        set(value) {
            _name = value
        }

    private var _age: Int? = 0
    var age: Int?
        get() = _age
        set(value) {
            _age = value
        }

    override fun toString(): String {
        return "Person(_name=$_name, _age=$_age)"
    }


}