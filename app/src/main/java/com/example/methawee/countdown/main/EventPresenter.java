package com.example.methawee.countdown.main;

import com.example.methawee.countdown.model.Event;
import com.example.methawee.countdown.model.EventRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by methawee on 5/29/2017 AD.
 */

public class EventPresenter implements Observer {
    private EventView view;
    private EventRepository repository;
    private ArrayList<Event> events;

    public EventPresenter(EventView view, EventRepository repository) {
        this.view = view;
        this.repository = repository;
        initialize();
    }

    public void initialize() {
        //repository.addObserver(this);
        repository.get();
    }

    public void save_event(String title, Date deadline) {
        repository.save_event(title, deadline);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == repository) {
           // events = new ArrayList<Event>(repository.get());
            view.setEventList(events);
        }
    }

    public void get_value() {
        events = repository.get();
        view.setEventList(events);
    }

}
