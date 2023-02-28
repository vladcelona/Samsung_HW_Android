package com.application.vladcelona.samsung_hw.statistics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.application.vladcelona.samsung_hw.MainActivity;
import com.application.vladcelona.samsung_hw.R;

public class StatisticsActivity extends AppCompatActivity {

    private TextView activityStatsOutput;
    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        activityStatsOutput = findViewById(R.id.activity_stats_output);
        goBackButton = findViewById(R.id.go_back_button);

        activityStatsOutput.setText(new Statistics().info());
        goBackButton.setOnClickListener(view -> {
            Intent myIntent = new Intent(view.getContext(), MainActivity.class);
            startActivityForResult(myIntent, 0);
        });
    }
}