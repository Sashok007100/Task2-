package com.example.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JsonLoader {

    private static final String URL = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/techs.ruleset.json";
    public static final String TAG = "TAGIS";
    private static final String KEY_USER_ID = "user_id";
    private static Response response;

    public static Keys[] getData() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            response = client.newCall(request).execute();
            String s=response.body().string();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Keys[] arr=gson.fromJson(s,Keys[].class);
            return arr;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
