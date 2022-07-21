package com.hitesh.pawar.TicTacToe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    public static final String msg1 = "player1";
    public static final String msg2 = "player2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextPage( View view){
        Intent intent = new Intent(this, MainActivity2.class);
        EditText play1 = findViewById(R.id.player_1);
        EditText play2 = findViewById(R.id.player_2);

        String p1 = play1.getText().toString();
        String p2 = play2.getText().toString();

        intent.putExtra(msg1 , p1);
        intent.putExtra(msg2 , p2);
        startActivity(intent);

    }
}