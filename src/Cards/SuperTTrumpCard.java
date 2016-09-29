package Cards;

/**
 * Created by Adroso360 on 29/09/2016.
 */
public class SuperTTrumpCard extends BaseSuperTCard{
    protected String subtitle;
    protected String categories;

    public SuperTTrumpCard(String fileName, String imageName, String title, String subtitle, String categories) {
        super(fileName, imageName, title);
        this.subtitle = subtitle;
        this.categories = categories;
    }
    public String toString() {
        return(fileName + " " + imageName + " " + title + " " + subtitle+ " " + categories);
    }
}
