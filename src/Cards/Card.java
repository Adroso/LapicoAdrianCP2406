package Cards;
/**
 * Created by Adroso360 on 3/09/2016.
 */
public abstract class Card {
    public String fileName;
    public String imageName;
    public String title;



    public Card(String fileName, String imageName, String title) {
        this.fileName = fileName;
        this.imageName = imageName;
        this.title = title;

    }

    public String toString() {
            return(fileName + " " + imageName + " " + title);
        }

    public abstract boolean isBetterThan(PlayCard card, String category);
}