package com.example.recycleview2revision;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Model>arrayList;
    ItemClickListner onDelete;
    ItemClickListner onUpdate;

    public Adapter(ArrayList<Model> arrayList,ItemClickListner onDelete,ItemClickListner onUpdate) {
        this.arrayList = arrayList;
        this.onDelete=onDelete;
        this.onUpdate=onUpdate;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        switch (viewType) {
            case Model.ViewHolde1r:
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout1, parent, false);
            return new ViewHolder(view,onDelete);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

int viewType=arrayList.get(position).getViewType();
Model model=arrayList.get(position);
switch (viewType){
    case Model.ViewHolde1r:
        if(holder instanceof ViewHolder){
            ((ViewHolder) holder).setData(model);
        }break;

}

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    @Override
    public int getItemViewType(int position) {
        int itemType = arrayList.get(position).getViewType();

        switch (itemType) {
            case Model.ViewHolde1r:

                return Model.ViewHolde1r;

        }
        return -1;
    }
}
