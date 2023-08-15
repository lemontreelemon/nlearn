package com.zzs.learn

import android.app.Application
import android.os.Build
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

class MyApp : Application() {

    lateinit var flutterEngine:FlutterEngine
    companion object{
        val FLUTTER_ENGINE_ID = "id1"
    }

    override fun onCreate() {
        super.onCreate()
        flutterEngine = FlutterEngine(this)
//        flutterEngine.navigationChannel.setInitialRoute("/")
        flutterEngine.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
        FlutterEngineCache.getInstance().put(FLUTTER_ENGINE_ID,flutterEngine)
        startFlutterService()
    }

    private fun startFlutterService() {
        var channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger,"flutter_version")
        channel.setMethodCallHandler{call,result ->
            if(call.method.equals("getVersion")){
                result.success(Build.BRAND)
            }else {
                result.notImplemented()
            }
        }
    }
}