package com.satdroid.applicatinnavdr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView runs,overs,wickets;
    TextView runs_Team2,overs_Team2,wickets_Team2;
    AppCompatButton Run1btn,Run2btn,Run4btn,Run6btn,Overr_btn,Wicket_btn,RollBackRun,Clear_team1;
    AppCompatButton Run1btn_Team2,Run2btn_Team2,Run4btn_Team2,Run6btn_Team2,Overr_btn_Team2,Wicket_btn_Team2,RollBackRun_Team2,Clear_team2;
    DBhandler dBhandler;

    int run=0,wicket=0,over=0;
    int run_team2=0,wicket_team2=0,over_team2=0;
    double temp_overt1=0,temp_overt2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.navig_drawer);
        navigationView=findViewById(R.id.navig_view);
        toolbar=findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Open_drawer,R.string.Close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState(); //manage the state close and open state

        //textview
        runs=findViewById(R.id.run_text);  //team1
        overs=findViewById(R.id.over_text);
        wickets=findViewById(R.id.wicket_text);

        runs_Team2=findViewById(R.id.run_text_team2);  //team2
        overs_Team2=findViewById(R.id.over_text_team2);
        wickets_Team2=findViewById(R.id.wicket_text_team2);


        //buttons
        Run1btn=findViewById(R.id.run_1btn); //team1
        Run2btn=findViewById(R.id.run_2btn);
        Run4btn=findViewById(R.id.run_4btn);
        Run6btn=findViewById(R.id.run_6btn);
        RollBackRun=findViewById(R.id.Roll_back_run);
        Overr_btn=findViewById(R.id.balls_btn);
        Wicket_btn=findViewById(R.id.wkt_btn);
        Clear_team1=findViewById(R.id.clear_btnTeam1);

        Run1btn_Team2=findViewById(R.id.run_1btn_team2); //team2
        Run2btn_Team2=findViewById(R.id.run_2btn_team2);
        Run4btn_Team2=findViewById(R.id.run_4btn_team2);
        Run6btn_Team2=findViewById(R.id.run_6btn_team2);
        RollBackRun_Team2=findViewById(R.id.Roll_back_run_team2);
        Overr_btn_Team2=findViewById(R.id.balls_btn_team2);
        Wicket_btn_Team2=findViewById(R.id.wkt_btn_team2);
        Clear_team2=findViewById(R.id.clear_btn_team2);

        dBhandler=new DBhandler(MainActivity.this);

        //run count  Team1
        RollBackRun.setEnabled(false);
        Run1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run=run+1;
                RollBackRun.setEnabled(true);
              runs.setText(Integer.toString(run));
            }
        });
        Run2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run=run+2;
                RollBackRun.setEnabled(true);
                runs.setText(Integer.toString(run));
            }
        });
        Run4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run=run+4;
                RollBackRun.setEnabled(true);
                runs.setText(Integer.toString(run));
            }
        });
        Run6btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run=run+6;
                RollBackRun.setEnabled(true);
                runs.setText(Integer.toString(run));
            }
        });
        RollBackRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(run==1)
                    RollBackRun.setEnabled(false);
                run--;
                runs.setText(Integer.toString(run));
            }
        });
        //overs count
        DecimalFormat dform=new DecimalFormat("#.#");
        Overr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                over=over+1;
                if(over%10==6)
                    over=over+4;
                temp_overt1=over*0.1;
                overs.setText(dform.format(temp_overt1));
            }
        });

        //wicket count
        Wicket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket=wicket+1;
                if(wicket==10)
                    Wicket_btn.setEnabled(false);
                wickets.setText(Integer.toString(wicket));
            }
        });
        Clear_team1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run=0;over=0;wicket=0;
                overs.setText("");
                runs.setText("");
                wickets.setText("");
                RollBackRun.setEnabled(false);
                Wicket_btn.setEnabled(true);

            }
        });

        //run count  Team2
        RollBackRun_Team2.setEnabled(false);
        Run1btn_Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run_team2=run_team2+1;
                RollBackRun_Team2.setEnabled(true);
                runs_Team2.setText(Integer.toString(run_team2));
            }
        });
        Run2btn_Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run_team2=run_team2+2;
                RollBackRun_Team2.setEnabled(true);
                runs_Team2.setText(Integer.toString(run_team2));
            }
        });
        Run4btn_Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run_team2=run_team2+4;
                RollBackRun_Team2.setEnabled(true);
                runs_Team2.setText(Integer.toString(run_team2));
            }
        });
        Run6btn_Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run_team2=run_team2+6;
                RollBackRun_Team2.setEnabled(true);
                runs_Team2.setText(Integer.toString(run_team2));
            }
        });
        RollBackRun_Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(run_team2==1)
                    RollBackRun_Team2.setEnabled(false);
                run_team2--;
                runs_Team2.setText(Integer.toString(run_team2));
            }
        });

        //overs count
        DecimalFormat dform_team2 =new DecimalFormat("#.#");
        Overr_btn_Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                over_team2=over_team2+1;
                if(over_team2%10==6)
                    over_team2=over_team2+4;
                temp_overt2=over_team2*0.1;
                overs_Team2.setText(dform_team2.format(temp_overt2));
            }
        });
        //wicket count
        Wicket_btn_Team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wicket_team2=wicket_team2+1;
                if(wicket_team2==10)
                    Wicket_btn_Team2.setEnabled(false);
                wickets_Team2.setText(Integer.toString(wicket_team2));
            }
        });
        Clear_team2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run_team2=0;over_team2=0;wicket_team2=0;
                overs_Team2.setText("");
                runs_Team2.setText("");
                wickets_Team2.setText("");
                RollBackRun_Team2.setEnabled(false);
                Wicket_btn_Team2.setEnabled(true);

            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                if(id==R.id.new_game)
                {
                    Toast.makeText(MainActivity.this,"New Match",Toast.LENGTH_SHORT).show();
                    clear_All();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;

                }
               if(id==R.id.previous_match_menu)
                {
                    Toast.makeText(MainActivity.this,"Previous Matches",Toast.LENGTH_SHORT).show();
                    Intent inext=new Intent(MainActivity.this,MatchResults.class);
                    startActivity(inext);
                    return true;

                }
                return true;

            }
        });
        //OnCreateOptionsMenu();
       toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem item) {

               int id=item.getItemId();
               if(id==R.id.save_btn) {

                   Calendar calendar=Calendar.getInstance();
                   SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEE, MMM d, ''yy");
                   String Date_match=simpleDateFormat.format(calendar.getTime());

                   String over_t1=dform_team2.format(temp_overt1);
                   String over_t2=dform.format(temp_overt2);

                   dBhandler.addNewResults(run,over_t1,wicket,run_team2,over_t2,wicket_team2,Date_match);
                   Toast.makeText(MainActivity.this,"Saved Successfully",Toast.LENGTH_SHORT).show();
                  clear_All();
               }
               return true;
           }
       });



    }

    public boolean OnCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.save_result,menu);
        return  true;
    }
    private void clear_All(){

        run=0;over=0;wicket=0;
        overs.setText("");
        runs.setText("");
        wickets.setText("");
        RollBackRun.setEnabled(false);
        Wicket_btn.setEnabled(true);

        run_team2=0;over_team2=0;wicket_team2=0;
        overs_Team2.setText("");
        runs_Team2.setText("");
        wickets_Team2.setText("");
        RollBackRun_Team2.setEnabled(false);
        Wicket_btn_Team2.setEnabled(true);
    }



}