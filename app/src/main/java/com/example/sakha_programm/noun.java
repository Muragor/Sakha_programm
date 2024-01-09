package com.example.sakha_programm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class noun extends AppCompatActivity implements View.OnTouchListener{

    final int DIALOG_FACE = 1;
    final int DIALOG_COUNT = 2;
    ImageView r1;
    ImageView r2;
    ImageView r3;
    ImageView r4;
    ImageView r5;
    ImageView r6;
    ImageView r7;
    ImageView r8;
    ImageView r9;
    ImageView r10;
    ImageView r11;
    ImageView r12;
    ImageView r13;
    ImageView r14;
    ImageView r15;
    ImageView r16;
    ImageView r17;
    ImageView r18;

    ImageView imagebkb1;
    ImageView imagebkb2;
    ImageView imagebkb3;
    ImageView imagebkb4;
    ImageView imagebkb5;

    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;
    TextView txt8;
    TextView txt9;
    TextView txt10;
    TextView txt11;
    TextView txt12;
    TextView txt13;
    TextView txt14;
    TextView txt15;
    TextView txt16;
    TextView txt17;
    TextView txt18;

    EditText textnoun;
    ImageView bt_face;
    ImageView bt_count;
    ImageView bt_start;

    int face = 0;
    int count = 0;
    String[] data = {"Безличное", "1 лицо ед.ч", "2 лицо ед.ч", "3 лицо ед.ч", "1 лицо мн.ч", "2 лицо мн.ч", "3 лицо мн.ч"};
    String[] data1 = {"Единственное число", "Множественное число"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noun);


        txt1= (TextView) findViewById(R.id.textView10);
        txt2= (TextView) findViewById(R.id.textView11);
        txt3= (TextView) findViewById(R.id.textView12);
        txt4= (TextView) findViewById(R.id.textView13);
        txt5= (TextView) findViewById(R.id.textView14);
        txt6= (TextView) findViewById(R.id.textView15);
        txt7= (TextView) findViewById(R.id.textView16);
        txt8= (TextView) findViewById(R.id.textView17);

        textnoun = (EditText) findViewById(R.id.editTextTextPersonName);
        bt_face = (ImageView) findViewById(R.id.rectangle_5);
        bt_count = (ImageView) findViewById(R.id.rectangle_);
        bt_start = (ImageView) findViewById(R.id.btn_noune);

        bt_face.setOnTouchListener(this);
        bt_count.setOnTouchListener(this);
        bt_start.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        String noun1 = textnoun.getText().toString();
        Sakha_noun noun = new Sakha_noun();
        switch (v.getId()) {
            case R.id.rectangle_5:
                showDialog(DIALOG_FACE);
                break;
            case R.id.rectangle_:
                showDialog(DIALOG_COUNT);
                break;
            case R.id.btn_noune:
                if (textnoun.getText().toString().equals("")) {
                    Toast.makeText(this, "Напишите ваше существительное", Toast.LENGTH_SHORT).show();
                    return false; }
                txt1.setText("Имен. " + noun.Imen_p(noun.plural(noun1, count), face, count));
                txt2.setText("Част. " + noun.Chast_p(noun.plural(noun1, count), face, count));
                txt3.setText("Дат. " + noun.Dat_p(noun.plural(noun1, count), face, count));
                txt4.setText("Вин. " + noun.Vin_p(noun.plural(noun1, count), face, count));
                txt5.setText("Исх. " + noun.Ish_p(noun.plural(noun1, count), face, count));
                txt6.setText("Твор. " + noun.Tvor_p(noun.plural(noun1, count), face, count));
                txt7.setText("Совм. " + noun.Sovm_p(noun.plural(noun1, count), face, count));
                txt8.setText("Срав. " + noun.Srav_p(noun.plural(noun1, count), face, count));
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
        }
        return adb.create();
    }
    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            face = lv.getCheckedItemPosition();
        }
    };
    DialogInterface.OnClickListener myClickListener1 = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            count = lv.getCheckedItemPosition();
        }
    };
}