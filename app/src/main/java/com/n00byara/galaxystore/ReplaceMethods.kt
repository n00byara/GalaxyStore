package com.n00byara.galaxystore

import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedBridge.*
import java.lang.Class


class ReplaceMethods{

    fun replaceAllMethods(clazz: Class<*>, methodName: String, value: Any){
        hookAllMethods(clazz, methodName, object : XC_MethodReplacement(){
            override fun replaceHookedMethod(param: MethodHookParam): Any {
                log("перехват метода: " + methodName + " из класса: " + clazz.name)
                return value
            }
        })
    }
}