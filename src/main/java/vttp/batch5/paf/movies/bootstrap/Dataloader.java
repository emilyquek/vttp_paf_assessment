package vttp.batch5.paf.movies.bootstrap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.beans.factory.annotation.Value;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParsingException;


public class Dataloader {

  //TODO: Task 2

  @Value("${zip.path}")
  private String zipFilePath;

  public static List<JsonObject> unzipFile(String zipFilePath) throws IOException {

    List<String> imdbList = new LinkedList<>();
    List<JsonObject> imdbJson = new LinkedList<>();

    InputStream is = new FileInputStream(zipFilePath);
    ZipInputStream zis = new ZipInputStream(is);

    ZipEntry entry = zis.getNextEntry();

    String s = String.format("Entry: %s", entry.getName());
    System.out.println(s);

      while (entry != null) {
        InputStreamReader isr = new InputStreamReader(zis);
        BufferedReader br = new BufferedReader(isr);

        String line = "a";
        int count = 0;

        while (line != null) {
          JsonParser parser = Json.createParser(br);
          while (parser.hasNext()) {
            parser.next(); 
            try {             
              JsonObject jsObj = parser.getObject();
              imdbJson.add(jsObj);
              count++;
    
              System.out.printf(">>>>> count: %d\n\n", count);
              System.out.printf(">>>>> from parser: %s\n\n", jsObj.toString());

            } catch (JsonParsingException ex) {
              parser.skipObject();
              continue;
            }
            if (count == 50) 
              break;
            
            break;
          }
        }
        br.close();
        break;
      }
    zis.close();
    return imdbJson;
  }
}
