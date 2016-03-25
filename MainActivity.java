package com.example.szopa.poetry;

import android.widget.Button;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public static int words = 1, lines = 1, paragraphs = 1;
    private TextView wordsAmountTextView, linesAmountTextView, paragraphsAmountTextView;
 /*   public void goToDisplayPoem (View view)
    {
        Intent intent = new Intent(this, DisplayPoem.class);
        startActivity(intent);
    } */
    //This code activates the About button

    public void onButtonClick (View v)
    {
        if(v.getId() == R.id.button) {

            Intent intent =new Intent(MainActivity.this, About.class);
            startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordsAmountTextView = (TextView) findViewById(R.id.wordsAmountTextView);
        linesAmountTextView = (TextView) findViewById(R.id.linesAmountTextView);
        paragraphsAmountTextView = (TextView) findViewById(R.id.paragraphsAmountTextView);

        // set SeekBars' OnSeekBarChangeListener methods
        SeekBar wordsSeekBar =
                (SeekBar) findViewById(R.id.wordsSeekBar);
        SeekBar linesSeekBar =
                (SeekBar) findViewById(R.id.linesSeekBar);
        SeekBar paragraphsSeekBar =
                (SeekBar) findViewById(R.id.paragraphsSeekBar);
        wordsSeekBar.setOnSeekBarChangeListener(wordsSeekBarListener);
        linesSeekBar.setOnSeekBarChangeListener(linesSeekBarListener);
        paragraphsSeekBar.setOnSeekBarChangeListener(paragraphsSeekBarListener);
    }

    // listener objects for the SeekBars' progress changed events
    private final OnSeekBarChangeListener wordsSeekBarListener =
            new OnSeekBarChangeListener()
            {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    words = progress;
                    String displayWords = "" + words;
                    wordsAmountTextView.setText(displayWords);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };
    private final OnSeekBarChangeListener linesSeekBarListener =
            new OnSeekBarChangeListener()
            {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    lines = progress;
                    String displayLines = "" + lines;
                    linesAmountTextView.setText(displayLines);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };
    private final OnSeekBarChangeListener paragraphsSeekBarListener =
            new OnSeekBarChangeListener()
            {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    paragraphs = progress;
                    String displayParagraphs = "" + paragraphs;
                    paragraphsAmountTextView.setText(displayParagraphs);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            };


    // initialises the DisplayPoem activity, accessed when button "Generate Poem!" is pressed
    public void goToDisplayPoem (View view)
    {
        Intent intent = new Intent(this, DisplayPoem.class);
        startActivity(intent);
    }

}