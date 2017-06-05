package com.example.methawee.countdown.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by methawee on 6/5/2017 AD.
 */

public class MockListRepository implements EventRepository {

    @Override
    public void all_event() {

    }

    @Override
    public void save_event(String title, Date deadline) {

    }

    @Override
    public ArrayList<Event> get() {
        return null;
    }

    @Override
    public void update(Event event) {

    }

    @Override
    public void delete(Event event) {

    }

    @Override
    public Event getEventAt(int position) {
        return null;
    }
}
