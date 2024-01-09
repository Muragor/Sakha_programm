package com.example.sakha_programm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    ImageView bt_verb;
    ImageView bt_noun;
    ImageView bt_word;
    ImageView bt_info;
    ImageView bt_pronoun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_noun = (ImageView) findViewById(R.id.imageView16);
        bt_word = (ImageView) findViewById(R.id.imageView17);
        bt_verb = (ImageView) findViewById(R.id.imageView14);
        bt_info= (ImageView) findViewById(R.id.imageView20);

        bt_pronoun = (ImageView) findViewById(R.id.imageView18);
        bt_verb.setOnTouchListener(this);
        bt_noun.setOnTouchListener(this);
        bt_word.setOnTouchListener(this);
        bt_info.setOnTouchListener(this);
        bt_pronoun.setOnTouchListener(this);


    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.imageView14:
                Intent intent = new Intent(this, Verb_activity.class);
                startActivity(intent);
                break;
            case R.id.imageView16:
                Intent intent1 = new Intent(this, noun.class);
                startActivity(intent1);
                break;
            case R.id.imageView17:
                Intent intent2 = new Intent(this, NumbersActivity1.class);
                startActivity(intent2);
                break;
            case R.id.imageView20:
                Intent intent3 = new Intent(this, SpravochnikActivity.class);
                startActivity(intent3);
                break;
            case R.id.imageView18:
                Intent intent4 = new Intent(this, PronounActivity.class);
                startActivity(intent4);
        }
        return false;
    }
}