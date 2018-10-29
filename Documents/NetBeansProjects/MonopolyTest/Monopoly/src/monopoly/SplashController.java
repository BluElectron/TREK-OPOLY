/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  SplashController.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/
package monopoly;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SplashController implements Initializable {
    
    // Variable and FXML node definitions
    private ArrayList<Image> imgList = new ArrayList<>();
       
    private Image img1, img2;
    
    @FXML
    private Pane splashPane;

    @FXML
    private ImageView imgIcon1;

    @FXML
    private ImageView imgIcon2;

    @FXML
    private Label lblPlayer1;

    @FXML
    private Label lblTitle;

    @FXML
    private Button btnStart;
    
    @FXML
    private Button btnSet2;

    @FXML
    private Button btnSet1;

    
    // Method to set player 1's icon
    @FXML
    void setIcon1(ActionEvent event) {
        img1 = imgList.get(0);
        imgList.remove(0);
        btnSet1.setVisible(false);
        imgIcon1.setImage(imgList.get(0));   
        lblPlayer1.setText("Player 2");
    }

     // Method to set player 2's icon
    @FXML
    void setIcon2(ActionEvent event) {
        img2 = imgList.get(0);
        btnSet2.setVisible(false);
        btnStart.setVisible(true);
    }

    // Method that rotates the list of images each time the player clicks
    // on the images
    @FXML
    public void setNewImage() {

        Collections.rotate(imgList, 1);
        imgIcon1.setImage(imgList.get(0));
    }
    
    // --- Method to open a new FXMLDocument stage --- 
    @FXML
    void startGame(ActionEvent event) {
        
       splashPane.getScene().getWindow().hide();
       Parent root = null;
        FXMLLoader root1=null;
        root1 = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        try{
            root = (Parent)root1.load();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        FXMLDocumentController controller = root1.<FXMLDocumentController>getController();
        // Set the player images
        controller.newGame(img1, img2);
        
        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setScene(sc);
        
        st.show();
        
    }
    
    // --- This method initializes the list values, hides the start button, and sets the first image --- 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgList.add(new Image ("tactical.png"));
        imgList.add(new Image ("engineering.png"));
        imgList.add(new Image ("science.png")); 
        btnStart.setVisible(false);
        imgIcon1.setImage(imgList.get(0));
    }    
    
}
