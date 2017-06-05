package com.example.methawee.countdown.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.methawee.countdown.R;
import com.example.methawee.countdown.dialog.DatePickerFragment;
import com.example.methawee.countdown.model.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class EventActivity extends AppCompatActivity implements DatePickerFragment.DateDialogListener {

    private ListView view;
    private EventAdapter adapter;
    private String title;
    private ArrayList<Event> events;
    private FirebaseDatabase database;
    private Date deadline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        events = new ArrayList<Event>();
        database = FirebaseDatabase.getInstance();
        setListView(events);
    }

    public void setListView(ArrayList<Event> events) {
        view = (ListView) findViewById(R.id.listview_events);
        adapter = new EventAdapter(this, events);
        view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                final EditText event = new EditText(this);
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("add your new event here ♥")
                        .setMessage("- what do you want to do next -")
                        .setView(event)
                        .setPositiveButton("select date ♡", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                title = String.valueOf(event.getText());
                                DatePickerFragment date_dialog = new DatePickerFragment();
                                date_dialog.show(getSupportFragmentManager(), "date");
                            }
                        })
                        .setNegativeButton("cancel ♡", null)
                        .create();
                dialog.show();
                return true;
            case R.id.action_delete_task:
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().getRoot().child("countdown ♡");
                db.setValue(null);
                Toast.makeText(EventActivity.this, "all data has been deleted.",Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void save_event(Date deadline) {
        String key = database.getReference("countdown ♡").push().getKey();
        Event event = new Event(title, deadline);
        event.setTitle(title.toString());
        events.add(event);
        event.setDeadline(deadline);
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(key, event.toFirebaseObject());
        database.getReference("countdown ♡").updateChildren(childUpdates, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                }
            }
        });
    }

    @Override
    public void onFinishDialog(Date date) {
        deadline = date;
        save_event(deadline);
        Toast.makeText(EventActivity.this, "data has been inserted.",Toast.LENGTH_LONG).show();
        setListView(events);
    }

    @Override
    public void onResume() {
        super.onResume();
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
                        setListView(events);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w("countdown", "cancel", databaseError.toException());
                    }
                }
        );
    }

}
