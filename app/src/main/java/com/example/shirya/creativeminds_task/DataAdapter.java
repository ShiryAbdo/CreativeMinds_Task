package com.example.shirya.creativeminds_task;

import android.content.Context;
 import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by shirya on 03/09/17.
 */

public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<repos_data> androidList;
    private Context context;
    private int lastPosition=-1;
    Realm mRealm;




    public DataAdapter(ArrayList<repos_data> android,Context c) {
        this.androidList = android;
        this.context=c;

        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration
                .Builder( ).deleteRealmIfMigrationNeeded() .build();

        Realm.setDefaultConfiguration(config);
        mRealm = Realm.getDefaultInstance();


     }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout. singel_card, viewGroup, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder,  final int i) {

        viewHolder.name.setText( androidList.get(i).getName());

        viewHolder.full_name.setText(androidList.get(i).getFull_name());

         viewHolder.description.setText(androidList.get(i).getDescription());
//        viewHolder.fork.setText(androidList.get(i).getOwner().getHtml_url().toString());

        mRealm.beginTransaction();




        Cache_repos_data realmStudent = mRealm.createObject(Cache_repos_data.class);

        realmStudent.setName(androidList.get(i).getName());
        realmStudent.setFull_name(androidList.get(i).getFull_name());
        if(androidList.get(i).getDescription()!=null){
            realmStudent.setDescription(androidList.get(i).getDescription());
        }

        realmStudent.setFork(androidList.get(i).getFork());
        realmStudent.setHtml_url(androidList.get(i).getHtml_url());
        realmStudent.setOwner_html_url(androidList.get(i).getOwner().getHtml_url().toString());
        mRealm.commitTransaction();





        if(androidList.get(i).getFork()==true){

            viewHolder.card.setCardBackgroundColor(Color.GREEN);

        }else {

            viewHolder.card.setCardBackgroundColor(Color.WHITE);
        }
        viewHolder.card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("");
                LayoutInflater inflater = LayoutInflater.from( context);
                View alertLayout = inflater.inflate(R.layout.dialog_view, null);
                final Button ownerLink = (Button) alertLayout.findViewById(R.id.ownerLink);
                final Button repository_html_url = (Button) alertLayout.findViewById(R.id.repository_html_url);
                 alert.setView(alertLayout);
                repository_html_url.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri uri = Uri.parse(androidList.get(i).getHtml_url().toString()); // missing 'http://' will cause crashed
                          context.startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    }
                });

                ownerLink.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Uri uri = Uri.parse(androidList.get(i).getOwner().getHtml_url().toString()); // missing 'http://' will cause crashed
                        context.startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    }
                });




                AlertDialog dialog = alert.create();
                dialog.show();
                return true;
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

