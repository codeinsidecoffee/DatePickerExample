package com.mrlonewolfer.datepickerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDatepicker;
    Context context;
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context =this;
        btnDatepicker=findViewById(R.id.btnDatePicker);
        btnDatepicker.setOnClickListener(this);
        txtView=findViewById(R.id.txtDate);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnDatePicker){
            showDatePickerDailog();

        }
    }

    private void showDatePickerDailog() {
       final Calendar calendar=Calendar.getInstance();
        final int Year=calendar.get(Calendar.YEAR);
        final int Month=calendar.get(Calendar.MONTH);
        final int Day=calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog=new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                txtView.setText(dayOfMonth+"/"+month+"/"+year);

            }
        },Year,Month,Day);

        datePickerDialog.show();

    }
}
