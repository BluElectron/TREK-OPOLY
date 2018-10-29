/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  RealEstateController.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/
package monopoly;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RealEstateController implements Initializable {

    // Declare variables and FXML nodes
    
    int currentCash;
    int rivalCash;
    boolean bought, jailed;
    Tile myTile;
    int railroads;
    
    
    @FXML
    private ImageView imgRealEstate;

    @FXML
    private TextArea txtMessage;

    @FXML
    private Button btnExit;

    @FXML
    private Button bntRent;

    @FXML
    private Button bntBuy;
    
    @FXML
    private Label lblPrice;

    
    // Method to set image in GUI
    @FXML
    void setImage(Image img) {
        imgRealEstate.setImage(img);
    }

    // Method to set text in GUI
    void setText(String message) {
        txtMessage.setText(message);
    }

    // Method to buy property, passing in the player name, player money, current Tile, the rival's Tile list, and rival's money
    void buyProperty(String name, int cash, Tile myT, List<Tile> rivalProperty, int rivalMoney) {
        
        // set values to parameters as needed
        currentCash = cash;
        rivalCash = rivalMoney;
        myTile = myT;
    
        // If on "court" tile, set jailed = true
        if(myTile.getName()=="court"){
            jailed = true;
            return;
        }
      
        // If tile is not owned and player has more cash than the tile price, they
        // have the option to buy the space
        else if (!myTile.getIsOwned()) {
            if (currentCash >= myTile.getPrice()) {
                bntBuy.setVisible(true);
                lblPrice.setText("-- PRICE: "+Integer.toString(myTile.getPrice())+" CREDITS --");
            }
        }
        // If tile is owned
        else {
            // And if current player does NOT own the space, they have to pay rent. 
            if (name != myTile.getName()) {
             
                lblPrice.setText("-- RENT: "+Integer.toString(myTile.getRent())+" CREDITS --");
                
                // If tile is a railroad...
                if (myTile.getId() == "rr") {
                    
                    // Check to see number of railroads (rent * # of railroads = rent)
                    for (int i = 0; i < rivalProperty.size(); i++) {
                        if (rivalProperty.get(i).getId()== "rr") {
                            railroads++;
                        }
                    }
                    // Set current player cash and rival cash to updated values
                    currentCash = currentCash - (myTile.getRent() * railroads);
                    rivalCash = rivalCash +(myTile.getRent() * railroads);

                } 
                // If tile is not a railroad...
                else {
                  // Set current player cash and rival cash to updated values
                    currentCash = currentCash - (myTile.getRent());
                    rivalCash = rivalCash +myTile.getRent();
                   
                }
            }
        }
    }

    // Action method that runs when bntBuy is clicked
    @FXML
    public void buy() {
        bought = true;
        System.out.println(myTile.getPrice());
        currentCash = currentCash - myTile.getPrice();
        lblPrice.setText("-- PURCHASE COMPLETE -- ");
        bntBuy.setVisible(false);
    }

    // Action method that runs when btnExit is clicked
    @FXML
    void exit() {
        Stage stg = (Stage) txtMessage.getScene().getWindow();
        stg.close();
    }

    // returns value of bought, checking if player bought the tile
    boolean isBought() {
        return bought;
    }
    
    // returns value of jailed, seeing if player landed on "court"
    boolean isJailed(){
        return jailed;
    }

    // returns current player cash
    int getNewCash() {
        return currentCash;
    }
    
    // returns other player cash
    int getRivalCash(){
    
        return rivalCash;
    }
    
    
    // initialize methods
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bntBuy.setVisible(false);
        bntRent.setVisible(false);
        bought = false;
        jailed = false;
        railroads = 0;
    }

}
