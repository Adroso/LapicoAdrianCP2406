package Cards;

/**
 * Created by Adroso360 on 29/09/2016.
 */
public class TrumpCard extends Card {
    public String subtitle;
    public String categories;

    public TrumpCard(String fileName, String imageName, String title, String subtitle, String categories) {
        super(fileName, imageName, title);
        this.subtitle = subtitle;
        this.categories = categories;
    }
    public String toString() {
        //return("\n" + title + " " + subtitle+ " " + categories);
        return ("\n |||||||||* TRUMP CARD *|||||||| \n" +"Title: "+ title +"\nChange trumps category to: " + categories+"\n<<<<<<< **************** >>>>>>>\n");
    }

    @Override
    public boolean isBetterThan(PlayCard card, String category) {
        return true;
    }
}
