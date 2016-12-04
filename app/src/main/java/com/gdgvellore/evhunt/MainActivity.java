package com.gdgvellore.evhunt;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.gdgvellore.evhunt.Entity.Actors.ClubsAndChapters;
import com.gdgvellore.evhunt.Entity.ClubsChapters.Fragments.ClubsAndChaptersFragment;
import com.gdgvellore.evhunt.Entity.Registration.Fragments.RegistrationFragment;
import com.gdgvellore.evhunt.Entity.TodaysEvents.Fragments.TodaysEventsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((AppCompatActivity) MainActivity.this).getSupportActionBar().setTitle("Home");
       // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        TodaysEventsFragment fg = new TodaysEventsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fg).commit();

        toolbar.setTitle("Today's Events");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorToolbarText));

    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        id = item.getItemId();
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                if (item.getItemId() == R.id.nav_search) {
//            // Handle the camera action
                }
//          else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

                else if(id==R.id.nav_today_event)
                {
                    getSupportActionBar().show();
                    toolbar.setTitle("Today's Events");
                    TodaysEventsFragment fg = new TodaysEventsFragment();
                   getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.content_main,fg).commit();
                }
                else if(id==R.id.nav_clubs_chapters)
                {
                    getSupportActionBar().show();
                    toolbar.setTitle("Clubs And Chapters");
                    toolbar.setBackgroundColor(getResources().getColor(R.color.clubsChaptersPrimary));
                    ClubsAndChaptersFragment clubsAndChaptersFragment = new ClubsAndChaptersFragment();
                    getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.content_main,clubsAndChaptersFragment).commit();
                }
                else if(id==R.id.nav_registration)
                {
                    getSupportActionBar().hide();
                   // toolbar.setTitle("Registration");
                   // toolbar.setBackgroundColor(getResources().getColor(R.color.regPrimaryColor));
                   // toolbar.setTitleTextColor(getResources().getColor(R.color.white));
                    RegistrationFragment registrationFragment = new RegistrationFragment();
                    getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.content_main,registrationFragment).commit();
                }
            }
            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
        return true;
    }
}
