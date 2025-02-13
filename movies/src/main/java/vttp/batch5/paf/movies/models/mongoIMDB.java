package vttp.batch5.paf.movies.models;

public class mongoIMDB {
    
    private String imdb_id;
    private String title;
    private String director;
    private String overview;
    private String tagline;
    private String genres;
    private Integer imdbRating;
    private Integer imdbVotes;

    public String getImdb_id() {return imdb_id;}
    public void setImdb_id(String imdb_id) {this.imdb_id = imdb_id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDirector() {return director;}
    public void setDirector(String director) {this.director = director;}

    public String getOverview() {return overview;}
    public void setOverview(String overview) {this.overview = overview;}

    public String getTagline() {return tagline;}
    public void setTagline(String tagline) {this.tagline = tagline;}

    public String getGenres() {return genres;}
    public void setGenres(String genres) {this.genres = genres;}

    public Integer getImdbRating() {return imdbRating;}
    public void setImdbRating(Integer imdbRating) {this.imdbRating = imdbRating;}

    public Integer getImdbVotes() {return imdbVotes;}
    public void setImdbVotes(Integer imdbVotes) {this.imdbVotes = imdbVotes;}

    public mongoIMDB() {

    }

}
