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


        r1 = (ImageView) findViewById(R.id.rectangle_6);
        r2= (ImageView) findViewById(R.id.rectangle_7);
        r3= (ImageView) findViewById(R.id.rectangle_8);
        r4= (ImageView) findViewById(R.id.rectangle_9);
        r5= (ImageView) findViewById(R.id.rectangle_11);
        r6= (ImageView) findViewById(R.id.rectangle_12);
        r7= (ImageView) findViewById(R.id.rectangle_13);
        r8= (ImageView) findViewById(R.id.rectangle_14);
        r9= (ImageView) findViewById(R.id.rectangle_15);
        r10= (ImageView) findViewById(R.id.rectangle_16);
        r11= (ImageView) findViewById(R.id.rectangle_19);
        r12= (ImageView) findViewById(R.id.rectangle_17);
        r13= (ImageView) findViewById(R.id.rectangle_18);
        r14= (ImageView) findViewById(R.id.rectangle_20);
        r15= (ImageView) findViewById(R.id.rectangle_21);
        r16= (ImageView) findViewById(R.id.rectangle_22);
        r17= (ImageView) findViewById(R.id.rectangle_23);
        r18= (ImageView) findViewById(R.id.rectangle_24);

        imagebkb1 = (ImageView) findViewById(R.id.imagebkb10);
        imagebkb2 = (ImageView) findViewById(R.id.imagebkb11);
        imagebkb3 = (ImageView) findViewById(R.id.imagebkb12);
        imagebkb4 = (ImageView) findViewById(R.id.imagebkb13);
        imagebkb5 = (ImageView) findViewById(R.id.imagebkb14);

        imagebkb1.setOnTouchListener(this);
        imagebkb2.setOnTouchListener(this);
        imagebkb3.setOnTouchListener(this);
        imagebkb4.setOnTouchListener(this);
        imagebkb5.setOnTouchListener(this);

        txt1= (TextView) findViewById(R.id.textView10);
        txt2= (TextView) findViewById(R.id.textView11);
        txt3= (TextView) findViewById(R.id.textView12);
        txt4= (TextView) findViewById(R.id.textView13);
        txt5= (TextView) findViewById(R.id.textView14);
        txt6= (TextView) findViewById(R.id.textView15);
        txt7= (TextView) findViewById(R.id.textView16);
        txt8= (TextView) findViewById(R.id.textView17);
        txt9= (TextView) findViewById(R.id.textView18);
        txt10= (TextView) findViewById(R.id.textView19);
        txt11= (TextView) findViewById(R.id.textView20);
        txt12= (TextView) findViewById(R.id.textView21);
        txt13= (TextView) findViewById(R.id.textView22);
        txt14= (TextView) findViewById(R.id.textView23);
        txt15= (TextView) findViewById(R.id.textView24);
        txt16= (TextView) findViewById(R.id.textView25);
        txt17= (TextView) findViewById(R.id.textView26);
        txt18= (TextView) findViewById(R.id.textView27);

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

                r1.setImageResource(R.drawable.rectangle_26);
                r2.setImageResource(R.drawable.rectangle_27);
                r3.setImageResource(R.drawable.rectangle_27);
                r4.setImageResource(R.drawable.rectangle_27);
                r5.setImageResource(R.drawable.rectangle_27);
                r6.setImageResource(R.drawable.rectangle_27);
                r7.setImageResource(R.drawable.rectangle_27);
                r8.setImageResource(R.drawable.rectangle_27);
                r9.setImageResource(R.drawable.rectangle_28);
                r10.setImageResource(R.drawable.rectangle_29);
                r11.setImageResource(R.drawable.rectangle_30);
                r12.setImageResource(R.drawable.rectangle_30);
                r13.setImageResource(R.drawable.rectangle_30);
                r14.setImageResource(R.drawable.rectangle_30);
                r15.setImageResource(R.drawable.rectangle_30);
                r16.setImageResource(R.drawable.rectangle_30);
                r17.setImageResource(R.drawable.rectangle_30);
                r18.setImageResource(R.drawable.rectangle_31);

                txt1.setText("Падеж");
                txt2.setText("Имен. падеж");
                txt3.setText("Част. падеж");
                txt4.setText("Дат. падеж");
                txt5.setText("Вин. падеж");
                txt6.setText("Исход. падеж");
                txt7.setText("Твор. падеж");
                txt8.setText("Совм. падеж");
                txt9.setText("Срав. падеж");
                txt10.setText("Имя существ.");
                txt11.setText(noun.Imen_p(noun.plural(noun1, count), face, count));
                txt12.setText(noun.Chast_p(noun.plural(noun1, count), face, count));
                txt13.setText(noun.Dat_p(noun.plural(noun1, count), face, count));
                txt14.setText(noun.Vin_p(noun.plural(noun1, count), face, count));
                txt15.setText(noun.Ish_p(noun.plural(noun1, count), face, count));
                txt16.setText(noun.Tvor_p(noun.plural(noun1, count), face, count));
                txt17.setText(noun.Sovm_p(noun.plural(noun1, count), face, count));
                txt18.setText(noun.Srav_p(noun.plural(noun1, count), face, count));
                Toast.makeText(this, "Просклонено", Toast.LENGTH_SHORT).show();
                break;

        case R.id.imagebkb10:
            textnoun.setText(noun1+"һ");
            break;
        case R.id.imagebkb11:
            textnoun.setText(noun1+"ҕ");
            break;
        case R.id.imagebkb12:
            textnoun.setText(noun1+"ө");
            break;
        case R.id.imagebkb13:
            textnoun.setText(noun1+"ү");
            break;
        case R.id.imagebkb14:
            textnoun.setText(noun1+"ҥ");
            break; }
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