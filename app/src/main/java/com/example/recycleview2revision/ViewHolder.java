package com.example.recycleview2revision;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView time;
    ImageView delete;
    ImageView edit;
    ItemClickListner itemClickListner;
    public ViewHolder(@NonNull View itemView ,ItemClickListner itemClickListner) {
        super(itemView);

        this.itemClickListner=itemClickListner;
        initView(itemView);
    }

    private void initView(View itemView) {
        name=itemView.findViewById(R.id.meeting);
        time=itemView.findViewById(R.id.textTime);
        delete=itemView.findViewById(R.id.delete);
        edit=itemView.findViewById(R.id.edit);

    }public void setData(Model model){
        name.setText(model.getName());
        time.setText(model.getTime()+"");
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListner.onUpdate(getAdapterPosition(),model);
            }
        });
delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        itemClickListner.onDelete(getAdapterPosition(),model);
    }
});

    }
}
