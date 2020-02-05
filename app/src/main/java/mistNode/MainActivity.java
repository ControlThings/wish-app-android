/**
 * Copyright (C) 2020, ControlThings Oy Ab
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * @license Apache-2.0
 */
package mistNode;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import addon.MistReceiver;
import addon.MistService;
import fi.ct.mistService.reference.R;


// implements mist receiver
public class MainActivity extends AppCompatActivity implements MistReceiver.Receiver {

    private final String TAG = "MainActivity";

    private Intent mist;
    FlashLight light;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Resopnse receiver for mist service (onConnected)
        MistReceiver mistReceiver = new MistReceiver(this);

        // Init Mist
        mist = new Intent(this, MistService.class);
        mist.putExtra("receiver", mistReceiver);

        // Start Mist service
        startService(mist);
    }

    // Mist is runing and connected to wish
    @Override
    public void onConnected() {

        //TestOldApi old = new TestOldApi();
        //old.test();
          light = new FlashLight(getBaseContext());
/*
        Test t = new Test();
        t.run();
        */
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //light.cleanup();
        stopService(mist);
    }
}
