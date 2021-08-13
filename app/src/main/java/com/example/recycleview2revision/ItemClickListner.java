package com.example.recycleview2revision;

public interface ItemClickListner {
    void onUpdate(int position,Model model);
    void onDelete(int position,Model model);
}
