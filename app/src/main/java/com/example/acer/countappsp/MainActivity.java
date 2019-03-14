package com.example.acer.countappsp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int c=0;
    Button button1,button2,button3,button4,button5,button6;
     int colorcode;
SharedPreferences sp;
    private String spFileName=" com.example.acer.countappsp";
    private String countKey="countKey";
    private String colorKey="colorKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);
        button1=findViewById(R.id.b1);
        button2=findViewById(R.id.b2);
        button3=findViewById(R.id.b3);
        button4=findViewById(R.id.b4);
        button5=findViewById(R.id.button1);
        button6=findViewById(R.id.button2);
        sp=getSharedPreferences(spFileName,MODE_PRIVATE);
        c= sp.getInt(countKey,1);
        if(c!=0)
        {
            textView.setText(String.valueOf(c));
        }
            colorcode=sp.getInt(colorKey,0);
            textView.setBackgroundColor(colorcode);


    }

    public void violet(View view) {
        colorcode =getResources().getColor(R.color.violet);
        textView.setBackgroundColor(colorcode);
    }

    public void red(View view) {
         colorcode=getResources().getColor(R.color.red);
        textView.setBackgroundColor(colorcode);
    }

    public void blue(View view) {
        colorcode=getResources().getColor(R.color.blue);
        textView.setBackgroundColor(colorcode);
    }

    public void green(View view) {
        colorcode=getResources().getColor(R.color.green);
        textView.setBackgroundColor(colorcode);
    }

    public void count(View view) {
    c++;
    textView.setText(String.valueOf(c));
    }

    public void reset(View view) {
        c=0;
        textView.setText(String.valueOf(c));
    }

    @Override
    protected void onPause() {
        super.onPause();
        c= Integer.parseInt(textView.getText().toString());
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt(countKey,c);
        editor.putInt(colorKey,colorcode);
        editor.apply();
        Toast.makeText(this,"Data Stored when OnPause method is called",Toast.LENGTH_SHORT).show();
    }

}
