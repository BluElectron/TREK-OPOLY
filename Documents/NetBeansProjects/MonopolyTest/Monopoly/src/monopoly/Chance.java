/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  Chance.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/

package monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.image.Image;

public class Chance extends Tile {
    
    // Variable definitions
    private Image pic;
    int price1, price2, price3;
    boolean owned;
    Random rand = new Random();
    int rando;
    String id;
   
    private List<Integer> chanceCards;
    
    // Constructor, setting values for the card prices and that it is "owned" already, 
    // so it can't be purchased
    public Chance(int cost, Image img) {
        super(img);
        chanceCards = new ArrayList<>();
        pic = img;
        owned = true;
        price1 = -100;
        price2 = 50;
        price3 = 100;
        id = "chance";
        
        System.out.println("Chance class\n");
    }
   
    // Get and set methods
    public Image getPicture() {
        return pic;
    }
    
    public int getCard(){
        return rando;           
    }
   
    // Method to return text depending on the card for the GUI
    public String getText(String txt, int override){
        rando = rand.nextInt(3)+1;
        switch(rando){
            case 1:
                return "Spock warns you that you could run into some Romulans. You listen and your crew is fine. \n" +
                        " Earn 100 credits for a job well done.";
            case 2:
                return "Spock says you'll find good fortune at a nearby planet. "
                        + "You find a giant space creature that tries to tear your head off. Wow, thanks, Spock.\nLOSE 50 CREDITS";
            case 3:
                return "Spock keeps saying everything is \"illogical.\" In frustration, you shoot the bridge display. "
                        + "\nPay 100 credits for anger management courses";
        }
        return ""; 
    }

    // Method to return a price based on the random number (rando)
    public int getRent(){
        switch(rando){
            case 1:
                return price1;
            case 2:
                return price2;
            case 3:
                return price3;
        }
        return 0;
    }
    
    public boolean getIsOwned(){
        return owned;
    }
    
    public String getId() {
        return id;
    }
    
}
