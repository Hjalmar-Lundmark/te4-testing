import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class testGson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        JsonObject[] arrObj;
        try {
            arrObj = gson.fromJson(new FileReader("src/story.json"), JsonObject[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner question = new Scanner(System.in);
        int ans;
        int place = 0;

        // story starts
        while (true) {
            //JsonElement id = arrObj[place].get("id");
            String text = arrObj[place].get("text").getAsString();
            JsonArray options = arrObj[place].get("options").getAsJsonArray();

            System.out.println(text);

            if (options.isEmpty()) {
                break;
            }

            for (int i = 0; i < 2; i++) {
                JsonObject option = options.get(i).getAsJsonObject();
                String optionText = option.get("msg").getAsString();

                System.out.println(i+1 + ". " + optionText);
            }

            //scanner listen
            System.out.println("Write the corresponding number below then press enter.");
            ans = question.nextInt();

            JsonObject option = options.get(ans-1).getAsJsonObject();
            place = option.get("nextId").getAsInt();
        }
    }
}