package com.example.shirya.creativeminds_task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by shirya on 03/09/17.
 */

public class repos_data {

     @SerializedName("name")
    @Expose
    private String name;

     @SerializedName("full_name")
    @Expose
    private String full_name;


     @SerializedName("description")
    @Expose
    private String description;


     @SerializedName("fork")
    @Expose
    private  Boolean fork;



//    @Required
//    @SerializedName("html_url")
//    @Expose
//    private  String html_url;

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setFull_name(String full_name) {
//        this.full_name = full_name;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setFork(Boolean fork) {
//        this.fork = fork;
//    }





    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getFork() {
        return fork;
    }


}


//
//
//package com.example.shirya.creativeminds_task;
//
//        import android.content.Context;
//        import android.content.Intent;
//        import android.support.v7.widget.CardView;
//        import android.support.v7.widget.RecyclerView;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.view.animation.Animation;
//        import android.view.animation.AnimationUtils;
//        import android.widget.TextView;
//
//        import java.util.ArrayList;
//
//        import io.realm.Realm;
//        import io.realm.RealmResults;
//
///**
// * Created by shirya on 04/09/17.
// */
//
//public class adaptor   extends RecyclerView.Adapter<adaptor.ViewHolder> {
//    //    private RealmResults<Cache_repos_data> androidList;
//    private Context context;
//    private int lastPosition=-1;
//    private Realm mRealm;
//
////    public adaptor(RealmResults<Cache_repos_data> android, Context c) {
////        this.androidList = android;
////        this.context=c;
////        mRealm = Realm.getInstance(context);
////    }
//
//    public adaptor(RealmResults<Cache_repos_data> cache_repos_datas,Context con) {
//        this.androidList = cache_repos_datas;
//        this.context=con;
//        mRealm = Realm.getInstance(context);
//    }
//
//    @Override
//    public adaptor.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout. singel_card, viewGroup, false);
//
//
//        return new adaptor.ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(adaptor.ViewHolder viewHolder, int i) {
//
//        viewHolder.name.setText( androidList.get(i).getName());
//
//        viewHolder.full_name.setText(androidList.get(i).getFull_name());
//
//        viewHolder.description.setText(androidList.get(i).getDescription());
//        viewHolder.fork.setText(androidList.get(i).getFork().toString());
//
//
//
//
//
//        mRealm.beginTransaction();
//        Cache_repos_data realmStudent = mRealm.createObject(Cache_repos_data.class);
//        realmStudent.setName(androidList.get(i).getName());
//        realmStudent.setFull_name(androidList.get(i).getFull_name());
//        mRealm.commitTransaction();
//
//        viewHolder.card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.startActivity(new Intent(context, Shwo_Cach.class));
//            }
//        });
//        setAnimation(viewHolder.card, i);
//
//    }
//
//
//
//    private void setAnimation(View viewToAnimate, int position)
//    {
//        // If the bound view wasn't previously displayed on screen, it's animated
//        if (position > lastPosition)
//        {
//            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
//            viewToAnimate.startAnimation(animation);
//            lastPosition = position;
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return androidList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        private TextView name,full_name,description ,fork;
//        private CardView card;
//        public ViewHolder(View view) {
//            super(view);
//            card=(CardView)view.findViewById(R.id.card);
//            name = (TextView)view.findViewById(R.id.name);
//            full_name = (TextView)view.findViewById(R.id.full_name);
//            description = (TextView)view.findViewById(R.id.description);
//            fork = (TextView)view.findViewById(R.id.fork);
//
//        }
//    }
//
//
//
//
//}

