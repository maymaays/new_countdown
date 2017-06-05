package com.example.methawee.countdown.model;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


/**
 * Created by methawee on 5/29/2017 AD.
 * - model -
 */

public class Event implements Serializable {

    private String title;
    private Date current, deadline;
    private long days, diff;

    public Event(String title, Date deadline) {
        this.title = title;
        this.deadline = deadline;
    }

    public Event(String title, long days) {
        this.title = title;
        this.days = days;
    }

    public long cal_diff() {
        Calendar today = Calendar.getInstance();
        current = today.getTime();
        try {
            if (!current.after(deadline)) {
                diff = deadline.getTime() - current.getTime();
                days = diff / (24 * 60 * 60 * 1000);
                diff -= days * (24 * 60 * 60 * 1000);
            } else {
                days = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return days;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public HashMap<String, String> toFirebaseObject() {
        HashMap<String, String> event = new HashMap<String, String>();
        days = cal_diff();
        event.put("title", title);
        event.put("days_diff", Long.toString(days + 1));
        return event;
    }
}
