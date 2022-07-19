package com.n00byara.galaxystore

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedBridge.*
import de.robv.android.xposed.XposedHelpers.*
import de.robv.android.xposed.callbacks.XC_LoadPackage

class Xposed : IXposedHookLoadPackage{

    private val booleanClassAndMethodCollection = mapOf("com.sec.android.app.commonlib.doc.Device" to "isSamsungDevice",
        "com.sec.android.app.samsungapps.utility.ThemeUtil" to "isEnableAOD",
        "com.google.android.material.internal.ManufacturerUtils" to "isSamsungDevice",
        "a.a.b.c.b" to "isSupported")
    private val stringsClassAndMethodsCollection = mapOf("com.sec.android.app.commonlib.doc.Device" to "getManufacturer", "com.sec.android.app.commonlib.doc.Device" to "getModelName")
    private val strings = arrayOf("Samsung", "SM-780G")
    private var i = 0


    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {

        if (lpparam.packageName != "com.sec.android.app.samsungapps") {
            log("NOT: " + lpparam.processName)
            return
        }
        log("*******************************************************************")
        val replaceMethods = ReplaceMethods()
        val clazz = findClass("com.sec.android.app.commonlib.doc.Device", lpparam.classLoader)

        val array = findMethodsByExactParameters(clazz, String::class.java)
        for (className in array){
            if(Regex("""^getManufacturer$""").find(className.toString()) != null){
                continue
            } else if (Regex("""^getModelName$""").find(className.toString()) != null){
                log("model")
            }
        }



    }
}


//        booleanClassAndMethodCollection.forEach{className, methodName ->
//        val clazz = findClass(className, lpparam.classLoader)
//            replaceMethods.replaceAllMethods(clazz, methodName, true)
//        }
//
//
//        stringsClassAndMethodsCollection.forEach{className, methodName ->
//            val clazz = findClass(className, lpparam.classLoader)
//            replaceMethods.replaceAllMethods(clazz, methodName, strings[i])
//            i++
//        }