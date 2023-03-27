package com.example.sakha_programm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Word_activity extends AppCompatActivity implements View.OnTouchListener {

    String[] data = {"имя существительное", "глагол"};
    String[] data1 = {"имена существительные со значением деятеля", "люди или животные, имеющие пристрастие к тому, что выражает основа", "глагол", "глаголы чувственного восприятия"};
    String[] data2 = {"имя существительное", "имена существительные со значением деятеля"};
    int w1 = 0;
    int w2 = 2;
    final int DIALOG_1 = 0;
    final int DIALOG_2 = 1;
    final int DIALOG_3 = 2;
    EditText editText1;
   TextView editText2;
    ImageView rectangle_chast_r1;
    ImageView rectangle_chast_r2;
    ImageView word_start;
    ImageView imagebkb1;
    ImageView imagebkb2;
    ImageView imagebkb3;
    ImageView imagebkb4;
    ImageView imagebkb5;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sakha_word);
        editText1 = (EditText) findViewById(R.id.word_text);
        editText2 = (TextView) findViewById(R.id.word_text2);
        editText2.setClickable(false);
        rectangle_chast_r1 = (ImageView) findViewById(R.id.rectangle_chast_r1);
        rectangle_chast_r2 = (ImageView) findViewById(R.id.rectangle_chast_r2);
        word_start= (ImageView) findViewById(R.id.word_start);
        rectangle_chast_r1.setOnTouchListener(this);
        rectangle_chast_r2.setOnTouchListener(this);
        word_start.setOnTouchListener(this);
        imagebkb1 = (ImageView) findViewById(R.id.imagebkb1);
        imagebkb2 = (ImageView) findViewById(R.id.imagebkb2);
        imagebkb3 = (ImageView) findViewById(R.id.imagebkb3);
        imagebkb4 = (ImageView) findViewById(R.id.imagebkb4);
        imagebkb5 = (ImageView) findViewById(R.id.imagebkb5);
        imagebkb1.setOnTouchListener(this);
        imagebkb2.setOnTouchListener(this);
        imagebkb3.setOnTouchListener(this);
        imagebkb4.setOnTouchListener(this);
        imagebkb5.setOnTouchListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        String word1 = editText1.getText().toString();
        Sakha_word word = new Sakha_word();
        switch (v.getId()) {

            case R.id.rectangle_chast_r1:

                showDialog(DIALOG_1);
                break;
            case R.id.rectangle_chast_r2:
                if (w1==1) showDialog(DIALOG_3);
                else showDialog(DIALOG_2);
                break;
            case R.id.word_start:
                if (word1.equals("")) {
                    Toast.makeText(this, "Напишите ваше слово", Toast.LENGTH_SHORT).show();
                    return false; }
                editText2.setText(word.word_finally(w2, word1));
                Toast.makeText(this, "Просклонено", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imagebkb1:
                editText1.setText(word1+"һ");
                break;
            case R.id.imagebkb2:
                editText1.setText(word1+"ҕ");
                break;
            case R.id.imagebkb3:
                editText1.setText(word1+"ө");
                break;
            case R.id.imagebkb4:
                editText1.setText(word1+"ү");
                break;
            case R.id.imagebkb5:
                editText1.setText(word1+"ҥ");
                break;
        }
        return false;
    }
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        switch (id) {
            // массив
            case DIALOG_1:
                adb.setTitle("Из какой части речи?");
                adb.setSingleChoiceItems(data, -1, myClickListener);
                adb.setPositiveButton("OK", myClickListener);
                break;
            case DIALOG_2:
                adb.setTitle("В какую часть речи?");
                adb.setSingleChoiceItems(data1, -1, myClickListener1);
                adb.setPositiveButton("OK", myClickListener1);
                break;
            case DIALOG_3:
                adb.setTitle("В какую часть речи?");
                adb.setSingleChoiceItems(data2, -1, myClickListener2);
                adb.setPositiveButton("OK", myClickListener2);
                break;
        }
        return adb.create();
    }
    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            w1 = lv.getCheckedItemPosition();
        }
    };
    DialogInterface.OnClickListener myClickListener1 = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            w2 = lv.getCheckedItemPosition();
        }
    };
    DialogInterface.OnClickListener myClickListener2 = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            w2 = lv.getCheckedItemPosition()+4;
        }
    };
}