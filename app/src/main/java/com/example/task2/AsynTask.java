package com.example.task2;

import android.os.AsyncTask;

public class AsynTask extends AsyncTask<MainActivity,Void, Void>
{


    @Override
    protected Void doInBackground(MainActivity... splasches) {
       Keys[] k =JsonLoader.getData();
       MainActivity m=splasches[0];
       m.CallMainAndDie(k.clone());
        return null;
    }

    @Override
    protected void onPostExecute(Void v)
    {

    }
}
