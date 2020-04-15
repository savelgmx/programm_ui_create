package com.example.programm_ui_create;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
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
 /*       xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="16dp"
*/
       FrameLayout.LayoutParams fParams = new FrameLayout.LayoutParams(frameLayoutMatchParent,frameLayoutMatchParent);
        frameLayout.addView(relativeLayout, fParams); //add inside  layout
/*
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"

*/

        RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams(relativeLayoutWrapContent,relativeLayoutWrapContent);
        relativeLayout.setGravity(Gravity.CENTER);



         //добавить image view
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

        linearLayout.addView(btnPrevious,lParams);
        linearLayout.addView(btnNext,lParams);

        setContentView(linearLayout);


    }
}
