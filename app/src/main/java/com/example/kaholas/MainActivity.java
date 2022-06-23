package com.example.kaholas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button read = findViewById(R.id.read);
        EditText ans = findViewById(R.id.answer);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.speak("2 * 2",TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        Button check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = ans.getText().toString();
//                Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_SHORT).show();
                if(answer.equals("4")){
                    textToSpeech.speak("correct",TextToSpeech.QUEUE_FLUSH,null);
                }
                else{
                    textToSpeech.speak("incorrect",TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });
    }
}