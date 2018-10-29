/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  CornerTile.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/
package monopoly;

import javafx.scene.image.Image;

public class CornerTile extends Tile{

    
    // Variable Definitions
    int price;
    //int rent;
    String name;
    Image picture;
    
    boolean owned;
    
    // Constructor, passing in money, image, and name of the tile (like "go")
    public CornerTile(int money, Image pic, String nm) {
        super(pic);
        price = money;
        //rent = rnt;
        picture = pic;
        name = nm;
        owned = true;
    }


    // Get and set methods
    public Image getPicture(){
        return picture;        
    }

    public String getName() {
        return name;
    }
    
    public boolean getIsOwned() {
        return owned;
    }
    
    // --- Method to get text depending on the tile name
    public String getText(String txt, int override){
        if(name=="go"){
            return "Collect 200 Credits!";
        }
        else if (name == "court"){
            return "Courtmartialed! You've been confined to quarters\n"
                    + "until your trial is completed.";            
        }
        else if(name=="jail"){
            return "You're not confined to quarters,\nyou can continue.";
        }
        else{
            return "You've arrived at a starbase!\nThere's no needed repairs.";
        }
    }

    
    
    
    
    
    

    

    
    
}
