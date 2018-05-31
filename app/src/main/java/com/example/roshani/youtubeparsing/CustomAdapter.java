package com.example.roshani.youtubeparsing;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.roshani.youtubeparsing.entities.High;
import com.example.roshani.youtubeparsing.entities.Item;
import com.example.roshani.youtubeparsing.entities.Medium;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context c;
    List<Item> list;
    public CustomAdapter(MainActivity mainActivity, List<Item> mydata) {
        c= mainActivity;
        list=mydata;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView= LayoutInflater.from(c).inflate(R.layout.singleitem,null);

        return new MyViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, final int position) {
        holder.title.setText(list.get(position).getSnippet().getTitle());
        holder.date1.setText(list.get(position).getSnippet().getPublishedAt());
        //glide is used for showing thumbnail image of the youtube videos
       Glide.with(c).load(list.get(position).getSnippet().getThumbnails().getDefault().getUrl()).into(holder.im);
       holder.convertView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(c,PlayerActivity.class);
               i.putExtra("id",list.get(position).getSnippet().getResourceId().getVideoId());
               c.startActivity(i);
           }
       });






    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView im;
        TextView title,date1;
        View convertView;
        public MyViewHolder(View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.imv);
            title=itemView.findViewById(R.id.txt);
            date1=itemView.findViewById(R.id.date);
            convertView=itemView;

        }
    }
}
