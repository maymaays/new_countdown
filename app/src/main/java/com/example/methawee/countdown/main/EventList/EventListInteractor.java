package com.example.methawee.countdown.main.EventList;
import com.example.methawee.countdown.model.Event;

import java.util.ArrayList;

/**
 * Created by methawee on 5/31/2017 AD.
 */

public interface EventListInteractor {
    ArrayList<Event> get();
    void update (Event event);
    void delete(Event event);
}