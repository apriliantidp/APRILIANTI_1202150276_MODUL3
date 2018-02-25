package com.example.aprilianti.aprilianti_1202150276_m3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.WriteAbortedException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aprilianti on 2/24/2018.
 */

public class WaterAdapter extends RecyclerView.Adapter<WaterAdapter.WaterViewHolder>{
    Context context;
    ArrayList<Water> arrayList;

    public WaterAdapter(Context context, ArrayList<Water> waters) {
        this.context = context;
        this.arrayList = waters;
    }

    @Override
    public WaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WaterViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(WaterViewHolder holder, int position) {

        Water currentWater = arrayList.get(position);
        holder.bindTo(currentWater);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class WaterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitle, mDescription;
        ImageView mWatersImage;
        public WaterViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mDescription = itemView.findViewById(R.id.subTitle);
            mWatersImage = itemView.findViewById(R.id.watersImage);
            itemView.setOnClickListener(this);
        }

        void bindTo(Water currentWater) {
            mTitle.setText(currentWater.getTitle());
            mDescription.setText(currentWater.getDescription());
            mWatersImage.setImageResource(currentWater.getImage());
        }

        @Override
        public void onClick(View view) {
            Water currentWater = arrayList.get(getAdapterPosition());
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", currentWater.getTitle());
            intent.putExtra("image", currentWater.getImage());
            intent.putExtra("detail", currentWater.getDetail());
            context.startActivity(intent);

        }
    }
}
