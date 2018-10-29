/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  Player.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/

package monopoly;

import java.util.List;
import javafx.scene.image.Image;

public abstract class Player {
    
    // Variable Definitions
    
    List myProperty;
    private String name;
    private Image gamePiece;
    private int moolah;
    private boolean jailed;

    // Constructor, passing in name, image, and starting money
    public Player(String name, Image gamePiece, int moolah) {
        this.name = name;
        this.gamePiece = gamePiece;
        this.moolah = moolah;
        jailed = false;     
    }
    
    // Get and set methods
    
    public boolean getJailed(){
        return jailed;
    }

    public void setJailed(boolean jail) {
        jailed = jail;
    }

    public int getMoolah() {
        return moolah;
    }
    
    
    public void setMoolah(int cashmoney){
        moolah = moolah - cashmoney;
    }

    public String getName() {
        return name;
    }
    
    public List getProperty(){
        return myProperty;
    }
    
    // Method to add a tile to the player's tile list
    public List addTile(Tile newT){
        myProperty.add(newT);
        return myProperty;
    }
    
    
    
    
    
    
    
}
