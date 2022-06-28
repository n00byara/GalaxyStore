package com.n00byara.galaxystore

import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage
import java.lang.reflect.Type

class ReplaceMethods{

    fun returnValueWithoutsParams(className: String, lpparam: XC_LoadPackage.LoadPackageParam, methodName: String, value: Any){
        XposedHelpers.findAndHookMethod(className, lpparam.classLoader, methodName, object : XC_MethodReplacement(){
            override fun replaceHookedMethod(param: MethodHookParam?): Any {
                return value
            }
        })
    }













    fun returnBoolen(className: String, lpparam: XC_LoadPackage.LoadPackageParam, methodName: String){//, type : Boolean) {
        XposedHelpers.findAndHookMethod(className, lpparam.classLoader, methodName, object : XC_MethodReplacement(){
            override fun replaceHookedMethod(param: MethodHookParam?): Any {
                return true
            }
        })
    }

    fun returnString(className: String, lpparam: XC_LoadPackage.LoadPackageParam, methodName: String, returnedString: String ){
        XposedHelpers.findAndHookMethod(className, lpparam.classLoader, methodName, object : XC_MethodReplacement(){
            override fun replaceHookedMethod(param: MethodHookParam?): Any {
                XposedBridge.log(className + " возвращаю: " + returnedString)
                return returnedString
            }
        })
    }
}