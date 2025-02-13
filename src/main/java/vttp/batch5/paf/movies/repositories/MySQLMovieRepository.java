package vttp.batch5.paf.movies.repositories;

import java.math.BigInteger;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.json.JsonObject;
import vttp.batch5.paf.movies.models.sqlIMDB;

public class MySQLMovieRepository {

  @Autowired
  private JdbcTemplate template;

  // TODO: Task 2.3
  // You can add any number of parameters and return any type from the method
  public int[] batchInsertMovies(List<JsonObject> imdbJsonList) {

    List<sqlIMDB> sqlList = new LinkedList<>();

    for (JsonObject j : imdbJsonList) {
      sqlIMDB s = new sqlIMDB();
      s.setImdb_id(j.getString("imdb_id"));
      s.setVoteAverage(j.getInt("vote_average"));
      s.setVoteCount(j.getInt("vote_count"));
      s.setReleaseDate(Date.valueOf(j.getString("release_date")));
      s.setRevenue(BigInteger.valueOf(j.getInt("revenue")));
      s.setBudget(BigInteger.valueOf(j.getInt("budget")));
      s.setRuntime(j.getInt("runtime"));

      sqlList.add(s);
    }

    List<Object[]> params = sqlList.stream()
          .map(imdb -> new Object[] {imdb.getImdb_id(), imdb.getVoteAverage(), imdb.getVoteCount(), imdb.getReleaseDate(), imdb.getRevenue(), imdb.getBudget(), imdb.getRuntime()})
          .collect(Collectors.toList());
    int[] added= template.batchUpdate(Queries.SQL_INSERT_MANY, params);
    
    return added;
  }
  
  // TODO: Task 3


}
