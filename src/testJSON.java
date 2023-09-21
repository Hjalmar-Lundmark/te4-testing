import org.json.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class testJSON {
    public static void main(String[] args) {
        JSONObject story;
        try {
            story = new JSONObject(new FileReader("src/story.json"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(story);

    }
}
