package com.gocodies.epic.twozerofoureight;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.google.android.gms.ads.MobileAds;


public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //admob
        MobileAds.initialize(this, getString(R.string.admob_app_id));

        // The following is a check to make sure the plugin boots us out when we're in
        // buddybuild processes, crash if not
        int processId = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        boolean isMainAppProcess = true;
        try {
            for (ActivityManager.RunningAppProcessInfo processInfo : activityManager.getRunningAppProcesses()) {
                if (processInfo.pid == processId && processInfo.processName != null && (processInfo.processName.endsWith(":acra") || processInfo.processName.endsWith(":outbox"))) {
                    isMainAppProcess = false;
                    break;
                }
            }
        } catch (Exception e) {
        }

        if (!isMainAppProcess) {
            throw new RuntimeException("We're in a buddybuild process but ended up in main app code. This is bad!");
        }
    }
}
