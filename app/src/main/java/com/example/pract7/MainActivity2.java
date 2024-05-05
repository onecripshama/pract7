package com.example.pract7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private int minute;
    private int hour;
    private int year;
    private int month;
    private int day;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button buttonDatePicker = findViewById(R.id.set_date);
        Button buttonSetName = findViewById(R.id.set_name);
        TextView time = findViewById(R.id.textView_time);
        TextView date = findViewById(R.id.textView_date);

        @SuppressLint("DefaultLocale")
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this,
                (view, hourOfDay, minute) -> time.setText(String.format("%02d:%02d", hourOfDay, minute)),
                hour, minute, true);
        timePickerDialog.show();

        buttonDatePicker.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity2.this,
                    (view, year, monthOfYear, dayOfMonth) -> {
                        @SuppressLint("DefaultLocale")
                        String selectedDate = String.format("%02d.%02d.%04d", dayOfMonth, monthOfYear + 1, year);
                        date.setText(selectedDate);
                    }, year, month, day);
            datePickerDialog.show();
        });

        buttonSetName.setOnClickListener(v -> {
            Dialog dialog = new Dialog(MainActivity2.this);
            dialog.setContentView(R.layout.custom_dialog);
            TextView textView = dialog.findViewById(R.id.textView1);
            Button button2 = dialog.findViewById(R.id.button2);
            Button button = dialog.findViewById(R.id.button);
            EditText editText = findViewById(R.id.editText);
            String data = editText.getText().toString();
            textView.setText("Ваше имя " + data + '?');
            button.setOnClickListener(v1 -> {
                Toast.makeText(this, "Приятно познакомиться, " + data + "!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
            button2.setOnClickListener(v2 -> {
                Toast.makeText(this, "Введите имя еще раз", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
            dialog.show();
        });
    }

}