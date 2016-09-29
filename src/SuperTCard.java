import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Adroso360 on 3/09/2016.
 */
public class SuperTCard {
    protected String fileName = "lol";
    protected String imageName;
    protected String title;
    protected String chemistry;
    protected String classification;
    protected String crysSystem;
    protected ArrayList occurrence;
    protected String hardness;
    protected String specGravity;
    protected String cleavage;
    protected String crustAbundance;
    protected String ecoVal;

    public SuperTCard(String fileName) {
        this.fileName = fileName;

    }

    public String getFilename(String name){
        return "lol";
}
    public String toString() {
            return fileName ;
        }
}