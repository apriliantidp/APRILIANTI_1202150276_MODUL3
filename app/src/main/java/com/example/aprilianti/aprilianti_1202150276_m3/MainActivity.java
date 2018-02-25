package com.example.aprilianti.aprilianti_1202150276_m3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.AbsListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Water> mWaterData;
    private WaterAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerview);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        mWaterData = new ArrayList<>();
        mAdapter = new WaterAdapter(this, mWaterData);
        mRecyclerView.setAdapter(mAdapter);


        initializeData();
        int swipeDirs;
        if (gridColumnCount > 1) {
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, swipeDirs) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                //Get the from and to position
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                //Swap the items and notify the adapter
                Collections.swap(mWaterData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                //Remove the item from the dataset
                mWaterData.remove(viewHolder.getAdapterPosition());

                //Notify the adapter
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        //Attach the helper to the RecyclerView
        helper.attachToRecyclerView(mRecyclerView);
        }



    private void initializeData() {
        TypedArray watersImageRes = getResources().obtainTypedArray(R.array.array_water);

        String[] watersList = getResources().getStringArray(R.array.array_water);

        mWaterData.clear();

        for (int i=0;i<watersList.length;i++){
            String[] judul = {"Ades", "Amidis", "Aqua", "Cleo", "Club", "Equil", "Evian",
                    "Leminerale", "Nestle", "Pristine", "Vit"};
            mWaterData.add(new Water(judul[i], "Air minum merk "+judul[i], "Air mineral adalah air yang mengandung mineral atau bahan-bahan larut lain yang mengubah rasa. " +
                    "Banyak kandungan Garam, sulfur, dan gas-gas yang larut di dalam air ini." +
                    "Air mineral biasanya masih memiliki buih. Air mineral bersumber dari mata air yang berada di alam." +
                    "Di Indonesia, bisnis air mineral dimulai pada tahun 1973 dengan merek Aqua. " +
                    "Mineral juga merupakan sumber minuman kepada atlet " +
                    "Mineral dapat menggantikan dan memulihkan sel-sel badan yang lama kepada sel yang baru. " +
                    "Namun hakikatnya air mineral adalah lebih mahal daripada air minuman.",
                    watersImageRes.getResourceId(i,0)));
        }


        watersImageRes.recycle();
        mAdapter.notifyDataSetChanged();

    }
}
