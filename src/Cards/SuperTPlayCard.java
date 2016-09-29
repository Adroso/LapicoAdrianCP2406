package Cards;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Adroso360 on 29/09/2016.
 */
public class SuperTPlayCard extends BaseSuperTCard {
    protected String chemistry;
    protected String classification;
    protected String crysSystem;
    protected String occurrence;
    protected double lowhardness;
    protected double highhardness;
    protected double lowspecGravity;
    protected double highspecGravity;
    protected String cleavage;
    protected String crustAbundance;
    protected String ecoVal;

    public SuperTPlayCard (String fileName, String imageName, String title, String chemistry, String classification, String crysSystem, String occurrence, double lowhardness, double highhardness, double lowspecGravity, double highspecGravity, String cleavage, String crustAbundance, String ecoVal) {
        super(fileName, imageName, title);
        this.chemistry = chemistry;
        this.classification = classification;
        this.crysSystem = crysSystem;
        this.occurrence = occurrence;
        this.lowhardness = lowhardness;
        this.highhardness = highhardness;
        this.lowspecGravity = lowspecGravity;
        this.highspecGravity = highspecGravity;
        this.cleavage = cleavage;
        this.crustAbundance = crustAbundance;
        this.ecoVal = ecoVal;


    }

}
