package com.example.akasztofa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button minusButton;
    private Button plusButton;
    private Button guessButton;
    private TextView guessLetter;
    private TextView guessWord;
    private ImageView image;
    private final String[] letterList = {"a", "b", "c", "d", "e", "f", "g","h", "i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index==0){
                    index = letterList.length-1;
                }else{
                    index--;
                }
                guessLetter.setText(letterList[index]);
            }
        });
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index== letterList.length-1){
                    index = 0;
                }else{
                    index++;
                }
                guessLetter.setText(letterList[index]);
            }
        });
    }

    private void init(){
        minusButton = findViewById(R.id.minusButton);
        plusButton = findViewById(R.id.plusButton);
        guessButton = findViewById(R.id.guessButton);
        guessLetter = findViewById(R.id.guessLetter);
        guessWord = findViewById(R.id.guessWord);
        image = findViewById(R.id.imageBox);
        index = 0;
        guessLetter.setText(letterList[index]);
    }
}