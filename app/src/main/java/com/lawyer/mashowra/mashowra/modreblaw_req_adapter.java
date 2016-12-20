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

public class modreblaw_req_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<lawyer> modreblaw_Req;
    private Context context;
    private LayoutInflater inflater;

    public modreblaw_req_adapter(Context context, List<lawyer> modreblaw_Req) {
        this.modreblaw_Req = modreblaw_Req;
        inflater= LayoutInflater.from(context);
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {

        View row = inflater.inflate(R.layout.item_moderblaw_req, parent, false);
        modreblawholder holder = new modreblawholder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        modreblawholder lholder= (modreblawholder) holder;
        lawyer l = modreblaw_Req.get(position);
        lholder.name.setText(l.name);
        lholder.city.setText(l.city);
        Glide.with(context).load(l.img).centerCrop().dontAnimate().into(lholder.img);


    }

    @Override
    public int getItemCount() {
        return modreblaw_Req.size();

    }

    class modreblawholder extends RecyclerView.ViewHolder {

        TextView name, city;

        CircleImageView img;
        public modreblawholder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.title_moderblaw);
            city = (TextView) itemView.findViewById(R.id.body_moderblaw);
            img = (CircleImageView)itemView.findViewById(R.id.img_moderblaw);


        }
    }
}

