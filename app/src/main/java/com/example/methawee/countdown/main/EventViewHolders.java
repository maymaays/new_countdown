package com.example.methawee.countdown.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.methawee.countdown.R;
import com.example.methawee.countdown.model.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * Created by methawee on 6/5/2017 AD.
 */

public class EventViewHolders extends RecyclerView.ViewHolder {
    
    public TextView title;
    public TextView days;
    public ArrayList<Event> events;

    public EventViewHolders(View convertView, final ArrayList<Event> events) {
        super(convertView);
        this.events = events;
        title = (TextView) convertView.findViewById(R.id.title);
        days = (TextView) convertView.findViewById(R.id.days);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.getReference("countdown ♡").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            long days = Long.parseLong(String.valueOf(data.child("days_diff").getValue()));
                            Event event = new Event(String.valueOf(data.child("title").getValue()), days);
                            if (days > 0) {
                                events.add(event);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w("countdown", "cancel", databaseError.toException());
                    }
                }
        );
    }
}
