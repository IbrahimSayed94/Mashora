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

public class lawyermotderb_req_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<lawyer> lawyermotderb_Req;
    private Context context;
    private LayoutInflater inflater;

    public lawyermotderb_req_adapter(Context context, List<lawyer> lawyermotderb_Req) {
        this.lawyermotderb_Req = lawyermotderb_Req;
        inflater= LayoutInflater.from(context);
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {

        View row = inflater.inflate(R.layout.item_lawyermotderb_req, parent, false);
        lawyermotderbholder holder = new lawyermotderbholder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        lawyermotderbholder lholder= (lawyermotderbholder) holder;
        lawyer l = lawyermotderb_Req.get(position);
        lholder.name.setText(l.name);
        lholder.city.setText(l.city);
        Glide.with(context).load(l.img).centerCrop().dontAnimate().into(lholder.img);

    }

    @Override
    public int getItemCount() {
        return lawyermotderb_Req.size();

    }

    class lawyermotderbholder extends RecyclerView.ViewHolder {

        TextView name, city;

        CircleImageView img;
        public lawyermotderbholder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.title_lawyermotderb);
            city = (TextView) itemView.findViewById(R.id.body_lawyermotderb);
            img = (CircleImageView)itemView.findViewById(R.id.img_lawyermotderb);

        }
    }
}

