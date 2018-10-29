/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  UtilityTile.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/
package monopoly;

import javafx.scene.image.Image;

public class UtilityTile extends Tile{

    // Variable definitions
    int price;
    int rent;
    boolean owned;
    String who;
    Image picture;
    String id;
    
    // Constructor, passing in the price, rent, image, and if the tile is already owned or not
    public UtilityTile(int money, int rnt, Image pic, boolean own) {
        super(pic);
        picture = pic;
        id = "utility";
        price = money;
        rent = rnt;
        owned = own;
        who = "Nobody";
        System.out.println("Utility class\n");
    }
    
    // Method to get text for the GUI
    public String getText(String txt, int money){
        if(owned){
            return "You have to pay! This costs "+rent+" credits.";
        }
        else if(!owned && money<price){
            return "You don't have enough money to purchase this utility!";
        }
        else{
            return "For this utility, you'll have to pay " + price + " credits.";
        }
    }

    // Get and set methods
    public Image getPicture() {
        return picture;
    }

    public int getRent() {
        return rent;
    }

    public boolean getIsOwned() {
        return owned;
    }

    public String getName() {
        return who;
    }
    
    public void setName(String nm){
        who = nm;        
    }

    public int getPrice() {
        return price;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
