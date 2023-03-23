package com.example.sakha_programm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    ImageView bt_verb;
    ImageView bt_noun;
    ImageView bt_word;
    ImageView bt_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_noun = (ImageView) findViewById(R.id.rectangle_3);
        bt_word = (ImageView) findViewById(R.id.rectangle_4);
        bt_verb = (ImageView) findViewById(R.id.rectangle_2);
        bt_info= (ImageView) findViewById(R.id.rectangle_10);
        bt_verb.setOnTouchListener(this);
        bt_noun.setOnTouchListener(this);
        bt_word.setOnTouchListener(this);
        bt_info.setOnTouchListener(this);

    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.rectangle_2:
                Intent intent = new Intent(this, Verb_activity.class);
                startActivity(intent);
                break;
            case R.id.rectangle_3:
                Intent intent1 = new Intent(this, noun.class);
                startActivity(intent1);
                break;
            case R.id.rectangle_4:
                Intent intent2 = new Intent(this, Word_activity.class);
                startActivity(intent2);
                break;
            case R.id.rectangle_10:
                Intent intent3 = new Intent(this, InfoActivity.class);
                startActivity(intent3);
                break;
        }
        return false;
    }
}