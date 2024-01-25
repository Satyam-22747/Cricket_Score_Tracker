package com.satdroid.applicatinnavdr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Array;
import java.util.ArrayList;

public class DBhandler extends SQLiteOpenHelper {

    private static final String db_name="Match Results";
    private static final int db_version=1;
    private static final String table_name="Teams_Score";
    private static final String id_teams="id";
    private static final String team1_run="Runs_T1 ";
    private static final String team1_over="Overs_T1 ";
    private static final String team1_wicket="Wickets_T1 ";
    private static final String team2_run="Runs_T2 ";
    private static final String team2_over="Overs_T2 ";
    private static final String team2_wicket="Wickets_T2 ";
    private static final String date_match="Date_Match ";


    public DBhandler(Context context) {
        super(context, db_name, null,db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + table_name+ "("+
                id_teams+"  INTEGER PRIMARY KEY AUTOINCREMENT,"
                +team1_run+"TEXT,"
                +team1_over+"TEXT, "
                +team1_wicket+"TEXT, "
                +team2_run+"TEXT, "
                +team2_over+"TEXT, "
                +team2_wicket+"TEXT,"
                +date_match+"TEXT "+")");
    }

    public  void addNewResults(int runs_team1,String overs_team1,int wickets_team1,int runs_team2,String overs_team2,int wickets_team2, String Match_Date)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(team1_run,runs_team1);
        values.put(team1_over,overs_team1);
        values.put(team1_wicket,wickets_team1);
        values.put(team2_run,runs_team2);
        values.put(team2_over,overs_team2);
        values.put(team2_wicket,wickets_team2);
        values.put(date_match,Match_Date);

        sqLiteDatabase.insert(table_name,null,values);
        sqLiteDatabase.close();
    }

    public ArrayList<FetchResults> readResults()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursorResult= sqLiteDatabase.rawQuery("SELECT * FROM " + table_name, null);
        ArrayList<FetchResults> fetchResultsArrayList=new ArrayList<>();
        if(cursorResult.moveToFirst())
        {
            do{
                fetchResultsArrayList.add(0,new FetchResults(cursorResult.getInt(1),
                        cursorResult.getString(2),
                        cursorResult.getInt(3),
                        cursorResult.getInt(4),
                        cursorResult.getString(5),
                        cursorResult.getInt(6),
                        cursorResult.getString(7)));
            }while(cursorResult.moveToNext());
        }
        cursorResult.close();
        return fetchResultsArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);
    }



}
