package com.lawyer.mashowra.mashowra;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class lawyer_req_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> //implements Filterable
{
    List<lawyer> lawyer_Req;
    private Context context;
    private LayoutInflater inflater;

    public lawyer_req_adapter(Context context, List<lawyer> lawyer_Req) {
        this.lawyer_Req = lawyer_Req;
        inflater= LayoutInflater.from(context);
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype) {

        View row = inflater.inflate(R.layout.item_lawyer_req, parent, false);
        lawyerbholder holder = new lawyerbholder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        lawyerbholder lholder= (lawyerbholder) holder;
        lawyer l = lawyer_Req.get(position);
        lholder.name.setText(l.name);
        lholder.city.setText(l.city);
        Glide.with(context).load(l.img).centerCrop().dontAnimate().into(lholder.img);


    }

    @Override
    public int getItemCount() {
        return lawyer_Req.size();

    }

    class lawyerbholder extends RecyclerView.ViewHolder {

        TextView name, city;

        CircleImageView img;
        public lawyerbholder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.title_lawyer);
            city = (TextView) itemView.findViewById(R.id.body_lawyer);
            img = (CircleImageView)itemView.findViewById(R.id.img_lawyer);


        }
    }
}
