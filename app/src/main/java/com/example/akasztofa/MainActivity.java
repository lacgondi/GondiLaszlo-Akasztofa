package com.example.akasztofa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Element variables
    private Button minusButton;
    private Button plusButton;
    private Button guessButton;
    private TextView guessLetter;
    private TextView guessWord;
    private ImageView image;

    //Variables
    private final String[] letterList = {"a", "b", "c", "d", "e", "f", "g","h", "i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private String[] usedLetterList = new String[26];
    private int index;
    private String[] wordList = {"fire", "police", "iphone", "keyboard", "house", "monitor", "clock","nagger","dragon", "racing"};
    private String word;

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
                guessLetter.setText(letterList[index].toUpperCase());
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
                guessLetter.setText(letterList[index].toUpperCase());
            }
        });
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private String thinkOfWord(String[] list){
        String underlines="";
        Random rng = new Random();
        word = list[rng.nextInt(9)];
        for (int i = 0; i < list.length; i++) {
            underlines+="_";
        }
        return underlines;
    }

    private void init(){
        minusButton = findViewById(R.id.minusButton);
        plusButton = findViewById(R.id.plusButton);
        guessButton = findViewById(R.id.guessButton);
        guessLetter = findViewById(R.id.guessLetter);
        guessWord = findViewById(R.id.guessWord);
        image = findViewById(R.id.imageBox);
        index = 0;
        guessLetter.setText(letterList[index].toUpperCase());
        guessWord.setText(thinkOfWord(wordList));
    }
}