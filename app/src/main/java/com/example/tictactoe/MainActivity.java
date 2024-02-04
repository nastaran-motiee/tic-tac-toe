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
    private ImageView[][] gridBoard;
    private Player currentPlayer;
    private int xCount = 0, oCount = 0, i = 0;
    private int[][] b = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};
    private TextView xScoreView, oScoreView;
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

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                int finalJ = j;
                int finalK = k;
                gridBoard[j][k].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (currentPlayer.equals(Player.X)) {
                            gridBoard[finalJ][finalK].setImageResource(R.drawable.cross);
                            b[finalJ][finalK] = 1;
                        } else {
                            gridBoard[finalJ][finalK].setImageResource(R.drawable.circle);
                            b[finalJ][finalK] = 0;
                        }

                        i++;

                        if(!checkWin()){
                            switchPlayer();
                        }

                        gridBoard[finalJ][finalK].setEnabled(false);
                    }
                });
            }
        }

        dialog = new Dialog(this);
        xScoreView = findViewById(R.id.ScoreX);
        oScoreView = findViewById(R.id.ScoreO);

        resetButton = findViewById(R.id.Reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGridBoard();
                resetValues();
                xCount = 0;
                oCount = 0;
                xScoreView.setText(String.valueOf(xCount));
                oScoreView.setText(String.valueOf(oCount));
            }
        });

        setCurrentPlayer(Player.X);
    }


    private void resetGridBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridBoard[i][j].setImageDrawable(null);
            }
        }
    }

    private boolean checkWin() {
        if (b[0][0] == b[0][1] && b[0][1] == b[0][2] ) {
           return announceWinner(new int[][]{{0, 0}, {0, 1}, {0, 2}});
        } else if (b[1][0] == b[1][1] && b[1][1] == b[1][2]) {
            return announceWinner(new int[][]{{1, 0}, {1, 1}, {1, 2}});
        } else if (b[2][0] == b[2][1] && b[2][1] == b[2][2]) {
            return announceWinner(new int[][]{{2, 0}, {2, 1}, {2, 2}});
        } else if (b[0][0] == b[1][0]&& b[1][0] == b[2][0]) {
            return announceWinner(new int[][]{{0, 0}, {1, 0}, {2, 0}});
        } else if (b[0][1] == b[1][1] && b[1][1] == b[2][1]) {
            return announceWinner(new int[][]{{0, 1}, {1, 1}, {2, 1}});
        } else if (b[0][2] == b[1][2] && b[1][2] == b[2][2]) {
            return announceWinner(new int[][]{{0, 2}, {1, 2}, {2, 2}});
        } else if (b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
            return announceWinner(new int[][]{{0, 0}, {1, 1}, {2, 2}});
        } else if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
            return announceWinner(new int[][]{{0, 2}, {1, 1}, {2, 0}});
        } else {
            if (i == 9) {
                openWinnerDialog("");
            }
        }
        return false;
    }


    /**
     * Switch Player
     */
    private void switchPlayer() {
        if (currentPlayer.equals(Player.X)) {
            setCurrentPlayer(Player.O);
        } else {
            setCurrentPlayer(Player.X);
        }
    }


    private void resetValues() {
        b = new int[][]{{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};
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

    /**
     * Custom Brain win
     */
    private void openWinnerDialog(String winner) {
        Button btnOk;
        if(Objects.equals(winner, "O")) {
            dialog.setContentView(R.layout.brain_dialog);
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            btnOk = dialog.findViewById(R.id.buttonOk2);
        }else if(Objects.equals(winner, "X")){
            dialog.setContentView(R.layout.heart_dialog);
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            btnOk = dialog.findViewById(R.id.buttonOk1);
        }else{
            dialog.setContentView(R.layout.x_dialog);
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            btnOk = dialog.findViewById(R.id.buttonOk3);
        }
        if(btnOk != null){
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    resetGridBoard();
                    resetValues();
                }
            });
        }

        dialog.show();
    }

    /**
     * Announce the winner
     * @return true
     */
    private boolean announceWinner(int[][] path){
        for(int i = 0; i < 3; i++){
            gridBoard[path[i][0]][path[i][1]].setBackgroundColor(0xFFff0000);
        }
        if(currentPlayer == Player.X){
            openWinnerDialog("X");
            xCount++;
            xScoreView.setText(String.valueOf(xCount));

        }else{
            openWinnerDialog("O");
            oCount++;
            oScoreView.setText(String.valueOf(oCount));
        }
        return true;
    }

    /**
     * @param player Player (X or O)
     */
    private void setCurrentPlayer(Player player){
        currentPlayer = player;

        switch(currentPlayer){
            case X:
                findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
                findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
                break;
            case O:
                findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
                findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
                break;

        }
    }
}
