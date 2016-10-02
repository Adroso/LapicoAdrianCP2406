package Cards;

/**
 * Created by Adroso360 on 29/09/2016.
 */
public class PlayCard extends Card {
    public String chemistry;
    public String classification;
    public String crysSystem;
    public String occurrence;
    public double lowhardness;
    public double highhardness;
    public double lowspecGravity;
    public double highspecGravity;
    public String cleavage;
    public String crustAbundance;
    public String ecoVal;

    public PlayCard(String fileName, String imageName, String title, String chemistry, String classification, String crysSystem, String occurrence, double lowhardness, double highhardness, double lowspecGravity, double highspecGravity, String cleavage, String crustAbundance, String ecoVal) {
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
    public String toString() {
        return ("\n <<<<<<< MINERAL CARD >>>>>> \n" + "Chemistry: " +chemistry + "\nClassification: " +classification + "\nCrystal System: "+crysSystem + "\n Occurrence: "+occurrence +"\n ---------------------------" + "\n Hardness: " +highhardness+"\n Specific Gravity: "+highspecGravity+"\n Cleavage: "+cleavage+"\n Crustal Abundance: "+crustAbundance+"\nEconomic Value: "+ecoVal+"\n <<<<<<< *********** >>>>>>>\n");
    }

// Section on Converting String values to Ints to be used for comparison of cards during gameplay
    public int findCleavage(){
        switch (cleavage){
            case "none":
                return 0;
            case "poor/none":
                return 1;
            case "1 poor":
                return 2;
            case "2 poor":
                return 3;
            case "1 good":
                return 4;
            case "1 good, 1 poor":
                return 5;
            case "2 good":
                return 6;
            case "3 good":
                return 7;
            case "1 perfect":
                return 8;
            case "1 perfect, 1 good":
                return 9;
            case "1 perfect, 2 good":
                return 10;
            case "2 perfect, 1 good":
                return 11;
            case "3 perfect":
                return 12;
            case "4 perfect":
                return 13;
            case "6 perfect":
                return 14;
            default:
                throw new NullPointerException("Cleavage get Value is not found");

        }

    }
    public boolean isBetterThan(PlayCard card, String category){
    switch (category){
        case "Hardness":
            return this.highhardness > card.highhardness;
        case "Specific gravity":
            return  this.highspecGravity > card.highspecGravity;
        case "Cleavage":
            return this.findCleavage() > card.findCleavage();
        case "Crustal abundance":
            return this.findCrustalAb() > card.findCrustalAb();
        case "Economic value":
            return  this.findEcoValue() > card.findEcoValue();
        default:
            throw new  NullPointerException("Category Not Found With:  " + category);
    }
    }
    public int findCrustalAb(){
        switch (crustAbundance){
            case "ultratrace":
                return 0;
            case "trace":
                return 1;
            case "low":
                return 2;
            case "moderate":
                return 3;
            case "high":
                return 4;
            case "very high":
                return 5;
            default:
                throw new NullPointerException("CrustalAbundance getValue is not found");
        }
    }
    public int findEcoValue(){
        switch (ecoVal){
            case "trivial":
                return 0;
            case "low":
                return 1;
            case "moderate":
                return 2;
            case "high":
                return 3;
            case "very high":
                return 4;
            case "I'm rich!":
                return 5;
            default:
                throw new NullPointerException("EconomicValue getValue is not found");
        }
    }
}
