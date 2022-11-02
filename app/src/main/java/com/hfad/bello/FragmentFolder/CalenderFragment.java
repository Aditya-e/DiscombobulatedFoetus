package com.hfad.bello.FragmentFolder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import com.hfad.bello.DataBase;
import com.hfad.bello.R;

public class CalenderFragment extends Fragment {
        private CalendarView calendarView;
        private Button button;
        private EditText editText;
        private String selectedDate;
        private DataBase dataBase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calender, container, false);
        calendarView=view.findViewById(R.id.calendarView);
        editText=view.findViewById(R.id.eventText);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int date) {
                    selectedDate=Integer.toString(year)+Integer.toString(month)+Integer.toString(date);
            }
        });
//        dataBase=new DataBase(getContext());
//        dataBase.insertData(selectedDate,editText.toString());

        return view;
    }
}