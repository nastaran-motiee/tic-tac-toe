package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView button1,button2,button3,button4,button5,button6,button7,button8,button9;
    private String startGame="X";
    int b1=5,b2=5,b3=5,b4=5,b5=5,b6=5,b7=5,b8=5,b9=5,xCount=0,oCount=0,i=0;
    private TextView scorex,scoreo;
    private Button Reset;

    private Dialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.buttonImage1);
        button2 = findViewById(R.id.buttonImage2);
        button3 = findViewById(R.id.buttonImage3);
        button4 = findViewById(R.id.buttonImage4);
        button5 = findViewById(R.id.buttonImage5);
        button6 = findViewById(R.id.buttonImage6);
        button7 = findViewById(R.id.buttonImage7);
        button8 = findViewById(R.id.buttonImage8);
        button9 = findViewById(R.id.buttonImage9);

        dialog = new Dialog(this);


        scorex = findViewById(R.id.ScoreX);
        scoreo = findViewById(R.id.ScoreO);

        Reset = findViewById(R.id.Reset);

        findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);


        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setImageDrawable(null);
                button2.setImageDrawable(null);
                button3.setImageDrawable(null);
                button4.setImageDrawable(null);
                button5.setImageDrawable(null);
                button6.setImageDrawable(null);
                button7.setImageDrawable(null);
                button8.setImageDrawable(null);
                button9.setImageDrawable(null);
                resetValues();
                xCount = 0;
                oCount = 0;
                scorex.setText("Score: "+String.valueOf(xCount));
                scoreo.setText("Score: "+String.valueOf(oCount));



            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startGame.equals("X")){
                    button1.setImageResource(R.drawable.cross);
                    b1 = 1;
                    i++;
                }else{
                    button1.setImageResource(R.drawable.circle);
                    b1 = 0;
                    i++;
                }
                choosePlayer();
                winningGame();
                button1.setEnabled(false);


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startGame.equals("X")){
                    button2.setImageResource(R.drawable.cross);
                    b2 = 1;
                    i++;
                }else{
                    button2.setImageResource(R.drawable.circle);
                    b2 = 0;
                    i++;
                }
                choosePlayer();
                winningGame();
                button2.setEnabled(false);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startGame.equals("X")){
                    button3.setImageResource(R.drawable.cross);
                    b3 = 1;
                    i++;
                }else{
                    button3.setImageResource(R.drawable.circle);
                    b3 = 0;
                    i++;
                }
                choosePlayer();
                winningGame();
                button3.setEnabled(false);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startGame.equals("X")){
                    button4.setImageResource(R.drawable.cross);
                    b4= 1;
                    i++;
                }else{
                    button4.setImageResource(R.drawable.circle);
                    b4 = 0;
                    i++;
                }
                choosePlayer();
                winningGame();
                button4.setEnabled(false);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startGame.equals("X")){
                    button5.setImageResource(R.drawable.cross);
                    b5 = 1;
                    i++;
                }else{
                    button5.setImageResource(R.drawable.circle);
                    b5 = 0;
                    i++;
                }
                choosePlayer();
                winningGame();
                button5.setEnabled(false);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startGame.equals("X")){
                    button6.setImageResource(R.drawable.cross);
                    b6 = 1;
                    i++;
                }else{
                    button6.setImageResource(R.drawable.circle);
                    b6 = 0;
                    i++;
                }
                choosePlayer();
                winningGame();
                button6.setEnabled(false);

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startGame.equals("X")){
                    button7.setImageResource(R.drawable.cross);
                    b7 = 1;
                    i++;
                }else{
                    button7.setImageResource(R.drawable.circle);
                    b7 = 0;
                    i++;
                }
                choosePlayer();
                winningGame();
                button7.setEnabled(false);

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startGame.equals("X")){
                    button8.setImageResource(R.drawable.cross);
                    b8 = 1;
                    i++;
                }else{
                    button8.setImageResource(R.drawable.circle);
                    b8 = 0;
                    i++;
                }
                choosePlayer();
                winningGame();
                button8.setEnabled(false);

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startGame.equals("X")){
                    button9.setImageResource(R.drawable.cross);
                    b9 = 1;
                    i++;
                }else{
                    button9.setImageResource(R.drawable.circle);
                    b9 = 0;
                    i++;
                }
                choosePlayer();
                winningGame();
                button9.setEnabled(false);
            }
        });


    }

    private void winningGame(){
        if(b1==1 && b2==1 && b3==1){
            openHeartDialog();
            xCount++;
            scorex.setText("Score: "+String.valueOf(xCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage2).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        }else if(b4==1 && b5==1 && b6==1){
            openHeartDialog();
            xCount++;
            scorex.setText("Score: "+String.valueOf(xCount));
            findViewById(R.id.buttonImage4).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage6).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        }else if(b7==1 && b8==1 && b9==1){
            openHeartDialog();
            xCount++;
            scorex.setText("Score: "+String.valueOf(xCount));
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage8).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        }else if(b1==1 && b4==1 && b7==1){
            openHeartDialog();
            xCount++;
            scorex.setText("Score: "+String.valueOf(xCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage4).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        }else if(b2==1 && b5==1 && b8==1){
            openHeartDialog();
            xCount++;
            scorex.setText("Score: "+String.valueOf(xCount));
            findViewById(R.id.buttonImage2).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage8).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        }else if(b3==1 && b6==1 && b9==1){
            openHeartDialog();
            xCount++;
            scorex.setText("Score: "+String.valueOf(xCount));
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage6).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        }else if(b1==1 && b5==1 && b9==1){
            openHeartDialog();
            xCount++;
            scorex.setText("Score: "+String.valueOf(xCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        }else if(b3==1 && b5==1 && b7==1){
            openHeartDialog();
            xCount++;
            scorex.setText("Score: "+String.valueOf(xCount));
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        }else if(b1==0 && b2==0 && b3==0){
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: "+String.valueOf(oCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage2).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        }else if(b4==0 && b5==0 && b6==0){
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: "+String.valueOf(oCount));
            findViewById(R.id.buttonImage4).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage6).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        }else if(b7==0 && b8==0 && b9==0){
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: "+String.valueOf(oCount));
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage8).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        }else if(b1==0 && b4==0 && b7==0){
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: "+String.valueOf(oCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage4).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        }else if(b2==0 && b5==0 && b8==0){
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: "+String.valueOf(oCount));
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage8).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        }else if(b3==0 && b6==0 && b9==0){
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: "+String.valueOf(oCount));
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage6).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        }else if(b1==0 && b5==0 && b9==0){
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: "+String.valueOf(oCount));
            findViewById(R.id.buttonImage1).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage9).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        }else if(b3==0 && b5==0 && b7==0){
            openBrainDialog();
            oCount++;
            scoreo.setText("Score: "+String.valueOf(oCount));
            findViewById(R.id.buttonImage3).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage5).setBackgroundColor(0xFFff0000);
            findViewById(R.id.buttonImage7).setBackgroundColor(0xFFff0000);
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        }else{
            if(i == 9){
               openXDialog();
            }
        }



    }

    private void choosePlayer(){
        if(startGame.equals("X")){
            startGame = "O";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFF001029);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFFFFFFFF);
        }else{
            startGame = "X";
            findViewById(R.id.HeartBorder).setBackgroundColor(0xFFFFFFFF);
            findViewById(R.id.BrainBorder).setBackgroundColor(0xFF001029);
        }

    }

    private void resetValues() {

        b1 = 5;
        b2 = 5;
        b3 = 5;
        b4 = 5;
        b5 = 5;
        b6 = 5;
        b7 = 5;
        b8 = 5;
        b9 = 5;
        i = 0;
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        button5.setEnabled(true);
        button6.setEnabled(true);
        button7.setEnabled(true);
        button8.setEnabled(true);
        button9.setEnabled(true);
        findViewById(R.id.buttonImage1).setBackgroundColor(0xFF001029);
        findViewById(R.id.buttonImage2).setBackgroundColor(0xFF001029);
        findViewById(R.id.buttonImage3).setBackgroundColor(0xFF001029);
        findViewById(R.id.buttonImage4).setBackgroundColor(0xFF001029);
        findViewById(R.id.buttonImage5).setBackgroundColor(0xFF001029);
        findViewById(R.id.buttonImage6).setBackgroundColor(0xFF001029);
        findViewById(R.id.buttonImage7).setBackgroundColor(0xFF001029);
        findViewById(R.id.buttonImage8).setBackgroundColor(0xFF001029);
        findViewById(R.id.buttonImage9).setBackgroundColor(0xFF001029);

    }

    //Custom heart win
    private void openHeartDialog(){
        dialog.setContentView(R.layout.heart_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk = dialog.findViewById(R.id.buttonOk1);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                button1.setImageDrawable(null);
                button2.setImageDrawable(null);
                button3.setImageDrawable(null);
                button4.setImageDrawable(null);
                button5.setImageDrawable(null);
                button6.setImageDrawable(null);
                button7.setImageDrawable(null);
                button8.setImageDrawable(null);
                button9.setImageDrawable(null);
                resetValues();
            }
        });
        dialog.show();


    }

    //Custom brain win
    private void openBrainDialog(){
        dialog.setContentView(R.layout.brain_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk = dialog.findViewById(R.id.buttonOk2);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                button1.setImageDrawable(null);
                button2.setImageDrawable(null);
                button3.setImageDrawable(null);
                button4.setImageDrawable(null);
                button5.setImageDrawable(null);
                button6.setImageDrawable(null);
                button7.setImageDrawable(null);
                button8.setImageDrawable(null);
                button9.setImageDrawable(null);
                resetValues();
            }
        });
        dialog.show();

    }

    //Custom No one wins
    private void openXDialog(){
        dialog.setContentView(R.layout.x_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button btnOk = dialog.findViewById(R.id.buttonOk3);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                button1.setImageDrawable(null);
                button2.setImageDrawable(null);
                button3.setImageDrawable(null);
                button4.setImageDrawable(null);
                button5.setImageDrawable(null);
                button6.setImageDrawable(null);
                button7.setImageDrawable(null);
                button8.setImageDrawable(null);
                button9.setImageDrawable(null);
                resetValues();
            }
        });
        dialog.show();

    }


}

