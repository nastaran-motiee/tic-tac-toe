package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ImageView[][] gridBoard;
    private String startGame = "X";
    int xCount = 0, oCount = 0, i = 0;

    int[][] b = {{5, 5, 5}, {5, 5, 5}, {5, 5, 5}};
    private TextView scorex, scoreo;
    private Button resetButton;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridBoard = new ImageView[][]{
                {findViewById(R.id.buttonImage1),
                        findViewById(R.id.buttonImage2),
                        findViewById(R.id.buttonImage3)},
                {findViewById(R.id.buttonImage4),
                        findViewById(R.id.buttonImage5),
                        findViewById(R.id.buttonImage6)},
                {findViewById(R.id.buttonImage7),
                        findViewById(R.id.buttonImage8),
                        findViewById(R.id.buttonImage9)}
        };

        dialog = new Dialog(this);

        scorex = findViewById(R.id.ScoreX);
        scoreo = findViewById(R.id.ScoreO);
        resetButton = findViewById(R.id.Reset);

        findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGridBoard();
                resetValues();
                xCount = 0;
                oCount = 0;
                scorex.setText("Score: " + String.valueOf(xCount));
                scoreo.setText("Score: " + String.valueOf(oCount));
            }
        });

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                int finalJ = j;
                int finalK = k;
                gridBoard[j][k].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (startGame.equals("X")) {
                            gridBoard[finalJ][finalK].setImageResource(R.drawable.cross);
                            b[finalJ][finalK] = 1;
                        } else {
                            gridBoard[finalJ][finalK].setImageResource(R.drawable.circle);
                            b[finalJ][finalK] = 0;
                        }
                        i++;
                        choosePlayer();
                        winningGame();
                        gridBoard[finalJ][finalK].setEnabled(false);
                    }
                });
            }
        }
    }

    private void resetGridBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridBoard[i][j].setImageDrawable(null);
            }
        }
    }


    private void winningGame() {
        if (b[0][0] == 1 && b[0][1] == 1 && b[0][2] == 1) {
            openHeartDialog();
            xCount++;
            scorex.setText("Score: " + String.valueOf(xCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage2).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        } else if (b[1][0] == 1 && b[1][1] == 1 && b[1][2] == 1) {
            openHeartDialog();
            xCount++;
            scorex.setText("Score: " + String.valueOf(xCount));
            findViewById(R.id.buttonImage4).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage6).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        } else if (b[2][0] == 1 && b[2][1] == 1 && b[2][2] == 1) {
            openHeartDialog();
            xCount++;
            scorex.setText("Score: " + String.valueOf(xCount));
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage8).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        } else if (b[0][0] == 1 && b[1][0] == 1 && b[2][0] == 1) {
            openHeartDialog();
            xCount++;
            scorex.setText("Score: " + String.valueOf(xCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage4).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        } else if (b[0][1] == 1 && b[1][1] == 1 && b[2][1] == 1) {
            openHeartDialog();
            xCount++;
            scorex.setText("Score: " + String.valueOf(xCount));
            findViewById(R.id.buttonImage2).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage8).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        } else if (b[0][2] == 1 && b[1][2] == 1 && b[2][2] == 1) {
            openHeartDialog();
            xCount++;
            scorex.setText("Score: " + String.valueOf(xCount));
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage6).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        } else if (b[0][0] == 1 && b[1][1] == 1 && b[2][2] == 1) {
            openHeartDialog();
            xCount++;
            scorex.setText("Score: " + String.valueOf(xCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        } else if (b[0][2] == 1 && b[1][1] == 1 && b[2][0] == 1) {
            openHeartDialog();
            xCount++;
            scorex.setText("Score: " + String.valueOf(xCount));
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        } else if (b[0][0] == 0 && b[0][1] == 0 && b[0][2] == 0) {
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: " + String.valueOf(oCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage2).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        } else if (b[1][0] == 0 && b[1][1] == 0 && b[1][2] == 0) {
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: " + String.valueOf(oCount));
            findViewById(R.id.buttonImage4).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage6).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        } else if (b[2][0] == 0 && b[2][1] == 0 && b[2][2] == 0) {
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: " + String.valueOf(oCount));
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage8).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        } else if (b[0][0] == 0 && b[1][0] == 0 && b[2][0] == 0) {
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: " + String.valueOf(oCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage4).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        } else if (b[0][1] == 0 && b[1][1] == 0 && b[2][1] == 0) {
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: " + String.valueOf(oCount));
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage8).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        } else if (b[0][2] == 0 && b[1][2] == 0 && b[2][2] == 0) {
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: " + String.valueOf(oCount));
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage6).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        } else if (b[0][0] == 0 && b[1][1] == 0 && b[2][2] == 0) {
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: " + String.valueOf(oCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        } else if (b[0][2] == 0 && b[1][1] == 0 && b[2][0] == 0) {
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: " + String.valueOf(oCount));
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        } else {
            if (i == 9) {
                openXDialog();
            }
        }

    }

    private void choosePlayer() {
        if (startGame.equals("X")) {
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        } else {
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        }

    }

    private void resetValues() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = 5;
            }
        }

        i = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridBoard[i][j].setEnabled(true);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridBoard[i][j].setBackgroundColor(0xFF001029);
            }
        }

    }

    //Custom heart win
    private void openHeartDialog() {
        dialog.setContentView(R.layout.heart_dialog);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk = dialog.findViewById(R.id.buttonOk1);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                resetGridBoard();
                resetValues();
            }
        });
        dialog.show();
    }

    //Custom brain win
    private void openBrainDialog() {
        dialog.setContentView(R.layout.brain_dialog);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk = dialog.findViewById(R.id.buttonOk2);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                resetGridBoard();
                resetValues();
            }
        });
        dialog.show();
    }

    //Custom No one wins
    private void openXDialog() {
        dialog.setContentView(R.layout.x_dialog);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk = dialog.findViewById(R.id.buttonOk3);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                resetGridBoard();
                resetValues();
            }
        });
        dialog.show();

    }

}
