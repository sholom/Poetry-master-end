package com.example.szopa.poetry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DisplayPoem extends AppCompatActivity {

    private TextView testTextView;
    private int words = MainActivity.words, lines = MainActivity.lines, paragraphs = MainActivity.paragraphs;
    private Poem aPoem = new Poem();
    private java.lang.String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_poem);

        testTextView = (TextView)findViewById(R.id.testTextView);
        output = aPoem.writePoem(words, lines, paragraphs);
        testTextView.setText(output);
    }
/*
    public void goToMain (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    } */
}