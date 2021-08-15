package quotes;

import java.util.List;

public class Quote{
    public List<String> tags;
    public String author;
    public String likes;
    public String text;
    public String toString() {
        String result;
        result = "quote: " + text + "\n" + "author: " + author;
        return result;
    };
}

