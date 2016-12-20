package com.lawyer.mashowra.mashowra;

/**
 * Created by koka7 on 11/6/2016.
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

public class mostshar_req_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<lawyer> mostshar_Req;
    private Context context;
    private LayoutInflater inflater;

    public mostshar_req_adapter(Context context, List<lawyer> mostshar_Req) {
        this.mostshar_Req = mostshar_Req;
        inflater= LayoutInflater.from(context);
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {

        View row = inflater.inflate(R.layout.item_mostshar_req, parent, false);
        mostsharholder holder = new mostsharholder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        mostsharholder lholder= (mostsharholder) holder;
        lawyer l = mostshar_Req.get(position);
        lholder.name.setText(l.name);
        lholder.city.setText(l.city);
        Glide.with(context).load(l.img).centerCrop().dontAnimate().into(lholder.img);


    }

    @Override
    public int getItemCount() {
        return mostshar_Req.size();

    }

    class mostsharholder extends RecyclerView.ViewHolder {

        TextView name, city;

        CircleImageView img;
        public mostsharholder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.title_mostshar);
            city = (TextView) itemView.findViewById(R.id.body_mostshar);
            img = (CircleImageView)itemView.findViewById(R.id.img_mostshar);


        }
    }
}

