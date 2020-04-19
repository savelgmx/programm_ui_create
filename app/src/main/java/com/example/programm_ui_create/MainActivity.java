package com.example.programm_ui_create;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout rootLayout = new FrameLayout(this); //создадим корневую frameLayout
        RelativeLayout relativeLayout = new RelativeLayout(this); //вложена в корневую
        //задать параметры для корневого фрейм лайоута в который будут вкладываться остальные
        FrameLayout.LayoutParams rootParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
         rootLayout.setPadding(16,16,16,16); //отступы
         rootLayout.setLayoutParams(rootParams);//устанавливаем параметры на View

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        relativeLayout.setGravity(Gravity.CENTER);

        //добавить image view
        ImageView ivIcon = new ImageView(this);
        ivIcon.setVisibility(View.VISIBLE);
        ivIcon.setImageResource(R.drawable.bruce_lee);
        ivIcon.setMaxWidth(128);
        ivIcon.setMaxHeight(192);
        //добавить text view
        RelativeLayout.LayoutParams tvParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tvTitle = new TextView(this);
        tvTitle.setText(R.string.author);
        tvTitle.setTextSize(28);
        tvParams.topMargin=8;
        tvTitle.layout(1,R.id.ivIcon,8,8);

        TextView tvQuote = new TextView(this);
        tvQuote.setText(R.string.text);
        tvQuote.setTextSize(14);
        tvQuote.layout(1,1,R.id.tvTitle,R.id.tvTitle);


        EditText etComment = new EditText(this);//edit text add
        RelativeLayout.LayoutParams etParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        etComment.setHint(R.string.comment);
        etComment.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);

        LinearLayout buttons = new LinearLayout(this);

        buttons.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams buttonsParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        Button btnPrevious = new Button(this);
        btnPrevious.setText(R.string.previous);
        Button btnNext = new Button(this);
        btnNext.setText(R.string.next);

        //добавляем view вместе с параметрами
        relativeLayout.addView(ivIcon,relativeParams);
        relativeLayout.addView(tvTitle,tvParams);
        relativeLayout.addView(tvQuote,tvParams);
        relativeLayout.addView(etComment,etParams);

        buttons.addView(btnPrevious,buttonsParams);
        buttons.addView(btnNext,buttonsParams);
        rootLayout.addView(relativeLayout);
        rootLayout.addView(buttons);
        setContentView(rootLayout);
    }
}
