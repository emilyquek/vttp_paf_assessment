package vttp.batch5.paf.movies.models;

import java.math.BigInteger;
import java.sql.Date;

public class sqlIMDB {
    
    private String imdb_id;
    private float voteAverage;
    private Integer voteCount;
    private Date releaseDate;
    private BigInteger revenue;
    private BigInteger budget;
    private Integer runtime;

    public String getImdb_id() {return imdb_id;}
    public void setImdb_id(String imdb_id) {this.imdb_id = imdb_id;}

    public float getVoteAverage() {return voteAverage;}
    public void setVoteAverage(float voteAverage) {this.voteAverage = voteAverage;}

    public Integer getVoteCount() {return voteCount;}
    public void setVoteCount(Integer voteCount) {this.voteCount = voteCount;}

    public Date getReleaseDate() {return releaseDate;}
    public void setReleaseDate(Date releaseDate) {this.releaseDate = releaseDate;}

    public BigInteger getRevenue() {return revenue;}
    public void setRevenue(BigInteger revenue) {this.revenue = revenue;}

    public BigInteger getBudget() {return budget;}
    public void setBudget(BigInteger budget) {this.budget = budget;}

    public Integer getRuntime() {return runtime;}
    public void setRuntime(Integer runtime) {this.runtime = runtime;}
    
    public sqlIMDB() {
    }

    public sqlIMDB(String imdb_id, float voteAverage, Integer voteCount, Date releaseDate, BigInteger revenue,
            BigInteger budget, Integer runtime) {
        this.imdb_id = imdb_id;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.budget = budget;
        this.runtime = runtime;
    }
}
