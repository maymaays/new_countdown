package com.example.methawee.countdown.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;


/**
 * Created by methawee on 5/29/2017 AD.
 */

public interface EventRepository {

   void all_event();

     void save_event(String title, Date deadline);

     ArrayList<Event> get();

    void update(Event event);

    void delete(Event event);

    Event getEventAt(int position);


}
