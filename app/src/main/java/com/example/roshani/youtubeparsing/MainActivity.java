package com.example.roshani.youtubeparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.roshani.youtubeparsing.entities.Example;
import com.example.roshani.youtubeparsing.entities.Item;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String part = "snippet,status";
    String fieds = "nextPageToken,items(snippet(publishedAt,title,resourceId,thumbnails),status)";
    String playlistid = "PLrEnWoR732-BHrPp_Pm8_VleD68f9s14-";
    String maxresults = "50";
    String apikey = "AIzaSyAJ7XL6febb9L2PNpiiIrmrG-dJNOGfZ9g";
    List<Item> mydata=new ArrayList<>();
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv.setItemAnimator(new DefaultItemAnimator());



        RequestInterface requestInterface= Apiclient.getClient().create(RequestInterface.class);
        Call<Example> call= requestInterface.getData(part,fieds,maxresults,playlistid,apikey);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                mydata=response.body().getItems();
                rv.setAdapter(new CustomAdapter(MainActivity.this,mydata));
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }
}
