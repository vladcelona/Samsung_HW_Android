package com.application.vladcelona.samsung_hw.pacman;

import android.app.Activity;
import android.os.Bundle;

import com.application.vladcelona.samsung_hw.R;
import com.application.vladcelona.samsung_hw.pacman.PacmanActivity;

public class HelpActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_layout);
        PacmanActivity.getPlayer().start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        PacmanActivity.getPlayer().pause();
    }

}
