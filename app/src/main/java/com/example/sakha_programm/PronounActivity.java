package com.example.sakha_programm;

import androidx.appcompat.app.AppCompatActivity;

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

public class PronounActivity extends AppCompatActivity implements View.OnTouchListener{

    final int DIALOG_FACE = 1;
    final int DIALOG_COUNT = 2;
    final int DIALOG_TIP = 3;
    ImageView tip;
    ImageView face;
    ImageView chislo;
    ImageView sklonit;

    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;
    TextView txt8;

    int face1 = -1;
    int count = -1;

    int tip1 = -1;
    String[] data = {"1 лицо", "2 лицо", "3 лицо"};
    String[] data1 = {"Единственное число", "Множественное число"};
    String[] data2 = {"Личное", "Притяжательное", "Лично-возвратное"};
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pronoun);
        tip     = (ImageView) findViewById(R.id.imageView19);
        face    = (ImageView) findViewById(R.id.imageView9);
        chislo  = (ImageView) findViewById(R.id.rectangle_);
        sklonit = (ImageView) findViewById(R.id.btn_noune);
        txt1= (TextView) findViewById(R.id.textView10);
        txt2= (TextView) findViewById(R.id.textView11);
        txt3= (TextView) findViewById(R.id.textView12);
        txt4= (TextView) findViewById(R.id.textView13);
        txt5= (TextView) findViewById(R.id.textView14);
        txt6= (TextView) findViewById(R.id.textView15);
        txt7= (TextView) findViewById(R.id.textView16);
        txt8= (TextView) findViewById(R.id.textView17);
        tip.setOnTouchListener(this);
        face.setOnTouchListener(this);
        chislo.setOnTouchListener(this);
        sklonit.setOnTouchListener(this);


    }

    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        PronounClass p = new PronounClass();
        Sakha_noun noun = new Sakha_noun();
        switch (v.getId()) {
            case R.id.imageView9:
                showDialog(DIALOG_FACE);
                break;
            case R.id.rectangle_:
                showDialog(DIALOG_COUNT);
                break;
            case R.id.imageView19:
                showDialog(DIALOG_TIP);
                break;
            case R.id.btn_noune:
                if (tip1 == -1) {
                    Toast.makeText(this, "Выберите тип", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else if (face1 == -1){
                    Toast.makeText(this, "Выберите лицо", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else if (count == -1){
                    Toast.makeText(this, "Выберите число", Toast.LENGTH_SHORT).show();
                    return false;
                }
                switch (tip1) {
                    case 1:
                       txt1.setText("Имен. " + p.pronoun_pad(face1, count, 0));
                       txt2.setText("Частн. отсутствует");
                       txt3.setText("Дат. " + p.pronoun_pad(face1, count, 1));
                       txt4.setText("Вин. " + p.pronoun_pad(face1, count, 2));
                       txt5.setText("Исх. " + p.pronoun_pad(face1, count, 3));
                       txt6.setText("Твор. " +p.pronoun_pad(face1, count, 4));
                       txt7.setText("Совм. " +p.pronoun_pad(face1, count, 5));
                       txt8.setText("Срав. " +p.pronoun_pad(face1, count, 6));
                       break;
                    case 2:
                        txt1.setText("Имен. " + p.pronoun_pad_2(face1, count, 0));
                        txt2.setText("Частн. отсутствует");
                        txt3.setText("Дат. " + p.pronoun_pad_2(face1, count, 1));
                        txt4.setText("Вин. " + p.pronoun_pad_2(face1, count, 2));
                        txt5.setText("Исх. " + p.pronoun_pad_2(face1, count, 3));
                        txt6.setText("Твор. " +p.pronoun_pad_2(face1, count, 4));
                        txt7.setText("Совм. " +p.pronoun_pad_2(face1, count, 5));
                        txt8.setText("Срав. " +p.pronoun_pad_2(face1, count, 6));
                        break;
                    default:
                        if(count == 1) {
                        txt1.setText("Имен. " + noun.Imen_p("Бэйэ", face1, 1));
                        txt2.setText("Частн. отсутствует");
                        txt3.setText("Дат. " + noun.Dat_p("Бэйэ", face1, 1));
                        txt4.setText("Вин. " + noun.Vin_p("Бэйэ", face1, 1));
                        txt5.setText("Исх. " + noun.Ish_p("Бэйэ", face1, 1));
                        txt6.setText("Твор. " + noun.Tvor_p("Бэйэ", face1, 1));
                        txt7.setText("Совм. " + noun.Sovm_p("Бэйэ", face1, 1));
                        txt8.setText("Срав. " + noun.Srav_p("Бэйэ", face1, 1)); }
                        else {
                            txt1.setText("Имен. " + noun.Imen_p("Бэйэ", face1+3, 2));
                            txt2.setText("Частн. отсутствует");
                            txt3.setText("Дат. " + noun.Dat_p("Бэйэ", face1+3, 2));
                            txt4.setText("Вин. " + noun.Vin_p("Бэйэ", face1+3, 2));
                            txt5.setText("Исх. " + noun.Ish_p("Бэйэ", face1+3, 2));
                            txt6.setText("Твор. " + noun.Tvor_p("Бэйэ", face1+3, 2));
                            txt7.setText("Совм. " + noun.Sovm_p("Бэйэ", face1+3, 2));
                            txt8.setText("Срав. " + noun.Srav_p("Бэйэ", face1+3, 2));
                        }
                        break; }

                Toast.makeText(this, "Просклонено", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        switch (id) {
            // массив
            case DIALOG_FACE:
                adb.setPositiveButton("OK", myClickListener);
                adb.setTitle("лицо");
                adb.setSingleChoiceItems(data, -1, myClickListener);
                break;

            case DIALOG_COUNT:
                adb.setPositiveButton("OK", myClickListener1);
                adb.setTitle("число");
                adb.setSingleChoiceItems(data1, -1, myClickListener1);
                break;
            case DIALOG_TIP:
                adb.setPositiveButton("OK", myClickListener2);
                adb.setTitle("тип");
                adb.setSingleChoiceItems(data2, -1, myClickListener2);
                break;
        }
        return adb.create();
    }
    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            face1 = lv.getCheckedItemPosition() + 1;
        }
    };
    DialogInterface.OnClickListener myClickListener1 = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            count = lv.getCheckedItemPosition()+1;
        }
    };
    DialogInterface.OnClickListener myClickListener2 = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            tip1 = lv.getCheckedItemPosition()+1;
        }
    };
}