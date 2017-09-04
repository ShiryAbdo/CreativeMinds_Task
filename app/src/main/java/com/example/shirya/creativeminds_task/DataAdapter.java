package com.example.shirya.creativeminds_task;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shirya on 03/09/17.
 */

public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<repos_data> androidList;
    private Context context;
    private int lastPosition=-1;

    public DataAdapter(ArrayList<repos_data> android,Context c) {
        this.androidList = android;
        this.context=c;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout. singel_card, viewGroup, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.name.setText( androidList.get(i).getName());

        viewHolder.full_name.setText(androidList.get(i).getFull_name());

         viewHolder.description.setText(androidList.get(i).getDescription());
        viewHolder.fork.setText(androidList.get(i).getFork().toString());


        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             }
        });
        setAnimation(viewHolder.card, i);

    }



    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return androidList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,full_name,description ,fork;
        private CardView card;
        public ViewHolder(View view) {
            super(view);
            card=(CardView)view.findViewById(R.id.card);
            name = (TextView)view.findViewById(R.id.name);
            full_name = (TextView)view.findViewById(R.id.full_name);
            description = (TextView)view.findViewById(R.id.description);
            fork = (TextView)view.findViewById(R.id.fork);

        }
    }

}

