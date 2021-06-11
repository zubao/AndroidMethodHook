package com.lpl.hookdemo;

import android.app.Application;
import android.util.Log;

import com.panda.hook.javahook.HookManager;
import com.panda.hook.javahook.MethodCallback;
import com.panda.hook.javahook.MethodHookParam;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Reflection.unseal(this);
        try {
            HookManager.findAndHookMethod(MainActivity.class, "onEvent", String.class, new MethodCallback() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    Log.i("ZB", "i'm in method " +param.method.getName()+" beforeHookedMethod");
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    Log.i("ZB", "i'm in method " +param.method.getName()+" afterHookedMethod");
                }
            });

            HookManager.startHooks(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
