package com.example.programm_ui_create;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        int frameLayoutMatchParent=FrameLayout.LayoutParams.MATCH_PARENT;
        int relativeLayoutWrapContent=RelativeLayout.LayoutParams.WRAP_CONTENT;

        int linearLayourWrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
        int linearLayoutMatchParent = LinearLayout.LayoutParams.MATCH_PARENT;

        FrameLayout frameLayout = new FrameLayout(this); //создадим корневую frameLayout
        RelativeLayout relativeLayout = new RelativeLayout(this); //вложена в корневую
        LinearLayout linearLayout = new LinearLayout(this); //2-й уровень вложенности
        //задать параметры
        FrameLayout.LayoutParams fParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);

 //       setContentView(frameLayout);

        frameLayout.addView(relativeLayout, fParams); //add inside  layout
        RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams(relativeLayoutWrapContent,relativeLayoutWrapContent);
        relativeLayout.setGravity(Gravity.CENTER);



        //добавить image view
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(Drawable.createFromPath("@drawable/bruce_lee"));
        relativeLayout.addView(imageView);



        //add text view
        TextView textView = new TextView(this);

        textView.setText("TextView");


        //textView.setLayoutParams(lpView);
        relativeLayout.addView(textView);



        Button btnPrevious =new Button(this);
        Button btnNext = new Button(this);
        btnPrevious.setText("Previous");
        btnNext.setText("Next");




        // Создание LayoutParams c шириной и высотой по содержимому
        //LayoutParams(int width, int height)
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                linearLayourWrapContent, linearLayourWrapContent);

        linearLayout.addView(textView);

        linearLayout.addView(btnPrevious,lParams);
        linearLayout.addView(btnNext,lParams);

        setContentView(linearLayout);


    }
}
