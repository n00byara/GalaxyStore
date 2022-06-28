package com.n00byara.galaxystore

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.callbacks.XC_LoadPackage

class Xposed : IXposedHookLoadPackage {

    private var i : Int = 0

    private val booleanClassAndMethodCollection = mapOf("com.sec.android.app.commonlib.doc.Device" to "isSamsungDevice",
        "com.sec.android.app.samsungapps.utility.ThemeUtil" to "isEnableAOD",
        "com.google.android.material.internal.ManufacturerUtils" to "isSamsungDevice",
        "a.a.b.c.b" to "isSupported")
    private val stringsClassAndMethodsCollection = mapOf("com.sec.android.app.commonlib.doc.Device" to "getManufacturer", "com.sec.android.app.commonlib.doc.Device" to "getModelName")
    private val strings = arrayOf("Samsung", "SM-780G")



    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {

        XposedBridge.log("*******************")
        XposedBridge.log((lpparam.appInfo).toString())
        val replace = ReplaceMethods()

        booleanClassAndMethodCollection.forEach{ className, methodName ->
            replace.returnValueWithoutsParams(className, lpparam, methodName, true)
        }

        stringsClassAndMethodsCollection.forEach{className, methodName ->
            replace.returnValueWithoutsParams(className, lpparam, methodName, strings[i])
            i++
        }

        XposedBridge.log(lpparam.processName)
//        val x = findClass("com.sec.android.app.samsungapps.myapps.MyappsThemeFragment", lpparam.classLoader) //"com.sec.android.app.commonlib.doc.SamsungApps"
//        val result = callStaticMethod(x, "createSpinnerItems")

        //"com.sec.android.app.commonlib.concreteloader.ConcreteDeviceInfoLoader", lpparam, "isRetailDevice", false
//        XposedBridge.log(result.toString())

        //com.sec.android.app.samsungapps.samsungapps
    }






















//        XposedBridge.log("processName = " + lpparam.processName + "\n")
//        XposedBridge.log("appInfo = " + lpparam.appInfo + "\n")
//        XposedBridge.log("classLoader = " + lpparam.classLoader.parent + "\n")
//        XposedBridge.log("isFirstApplication = " + lpparam.isFirstApplication + "\n" + "*****************************" + "\n\n\n" + "*****************************")


        //XposedBridge.log(getSystemClassLoader().toString()) //    "b99ce72"
//        loadClass(lpparam.processName + ".b99ce72")
//        booleanClassAndMethodCollection.forEach{(className, methodName) -> {
//            when(methodName){
//                "isRetailDevice" -> returnBoolen(className, lpparam, methodName, false)
//                else -> {
//                    returnBoolen(className, lpparam, methodName, true)
//                }
//            }
//        }}
//        returnBoolen("com.sec.android.app.commonlib.doc.Device", lpparam, "isSamsungDevice", true)
//        returnBoolen("com.sec.android.app.samsungapps.utility.ThemeUtil", lpparam, "isEnableAOD", true)
//        returnBoolen("com.google.android.material.internal.ManufacturerUtils", lpparam, "isSamsungDevice", true)
//        returnBoolen("a.a.b.c.b", lpparam, "isSupported", true)
//        returnBoolen("com.sec.android.app.commonlib.concreteloader.ConcreteDeviceInfoLoader", lpparam, "isRetailDevice", false)
//        returnBoolen("com.sec.android.app.commonlib.concreteloader.ConcreteDeviceInfoLoader", lpparam, "isSamsungDevice", true)
//        returnBoolen("com.sec.android.app.commonlib.knoxmode.KNOXAPI", lpparam, "isKnoxMode", true)
//
//
//        returnString("com.sec.android.app.commonlib.doc.Device", lpparam,"getManufacturer",  "Samsung")
//        returnString("com.sec.android.app.commonlib.doc.Device", lpparam, "getModelName", "SM-780G")
//        returnString("com.sec.android.app.commonlib.doc.Device", lpparam, "getIMEI", "358351081604329")
//        returnString("com.sec.android.app.commonlib.concreteloader.ConcreteDeviceInfoLoader", lpparam, "getManufacture", "Samsung")
//        returnString("com.sec.android.app.commonlib.concreteloader.ConcreteDeviceInfoLoader", lpparam, "getModelName", "SM-780G")

//        onlyTrueClassAndMethodCollection.forEach{(className, methodName) ->
//            returnTrue(className, lpparam, methodName)
//        }



    fun t(): Boolean {
        return true
    }
}