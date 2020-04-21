package com.example.programm_ui_create;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
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
        //задать параметры для корневого фрейм лайоута в который будут вкладываться остальные
        FrameLayout.LayoutParams rootParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        rootLayout.setPadding(16,16,16,16); //отступы
        rootLayout.setLayoutParams(rootParams);//устанавливаем параметры на View
        RelativeLayout relativeLayout = new RelativeLayout(this); //вложена в корневую

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        relativeLayout.setLayoutParams(relativeParams);
        relativeLayout.setGravity(Gravity.CENTER);

        //добавить image view
        ImageView ivIcon = new ImageView(this);
        ivIcon.setImageResource(R.drawable.bruce_lee);
        ivIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ivIcon.setId('1');
        //добавить text view
        TextView tvTitle = new TextView(this);
        RelativeLayout.LayoutParams titleParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        titleParams.setMarginStart(8);
        titleParams.leftMargin = 8;
        titleParams.addRule(RelativeLayout.ALIGN_TOP,ivIcon.getId());
        titleParams.addRule(RelativeLayout.END_OF,ivIcon.getId());
        titleParams.addRule(RelativeLayout.RIGHT_OF,ivIcon.getId());
        tvTitle.setLayoutParams(titleParams);
        tvTitle.setText(R.string.author);
        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
        tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
        tvTitle.setId('2');

        TextView tvQuote = new TextView(this);
        RelativeLayout.LayoutParams tqParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        tqParams.topMargin = 8;
        tqParams.addRule(RelativeLayout.ALIGN_LEFT,tvTitle.getId());
        tqParams.addRule(RelativeLayout.ALIGN_START,tvTitle.getId());
        tqParams.addRule(RelativeLayout.BELOW,tvTitle.getId());
        tvQuote.setLayoutParams(tqParams);
        tvQuote.setText(R.string.text);
        tvQuote.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        tvQuote.setTypeface(Typeface.DEFAULT,Typeface.ITALIC);
        tvQuote.setId('3');

        LinearLayout buttons = new LinearLayout(this);
        buttons.setId('4');

        EditText etComment = new EditText(this);
        RelativeLayout.LayoutParams etParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        etParams.topMargin = 8;
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            etParams.addRule(RelativeLayout.BELOW, ivIcon.getId());
        } else {
            etParams.addRule(RelativeLayout.ALIGN_LEFT,tvQuote.getId());
            etParams.addRule(RelativeLayout.ABOVE, buttons.getId());
        }
        etComment.setLayoutParams(etParams);
        etComment.setHint(R.string.comment);
        etComment.setInputType(InputType.TYPE_CLASS_TEXT);
        etComment.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        etComment.setId('5');

        buttons.setOrientation(LinearLayout.HORIZONTAL);
        RelativeLayout.LayoutParams buttonsContParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            buttonsContParams.addRule(RelativeLayout.BELOW,etComment.getId());
        } else {
            buttonsContParams.addRule(RelativeLayout.ALIGN_LEFT,etComment.getId());
            buttonsContParams.addRule(RelativeLayout.ALIGN_BOTTOM, ivIcon.getId());
        }
        buttons.setLayoutParams(buttonsContParams);

        Button btnPrevious = new Button(this);
        btnPrevious.setText(R.string.previous);
        Button btnNext = new Button(this);
        btnNext.setText(R.string.next);

        LinearLayout.LayoutParams buttonsParams =
                new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonsParams.weight = 1;

        buttons.addView(btnPrevious,buttonsParams);
        buttons.addView(btnNext,buttonsParams);

        //добавляем view вместе с параметрами
        relativeLayout.addView(ivIcon,relativeParams);
        relativeLayout.addView(tvTitle,titleParams);
        relativeLayout.addView(tvQuote,tqParams);
        relativeLayout.addView(etComment,etParams);
        relativeLayout.addView(buttons);
        rootLayout.addView(relativeLayout);

        setContentView(rootLayout);
    }
}
