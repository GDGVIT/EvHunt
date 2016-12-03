package com.gdgvellore.evhunt.Entity.Login.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gdgvellore.evhunt.MainActivity;
import com.gdgvellore.evhunt.R;

/**
 * Created by Shuvam Ghosh on 12/3/2016.
 */

public class LoginActivity extends AppCompatActivity{

    private TextView tv;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        button = (Button)findViewById(R.id.loginButton);
        getSupportActionBar().hide();
        tv = (TextView)findViewById(R.id.welcome);
        Typeface type = Typeface.createFromAsset(getAssets(),"Roboto-Thin.ttf");
        tv.setTypeface(type);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });



    }
}
