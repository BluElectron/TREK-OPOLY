/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  Mission.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/

package monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.image.Image;

public class Mission extends Tile{
    
    // Variable Definitions
    int price1, price2, price3;
    Image picture;
    Random rand = new Random();
    int rando;
    String id;
    boolean owned;
   
    private List<Integer> missionCards;
    
    // Constructor, setting values for the card prices and that it is "owned" already, 
    // so it can't be purchased
    public Mission(int cost, Image img) {
        super(img);
        missionCards = new ArrayList<>();
        picture = img;
        price1 = -75;
        price2 = 200;
        price3 = -50;
        owned = true;
        id = "mission";
        System.out.println("Mission class\n");
    }
    
    // Get and set methods
  
    public void setPrice(int price) {
        this.price = price;
    }
    
    // Method to get text depending on the value of rando
    public String getText(String txt, int override){
       rando = rand.nextInt(3)+1;
        switch(rando){
            case 1:
                return "You and your crew explore an unknown system \nand find a planet with sentient life.\nAWARDED 75 CREDITS";
            case 2:
                return "Starfleet orders you to protect an outpost from bandits.\nYou destroy the outpost. LOST 200 CREDITS";
            case 3:
                return "You delegate a meeting between \nthe Ferengi and the Bajorans. AWARDED 50 CREDITS";
        }
        return "";
    }
    
    // Method to get rent price depending on value of rando
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
    
    public Image getPicture() {
        return picture;
    }
    
    public int getCard(){
        rando = rand.nextInt(4);
        return missionCards.get(rando);                
    }
    
    public boolean getIsOwned(){
        return owned;
    }

    public String getId() {
        return id;
    }
    
    
}
