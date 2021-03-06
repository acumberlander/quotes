/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;


public class App {
    public ArrayList<Quote> quotes = new ArrayList<Quote>();
    Gson gson = new Gson();

    public String getRandomQuoteAndAuthor() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(
                new FileReader("./src/main/resources/recentquotes.json"));

        //This line from googling gets the correct type for an ArrayList<Quote>
        Type quoteListType = new TypeToken<ArrayList<Quote>>(){}.getType();

        //convert the json string back to object
        quotes = gson.fromJson(br, quoteListType);

        Random random = new Random();
        int randomIndex = random.nextInt((quotes.size() - 1));
        return quotes.get(randomIndex).toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new App().getRandomQuoteAndAuthor());
    }
}
