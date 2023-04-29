package com.example.sakha_programm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Verb_activity extends AppCompatActivity implements View.OnTouchListener {

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    final String LOG_TAG = "myLogs";
    ImageView btn_start;
    ImageView btn_verb;

    ImageView rect1;
    ImageView rect2;
    ImageView rect3;
    ImageView rect4;
    ImageView rect5;
    ImageView rect6;
    ImageView rect7;
    ImageView rect8;
    ImageView rect9;
    ImageView rect10;
    ImageView rect11;
    ImageView rect12;
    ImageView mood;
    TextView tx3;

    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;
    TextView text8;
    TextView text9;
    TextView text10;
    TextView text11;
    TextView text12;
    EditText textverb;

    ImageView imagebkb1;
    ImageView imagebkb2;
    ImageView imagebkb3;
    ImageView imagebkb4;
    ImageView imagebkb5;
    final int DIALOG_TIME = 1;
    final int DIALOG_MOOD = 2;
    final int DIALOG_TIME_1 = 3;
    final int DIALOG_TIME_MUST_VERB_1 = 4;
    String data[] = { "Будущее время", "Прошедшее время", "Настоящее время", "Недавнопрошедшее время","Отрицательное будущее  время", "Отрицательное прошедшее время", "Отрицательное настоящее время", "Отрицательное недавнопрошедшее время", "Настоящее время еще не совершившегося действия"};
    String data1[] = {"Изъявительное наклонение", "Повелительное наклонение", "ДОЛЖЕНСТВОВАТЕЛЬНОЕ НАКЛОНЕНИЕ I"};
    String data_must_verb_1[] = {"Положительная форма", "Отрицательная форма"};
    String data2[] = {"Будущее время", "Настоящее время", "Отрицательное будущее время", "Отрицательное настоящее время" };
    int time = 2;
    int mood1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verb);

        btn_verb = (ImageView) findViewById(R.id.Btn_verb);
        btn_start = (ImageView) findViewById(R.id.rectangle_5);

        rect1 = (ImageView) findViewById(R.id.imageView);
        rect2 = (ImageView) findViewById(R.id.imageView2);
        rect3 = (ImageView) findViewById(R.id.imageView3);
        rect4 = (ImageView) findViewById(R.id.imageView5);
        rect5 = (ImageView) findViewById(R.id.imageView6);
        rect6 = (ImageView) findViewById(R.id.imageView7);
        rect7 = (ImageView) findViewById(R.id.imageView10);
        rect8 = (ImageView) findViewById(R.id.imageView11);
        rect9 = (ImageView) findViewById(R.id.imageView4);
        rect10 = (ImageView) findViewById(R.id.imageView8);
        rect11 = (ImageView) findViewById(R.id.imageView9);
        rect12 = (ImageView) findViewById(R.id.imageView12);
        mood = (ImageView) findViewById(R.id.mood);

        imagebkb1 = (ImageView) findViewById(R.id.imagebkb);
        imagebkb2 = (ImageView) findViewById(R.id.imagebkb6);
        imagebkb3 = (ImageView) findViewById(R.id.imagebkb7);
        imagebkb4 = (ImageView) findViewById(R.id.imagebkb8);
        imagebkb5 = (ImageView) findViewById(R.id.imagebkb9);
        imagebkb1.setOnTouchListener(this);
        imagebkb2.setOnTouchListener(this);
        imagebkb3.setOnTouchListener(this);
        imagebkb4.setOnTouchListener(this);
        imagebkb5.setOnTouchListener(this);

        text1 = (TextView) findViewById(R.id.textView10);
        text2 = (TextView) findViewById(R.id.textView11);
        text3 = (TextView) findViewById(R.id.textView12);
        text4 = (TextView) findViewById(R.id.textView13);
        text5 = (TextView) findViewById(R.id.textView14);
        text6 = (TextView) findViewById(R.id.textView15);
        text7 = (TextView) findViewById(R.id.textView16);
        text8 = (TextView) findViewById(R.id.textView17);
        text9 = (TextView) findViewById(R.id.textView18);
        text10 = (TextView) findViewById(R.id.textView19);
        text11 = (TextView) findViewById(R.id.textView20);
        text12 = (TextView) findViewById(R.id.textView21);

        textverb = (EditText) findViewById(R.id.editTextVerb);
        btn_start.setOnTouchListener(this);
        btn_verb.setOnTouchListener(this);
        mood.setOnTouchListener(this);
}

    @Override
    public boolean onTouch(View v, MotionEvent event) {


        String verb1 = textverb.getText().toString();
        Sakha_verb verb = new Sakha_verb();
        switch (v.getId()) {
            case R.id.rectangle_5:
                if (mood1 == 0) {
                showDialog(DIALOG_TIME); }
                if (mood1 == 1) {
                    showDialog(DIALOG_TIME_1); }
                if (mood1 == 2) {
                    showDialog(DIALOG_TIME_MUST_VERB_1);
                }
                break;
            case R.id.Btn_verb:

                if (textverb.getText().toString().equals("")) {
                    Toast.makeText(this, "Напишите ваш глагол", Toast.LENGTH_SHORT).show();
                    return false; }
                rect1.setImageResource(R.drawable.rectangle_9);
                rect2.setImageResource(R.drawable.rectangle_10);
                rect3.setImageResource(R.drawable.rectangle_11);
                rect4.setImageResource(R.drawable.rectangle_12);
                rect5.setImageResource(R.drawable.rectangle_13);
                rect6.setImageResource(R.drawable.rectangle_15);
                rect7.setImageResource(R.drawable.rectangle_17);
                rect8.setImageResource(R.drawable.rectangle_16);
                rect9.setImageResource(R.drawable.rectangle_18);
                rect10.setImageResource(R.drawable.rectangle_20);
                rect11.setImageResource(R.drawable.rectangle_20);
                rect12.setImageResource(R.drawable.rectangle_21);
                text1.setText("Лицо");
                text2.setText("1 лицо");
                text3.setText("2 лицо");
                text4.setText("3 лицо");
                text5.setText("Единственное число");
                text9.setText("Множественное число");
                tx3 = (TextView) findViewById(R.id.text1);


                if (mood1 == 0)
                {
                    switch (time)
                    {
                    case 0:
                        tx3.setText("Будущее время");
                        text6.setText(verb.verb_finally(verb1, 1, 1, 1));
                        text7.setText(verb.verb_finally(verb1, 1, 1, 2));
                        text8.setText(verb.verb_finally(verb1, 1, 1, 3));
                        text10.setText(verb.verb_finally(verb1, 1, 2, 1));
                        text11.setText(verb.verb_finally(verb1, 1, 2, 2));
                        text12.setText(verb.verb_finally(verb1, 1, 2, 3));
                        break;
                    case 1:
                        tx3.setText("Прошедшее время");
                        text6.setText(verb.verb_finally(verb1, 3, 1, 1));
                        text7.setText(verb.verb_finally(verb1, 3, 1, 2));
                        text8.setText(verb.verb_finally(verb1, 3, 1, 3));
                        text10.setText(verb.verb_finally(verb1, 3, 2, 1));
                        text11.setText(verb.verb_finally(verb1, 3, 2, 2));
                        text12.setText(verb.verb_finally(verb1, 3, 2, 3));
                        break;
                    case 2:
                        tx3.setText("Настоящее время");
                        text6.setText(verb.verb_finally(verb1, 2, 1, 1));
                        text7.setText(verb.verb_finally(verb1, 2, 1, 2));
                        text8.setText(verb.verb_finally(verb1, 2, 1, 3));
                        text10.setText(verb.verb_finally(verb1, 2, 2, 1));
                        text11.setText(verb.verb_finally(verb1, 2, 2, 2));
                        text12.setText(verb.verb_finally(verb1, 2, 2, 3));
                        break;
                    case 3:
                        tx3.setText("Недавнопрошедшее время");
                        text6.setText(verb.verb_finally(verb1, 7, 1, 1));
                        text7.setText(verb.verb_finally(verb1, 7, 1, 2));
                        text8.setText(verb.verb_finally(verb1, 7, 1, 3));
                        text10.setText(verb.verb_finally(verb1, 7, 2, 1));
                        text11.setText(verb.verb_finally(verb1, 7, 2, 2));
                        text12.setText(verb.verb_finally(verb1, 7, 2, 3));
                        break;
                    case 4:
                        tx3.setText("Отрицательное будущее  время");
                        text6.setText(verb.verb_finally(verb1, 4, 1, 1));
                        text7.setText(verb.verb_finally(verb1, 4, 1, 2));
                        text8.setText(verb.verb_finally(verb1, 4, 1, 3));
                        text10.setText(verb.verb_finally(verb1, 4, 2, 1));
                        text11.setText(verb.verb_finally(verb1, 4, 2, 2));
                        text12.setText(verb.verb_finally(verb1, 4, 2, 3));
                        break;
                    case 5:
                        tx3.setText("Отрицательное прошедшее время");
                        text6.setText(verb.verb_finally(verb1, 6, 1, 1));
                        text7.setText(verb.verb_finally(verb1, 6, 1, 2));
                        text8.setText(verb.verb_finally(verb1, 6, 1, 3));
                        text10.setText(verb.verb_finally(verb1, 6, 2, 1));
                        text11.setText(verb.verb_finally(verb1, 6, 2, 2));
                        text12.setText(verb.verb_finally(verb1, 6, 2, 3));
                        break;
                    case 6:
                        tx3.setText("Отрицательное настоящее время");
                        text6.setText(verb.verb_finally(verb1, 5, 1, 1));
                        text7.setText(verb.verb_finally(verb1, 5, 1, 2));
                        text8.setText(verb.verb_finally(verb1, 5, 1, 3));
                        text10.setText(verb.verb_finally(verb1, 5, 2, 1));
                        text11.setText(verb.verb_finally(verb1, 5, 2, 2));
                        text12.setText(verb.verb_finally(verb1, 5, 2, 3));
                        break;
                    case 7:
                        tx3.setText("Отрицательное недавнопрошедшее время");
                        text6.setText(verb.verb_finally(verb1, 8, 1, 1));
                        text7.setText(verb.verb_finally(verb1, 8, 1, 2));
                        text8.setText(verb.verb_finally(verb1, 8, 1, 3));
                        text10.setText(verb.verb_finally(verb1, 8, 2, 1));
                        text11.setText(verb.verb_finally(verb1, 8, 2, 2));
                        text12.setText(verb.verb_finally(verb1, 8, 2, 3));
                        break;
                    case 8:
                        tx3.setText("Настоящее время еще не совершившегося действия");
                        text6.setText(verb.verb_finally(verb1, 9, 1, 1));
                        text7.setText(verb.verb_finally(verb1, 9, 1, 2));
                        text8.setText(verb.verb_finally(verb1, 9, 1, 3));
                        text10.setText(verb.verb_finally(verb1, 9, 2, 1));
                        text11.setText(verb.verb_finally(verb1, 9, 2, 2));
                        text12.setText(verb.verb_finally(verb1, 9, 2, 3));
                        break; } }
                if (mood1 == 1)   {
                    if (time < 2) {
                    text6.setText(verb.imperative_mood(verb1, time+1, 1, 1, 0));
                    text7.setText(verb.imperative_mood(verb1, time+1, 1, 2, 0));
                    text8.setText(verb.imperative_mood(verb1, time+1, 1, 3, 0));
                    text10.setText(verb.imperative_mood(verb1, time+1, 2, 1, 0));
                    text11.setText(verb.imperative_mood(verb1, time+1, 2, 2, 0));
                    text12.setText(verb.imperative_mood(verb1, time+1, 2, 3, 0));
                    if (time+1==1) tx3.setText("Будущее время повелительного наклонения");
                    else tx3.setText("Настоящее время повелительного наклонения"); }
                    else {
                        text6.setText(verb.imperative_mood(verb1, time-1, 1, 1, 1));
                        text7.setText(verb.imperative_mood(verb1, time-1, 1, 2, 1));
                        text8.setText(verb.imperative_mood(verb1, time-1, 1, 3, 1));
                        text10.setText(verb.imperative_mood(verb1, time-1, 2, 1, 1));
                        text11.setText(verb.imperative_mood(verb1, time-1, 2, 2, 1));
                        text12.setText(verb.imperative_mood(verb1, time-1, 2, 3, 1));
                        if (time-2==0) tx3.setText("Отрицательное будущее время повелительного наклонения");
                        else tx3.setText("Отрицательное настоящее время повелительного наклонения"); }
                    }
                if (mood1 == 2) {
                    Must_verb_1 verb_must_1 = new Must_verb_1();
                    if (time==0) {
                    text6.setText(verb_must_1.must_verb(verb1, 1, 1));
                    text7.setText(verb_must_1.must_verb(verb1, 1, 2));
                    text8.setText(verb_must_1.must_verb(verb1, 1, 3));
                    text10.setText(verb_must_1.must_verb(verb1, 2, 1));
                    text11.setText(verb_must_1.must_verb(verb1, 2, 2));
                    text12.setText(verb_must_1.must_verb(verb1, 2, 3)); }
                    else {
                    text6.setText(verb_must_1.must_verb_minus(verb1, 1, 1));
                    text7.setText(verb_must_1.must_verb_minus(verb1, 1, 2));
                    text8.setText(verb_must_1.must_verb_minus(verb1, 1, 3));
                    text10.setText(verb_must_1.must_verb_minus(verb1, 2, 1));
                    text11.setText(verb_must_1.must_verb_minus(verb1, 2, 2));
                    text12.setText(verb_must_1.must_verb_minus(verb1, 2, 3));
                    }
                }
                Toast.makeText(this, "Просклонено", Toast.LENGTH_SHORT).show();

            break;
            case R.id.mood:
                showDialog(DIALOG_MOOD);
                break;
            case R.id.imagebkb:
                textverb.setText(verb1+"һ");
                break;
            case R.id.imagebkb6:
                textverb.setText(verb1+"ҕ");
                break;
            case R.id.imagebkb7:
                textverb.setText(verb1+"ө");
                break;
            case R.id.imagebkb8:
                textverb.setText(verb1+"ү");
                break;
            case R.id.imagebkb9:
                textverb.setText(verb1+"ҥ");
                break;
        }
        return false;
    }
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        switch (id) {
            // массив
            case DIALOG_TIME:
                adb.setTitle("время");
                adb.setSingleChoiceItems(data, -1, myClickListener);
                break;

            case DIALOG_MOOD:
                adb.setTitle("наклонение");
                adb.setSingleChoiceItems(data1, -1, myClickListener1);
                break;
            case DIALOG_TIME_1:
                adb.setTitle("время");
                adb.setSingleChoiceItems(data2, -1, myClickListener);
                break;
            case DIALOG_TIME_MUST_VERB_1:
                adb.setTitle("время");
                adb.setSingleChoiceItems(data_must_verb_1, -1, myClickListener);
                break;
        }

        adb.setPositiveButton("OK", myClickListener);
        return adb.create();
    }
DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int which) {
        ListView lv = ((AlertDialog) dialog).getListView();
        time = lv.getCheckedItemPosition();
    }
};

    DialogInterface.OnClickListener myClickListener1 = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            mood1 = lv.getCheckedItemPosition();

        }
    };

}