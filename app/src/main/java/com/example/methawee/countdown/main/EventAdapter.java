package com.example.methawee.countdown.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.methawee.countdown.R;
import com.example.methawee.countdown.model.Event;


import java.util.ArrayList;

import static java.security.AccessController.getContext;


/**
 * Created by methawee on 5/29/2017 AD.
 */

//public class EventAdapter extends RecyclerView.Adapter<EventViewHolders> {
//
//    private ArrayList<Event> events;
//    protected Context context;
//
//    public EventAdapter(Context context, ArrayList<Event> events) {
//
//        this.events = events;
//        this.context = context;
//    }
//
//    @Override
//    public EventViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
//        EventViewHolders ev = null;
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
//        ev = new EventViewHolders(v, events);
//        return ev;
//    }
//
//    @Override
//    public void onBindViewHolder(EventViewHolders holder, int position) {
//        final Event event = events.get(position);
//        holder.title.setText(event.getTitle());
//        holder.days.setText(Long.toString(event.cal_diff()) + " days");
//    }
//
//    @Override
//    public int getItemCount() {
//        return this.events.size();
//    }
//
//}





public class EventAdapter extends ArrayAdapter<Event> {

    private static class ViewHolder {
        private TextView title;
        private TextView days;
    }

    public EventAdapter(Context context, ArrayList<Event> events) {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Event event = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_event, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.days = (TextView) convertView.findViewById(R.id.days);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(event.getTitle());
        viewHolder.days.setText(Long.toString(event.cal_diff()) + " days");
        return convertView;
    }
}
