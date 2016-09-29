package Cards;

import org.w3c.dom.ranges.Range;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Adroso360 on 3/09/2016.
 */
public class BaseSuperTCard {
    protected String fileName;
    protected String imageName;
    protected String title;


    public BaseSuperTCard(String fileName, String imageName, String title) {
        this.fileName = fileName;
        this.imageName = imageName;
        this.title = title;

    }

    public String toString() {
            return(fileName + " " + imageName + " " + title);
        }
}