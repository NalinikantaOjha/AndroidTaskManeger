package com.example.recycleview2revision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListner{
    RecyclerView recyclerView;
    ArrayList<Model>arrayList=new ArrayList<>();
    EditText name;
    EditText time;
    Button Done;
    Adapter view;
    Button add;
    CardView cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildData();
        setLayout();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView.setVisibility(View.VISIBLE);

                Done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Model model1=new Model(Model.ViewHolde1r,name.getText().toString(),Integer.parseInt(time.getText().toString()));

                        cardView.setVisibility(View.GONE);
                        arrayList.add(model1);
                        view.notifyDataSetChanged();
                    }
                });

            }
        });
    }
    public  void initView(){
        cardView=findViewById(R.id.editCardView);
        recyclerView=findViewById(R.id.recyclerView);
        name=findViewById(R.id.etName);
        time=findViewById(R.id.etTime);
        Done=findViewById(R.id.btnDone);
        add=findViewById(R.id.addtask);

    }
    private void buildData(){
for(int i =0;i<3;i++) {
    Model model = new Model(Model.ViewHolde1r,"Meeting with Nal", 12);
    arrayList.add(model);
}
    }private void setLayout(){

        view=new Adapter(arrayList,this,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(view);


    }

    @Override
    public void onUpdate(int position, Model model) {
        cardView.setVisibility(View.VISIBLE);
        name.setText(model.getName());
       time.setText(model.getTime()+"");
       Done.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Model model1=new Model(Model.ViewHolde1r,name.getText().toString(),Integer.parseInt(time.getText().toString()));

               cardView.setVisibility(View.GONE);
               arrayList.set(position,model1);
               view.notifyDataSetChanged();
           }
       });


    }

    @Override
    public void onDelete(int position, Model model) {
arrayList.remove(position);
view.notifyDataSetChanged();

    }
}