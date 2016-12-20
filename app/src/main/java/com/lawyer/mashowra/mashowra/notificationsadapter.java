package com.lawyer.mashowra.mashowra;

/**
 * Created by Ibrahim on 11/4/2016.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class notificationsadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<notification> notificationList;
    private Context context;
    private LayoutInflater inflater;

    public notificationsadapter(Context context, List<notification> notificationList) {
        this.notificationList = notificationList;
        inflater= LayoutInflater.from(context);
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {

        View row = inflater.inflate(R.layout.item_notification, parent, false);
        notificationholder holder = new notificationholder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final notificationholder nholder= (notificationholder) holder;
        notification n = notificationList.get(position);
        nholder.time.setText(n.time);
        nholder.title.setText(n.title);
        nholder.body.setText(n.body);
        Glide.with(context).load(n.img).centerCrop().dontAnimate().into(nholder.img);

    }

    @Override
    public int getItemCount() {
        return notificationList.size();

    }

    class notificationholder extends RecyclerView.ViewHolder {

        TextView time, title, body;

        CircleImageView img;
        public notificationholder(View itemView) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.time);
            title = (TextView) itemView.findViewById(R.id.title);
            body = (TextView) itemView.findViewById(R.id.body);
            img = (CircleImageView)itemView.findViewById(R.id.notificationimg);

        }
    }
}

