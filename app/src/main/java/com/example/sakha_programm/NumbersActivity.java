package com.example.sakha_programm;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
public class NumbersActivity extends AppCompatActivity implements View.OnTouchListener  {
    ImageView bt_start;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        bt_start = (ImageView) findViewById(R.id.imageView8);
        text1 = (TextView) findViewById(R.id.textView4);
        text2 = (TextView) findViewById(R.id.textView5);
        text3 = (TextView) findViewById(R.id.textView6);
        text4 = (TextView) findViewById(R.id.textView7);
        text5 = (TextView) findViewById(R.id.textView8);
        text6 = (TextView) findViewById(R.id.textView9);
        text7 = (TextView) findViewById(R.id.textView10);
        txt = (EditText) findViewById(R.id.editTextText);
        bt_start.setOnTouchListener(this);

    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Count_class s1 = new Count_class();
        String s2 = String.valueOf(txt.getText());
        switch (view.getId()) {
            case R.id.imageView8:
                 text1.setText("Количеств. "+s2);
                 text2.setText("Порядков. "+s1.OrdinalNumbers(s2));
                 text3.setText("Собир. "+s1.SobirNumbers(s2, 1) + "(н)");
                 text4.setText("Огранич. "+s1.SobirNumbers(s2, 3));
                 text5.setText("Кратн. "+s1.KratNumbers(s2));
                 text6.setText("Раздел. "+s1.RazdNumbers(s2));
                 text7.setText("Приблиз. "+s1.PriblizNumbers(s2));
                 break;}
        return false; }

    }

