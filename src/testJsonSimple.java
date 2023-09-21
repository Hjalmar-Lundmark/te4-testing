import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class testJsonSimple {
    public static void main(String[] args) {
        JSONObject story;
        try {
            story = new org.json.simple.JSONObject((Map) new FileReader("src/story.json"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(story.get("id"));



    }
}
