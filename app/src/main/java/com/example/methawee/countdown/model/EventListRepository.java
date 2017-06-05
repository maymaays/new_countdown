package com.example.methawee.countdown.model;

import com.example.methawee.countdown.main.EventAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by methawee on 6/1/2017 AD.
 */

public class EventListRepository implements EventRepository {

    private ArrayList<Event> events;
    private FirebaseDatabase database;
    private EventAdapter adapter;
    private static EventListRepository instance = null;

    public static EventListRepository getInstance() {
        if (instance == null)
            instance = new EventListRepository();
        return instance;
    }

    private EventListRepository() {

    }

    @Override
    public void all_event() {

    }

    @Override
    public void save_event(String title, Date deadline) {
//        database = FirebaseDatabase.getInstance();
//        String key = database.getReference("countdown ♡").push().getKey();
//        Event event = new Event(title, deadline);
//        event.setTitle(title.toString());
//        event.setDeadline(deadline);
//        Map<String, Object> childUpdates = new HashMap<>();
//        childUpdates.put(key, event.toFirebaseObject());
//        database.getReference("countdown ♡").updateChildren(childUpdates, new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//                if (databaseError == null) {
//                }
//            }
//        });
    }

    @Override
    public ArrayList<Event> get() {
//        database = FirebaseDatabase.getInstance();
//        database.getReference("countdown ♡").addListenerForSingleValueEvent(
//                new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        for (DataSnapshot data : dataSnapshot.getChildren()) {
//                            long days = Long.parseLong(String.valueOf(data.child("days_diff").getValue()));
//                            Event event = new Event(String.valueOf(data.child("title").getValue()), days);
//                            if (days > 0) {
//                                events.add(event);
//                            }
//                        }
//                        adapter.notifyDataSetChanged();
//                    }
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                }
//        );
        return events;
    }

    @Override
    public void update(Event event) {
//        database = FirebaseDatabase.getInstance();
//        String key = database.getReference("countdown ♡").push().getKey();
////        event.setTitle(title.toString());
////        event.setDeadline(deadline);
//        Map<String, Object> childUpdates = new HashMap<>();
//        childUpdates.put(key, event.toFirebaseObject());
//        database.getReference("countdown ♡").updateChildren(childUpdates, new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//                if (databaseError == null) {
//                }
//            }
//        });
    }

    @Override
    public void delete(Event event) {

    }

    @Override
    public Event getEventAt(int position) {
        return null;
    }
}
