package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<CongAn> congAns;
    CongAnAdapter congAnAdapter;
    RecyclerView main_rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_rcv = findViewById(R.id.main_rcv);
        congAns = new ArrayList<>();
        congAnAdapter = new CongAnAdapter(congAns, this);

        main_rcv.setLayoutManager(new LinearLayoutManager(this));
        main_rcv.setAdapter(congAnAdapter);



        showlist();



    }

    public void showlist() {
        congAns.add(new CongAn("Nguyễn Văn A", "Thượng úy", "Hà Nội", "Việt Nam", R.drawable.thuonguy1, 2));
        congAns.add(new CongAn("Nguyễn Văn A", "Thượng úy", "Hà Nội", "Việt Nam", R.drawable.thuonguy1, 2));
        congAns.add(new CongAn("Nguyễn Văn A", "Thượng úy", "Hà Nội", "Việt Nam", R.drawable.thuonguy1, 2));
        congAns.add(new CongAn("Nguyễn Văn A", "Thượng úy", "Hà Nội", "Việt Nam", R.drawable.thuonguy1, 2));
        congAns.add(new CongAn("Nguyễn Văn A", "Thượng úy", "Hà Nội", "Việt Nam", R.drawable.thuonguy1, 2));

        congAnAdapter.notifyDataSetChanged();
    }


}