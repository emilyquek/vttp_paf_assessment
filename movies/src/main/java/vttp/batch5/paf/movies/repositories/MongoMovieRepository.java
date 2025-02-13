package vttp.batch5.paf.movies.repositories;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import jakarta.json.JsonObject;

public class MongoMovieRepository {

    @Autowired
    private MongoTemplate template;

 // TODO: Task 2.3
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    db.imdb.insertMany([
//  {_id: 'imdb_id', 'title': 'title', 'directors': 'director', 'overview': 'overview', 'tagline': 'tagline' , 'genres': 'genres', 'imdb_rating': 'imdb_rating', 'imdb_votes': 'imdb_votes'}
// ]);
 //
 public void batchInsertMovies(List<JsonObject> imdbJsonList) {

    List<Document> docsToInsert = new LinkedList<>();
    for (JsonObject j : imdbJsonList) {
        docsToInsert.add(Document.parse(j.toString()));
    }

    Collection<Document> batchInsertDocs = template.insert(docsToInsert, "imdb");

 }

 // TODO: Task 2.4
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //
 public void logError() {

 }

 // TODO: Task 3
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //


}
