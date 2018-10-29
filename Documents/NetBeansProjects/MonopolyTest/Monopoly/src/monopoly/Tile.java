/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  Tile.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/

package monopoly;

import javafx.scene.image.Image;

public abstract class Tile {
    
    // Variable definitions
    String message;
    
    int price;
    int rent;
    private Image tileView;
    String id;
    String name;
    boolean isOwned;

    // Constructor
    public Tile(Image img) {
        tileView = img;
        isOwned = false;
        name = "";
    }

    // Default get and set methods for the child classes to use
    public Image getPicture() {
        return tileView;
    }
    
    public String getText(String txt, int price){
        return message;
    }

    public void setPrice(int p) {
        price = p;
    }

    public int getPrice() {
        return price;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getRent() {
        return rent;
    }
    
    public int getCard(){
        return 0;
    }

    public String getId() {
        return id;
    }

    public void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }

    public boolean getIsOwned() {
        return isOwned;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   


}
