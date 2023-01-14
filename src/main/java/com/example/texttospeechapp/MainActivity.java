package com.example.texttospeechapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Locale;
/*
 * PROJECT : TEXT TO SPEECH
 * LANGUAGE : JAVA
 * AUTHOR : IMTIAZ ADAR
 */
public class MainActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;
    Button speechB, clearB;
    EditText edittText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittText = findViewById(R.id.textFieldd);
        speechB =  findViewById(R.id.speechButton);
        clearB = findViewById(R.id.button__clear);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int ii) {
                if(ii!=TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

        speechB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String finalres = edittText.getText().toString();
                Toast.makeText(MainActivity.this, "SPEAKING", Toast.LENGTH_SHORT).show();
                textToSpeech.setSpeechRate(0.9f);
                textToSpeech.speak(finalres, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        clearB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edittText.setText("");
            }
        });
    }
}