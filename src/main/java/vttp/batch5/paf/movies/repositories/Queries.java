package vttp.batch5.paf.movies.repositories;

public class Queries {
    
    public static String SQL_INSERT_MANY = "insert into imdb (imdb_id, vote_average, vote_count, release_date, revenue, budget, runtime) values (?, ?, ?, ?, ?, ?, ?)";
}
