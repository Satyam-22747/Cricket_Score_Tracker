package com.satdroid.applicatinnavdr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{


    private ArrayList<FetchResults> fetchResultsArrayLists;
    private Context context;

    public MyAdapter(ArrayList<FetchResults> fetchResultsArrayLists, Context context) {
        this.fetchResultsArrayLists = fetchResultsArrayLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.result_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FetchResults fetchResults=fetchResultsArrayLists.get(position);
        holder.run_t1.setText(String.valueOf(fetchResults.getRun_team1()));
        holder.match_dates.setText(fetchResults.getMatch_dates());
        holder.Over_t1.setText(fetchResults.getOver_team1());
        holder.run_t2.setText(String.valueOf(fetchResults.getRun_team2()));
        holder.Over_t2.setText(fetchResults.getOver_team2());
        holder.wicket_t1.setText(String.valueOf(fetchResults.getWicket_team1()));
        holder.wicket_t2.setText(String.valueOf(fetchResults.getWicket_team2()));
    }

    @Override
    public int getItemCount() {
        return fetchResultsArrayLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView run_t1,run_t2,Over_t1,Over_t2,wicket_t1,wicket_t2,match_dates;
        public ViewHolder(@NonNull View itemview){
            super(itemview);
                    run_t1=itemview.findViewById(R.id.runT1_rv);
                    run_t2=itemview.findViewById(R.id.runT2_rv);
                    Over_t1=itemview.findViewById(R.id.overT1_rv);
                    Over_t2=itemview.findViewById(R.id.overT2_rv);
                    wicket_t1=itemview.findViewById(R.id.wicketT1_rv);
                    wicket_t2=itemview.findViewById(R.id.wicketT2_rv);
                    match_dates=itemview.findViewById(R.id.date_rv);
        }
    }
}
