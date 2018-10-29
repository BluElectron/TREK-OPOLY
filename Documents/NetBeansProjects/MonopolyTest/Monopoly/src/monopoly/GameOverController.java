/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  GameOverController.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/
package monopoly;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GameOverController implements Initializable {

    Image img1, img2;
    
    @FXML
    private Label lblWinner;

    @FXML
    private Button bntRestart;

    @FXML
    private Button btnExit;
    
    private Media myTunes = new Media(new File("starTrekEndingTheme.mp3").toURI().toString());
    private MediaPlayer mediaPlayer1 = new MediaPlayer(myTunes);

    @FXML
    void exit() {
        Stage stg = (Stage) btnExit.getScene().getWindow();
        stg.close();
    }

    @FXML
    void restart() {
       btnExit.getScene().getWindow().hide();
       Parent root = null;
        FXMLLoader root1=null;
        root1 = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        try{
            root = (Parent)root1.load();
        }catch(IOException ex){
           // System.out.println("hi bud");
            ex.printStackTrace();
        }
        FXMLDocumentController controller = root1.<FXMLDocumentController>getController();
        controller.newGame(img1, img2);
        
        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setScene(sc);
        
        st.show();

    }
    
    void setNewImage(Image myimg1, Image myimg2){
        img1=myimg1;
        img2=myimg2;   
    }
    
    void setText(String txt){
        lblWinner.setText(txt);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediaPlayer1.play();
    }    
    
}
