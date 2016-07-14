package com.example.android.intro.wwcandwtm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BirthdayActivity extends AppCompatActivity {
    Boolean user = false;
    TextView nameTxt;
    ImageView cardImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        nameTxt = (TextView) findViewById(R.id.nameText);
        cardImage = (ImageView) findViewById(R.id.bdayImage);
    }

    public void onChangeButton(View view){
        if (!user){
            nameTxt.setText("Tabby");
            cardImage.setImageDrawable(getResources().getDrawable(R.drawable.tabby_image));
            user = true;
        } else {
            nameTxt.setText("Samantha");
            cardImage.setImageDrawable(getResources().getDrawable(R.drawable.sam_image));
            user = false;
        }
    }
}

