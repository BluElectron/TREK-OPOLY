/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  Human.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/


package monopoly;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class Human extends Player{

    // Variable definitions 
    private String name;
    private Image gamepiece;
    private int moolah;
    private boolean jailed;
    private List<Tile> myProperty = new ArrayList<>();
    
    public Human(String nm, Image img, int money) {
        super(nm, img, money);
        name = nm;
        gamepiece = img;
        moolah = money;
        myProperty = new ArrayList<>();
    }
    
    // Method to add to the player's tile list
    public List<Tile> addTile(Tile myT){
        myProperty.add(myT);
        return myProperty;
    }
    
    // Get and set methods
    public List<Tile> getProperty(){
        return myProperty;
    }
    
    public Image getGamepiece() {
        return gamepiece;
    }

    public int getMoolah() {
        return moolah;
    }
   
    public void setMoolah(int cashmoney) {
        moolah = cashmoney;
    }

    public String getName() {
        return name;
    }

    public boolean getJailed() {
        return jailed;
    }

    public void setJailed(boolean jail) {
        jailed = jail;
    }
    
    
    
    
    
    

}
