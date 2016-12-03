package com.gdgvellore.evhunt.Entity.ClubsChapters.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.gdgvellore.evhunt.Entity.Actors.ClubsAndChapters;
import com.gdgvellore.evhunt.MainActivity;
import com.gdgvellore.evhunt.R;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.ArrayList;

/**
 * Created by Shuvam Ghosh on 10/23/2016.
 */

public class ClubsAndChaptersFragment extends Fragment {

    private RecyclerView clubsAndChaptersRecView;
    private RecyclerViewAdapter adapter;
    private ArrayList<ClubsAndChapters> listOfClubs;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.clubs_and_chapters_fragment,container,false);
         init(rootView);
         return rootView;

    }

    private void init(View rootView) {




        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.clubsChaptersDark));

        }

        clubsAndChaptersRecView = (RecyclerView)rootView.findViewById(R.id.clubsAndChaptersRecView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        clubsAndChaptersRecView.setLayoutManager(layoutManager);
        listOfClubs = new ArrayList<ClubsAndChapters>();

        for(int i=0;i<50;i++)
        {
            ClubsAndChapters obj = new ClubsAndChapters();
            obj.setClubName("Club: "+i);
            listOfClubs.add(obj);
        }

        adapter = new RecyclerViewAdapter(listOfClubs);
        clubsAndChaptersRecView.setAdapter(adapter);



    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<MyCustomView> implements FastScrollRecyclerView.SectionedAdapter{

        ArrayList<ClubsAndChapters> list = new ArrayList<ClubsAndChapters>();


        RecyclerViewAdapter(ArrayList<ClubsAndChapters> list)
        {
            this.list = list;
        }


        @Override
        public MyCustomView onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clubs_and_chapters_fragment_item,parent,false);
            return new MyCustomView(view);
        }

        @Override
        public void onBindViewHolder(MyCustomView holder, int position) {

            holder.clubName.setText(list.get(position).getClubName());
            holder.clubOrChapter.setText("Chapter");
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        @NonNull
        @Override
        public String getSectionName(int position) {
            return (""+(list.get(position).getClubName().charAt(0)));
        }

    }

    private class MyCustomView extends RecyclerView.ViewHolder{

        private TextView clubName;
        private TextView clubOrChapter;

        public MyCustomView(View itemView) {
            super(itemView);
            clubName = (TextView)itemView.findViewById(R.id.clubName);
            clubOrChapter = (TextView)itemView.findViewById(R.id.chapterOrClub);

        }
    }
}
