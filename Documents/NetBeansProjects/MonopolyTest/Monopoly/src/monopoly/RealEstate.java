/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  RealEstate.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/


package monopoly;

import javafx.scene.image.Image;

public class RealEstate extends Tile{
    
    
    // Variable Definitions
    int price;
    int rent;
    boolean owned;
    String who;
    //String name;
    Image picture;
    String id;

    // Constructor, passing in the price, rent, picture, and ID - defines if picture is a person or location/object
    public RealEstate(int money, int rnt, Image pic, String myId) {
        super(pic);
        owned = false;
        price = money;
        rent = rnt;
        picture = pic;
        id = myId;
        who = "Nobody";
        //classDefiner = "realestate";
        System.out.println("RealEstate class\n");
    }

    
  
    // --- Method to return text depending on the parameters ---
    // --- Checks player money, what the tile is showing, and who owns it ---
    public String getText(String name, int cash){
       if(!owned && id=="ship"&&cash>price){
           return "No one owns this property! \nWould you like to buy it?";
       }
       else if(!owned && id=="ship"&&cash<price){
           return "You don't have enough money to purchase this property.";
       }
       else if(!owned && id=="rr" && cash>price){
           return "Would you like to become a citizen\nof this world?\n";
       }
       else if(!owned && id=="rr" && cash<price){
           return "You don't have enough money for\nthe citizenship fee.";
       }
       else if(!owned && who==name && id=="rr"){
           return "You are already a citizen\nof this world.\n";
       }
       else if(owned && who!=name && id=="rr"){
           return "Your rival is a citizen of this world\nand forces you"
                   + "to pay\na travel fee.";
       }
       else if(owned&&who==name && id=="ship"){
           return "You already own this property.";
       }
       else if (owned && who!=name && id=="ship"){
           return "You need to pay up - your \nrival owns this property.";
       }
       else if(!owned && id=="officer" && cash > price){
           return "Would you like to be \ntrained by this person?";
       }
       else if(!owned && id=="officer" && cash<price){
           return "You don't have enough money to be trained by this person.";
       }
       else if(owned&&who==name && id=="officer"){
           return "You have already been trained \nby this person.";
       }
       else if (owned && who!=name && id=="officer"){
           return "Your rival is getting better! \nPay to get combat tips.";
       }
       
       return "";
    }
    
    // Other get/set methods
    
    public String getId(){
        return id;
    }
    
    public void setName(String nm){
        who = nm;
    }

    public void setIsOwned(boolean owned) {
        this.owned = owned;
    }
    
    public String getName(){
        return who;
    }
    
    public boolean getIsOwned(){
        return owned;
    }

    public int getPrice() {
        return price;
    }

  
    public int getRent() {
        return rent;
    }
    
    public Image getPicture() {
        return picture;
    }
    
    
    
    
    
    
    
    
    
    
    

}
