package com.n00byara.galaxystore

import 	de.robv.android.xposed.XposedHelpers.*

class Class {
    fun find(obj: Any): Any{
        return getParameterTypes(obj)
    }
}