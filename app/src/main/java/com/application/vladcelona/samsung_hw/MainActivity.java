package com.application.vladcelona.samsung_hw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.application.vladcelona.samsung_hw.pacman.PacmanActivity;
import com.application.vladcelona.samsung_hw.statistics.StatisticsActivity;
import com.application.vladcelona.samsung_hw.tictactoe.TictactoeActivity;

public class MainActivity extends AppCompatActivity {

    private Button tictactoeButton;
    private Button battleShipButton;
    private Button pacmanButton;
    private Button statsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tictactoeButton = findViewById(R.id.tictactoe_button);
        battleShipButton = findViewById(R.id.battle_ship_button);
        pacmanButton = findViewById(R.id.pacman_button);
        statsButton = findViewById(R.id.stats_button);

        tictactoeButton.setOnClickListener(view -> {
            Intent myIntent = new Intent(view.getContext(), TictactoeActivity.class);
            startActivityForResult(myIntent, 0);
        });

        battleShipButton.setOnClickListener(view -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Unavailable");
            alert.setMessage("Sorry, this game is unavailable at the moment. Try other games");
            alert.setPositiveButton("OK", null);
            alert.show();
        });

        pacmanButton.setOnClickListener(view -> {
            Intent myIntent = new Intent(view.getContext(), PacmanActivity.class);
            startActivityForResult(myIntent, 0);
        });


        statsButton.setOnClickListener(view -> {
            Intent myIntent = new Intent(view.getContext(), StatisticsActivity.class);
            startActivityForResult(myIntent, 0);
        });
    }
}