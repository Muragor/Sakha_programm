package com.example.sakha_programm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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
import android.widget.Switch;
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

    final int DIALOG_TIME_PR_SUB_VERB = 5;
    final int DIALOG_TIME_CONDITIONAL = 6;
    final int DIALOG_TIME_CONDITIONAL_2 = 7;
    final int DIALOG_TIME_MAYBE = 8;
    final int DIALOG_TIME_AFFIR = 9;
    final int DIALOG_FORM = 10;
    final int DIALOG_FORM_PAST = 11;
    String[] data_past_time = {"Недавнопрошедшее время", "Преждепрошедшее время", "Прошедшее результативное |", "Прошедшее результативное ||", "Прошедшее эпизодическое |", "Прошедшее эпизодическое ||", "Прошедшее эпизодическое |||", "Прошедшее незаконченное |", "Прошедшее незаконченное ||", "Давнопрошедшее время", "Давнопрошедшее эпизодическое время |", "Давнопрошедшее эпизодическое время ||", "Давнопрошедшее эпизодическое время |||" };
    String[] data = { "Будущее время", "Настоящее время", "Прошедшее время"};
    String[] data1 = {"Изъявительное наклонение", "Повелительное наклонение", "Долженствовательное наклонение", "Желательно-сослагательное наклонение", "Условное наклонение", "Условно-временное наклонение", "Возможное наклонение", "Утвердительное наклонение"};
    String[] data_conditional = {"Вневременная форма", "Отрицательная вневременная форма", "Настоящее время", "Отрицательное настоящее время", "Прошедшее время", "Отрицательное прошедшее время"};
    String[] data_must_verb_1 = {"Положительная форма", "Отрицательная форма"};

    String[] data_affir_verb = {"Положительная форма", "Отрицательная форма I", "Отрицательная форма II"};
    String data2[] = {"Будущее время", "Настоящее время", "Отрицательное будущее время", "Отрицательное настоящее время" };
    int time = -1;
    int mood1 = -1;
 int form2 = -1;
    int form1 = -1;
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

        Conditional_verb verb_cond = new Conditional_verb();
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
                if (mood1 == 3) {
                    showDialog(DIALOG_TIME_PR_SUB_VERB);
                }
                if (mood1 == 4) {
                    showDialog(DIALOG_TIME_CONDITIONAL);
                }
                if (mood1 == 5) { showDialog(DIALOG_TIME_CONDITIONAL_2); }
                if (mood1 == 6) { showDialog(DIALOG_TIME_MAYBE); }
                if (mood1 == 7) { showDialog(DIALOG_TIME_AFFIR); }
                break;

            case R.id.Btn_verb:

                if (textverb.getText().toString().equals("")) {
                    Toast.makeText(this, "Напишите ваш глагол", Toast.LENGTH_SHORT).show();
                    return false; }
                if (time == -1 && mood1 != -1) {
                    Toast.makeText(this, "Выберите время", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else if (time != -1 && mood1 == -1){
                    Toast.makeText(this, "Выберите наклонение", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else if (time == -1 && mood1 == -1){
                    Toast.makeText(this, "Выберите время и наклонение", Toast.LENGTH_SHORT).show();
                    return false;
                }
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
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
                rect12.setImageResource(R.drawable.rectangle_21); }
                else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    rect1.setImageResource(R.drawable.rectangle_9);
                    rect2.setImageResource(R.drawable.rectangle_10);
                    rect3.setImageResource(R.drawable.rectangle_11);
                    rect4.setImageResource(R.drawable.rectangle_12);
                    rect5.setImageResource(R.drawable.rectangle_13_gor);
                    rect6.setImageResource(R.drawable.rectangle_15_gor);
                    rect7.setImageResource(R.drawable.rectangle_15_gor);
                    rect8.setImageResource(R.drawable.rectangle_16_gor);
                    rect9.setImageResource(R.drawable.rectangle_18_gor);
                    rect10.setImageResource(R.drawable.rectangle_20_gor);
                    rect11.setImageResource(R.drawable.rectangle_20_gor);
                    rect12.setImageResource(R.drawable.rectangle_21_gor);
                }
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
                        if (form2==0) {
                        tx3.setText("Будущее время");
                        text6.setText(verb.verb_finally(verb1, 1, 1, 1));
                        text7.setText(verb.verb_finally(verb1, 1, 1, 2));
                        text8.setText(verb.verb_finally(verb1, 1, 1, 3));
                        text10.setText(verb.verb_finally(verb1, 1, 2, 1));
                        text11.setText(verb.verb_finally(verb1, 1, 2, 2));
                        text12.setText(verb.verb_finally(verb1, 1, 2, 3));
                        break; }
                        else { tx3.setText("Отрицательное будущее  время");
                            text6.setText(verb.verb_finally(verb1, 4, 1, 1));
                            text7.setText(verb.verb_finally(verb1, 4, 1, 2));
                            text8.setText(verb.verb_finally(verb1, 4, 1, 3));
                            text10.setText(verb.verb_finally(verb1, 4, 2, 1));
                            text11.setText(verb.verb_finally(verb1, 4, 2, 2));
                            text12.setText(verb.verb_finally(verb1, 4, 2, 3));
                            break;}
                    case 1:
                        tx3.setText("Настоящее время");
                        if (form2 == 0) {
                        text6.setText(verb.verb_finally(verb1, 2, 1, 1));
                        text7.setText(verb.verb_finally(verb1, 2, 1, 2));
                        text8.setText(verb.verb_finally(verb1, 2, 1, 3));
                        text10.setText(verb.verb_finally(verb1, 2, 2, 1));
                        text11.setText(verb.verb_finally(verb1, 2, 2, 2));
                        text12.setText(verb.verb_finally(verb1, 2, 2, 3));
                        break;}
                        else {
                            tx3.setText("Отрицательное настоящее время");
                            text6.setText(verb.verb_finally(verb1, 5, 1, 1));
                            text7.setText(verb.verb_finally(verb1, 5, 1, 2));
                            text8.setText(verb.verb_finally(verb1, 5, 1, 3));
                            text10.setText(verb.verb_finally(verb1, 5, 2, 1));
                            text11.setText(verb.verb_finally(verb1, 5, 2, 2));
                            text12.setText(verb.verb_finally(verb1, 5, 2, 3));
                            break;
                        }

                    case 2:
                        switch (form1) {
                            case 0:
                                if (form2 == 0) {
                                    tx3.setText("Недавнопрошедшее время");
                                    text6.setText(verb.verb_finally(verb1, 7, 1, 1));
                                    text7.setText(verb.verb_finally(verb1, 7, 1, 2));
                                    text8.setText(verb.verb_finally(verb1, 7, 1, 3));
                                    text10.setText(verb.verb_finally(verb1, 7, 2, 1));
                                    text11.setText(verb.verb_finally(verb1, 7, 2, 2));
                                    text12.setText(verb.verb_finally(verb1, 7, 2, 3));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное недавнопрошедшее время");
                                    text6.setText(verb.verb_finally(verb1, 8, 1, 1));
                                    text7.setText(verb.verb_finally(verb1, 8, 1, 2));
                                    text8.setText(verb.verb_finally(verb1, 8, 1, 3));
                                    text10.setText(verb.verb_finally(verb1, 8, 2, 1));
                                    text11.setText(verb.verb_finally(verb1, 8, 2, 2));
                                    text12.setText(verb.verb_finally(verb1, 8, 2, 3));
                                    break;
                                }
                            case 1:
                                if (form2 == 0) {
                                    tx3.setText("Преждепрошедшее время");
                                    text6.setText(verb.verb_finally(verb1, 3, 1, 1));
                                    text7.setText(verb.verb_finally(verb1, 3, 1, 2));
                                    text8.setText(verb.verb_finally(verb1, 3, 1, 3));
                                    text10.setText(verb.verb_finally(verb1, 3, 2, 1));
                                    text11.setText(verb.verb_finally(verb1, 3, 2, 2));
                                    text12.setText(verb.verb_finally(verb1, 3, 2, 3));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное преждепрошедшее время");
                                    text6.setText(verb.verb_finally(verb1, 6, 1, 1));
                                    text7.setText(verb.verb_finally(verb1, 6, 1, 2));
                                    text8.setText(verb.verb_finally(verb1, 6, 1, 3));
                                    text10.setText(verb.verb_finally(verb1, 6, 2, 1));
                                    text11.setText(verb.verb_finally(verb1, 6, 2, 2));
                                    text12.setText(verb.verb_finally(verb1, 6, 2, 3));
                                    break;
                                }
                            case 2:
                                if (form2 == 0) {
                                    tx3.setText("Прошедшее результативное время |");
                                    text6.setText(verb.past_time_result_1(verb1, 1, 1, 0));
                                    text7.setText(verb.past_time_result_1(verb1, 1, 2, 0));
                                    text8.setText(verb.past_time_result_1(verb1, 1, 3, 0));
                                    text10.setText(verb.past_time_result_1(verb1, 2, 1, 0));
                                    text11.setText(verb.past_time_result_1(verb1, 2, 2, 0));
                                    text12.setText(verb.past_time_result_1(verb1, 2, 3, 0));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное прошедшее результативное время |");
                                    text6.setText(verb.past_time_result_1(verb1, 1, 1, 1));
                                    text7.setText(verb.past_time_result_1(verb1, 1, 2, 1));
                                    text8.setText(verb.past_time_result_1(verb1, 1, 3, 1));
                                    text10.setText(verb.past_time_result_1(verb1, 2, 1, 1));
                                    text11.setText(verb.past_time_result_1(verb1, 2, 2, 1));
                                    text12.setText(verb.past_time_result_1(verb1, 2, 3, 1));
                                    break;
                                }
                            case 3:
                                if (form2 == 0) {
                                    tx3.setText("Прошедшее результативное время ||");
                                    text6.setText(verb.past_time_result_2(verb1, 1, 1, 0));
                                    text7.setText(verb.past_time_result_2(verb1, 1, 2, 0));
                                    text8.setText(verb.past_time_result_2(verb1, 1, 3, 0));
                                    text10.setText(verb.past_time_result_2(verb1, 2, 1, 0));
                                    text11.setText(verb.past_time_result_2(verb1, 2, 2, 0));
                                    text12.setText(verb.past_time_result_2(verb1, 2, 3, 0));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное прошедшее результативное время ||");
                                    text6.setText(verb.past_time_result_2(verb1, 1, 1, 1));
                                    text7.setText(verb.past_time_result_2(verb1, 1, 2, 1));
                                    text8.setText(verb.past_time_result_2(verb1, 1, 3, 1));
                                    text10.setText(verb.past_time_result_2(verb1, 2, 1, 1));
                                    text11.setText(verb.past_time_result_2(verb1, 2, 2, 1));
                                    text12.setText(verb.past_time_result_2(verb1, 2, 3, 1));
                                    break;
                                }
                            case 4:
                                if (form2 == 0) {
                                    tx3.setText("Прошедшее эпизодическое время |");
                                    text6.setText(verb.past_time_episodic_1(verb1, 1, 1, 0));
                                    text7.setText(verb.past_time_episodic_1(verb1, 1, 2, 0));
                                    text8.setText(verb.past_time_episodic_1(verb1, 1, 3, 0));
                                    text10.setText(verb.past_time_episodic_1(verb1, 2, 1, 0));
                                    text11.setText(verb.past_time_episodic_1(verb1, 2, 2, 0));
                                    text12.setText(verb.past_time_episodic_1(verb1, 2, 3, 0));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное прошедшее эпизодическое время |");
                                    text6.setText(verb.past_time_episodic_1(verb1, 1, 1, 1));
                                    text7.setText(verb.past_time_episodic_1(verb1, 1, 2, 1));
                                    text8.setText(verb.past_time_episodic_1(verb1, 1, 3, 1));
                                    text10.setText(verb.past_time_episodic_1(verb1, 2, 1, 1));
                                    text11.setText(verb.past_time_episodic_1(verb1, 2, 2, 1));
                                    text12.setText(verb.past_time_episodic_1(verb1, 2, 3, 1));
                                    break;
                                }
                            case 5:
                                if (form2 == 0) {
                                    tx3.setText("Прошедшее эпизодическое время ||");
                                    text6.setText(verb.past_time_episodic_2(verb1, 1, 1, 0));
                                    text7.setText(verb.past_time_episodic_2(verb1, 1, 2, 0));
                                    text8.setText(verb.past_time_episodic_2(verb1, 1, 3, 0));
                                    text10.setText(verb.past_time_episodic_2(verb1, 2, 1, 0));
                                    text11.setText(verb.past_time_episodic_2(verb1, 2, 2, 0));
                                    text12.setText(verb.past_time_episodic_2(verb1, 2, 3, 0));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное прошедшее эпизодическое время ||");
                                    text6.setText(verb.past_time_episodic_2(verb1, 1, 1, 1));
                                    text7.setText(verb.past_time_episodic_2(verb1, 1, 2, 1));
                                    text8.setText(verb.past_time_episodic_2(verb1, 1, 3, 1));
                                    text10.setText(verb.past_time_episodic_2(verb1, 2, 1, 1));
                                    text11.setText(verb.past_time_episodic_2(verb1, 2, 2, 1));
                                    text12.setText(verb.past_time_episodic_2(verb1, 2, 3, 1));
                                    break;
                                }
                            case 6:
                                if (form2 == 0) {
                                    tx3.setText("Прошедшее эпизодическое время |||");
                                    text6.setText(verb.past_time_episodic_3(verb1, 1, 1, 0));
                                    text7.setText(verb.past_time_episodic_3(verb1, 1, 2, 0));
                                    text8.setText(verb.past_time_episodic_3(verb1, 1, 3, 0));
                                    text10.setText(verb.past_time_episodic_3(verb1, 2, 1, 0));
                                    text11.setText(verb.past_time_episodic_3(verb1, 2, 2, 0));
                                    text12.setText(verb.past_time_episodic_3(verb1, 2, 3, 0));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное прошедшее эпизодическое время |||");
                                    text6.setText(verb.past_time_episodic_3(verb1, 1, 1, 1));
                                    text7.setText(verb.past_time_episodic_3(verb1, 1, 2, 1));
                                    text8.setText(verb.past_time_episodic_3(verb1, 1, 3, 1));
                                    text10.setText(verb.past_time_episodic_3(verb1, 2, 1, 1));
                                    text11.setText(verb.past_time_episodic_3(verb1, 2, 2, 1));
                                    text12.setText(verb.past_time_episodic_3(verb1, 2, 3, 1));
                                    break;
                                }
                            case 7:
                                if (form2 == 0) {
                                    tx3.setText("Прошедшее незаконченное время |");
                                    text6.setText(verb.past_time_not_finished_1(verb1, 1, 1, 0));
                                    text7.setText(verb.past_time_not_finished_1(verb1, 1, 2, 0));
                                    text8.setText(verb.past_time_not_finished_1(verb1, 1, 3, 0));
                                    text10.setText(verb.past_time_not_finished_1(verb1, 2, 1, 0));
                                    text11.setText(verb.past_time_not_finished_1(verb1, 2, 2, 0));
                                    text12.setText(verb.past_time_not_finished_1(verb1, 2, 3, 0));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное прошедшее незаконченное время |");
                                    text6.setText(verb.past_time_not_finished_1(verb1, 1, 1, 1));
                                    text7.setText(verb.past_time_not_finished_1(verb1, 1, 2, 1));
                                    text8.setText(verb.past_time_not_finished_1(verb1, 1, 3, 1));
                                    text10.setText(verb.past_time_not_finished_1(verb1, 2, 1, 1));
                                    text11.setText(verb.past_time_not_finished_1(verb1, 2, 2, 1));
                                    text12.setText(verb.past_time_not_finished_1(verb1, 2, 3, 1));
                                    break;
                                }
                            case 8:
                                if (form2 == 0) {
                                    tx3.setText("Прошедшее незаконченное время ||");
                                    text6.setText(verb.past_time_not_finished_2(verb1, 1, 1, 0));
                                    text7.setText(verb.past_time_not_finished_2(verb1, 1, 2, 0));
                                    text8.setText(verb.past_time_not_finished_2(verb1, 1, 3, 0));
                                    text10.setText(verb.past_time_not_finished_2(verb1, 2, 1, 0));
                                    text11.setText(verb.past_time_not_finished_2(verb1, 2, 2, 0));
                                    text12.setText(verb.past_time_not_finished_2(verb1, 2, 3, 0));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное прошедшее незаконченное время ||");
                                    text6.setText(verb.past_time_not_finished_2(verb1, 1, 1, 1));
                                    text7.setText(verb.past_time_not_finished_2(verb1, 1, 2, 1));
                                    text8.setText(verb.past_time_not_finished_2(verb1, 1, 3, 1));
                                    text10.setText(verb.past_time_not_finished_2(verb1, 2, 1, 1));
                                    text11.setText(verb.past_time_not_finished_2(verb1, 2, 2, 1));
                                    text12.setText(verb.past_time_not_finished_2(verb1, 2, 3, 1));
                                    break;
                                }
                            case 9:
                                if (form2 == 0) {
                                    tx3.setText("Давнопрошедшее время");
                                    text6.setText(verb.past_time_long_ago(verb1, 1, 1, 0));
                                    text7.setText(verb.past_time_long_ago(verb1, 1, 2, 0));
                                    text8.setText(verb.past_time_long_ago(verb1, 1, 3, 0));
                                    text10.setText(verb.past_time_long_ago(verb1, 2, 1, 0));
                                    text11.setText(verb.past_time_long_ago(verb1, 2, 2, 0));
                                    text12.setText(verb.past_time_long_ago(verb1, 2, 3, 0));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное давнопрошедшее время");
                                    text6.setText(verb.past_time_long_ago(verb1, 1, 1, 1));
                                    text7.setText(verb.past_time_long_ago(verb1, 1, 2, 1));
                                    text8.setText(verb.past_time_long_ago(verb1, 1, 3, 1));
                                    text10.setText(verb.past_time_long_ago(verb1, 2, 1, 1));
                                    text11.setText(verb.past_time_long_ago(verb1, 2, 2, 1));
                                    text12.setText(verb.past_time_long_ago(verb1, 2, 3, 1));
                                    break;
                                }
                            case 10:
                                if (form2 == 0) {
                                    tx3.setText("Давнопрошедшее эпизодическое время |");
                                    text6.setText(verb.past_time_long_ago_episodic_1(verb1, 1, 1, 0));
                                    text7.setText(verb.past_time_long_ago_episodic_1(verb1, 1, 2, 0));
                                    text8.setText(verb.past_time_long_ago_episodic_1(verb1, 1, 3, 0));
                                    text10.setText(verb.past_time_long_ago_episodic_1(verb1, 2, 1, 0));
                                    text11.setText(verb.past_time_long_ago_episodic_1(verb1, 2, 2, 0));
                                    text12.setText(verb.past_time_long_ago_episodic_1(verb1, 2, 3, 0));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное давнопрошедшее  эпизодическое время |");
                                    text6.setText(verb.past_time_long_ago_episodic_1(verb1, 1, 1, 1));
                                    text7.setText(verb.past_time_long_ago_episodic_1(verb1, 1, 2, 1));
                                    text8.setText(verb.past_time_long_ago_episodic_1(verb1, 1, 3, 1));
                                    text10.setText(verb.past_time_long_ago_episodic_1(verb1, 2, 1, 1));
                                    text11.setText(verb.past_time_long_ago_episodic_1(verb1, 2, 2, 1));
                                    text12.setText(verb.past_time_long_ago_episodic_1(verb1, 2, 3, 1));
                                    break;
                                }
                            case 11:
                                if (form2 == 0) {
                                    tx3.setText("Давнопрошедшее эпизодическое время ||");
                                    text6.setText(verb.past_time_long_ago_episodic_2(verb1, 1, 1, 0));
                                    text7.setText(verb.past_time_long_ago_episodic_2(verb1, 1, 2, 0));
                                    text8.setText(verb.past_time_long_ago_episodic_2(verb1, 1, 3, 0));
                                    text10.setText(verb.past_time_long_ago_episodic_2(verb1, 2, 1, 0));
                                    text11.setText(verb.past_time_long_ago_episodic_2(verb1, 2, 2, 0));
                                    text12.setText(verb.past_time_long_ago_episodic_2(verb1, 2, 3, 0));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное давнопрошедшее  эпизодическое время ||");
                                    text6.setText(verb.past_time_long_ago_episodic_2(verb1, 1, 1, 1));
                                    text7.setText(verb.past_time_long_ago_episodic_2(verb1, 1, 2, 1));
                                    text8.setText(verb.past_time_long_ago_episodic_2(verb1, 1, 3, 1));
                                    text10.setText(verb.past_time_long_ago_episodic_2(verb1, 2, 1, 1));
                                    text11.setText(verb.past_time_long_ago_episodic_2(verb1, 2, 2, 1));
                                    text12.setText(verb.past_time_long_ago_episodic_2(verb1, 2, 3, 1));
                                    break;
                                }
                            case 12:
                                if (form2 == 0) {
                                    tx3.setText("Давнопрошедшее эпизодическое время |||");
                                    text6.setText(verb.past_time_long_ago_episodic_3(verb1, 1, 1, 0));
                                    text7.setText(verb.past_time_long_ago_episodic_3(verb1, 1, 2, 0));
                                    text8.setText(verb.past_time_long_ago_episodic_3(verb1, 1, 3, 0));
                                    text10.setText(verb.past_time_long_ago_episodic_3(verb1, 2, 1, 0));
                                    text11.setText(verb.past_time_long_ago_episodic_3(verb1, 2, 2, 0));
                                    text12.setText(verb.past_time_long_ago_episodic_3(verb1, 2, 3, 0));
                                    break;
                                }
                                else {
                                    tx3.setText("Отрицательное давнопрошедшее  эпизодическое время |||");
                                    text6.setText(verb.past_time_long_ago_episodic_3(verb1, 1, 1, 1));
                                    text7.setText(verb.past_time_long_ago_episodic_3(verb1, 1, 2, 1));
                                    text8.setText(verb.past_time_long_ago_episodic_3(verb1, 1, 3, 1));
                                    text10.setText(verb.past_time_long_ago_episodic_3(verb1, 2, 1, 1));
                                    text11.setText(verb.past_time_long_ago_episodic_3(verb1, 2, 2, 1));
                                    text12.setText(verb.past_time_long_ago_episodic_3(verb1, 2, 3, 1));
                                    break;
                                }
                        }


                     } }
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
                    if (time==0) {tx3.setText("Положительная форма долженственного наклонения");
                    text6.setText(verb_must_1.must_verb(verb1, 1, 1));
                    text7.setText(verb_must_1.must_verb(verb1, 1, 2));
                    text8.setText(verb_must_1.must_verb(verb1, 1, 3));
                    text10.setText(verb_must_1.must_verb(verb1, 2, 1));
                    text11.setText(verb_must_1.must_verb(verb1, 2, 2));
                    text12.setText(verb_must_1.must_verb(verb1, 2, 3)); }
                    else {tx3.setText("Отрицательная форма долженственного наклонения");
                    text6.setText(verb_must_1.must_verb_minus(verb1, 1, 1));
                    text7.setText(verb_must_1.must_verb_minus(verb1, 1, 2));
                    text8.setText(verb_must_1.must_verb_minus(verb1, 1, 3));
                    text10.setText(verb_must_1.must_verb_minus(verb1, 2, 1));
                    text11.setText(verb_must_1.must_verb_minus(verb1, 2, 2));
                    text12.setText(verb_must_1.must_verb_minus(verb1, 2, 3));
                    }
                }
                if (mood1 == 3) {
                    Preferably_a_subjunctive_verb verb_pr = new Preferably_a_subjunctive_verb();
                    if (time==0) {
                        tx3.setText("Положительная форма желательно-сослагательного наклонения");
                        text6.setText(verb_pr.Pr_a_sub_verb(verb1, 1, 1));
                        text7.setText(verb_pr.Pr_a_sub_verb(verb1, 1, 2));
                        text8.setText(verb_pr.Pr_a_sub_verb(verb1, 1, 3));
                        text10.setText(verb_pr.Pr_a_sub_verb(verb1, 2, 1));
                        text11.setText(verb_pr.Pr_a_sub_verb(verb1, 2, 2));
                        text12.setText(verb_pr.Pr_a_sub_verb(verb1, 2, 3)); }
                    else {
                        tx3.setText("Отрицательная форма желательно-сослагательного наклонения");
                        text6.setText(verb_pr.Pr_a_sub_verb_minus(verb1, 1, 1));
                        text7.setText(verb_pr.Pr_a_sub_verb_minus(verb1, 1, 2));
                        text8.setText(verb_pr.Pr_a_sub_verb_minus(verb1, 1, 3));
                        text10.setText(verb_pr.Pr_a_sub_verb_minus(verb1, 2, 1));
                        text11.setText(verb_pr.Pr_a_sub_verb_minus(verb1, 2, 2));
                        text12.setText(verb_pr.Pr_a_sub_verb_minus(verb1, 2, 3));
                    }
                }
                if (mood1 == 4) {

                    switch (time) {
                        case 0:
                            tx3.setText("Вневременная форма условного наклонения");
                            text6.setText(verb_cond.not_in_time(verb1, 1, 1, 0));
                            text7.setText(verb_cond.not_in_time(verb1, 1, 2, 0));
                            text8.setText(verb_cond.not_in_time(verb1, 1, 3, 0));
                            text10.setText(verb_cond.not_in_time(verb1, 2, 1, 0));
                            text11.setText(verb_cond.not_in_time(verb1, 2, 2, 0));
                            text12.setText(verb_cond.not_in_time(verb1, 2, 3, 0));
                            break;
                        case 1:
                            tx3.setText("Отрицательная вневременная форма условного наклонения");
                            text6.setText(verb_cond.not_in_time(verb1, 1, 1, 1));
                            text7.setText(verb_cond.not_in_time(verb1, 1, 2, 1));
                            text8.setText(verb_cond.not_in_time(verb1, 1, 3, 1));
                            text10.setText(verb_cond.not_in_time(verb1, 2, 1, 1));
                            text11.setText(verb_cond.not_in_time(verb1, 2, 2, 1));
                            text12.setText(verb_cond.not_in_time(verb1, 2, 3, 1));
                            break;
                        case 2:
                            tx3.setText("Настоящее время условного наклонения");
                            text6.setText(verb_cond.real_time_conditional(verb1, 1, 1, 0, 0));
                            text7.setText(verb_cond.real_time_conditional(verb1, 1, 2, 0, 0));
                            text8.setText(verb_cond.real_time_conditional(verb1, 1, 3, 0, 0));
                            text10.setText(verb_cond.real_time_conditional(verb1, 2, 1, 0, 0));
                            text11.setText(verb_cond.real_time_conditional(verb1, 2, 2, 0, 0));
                            text12.setText(verb_cond.real_time_conditional(verb1, 2, 3, 0, 0));
                            break;
                        case 3:
                            tx3.setText("Отрицательное настоящее время условного наклонения");
                            text6.setText(verb_cond.real_time_conditional(verb1, 1, 1, 1, 0));
                            text7.setText(verb_cond.real_time_conditional(verb1, 1, 2, 1, 0));
                            text8.setText(verb_cond.real_time_conditional(verb1, 1, 3, 1, 0));
                            text10.setText(verb_cond.real_time_conditional(verb1, 2, 1, 1, 0));
                            text11.setText(verb_cond.real_time_conditional(verb1, 2, 2, 1, 0));
                            text12.setText(verb_cond.real_time_conditional(verb1, 2, 3, 1, 0));
                            break;
                        case 4:
                            tx3.setText("Прошедшее время условного наклонения");
                            text6.setText(verb_cond.past_time_conditional(verb1, 1, 1, 0, 0));
                            text7.setText(verb_cond.past_time_conditional(verb1, 1, 2, 0, 0));
                            text8.setText(verb_cond.past_time_conditional(verb1, 1, 3, 0, 0));
                            text10.setText(verb_cond.past_time_conditional(verb1, 2, 1, 0, 0));
                            text11.setText(verb_cond.past_time_conditional(verb1, 2, 2, 0, 0));
                            text12.setText(verb_cond.past_time_conditional(verb1, 2, 3, 0, 0));
                            break;
                        case 5:
                            tx3.setText("Отрицательное прошедшее время условного наклонения");
                            text6.setText(verb_cond.past_time_conditional(verb1, 1, 1, 1, 0));
                            text7.setText(verb_cond.past_time_conditional(verb1, 1, 2, 1, 0));
                            text8.setText(verb_cond.past_time_conditional(verb1, 1, 3, 1, 0));
                            text10.setText(verb_cond.past_time_conditional(verb1, 2, 1, 1, 0));
                            text11.setText(verb_cond.past_time_conditional(verb1, 2, 2, 1, 0));
                            text12.setText(verb_cond.past_time_conditional(verb1, 2, 3, 1, 0));
                            break;
                    } }
                    if (mood1 == 5) {
                        switch (time) {
                            case 0:
                                tx3.setText("Вневременная форма условно-временного наклонения");
                                text6.setText(verb_cond.not_in_time_2(verb1, 1, 1, 0));
                                text7.setText(verb_cond.not_in_time_2(verb1, 1, 2, 0));
                                text8.setText(verb_cond.not_in_time_2(verb1, 1, 3, 0));
                                text10.setText(verb_cond.not_in_time_2(verb1, 2, 1, 0));
                                text11.setText(verb_cond.not_in_time_2(verb1, 2, 2, 0));
                                text12.setText(verb_cond.not_in_time_2(verb1, 2, 3, 0));
                                break;
                            case 1:
                                tx3.setText("Отрицательная вневременная форма условно-временного наклонения");
                                text6.setText(verb_cond.not_in_time_2(verb1, 1, 1, 1));
                                text7.setText(verb_cond.not_in_time_2(verb1, 1, 2, 1));
                                text8.setText(verb_cond.not_in_time_2(verb1, 1, 3, 1));
                                text10.setText(verb_cond.not_in_time_2(verb1, 2, 1, 1));
                                text11.setText(verb_cond.not_in_time_2(verb1, 2, 2, 1));
                                text12.setText(verb_cond.not_in_time_2(verb1, 2, 3, 1));
                                break;
                            case 2:
                                tx3.setText("Настоящее время условно-временного наклонения");
                                text6.setText(verb_cond.real_time_conditional(verb1, 1, 1, 0, 1));
                                text7.setText(verb_cond.real_time_conditional(verb1, 1, 2, 0, 1));
                                text8.setText(verb_cond.real_time_conditional(verb1, 1, 3, 0, 1));
                                text10.setText(verb_cond.real_time_conditional(verb1, 2, 1, 0, 1));
                                text11.setText(verb_cond.real_time_conditional(verb1, 2, 2, 0, 1));
                                text12.setText(verb_cond.real_time_conditional(verb1, 2, 3, 0, 1));
                                break;
                            case 3:
                                tx3.setText("Отрицательное настоящее время условно-временного наклонения");
                                text6.setText(verb_cond.real_time_conditional(verb1, 1, 1, 1, 1));
                                text7.setText(verb_cond.real_time_conditional(verb1, 1, 2, 1, 1));
                                text8.setText(verb_cond.real_time_conditional(verb1, 1, 3, 1, 1));
                                text10.setText(verb_cond.real_time_conditional(verb1, 2, 1, 1, 1));
                                text11.setText(verb_cond.real_time_conditional(verb1, 2, 2, 1, 1));
                                text12.setText(verb_cond.real_time_conditional(verb1, 2, 3, 1, 1));
                                break;
                            case 4:
                                tx3.setText("Прошедшее время условно-временного наклонения");
                                text6.setText(verb_cond.past_time_conditional(verb1, 1, 1, 0, 1));
                                text7.setText(verb_cond.past_time_conditional(verb1, 1, 2, 0, 1));
                                text8.setText(verb_cond.past_time_conditional(verb1, 1, 3, 0, 1));
                                text10.setText(verb_cond.past_time_conditional(verb1, 2, 1, 0, 1));
                                text11.setText(verb_cond.past_time_conditional(verb1, 2, 2, 0, 1));
                                text12.setText(verb_cond.past_time_conditional(verb1, 2, 3, 0, 1));
                                break;
                            case 5:
                                tx3.setText("Отрицательное прошедшее время условно-временного наклонения");
                                text6.setText(verb_cond.past_time_conditional(verb1, 1, 1, 1, 1));
                                text7.setText(verb_cond.past_time_conditional(verb1, 1, 2, 1, 1));
                                text8.setText(verb_cond.past_time_conditional(verb1, 1, 3, 1, 1));
                                text10.setText(verb_cond.past_time_conditional(verb1, 2, 1, 1, 1));
                                text11.setText(verb_cond.past_time_conditional(verb1, 2, 2, 1, 1));
                                text12.setText(verb_cond.past_time_conditional(verb1, 2, 3, 1, 1));
                                break;
                    }
                }
                if (mood1 == 6) {
                    if (time==0) {
                        tx3.setText("Положительная форма возможного наклонения");
                        text6.setText(verb.maybe_mood(verb1, 1, 1, 0));
                        text7.setText(verb.maybe_mood(verb1, 1, 2, 0));
                        text8.setText(verb.maybe_mood(verb1, 1, 3, 0));
                        text10.setText(verb.maybe_mood(verb1, 2, 1, 0));
                        text11.setText(verb.maybe_mood(verb1, 2, 2, 0));
                        text12.setText(verb.maybe_mood(verb1, 2, 3, 0)); }
                    else {tx3.setText("Отрицательная форма возможного наклонения");
                        text6.setText(verb.maybe_mood(verb1, 1, 1, 1));
                        text7.setText(verb.maybe_mood(verb1, 1, 2, 1));
                        text8.setText(verb.maybe_mood(verb1, 1, 3, 1));
                        text10.setText(verb.maybe_mood(verb1, 2, 1, 1));
                        text11.setText(verb.maybe_mood(verb1, 2, 2, 1));
                        text12.setText(verb.maybe_mood(verb1, 2, 3, 1));
                    }
                }
                if (mood1 == 7) {
                    Affirmative_verb affirmative_verb = new Affirmative_verb();
                    switch (time){
                        case 0:
                            tx3.setText("Положительная форма утвердительного наклонения");
                            text6.setText(affirmative_verb.Aff_verb(verb1, 1, 1));
                            text7.setText(affirmative_verb.Aff_verb(verb1, 1, 2));
                            text8.setText(affirmative_verb.Aff_verb(verb1, 1, 3));
                            text10.setText(affirmative_verb.Aff_verb(verb1, 2, 1));
                            text11.setText(affirmative_verb.Aff_verb(verb1, 2, 2));
                            text12.setText(affirmative_verb.Aff_verb(verb1, 2, 3));
                            break;
                        case 1:
                            tx3.setText("Отрицательная форма | утвердительного наклонения");
                            text6.setText(affirmative_verb.Aff_verb_minus(verb1, 1, 1, 0));
                            text7.setText(affirmative_verb.Aff_verb_minus(verb1, 1, 2, 0));
                            text8.setText(affirmative_verb.Aff_verb_minus(verb1, 1, 3, 0));
                            text10.setText(affirmative_verb.Aff_verb_minus(verb1, 2, 1, 0));
                            text11.setText(affirmative_verb.Aff_verb_minus(verb1, 2, 2, 0));
                            text12.setText(affirmative_verb.Aff_verb_minus(verb1, 2, 3, 0));
                            break;

                        case 2:
                            tx3.setText("Отрицательная форма || утвердительного наклонения");
                            text6.setText(affirmative_verb.Aff_verb_minus(verb1, 1, 1, 1));
                            text7.setText(affirmative_verb.Aff_verb_minus(verb1, 1, 2, 1));
                            text8.setText(affirmative_verb.Aff_verb_minus(verb1, 1, 3, 1));
                            text10.setText(affirmative_verb.Aff_verb_minus(verb1, 2, 1, 1));
                            text11.setText(affirmative_verb.Aff_verb_minus(verb1, 2, 2, 1));
                            text12.setText(affirmative_verb.Aff_verb_minus(verb1, 2, 3, 1));

                } }
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
                adb.setPositiveButton("Дальше", myClickListener_time_iziev);
                break;

            case DIALOG_MOOD:
                adb.setTitle("наклонение");
                adb.setSingleChoiceItems(data1, -1, myClickListener1);
                adb.setPositiveButton("OK", myClickListener1);
                break;
            case DIALOG_TIME_1:
                adb.setTitle("время");
                adb.setSingleChoiceItems(data2, -1, myClickListener);
                adb.setPositiveButton("OK", myClickListener);
                break;
            case DIALOG_TIME_MUST_VERB_1:
                adb.setTitle("время");
                adb.setSingleChoiceItems(data_must_verb_1, -1, myClickListener);
                adb.setPositiveButton("OK", myClickListener);
                break;
            case DIALOG_TIME_PR_SUB_VERB:
                adb.setTitle("время");
                adb.setSingleChoiceItems(data_must_verb_1, -1, myClickListener);
                adb.setPositiveButton("OK", myClickListener);
                break;
            case DIALOG_TIME_CONDITIONAL:
                adb.setTitle("время");
                adb.setSingleChoiceItems(data_conditional, -1, myClickListener);
                adb.setPositiveButton("OK", myClickListener);
                break;
            case DIALOG_TIME_CONDITIONAL_2:
                adb.setTitle("время");
                adb.setSingleChoiceItems(data_conditional, -1, myClickListener);
                adb.setPositiveButton("OK", myClickListener);
                break;
            case DIALOG_TIME_MAYBE:
                adb.setTitle("время");
                adb.setSingleChoiceItems(data_must_verb_1, -1, myClickListener);
                adb.setPositiveButton("OK", myClickListener);
                break;
            case DIALOG_TIME_AFFIR:
                adb.setTitle("время");
                adb.setSingleChoiceItems(data_affir_verb, -1, myClickListener);
                adb.setPositiveButton("OK", myClickListener);
                break;
            case DIALOG_FORM_PAST:
                adb.setTitle("Форма прошедшего времени");
                adb.setSingleChoiceItems(data_past_time, -1, myClickListener2);
                adb.setPositiveButton("Дальше", myClickListener_form);
                break;
            case DIALOG_FORM:
                adb.setTitle("время");
                adb.setSingleChoiceItems(data_must_verb_1, -1, myClickListener_form_yn);
                adb.setPositiveButton("OK", myClickListener_form_yn);
                break;
        }


        return adb.create();
    }
DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int which) {
        ListView lv = ((AlertDialog) dialog).getListView();
        time = lv.getCheckedItemPosition();
        form1 = -1;
    }
};

    DialogInterface.OnClickListener myClickListener1 = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            mood1 = lv.getCheckedItemPosition();
            time = -1;

        }
    };
    DialogInterface.OnClickListener myClickListener2 = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            form1 = lv.getCheckedItemPosition();
        }
    };
    DialogInterface.OnClickListener myClickListener_time_iziev = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            if (time == 2 ) showDialog(DIALOG_FORM_PAST);
            else showDialog(DIALOG_FORM);

        }
    };
    DialogInterface.OnClickListener myClickListener_form = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
             showDialog(DIALOG_FORM);
        }
    };
    DialogInterface.OnClickListener myClickListener_form_yn = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            form2 = lv.getCheckedItemPosition();
        }
    };
}