package com.gdgvellore.evhunt.Entity.ClubsChapters.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gdgvellore.evhunt.R;

/**
 * Created by Shuvam Ghosh on 12/4/2016.
 */

public class ClubDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_details);
        getSupportActionBar().hide();
    }
}
