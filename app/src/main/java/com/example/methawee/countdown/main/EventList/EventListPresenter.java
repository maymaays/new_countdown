package com.example.methawee.countdown.main.EventList;

import android.content.Context;
import android.widget.Toast;

import com.example.methawee.countdown.model.Event;

import java.util.ArrayList;

/**
 * Created by methawee on 5/31/2017 AD.
 */

public class EventListPresenter {
    private EventListView view;
    private EventListInteractor interactor;
    private Context context;

    public EventListPresenter(EventListView view, Context context) {
        this.view = view;
        //this.interactor = new EventRepository(context.getContentResolver());
        this.context = context;
    }

    public void add() {
        view.showEventDetail();
    }

    public void edit(Event event) {
        view.showEventToEdit(event);
    }

    public void done(Event event, int position) {
        interactor.update(event);
        ArrayList<Event> events = interactor.get();
        view.notifyEventRemoved(position);
        view.setEvent(events);
        for (Event task : events) {
            if (task.getTitle() == event.getTitle()) {
                view.notifyEventInserted(events.indexOf(task));
            }
        }
    }

    public void delete(Event event) {
        interactor.delete(event);
        view.setEvent(interactor.get());
        view.notifyEventDateSetChanged();
        Toast.makeText(context, "delete", Toast.LENGTH_SHORT).show();
    }
}
