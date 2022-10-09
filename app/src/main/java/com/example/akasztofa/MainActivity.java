package com.example.akasztofa;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.charset.Charset;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Element variables
    private Button minusButton;
    private Button plusButton;
    private Button guessButton;
    private TextView guessLetter;
    private TextView guessWord;
    private ImageView hangmanImage;

    //Variables
    private final String[] letterList = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private String[] usedLetterList = new String[26];
    private int index;
    private String[] wordList = {"fire", "police", "iphone", "keyboard", "house", "monitor", "clock", "nagger", "dragon", "racing"};
    private String word;
    private int mistakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == 0) {
                    index = letterList.length - 1;
                } else {
                    index--;
                }
                guessLetter.setText(letterList[index].toUpperCase());
            }
        });
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index == letterList.length - 1) {
                    index = 0;
                } else {
                    index++;
                }
                guessLetter.setText(letterList[index].toUpperCase());
            }
        });
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String output = "";
                CharSequence currentLetter = guessLetter.getText();
                Log.i("currentL", (String) currentLetter);
                if (word.contains(currentLetter)){
                    for (int i = 0; i < word.length(); i++) {
                        if(word.charAt(i)==currentLetter.charAt(0)){
                            output+=currentLetter;
                        }else{
                            output+="_";
                        }
                    }
                    guessWord.setText(output);
                }else{
                    mistakes++;
                    switch (mistakes) {
                        case 1:
                            hangmanImage.setImageResource(R.drawable.akasztofa01);
                            break;
                        case 2:
                            hangmanImage.setImageResource(R.drawable.akasztofa02);
                            break;
                        case 3:
                            hangmanImage.setImageResource(R.drawable.akasztofa03);
                            break;
                        case 4:
                            hangmanImage.setImageResource(R.drawable.akasztofa04);
                            break;
                        case 5:
                            hangmanImage.setImageResource(R.drawable.akasztofa05);
                            break;
                        case 6:
                            hangmanImage.setImageResource(R.drawable.akasztofa06);
                            break;
                        case 7:
                            hangmanImage.setImageResource(R.drawable.akasztofa07);
                            break;
                        case 8:
                            hangmanImage.setImageResource(R.drawable.akasztofa08);
                            break;
                        case 9:
                            hangmanImage.setImageResource(R.drawable.akasztofa09);
                            break;
                        case 10:
                            hangmanImage.setImageResource(R.drawable.akasztofa10);
                            break;
                        case 11:
                            hangmanImage.setImageResource(R.drawable.akasztofa11);
                            break;
                        case 12:
                            hangmanImage.setImageResource(R.drawable.akasztofa12);
                            break;
                        case 13:
                            hangmanImage.setImageResource(R.drawable.akasztofa13);
                            break;
                    }
                }
            }
        });
    }

    private String thinkOfWord(String[] list) {
        String underlines = "";
        Random rng = new Random();
        word = list[rng.nextInt(9)].toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            underlines += "_";
        }
        Log.i("Chosen word", word);
        return underlines;
    }

    private void init() {
        minusButton = findViewById(R.id.minusButton);
        plusButton = findViewById(R.id.plusButton);
        guessButton = findViewById(R.id.guessButton);
        guessLetter = findViewById(R.id.guessLetter);
        guessWord = findViewById(R.id.guessWord);
        hangmanImage = findViewById(R.id.hangmanImage);

        index = 0;
        guessLetter.setText(letterList[index].toUpperCase());
        guessWord.setText(thinkOfWord(wordList));
        mistakes = 0;
    }
}