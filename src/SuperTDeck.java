import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.*;
/**
 * Created by Adroso360 on 3/09/2016.
 */
public class SuperTDeck {
    private static final int NUM_INIT_CARDS = 60;
    private ArrayList<SuperTCard> cards;

    public static void ImportCards(){
        // Reading the JSON file of cards
        //TODO work out importing JSON READER
        JSONParser parser = new JSONParser();

        try {
        Object obj = parser.parse(new FileReader("c:\\file.json"));

        JSONObject jsonObject =  (JSONObject) obj;

        String name = (String) jsonObject.get("name");
        System.out.println(name);

        String city = (String) jsonObject.get("city");
        System.out.println(city);

        String job = (String) jsonObject.get("job");
        System.out.println(job);

        // loop array
        JSONArray cars = (JSONArray) jsonObject.get("cars");
        Iterator<String> iterator = cars.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e) {
         // import the XML card file
     }

    public SuperTDeck(){
        cards = new ArrayList<SuperTCard>();
        for (int i = 0; i < NUM_INIT_CARDS; i++) {
             cards.add(new stCard());
            // create random interger array with no repeating

        }
    }
    public ArrayList<SuperTCard> dealCards(int i) {
        return null;
    }
}
