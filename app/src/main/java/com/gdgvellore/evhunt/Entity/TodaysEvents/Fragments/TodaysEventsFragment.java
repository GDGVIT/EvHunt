package com.gdgvellore.evhunt.Entity.TodaysEvents.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdgvellore.evhunt.Entity.Actors.TodaysEvents;
import com.gdgvellore.evhunt.R;

import java.util.ArrayList;

/**
 * Created by Shuvam Ghosh on 10/23/2016.
 */

public class TodaysEventsFragment extends Fragment {

    private RecyclerView recView;
    private RecyclerViewAdapter adapter;
    private ArrayList<TodaysEvents> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_todays_events,container,false);
        init(rootView);
        return rootView;
    }

    private void init(View rootView) {

        recView = (RecyclerView)rootView.findViewById(R.id.recView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(rootView.getContext());
        recView.setLayoutManager(manager);
        list = new ArrayList<TodaysEvents>();

        for(int i=0;i<10;i++)
        {
            TodaysEvents ev = new TodaysEvents();
            ev.setNameOfEvent("Event No: "+i);
            ev.setDate("Date No: "+i);
            ev.setLocation("Location No: "+i);

            list.add(ev);
        }

        adapter = new RecyclerViewAdapter(list);
        recView.setAdapter(adapter);



    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyView> {


        ArrayList<TodaysEvents> listPfTodaysEvents = new ArrayList<TodaysEvents>();

        RecyclerViewAdapter(ArrayList<TodaysEvents> list)
        {
            this.listPfTodaysEvents = list;
        }

        @Override
        public MyView onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_todays_events_item,parent,false);
            return new MyView(view);
        }



        @Override
        public void onBindViewHolder(MyView holder, int position) {

           // holder.tv.setText(listPfTodaysEvents.get(position).getNameOfEvent());
        }

        @Override
        public int getItemCount() {
            return listPfTodaysEvents.size();
        }

        public class MyView extends RecyclerView.ViewHolder
        {
            TextView tv;

            public MyView(View itemView) {
                super(itemView);
               // tv = (TextView)itemView.findViewById(R.id.cardText);
            }
        }


    }
}
