package com.example.w2d3_ex1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements FirstFragment.OnButtonClickListenerFirst,
        SecondFragment.OnButtonClickListenerSecond {

    FragmentManager fragmentManager;
    FirstFragment firstFrag;
    SecondFragment secondFrag;

    @Override
    public void sendToSecond(String msg) {
        secondFrag.printMessage(msg);
    }

    @Override
    public void sendToFirst(String msg) {
        firstFrag.printMessage(msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //this inflates the layout
        fragmentManager = getSupportFragmentManager();

        firstFrag = new FirstFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.firstContainer, firstFrag)
                .commit();

        secondFrag = new SecondFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.secondContainer, secondFrag)
                .commit();
    }
}
