package com.application.vladcelona.samsung_hw.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.application.vladcelona.samsung_hw.R;
import com.application.vladcelona.samsung_hw.tictactoe.TicTacToe;

public class TictactoeActivity extends AppCompatActivity {

    private TicTacToe TicTacToeToeGame;
    private Button[][] buttons;
    private TextView status;

    public static String winnerPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TicTacToeToeGame = new TicTacToe();
        buildGuiByCode();
    }

    public void buildGuiByCode() {

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int w = size.x / TicTacToe.SIDE;

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(TicTacToe.SIDE);
        gridLayout.setRowCount(TicTacToe.SIDE + 1);

        buttons = new Button[TicTacToe.SIDE][TicTacToe.SIDE];
        ButtonHandler bh = new ButtonHandler();
        for(int row = 0; row < TicTacToe.SIDE; row++) {
            for(int col = 0; col < TicTacToe.SIDE; col++) {
                buttons[row][col] = new Button(this);
                buttons[row][col].setTextSize((int) (w * .2));
                buttons[row][col].setOnClickListener(bh);
                gridLayout.addView(buttons[row][col], w, w);
            }
        }

        status = new TextView(this);
        GridLayout.Spec rowSpec = GridLayout.spec(TicTacToe.SIDE, 1);
        GridLayout.Spec columnSpec = GridLayout.spec(0, TicTacToe.SIDE);
        GridLayout.LayoutParams lpStatus
                = new GridLayout.LayoutParams(rowSpec, columnSpec);
        status.setLayoutParams(lpStatus);

        status.setWidth(TicTacToe.SIDE * w);
        status.setHeight(w);
        status.setGravity(Gravity.CENTER);
        status.setBackgroundColor(Color.GREEN);
        status.setTextSize((int) (w * .15));
        status.setText(TicTacToeToeGame.result());

        gridLayout.addView(status);

        setContentView(gridLayout);
    }

    public void update(int row, int col) {
        int play = TicTacToeToeGame.play(row, col);
        if (play == 1) {
            buttons[row][col].setText("X");
        } else if (play == 2) {
            buttons[row][col].setText("O");
        }
        if (TicTacToeToeGame.isGameOver()) {
            status.setBackgroundColor(Color.RED); enableButtons(false);
            status.setText(TicTacToeToeGame.result()); showNewGameDialog();
        }
    }

    public void enableButtons(boolean enabled) {
        for(int row = 0; row < TicTacToe.SIDE; row++) {
            for(int col = 0; col < TicTacToe.SIDE; col++) { buttons[row][col].setEnabled(enabled); }
        }
    }

    public void resetButtons() {
        for (int row = 0; row < TicTacToe.SIDE; row++) {
            for (int col = 0; col < TicTacToe.SIDE; col++)  { buttons[row][col].setText(""); }
        }
    }

    public void showNewGameDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        winnerPlayer = new TicTacToe().result();
        alert.setTitle("Great! " + TicTacToe.gameResult); alert.setMessage("Would you like ot play again?");
        PlayDialog playAgain = new PlayDialog();
        alert.setPositiveButton("YES", (DialogInterface.OnClickListener) playAgain);
        alert.setNegativeButton("NO", playAgain);
        alert.show();
    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            for(int row = 0; row < TicTacToe.SIDE; row++) {
                for (int column = 0; column < TicTacToe.SIDE; column++) {
                    if (v == buttons[row][column]) { update(row, column); }
                }
            }
        }
    }

    private class PlayDialog implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int id) {
            if (id == -1) /* YES button */ {
                TicTacToeToeGame.resetGame(); enableButtons(true);
                resetButtons(); status.setBackgroundColor(Color.GREEN);
                status.setText(TicTacToeToeGame.result());
            } else if (id == -2) {
                TictactoeActivity.this.finish();
            }
        }
    }
}