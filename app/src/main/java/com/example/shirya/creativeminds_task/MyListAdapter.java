package com.example.shirya.creativeminds_task;

        import android.content.Context;
        import android.support.v7.widget.CardView;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.FrameLayout;
        import android.widget.TextView;

        import io.realm.RealmBasedRecyclerViewAdapter;
        import io.realm.RealmResults;
        import io.realm.RealmViewHolder;

/**
 * Created by shirya on 04/09/17.
 */

public class MyListAdapter  extends  RealmBasedRecyclerViewAdapter<Cache_repos_data, MyListAdapter.ViewHolder> {

    public class ViewHolder extends RealmViewHolder {

        //        public TextView todoTextView;
        private TextView name,full_name,description ,fork;
        private CardView card;
        public ViewHolder(FrameLayout container) {
            super(container);
            this.card=(CardView)container.findViewById(R.id.card);
            this.name = (TextView)container.findViewById(R.id.name);
            this.full_name = (TextView)container.findViewById(R.id.full_name);
            this.description = (TextView)container.findViewById(R.id.description);
            this.fork = (TextView)container.findViewById(R.id.fork);


        }
    }

    public MyListAdapter(
            Context context,
            RealmResults<Cache_repos_data> realmResults,
            boolean automaticUpdate,
            boolean animateResults) {
        super(context, realmResults, automaticUpdate, animateResults);
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
        View v = inflater.inflate(R.layout.singel_card, viewGroup, false);
        ViewHolder vh = new ViewHolder((FrameLayout) v);
        return vh;
    }

    @Override
    public void onBindRealmViewHolder(ViewHolder viewHolder, int position) {
        final Cache_repos_data  toDoItem = realmResults.get(position);
        viewHolder.name.setText(toDoItem.getName());
        viewHolder.full_name.setText(toDoItem.getFull_name());
        viewHolder.description.setText(toDoItem.getDescription());
        viewHolder.fork.setText(toDoItem.getFork());

//        viewHolder.itemView.setBackgroundColor(
//                COLORS[(int) (toDoItem.getId() % COLORS.length)]
//        );
    }
}



