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

public class mo7kem_req_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<lawyer> mo7kem_Req;
    private Context context;
    private LayoutInflater inflater;

    public mo7kem_req_adapter(Context context, List<lawyer> mo7kem_Req) {
        this.mo7kem_Req = mo7kem_Req;
        inflater= LayoutInflater.from(context);
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {

        View row = inflater.inflate(R.layout.item_mo7kem_req, parent, false);
        mo7kemholder holder = new mo7kemholder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        mo7kemholder lholder= (mo7kemholder) holder;
        lawyer l = mo7kem_Req.get(position);
        lholder.name.setText(l.name);
        lholder.city.setText(l.city);
        Glide.with(context).load(l.img).centerCrop().dontAnimate().into(lholder.img);


    }

    @Override
    public int getItemCount() {
        return mo7kem_Req.size();

    }

    class mo7kemholder extends RecyclerView.ViewHolder {

        TextView name, city;

        CircleImageView img;
        public mo7kemholder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.title_mo7kem);
            city = (TextView) itemView.findViewById(R.id.body_mo7kem);
            img = (CircleImageView)itemView.findViewById(R.id.img_mo7kem);


        }
    }
}

