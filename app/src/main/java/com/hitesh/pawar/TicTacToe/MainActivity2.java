package com.hitesh.pawar.TicTacToe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String player1;
    String player2;

    boolean gameActive = true ;
    // 0 - x
    // 1 - o
    int activePlayer = 0 ;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    //state meanings
    // 0 - x
    // 1 - y
    // 2 - null


    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if(!gameActive){
            gameReset(view);
        }

        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText(player2+"'s turn - Tap To Play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText(player1+"'s turn - Tap To Play");
            }

            if(gameState[0] != 2 && gameState[1] != 2 && gameState[2] != 2 && gameState[3] != 2 &&
                    gameState[4] != 2 && gameState[5] != 2 && gameState[6] != 2 && gameState[7] != 2
                    && gameState[8] != 2){

                gameActive = false;
                TextView status = findViewById(R.id.status);
                status.setText(" No One Won !");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }

        //Check if any player has won
        for(int[] winposition: winPositions){
            if(gameState[winposition[0]] == gameState[winposition[1]] &&
                    gameState[winposition[1]] == gameState[winposition[2]] &&
                    gameState[winposition[0]] != 2){
                //Someone has won - Find who
                gameActive = false;
                String winnerstr;
                if(gameState[winposition[0]] == 0 ){
                    winnerstr = player1+" has won !";
                }
                else{
                    winnerstr = player2+" has Won !";
                }
                //Update Status
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);

            }

        }

    }

    public void gameReset( View view ){
        gameActive = true;
        activePlayer = 0 ;
        for (int i = 0 ; i < gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        player1 = intent.getStringExtra(MainActivity.msg1);
        player2 = intent.getStringExtra(MainActivity.msg2);

    }
}