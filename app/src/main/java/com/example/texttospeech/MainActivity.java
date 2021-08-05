package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText textvalue;
    Button speak;

    TextToSpeech text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speak = findViewById(R.id.speak);
        textvalue = findViewById(R.id.textvalue);
        text = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS)
                    text.setLanguage(Locale.ENGLISH);
                else
                    Log.e("failed", "onInit: False");
            }
        });

        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String existingtext = textvalue.getText().toString();
                text.speak(existingtext, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
}