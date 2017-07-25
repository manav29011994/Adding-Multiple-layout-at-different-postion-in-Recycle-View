package com.recycletest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by manav on 24/7/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<MyPojo> mDataset;


    private final static int HEADER_VIEW = 0;
    private final static int CONTENT_VIEW = 1;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;
        public ViewHolder(View v) {
            super(v);
            view = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<MyPojo> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {


        int layoutRes = 0;
        switch (viewType) {
            case HEADER_VIEW:
                layoutRes = R.layout.myviews;
                break;
            case CONTENT_VIEW:
                layoutRes = R.layout.new_view;
                break;
        }


        View v = (View)LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false);

        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        int viewType = getItemViewType(position);
        if(viewType==0) {
            MyPojo my = mDataset.get(position);
            TextView name = (TextView) holder.view.findViewById(R.id.name);
            TextView address = (TextView) holder.view.findViewById(R.id.place);
            name.setText(my.name);
            address.setText(my.address);
        }

        else if(viewType==1)
        {
            TextView my=(TextView)holder.view.findViewById(R.id.fcuk);
            my.setText("added banner");
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    @Override
    public int getItemViewType(int position) {

        int res=position % 5;
        if(res==0)
        {
            return CONTENT_VIEW;
        }

        else

            return HEADER_VIEW;

    }
}


