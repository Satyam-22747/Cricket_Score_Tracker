package com.satdroid.applicatinnavdr;

//this class is being created to store the results fetched from the sqlite database
public class FetchResults {

    private int run_team1;
    private int run_team2;
    private String over_team1;
    private String over_team2;
    private int wicket_team1;
    private int wicket_team2;
    private String match_dates;
    private int id;

    public int getRun_team1() {
        return run_team1;
    }

    public void setRun_team1(int run_team1) {
        this.run_team1 = run_team1;
    }

    public int getRun_team2() {
        return run_team2;
    }

    public void setRun_team2(int run_team2) {
        this.run_team2 = run_team2;
    }

    public String getOver_team1() {
        return over_team1;
    }

    public void setOver_team1(String over_team1) {
        this.over_team1 = over_team1;
    }

    public String getOver_team2() {
        return over_team2;
    }

    public void setOver_team2(String over_team2) {
        this.over_team2 = over_team2;
    }

    public int getWicket_team1() {
        return wicket_team1;
    }

    public void setWicket_team1(int wicket_team1) {
        this.wicket_team1 = wicket_team1;
    }

    public int getWicket_team2() {
        return wicket_team2;
    }

    public void setWicket_team2(int wicket_team2) {
        this.wicket_team2 = wicket_team2;
    }

    public String getMatch_dates() {
        return match_dates;
    }

    public void setMatch_dates(String match_dates) {
        this.match_dates = match_dates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //create a constructor
    public FetchResults(int run_team1, String over_team1,int wicket_team1,int run_team2, String over_team2, int wicket_team2, String match_dates) {
        this.run_team1 = run_team1;
        this.run_team2 = run_team2;
        this.over_team1 = over_team1;
        this.over_team2 = over_team2;
        this.wicket_team1 = wicket_team1;
        this.wicket_team2 = wicket_team2;
        this.match_dates = match_dates;
    }
}
