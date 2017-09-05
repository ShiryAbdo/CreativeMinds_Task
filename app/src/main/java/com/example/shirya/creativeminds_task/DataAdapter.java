package com.example.shirya.creativeminds_task;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
//        mRealm.setDefaultConfiguration(config);


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




        mRealm.beginTransaction();
        Cache_repos_data realmStudent = mRealm.createObject(Cache_repos_data.class);
        realmStudent.setName(androidList.get(i).getName());
        realmStudent.setFull_name(androidList.get(i).getFull_name());
         mRealm.commitTransaction();
        viewHolder.card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);

//                LayoutInflater li = LayoutInflater.from(this);
//                View dialogView = li.inflate(R.layout.to_do_dialog_view, null);
//                final EditText input = (EditText) dialogView.findViewById(R.id.input)



                return true;
            }
        });
        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, Shwo_Cach.class));
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


//
//
//package com.example.shirya.creativeminds_task;
//
//        import android.content.Context;
//        import android.support.v7.widget.CardView;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.FrameLayout;
//        import android.widget.TextView;
//
//        import io.realm.RealmBasedRecyclerViewAdapter;
//        import io.realm.RealmResults;
//        import io.realm.RealmViewHolder;
//
///**
// * Created by shirya on 04/09/17.
// */
//
//public class MyListAdapter  extends  RealmBasedRecyclerViewAdapter<Cache_repos_data, MyListAdapter.ViewHolder> {
//
//    public class ViewHolder extends RealmViewHolder {
//
//        //        public TextView todoTextView;
//        private TextView name,full_name,description ,fork;
//        private CardView card;
//        public ViewHolder(FrameLayout container) {
//            super(container);
//            this.card=(CardView)container.findViewById(R.id.card);
//            this.name = (TextView)container.findViewById(R.id.name);
//            this.full_name = (TextView)container.findViewById(R.id.full_name);
//            this.description = (TextView)container.findViewById(R.id.description);
//            this.fork = (TextView)container.findViewById(R.id.fork);
//
//
//        }
//    }
//
//    public MyListAdapter(
//            Context context,
//            RealmResults<Cache_repos_data> realmResults,
//            boolean automaticUpdate,
//            boolean animateResults) {
//        super(context, realmResults, automaticUpdate, animateResults);
//    }
//
//    @Override
//    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
//        View v = inflater.inflate(R.layout.singel_card, viewGroup, false);
//        ViewHolder vh = new ViewHolder((FrameLayout) v);
//        return vh;
//    }
//
//    @Override
//    public void onBindRealmViewHolder(ViewHolder viewHolder, int position) {
//        final Cache_repos_data  toDoItem = realmResults.get(position);
//        viewHolder.name.setText(toDoItem.getName());
//        viewHolder.full_name.setText(toDoItem.getFull_name());
//        viewHolder.description.setText(toDoItem.getDescription());
//        viewHolder.fork.setText(toDoItem.getFork());
//
////        viewHolder.itemView.setBackgroundColor(
////                COLORS[(int) (toDoItem.getId() % COLORS.length)]
////        );
//    }
//}
//
//
//
