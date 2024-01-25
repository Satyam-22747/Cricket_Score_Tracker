package com.satdroid.applicatinnavdr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MatchResults extends AppCompatActivity {

    private ArrayList<FetchResults> fetchResultsList;
    private DBhandler dBhandler;
    private MyAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_results2);

        fetchResultsList=new ArrayList<>();
        dBhandler=new DBhandler(MatchResults.this);
        fetchResultsList=dBhandler.readResults();
        adapter=new MyAdapter(fetchResultsList,MatchResults.this);
        recyclerView=findViewById(R.id.RCV_display_results);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MatchResults.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }
}