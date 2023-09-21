import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.simple.parser.ParseException;

public class testGson {
    public static void main(String[] args) {
        String storyFile = "src/story.json";
        Gson gson = new Gson();
        JsonObject[] arrObj;
        try {
            arrObj = gson.fromJson(new FileReader(storyFile), JsonObject[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner q = new Scanner(System.in);
        int qAns;
        int place = 0;

        // story starts
        while (true) {
            JsonElement id = arrObj[place].get("id");
            JsonElement text = arrObj[place].get("text");
            JsonArray options = arrObj[place].get("options").getAsJsonArray();

            System.out.println(text);

            if (options.isEmpty()) {
                break;
            }
            for (int i = 0; i < 2; i++) {
                JsonObject option = options.get(i).getAsJsonObject();
                JsonElement optionText = option.get("msg");

                System.out.println(i+1 + ". " + optionText);
            }

            //scanner listen
            System.out.println("Write the corresponding number below then press enter.");
            qAns = q.nextInt();
            System.out.println(qAns);

            JsonObject option = options.get(qAns-1).getAsJsonObject();
            JsonElement optionNextId = option.get("nextId");
            place = optionNextId.getAsInt();
        }

        System.out.println("story completed");

    }
}
