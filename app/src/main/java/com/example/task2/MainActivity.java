package com.example.task2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private  AsynTask as;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        as =new AsynTask();
        as.execute(this);
    }

    public void CallMainAndDie(Keys[] keys)
    {
        Intent intent=new Intent(this,Main3Activity.class);
        intent.putExtra("keys",keys);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        as.cancel(true);
        super.onBackPressed();
    }
}
