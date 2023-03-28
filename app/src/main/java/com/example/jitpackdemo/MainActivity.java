package com.example.jitpackdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.jitpackdemo.bean.User;
import com.example.jitpackdemo.vm.MyViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ILog{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                Log.i(TAG, "onChanged: "+users.size());
            }
        });
    }
}