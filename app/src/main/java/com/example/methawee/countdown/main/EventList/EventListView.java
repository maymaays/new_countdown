package com.example.methawee.countdown.main.EventList;

import com.example.methawee.countdown.model.Event;

import java.util.ArrayList;

/**
 * Created by methawee on 5/31/2017 AD.
 */

public interface EventListView {

    void setEvent(ArrayList<Event> events);

    void notifyEventDateSetChanged();

    void notifyEventRemoved(int position);

    void notifyEventInserted(int position);

    void showEventToEdit(Event event);

    void showEventDetail();

}
