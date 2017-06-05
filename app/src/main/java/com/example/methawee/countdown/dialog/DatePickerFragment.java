package com.example.methawee.countdown.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.example.methawee.countdown.R;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by methawee on 5/29/2017 AD.
 * - datepicker dialog -
 */


public class DatePickerFragment extends DialogFragment  {

    private DatePicker datePicker;

    public interface DateDialogListener {
        void onFinishDialog(Date date);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.datepicker, null);
        datePicker = (DatePicker) v.findViewById(R.id.datepick);
        return new android.support.v7.app.AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("select your event date ♡")
                .setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int year = datePicker.getYear();
                                int mon = datePicker.getMonth();
                                int day = datePicker.getDayOfMonth();
                                Date date = new GregorianCalendar(year, mon, day).getTime();
                                DateDialogListener activity = (DateDialogListener) getActivity();
                                activity.onFinishDialog(date);
                                dismiss();
                            }
                        })
                .create();
    }
}