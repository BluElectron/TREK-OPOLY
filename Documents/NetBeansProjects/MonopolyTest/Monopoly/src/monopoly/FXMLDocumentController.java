/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  FXMLDocumentController.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/

package monopoly;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FXMLDocumentController implements Initializable {

    // Defining player variables, roll variables, text, position x and y variables,
    // Board object, array position variables, and boolean definers. 
    private Human player1, player2;
    private Game myGame;
    String text;
    private int roll, roll1, roll2;
    double x, y;
    private Board myBoard;
    int whereIAm1, whereIAm2, whereIsJail;
    private boolean turn, jailed;
    
    private Media myTunes = new Media(new File("starTrekTheme.mp3").toURI().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(myTunes);
    
    Stage gameStage;
    
    // FXML definitions for the GUI
    
    @FXML
    private AnchorPane gamePane;

    @FXML
    private TextArea txtRoll;
    
    @FXML
    private Button btnRoll;

    @FXML
    private ImageView imgBoard;

    @FXML
    private ImageView imgPlayer1;

    @FXML
    private ImageView imgPlayer2;

    @FXML
    private ImageView diceRoll;

    @FXML
    private ImageView dice1;

    @FXML
    private ImageView dice2;

    @FXML
    private Label lblTurn;
    
    @FXML
    private Label lblPlayer1;

    @FXML
    private Label lblMoney1;

    @FXML
    private Label lblPlayer2;

    @FXML
    private Label lblMoney2;
    
    @FXML
    private ImageView imgTrekPaper;

    

    
    // --- Method to create new Game object, which gives the roll() method ---
    // --- Also instatiates player objects and sets labels on the GUI      ---
    public void newGame(Image img1, Image img2) {
        myGame = new Game();
        player1 = new Human("Player 1", img1, 1000);
        player2 = new Human("Player 2", img2, 1000);
        imgPlayer1.setImage(player1.getGamepiece());
        imgPlayer2.setImage(player2.getGamepiece());
        lblMoney1.setText(Integer.toString(player1.getMoolah())+" CREDITS");
        lblMoney2.setText(Integer.toString(player2.getMoolah())+" CREDITS");
    }

    // --- Method to return image that corresponds to the dice roll ---
    public Image checkRoll(int rollNum) {
        switch (rollNum) {
            case 1:
                return new Image("dice1.png");
            case 2:
                return new Image("dice2.png");
            case 3:
                return new Image("dice3.png");
            case 4:
                return new Image("dice4.png");
            case 5:
                return new Image("dice5.png");
            case 6:
                return new Image("dice6.png");
        }
        return null;
    }

    
    // --- This method does everything associated with a new turn
    // --- Rolls the dice, dice ANIMATION, determines who's turn it is,
    // --- calls openTile method for opening new stage, and determines if
    // --- the game has ended
    @FXML
    public void newRoll() {

        diceRoll.setVisible(true);

        roll1 = myGame.roll();
        roll2 = myGame.roll();

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae -> diceRoll.setVisible(false)));
        timeline.play();

        dice1.setImage(checkRoll(roll1));
        dice2.setImage(checkRoll(roll2));

        text = Integer.toString(roll = roll1 + roll2);
        txtRoll.setText(text);
        
        // If turn == true, player 1 goes
        if (turn) {
            
            if (!player1.getJailed()&&player1.getMoolah()>0) {
                // determine current location of player
                whereIAm1 = makeAMove(imgPlayer1, whereIAm1, roll, player1);
                lblMoney1.setText(Integer.toString(player1.getMoolah())+" CREDITS");
                openTile(whereIAm1, player1, player2);
                System.out.println(whereIAm1);
                if(jailed){
                    whereIAm1 = makeAMove(imgPlayer1, whereIAm1, whereIsJail, player1);
                }
                
                lblMoney1.setText(Integer.toString(player1.getMoolah())+" CREDITS");
            }
            
            turn = false;
        } 
        // if turn == false, player 2 goes
        else {
           
            if (!player2.getJailed()&&player2.getMoolah()>0) {
                // determine current location of player
                whereIAm2 = makeAMove(imgPlayer2, whereIAm2, roll, player2);
                lblMoney2.setText(Integer.toString(player2.getMoolah())+" CREDITS");
                openTile(whereIAm2, player2, player1);
                System.out.println(whereIAm2);
                if(jailed){
                    whereIAm2 = makeAMove(imgPlayer2, whereIAm2, whereIsJail, player2);
                }
                lblMoney2.setText(Integer.toString(player2.getMoolah())+" CREDITS");              
            }
            turn = true;
            
        }
        if(player1.getMoolah()<=0 || player2.getMoolah()<=0){
            gameOver();
        }
         // determines what the on-screen label should say for who's turn it is
        takeTurns();
    }
    
    
    
    // -- Method to display a label of who's turn it is ---
    public void takeTurns() {

        if (turn && !player1.getJailed()) {
            lblTurn.setText("Go Player 2!");
        } else if (!turn && !player2.getJailed()) {
            lblTurn.setText("Go Player 1!");
        } else if (turn && player1.getJailed()) {
            lblTurn.setText("PLAYER 1 IS IN JAIL. Go Player 2!");
        } else if (!turn && player2.getJailed()) {
            lblTurn.setText("PLAYER 2 IS IN JAIL. Go Player 1!");
        }
    }

    
    // --- Method that moves the player icon to the correct board location,
    // --- looping for the number of roll total. It also adds 200 for passing GO (0)
    
    public int makeAMove(ImageView imgV, int counter, int move, Player play) {
        
        for (int i = 0; i < move; i++) {
            
            if (counter <= 9) {
                counter++;
                imgV.relocate(imgV.getLayoutX() - 48, imgV.getLayoutY());
            } else if (counter > 9 && counter <= 19) {
                counter++;
                imgV.relocate(imgV.getLayoutX(), imgV.getLayoutY() - 50);
            } else if (counter > 19 && counter <= 29) {
                counter++;
                imgV.relocate(imgV.getLayoutX() + 48, imgV.getLayoutY());
            } else if (counter > 29 && counter <= 39) {
                counter++;
                imgV.relocate(imgV.getLayoutX(), imgV.getLayoutY() + 50);
            } 
            // if at the last index, make counter=0 and add 200 for GO
            else if (counter>39 &&!jailed)
                {
                counter=0;
                play.setMoolah(play.getMoolah()+200);
            }
            // if reached the last index, set counter to 0
            else{
                counter = 0;
            }
            
        }
        // if landing on GO, add 200 and set counter to 0
        if (counter==40&&!jailed){
            counter=0;
            play.setMoolah(play.getMoolah()+200);
        }   
        return counter;
    }
    
    
    // Method to open new stage for the Tile
    
    void openTile(int count, Player play, Player rival) {
        Parent root = null;
        FXMLLoader root1 = null;
        root1 = new FXMLLoader(getClass().getResource("RealEstate.fxml"));
        try {
            root = (Parent) root1.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // create controller from RealEstateController.java, set image, text, and run buy method
        RealEstateController controller;
        controller = root1.<RealEstateController>getController();
        controller.setImage(myBoard.getTile(count).getPicture());
        controller.setText(myBoard.getTile(count).getText(play.getName(), play.getMoolah()));
        controller.buyProperty(play.getName(), play.getMoolah(), myBoard.getTile(count), rival.getProperty(), rival.getMoolah());
        
       // check to see if player landed on the "court" space
        jailed = controller.isJailed();

        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setScene(sc);
        
        // waits until action is taken
        st.showAndWait();
       
        // set current player (play) money and rival player (rival) money
        play.setMoolah(controller.getNewCash());
        rival.setMoolah(controller.getRivalCash());
      
        // if the player bought the space, set the tile to owned==true and name==player name
        // Also add the tile to the player's tile List
        if(controller.isBought()){
            myBoard.getTile(count).setIsOwned(true);
            myBoard.getTile(count).setName(play.getName());
            play.addTile(myBoard.getTile(count));
        }
    }

    // --- Opens a gameOver stage and closes the FMXL stage 
    // --- This method is called when one of the players' money reaches 0
    void gameOver(){
    
        Parent root = null;
        FXMLLoader root1 = null;
        root1 = new FXMLLoader(getClass().getResource("GameOver.fxml"));
        try {
            root = (Parent) root1.load();
        } catch (IOException ex) {
            // System.out.println("hi bud");
            ex.printStackTrace();
        }
        GameOverController controller;
        controller = root1.<GameOverController>getController();
        controller.setNewImage(player1.getGamepiece(), player2.getGamepiece());
        
        // Set text to the game's winner, determined by the remaining money
        if(player1.getMoolah()>player2.getMoolah()){
            controller.setText("Player 1 Wins!");
        }
        else if(player1.getMoolah()<player2.getMoolah()){
            controller.setText("Player 2 Wins!");
        }
        
        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setScene(sc);
        
        
        st.show();
        
        // Get current stage and close it
        Stage boardStage = (Stage) imgBoard.getScene().getWindow();
        boardStage.close();
        mediaPlayer.stop();
    }
    
    // Initialize method to set initial values, create the board, and set text/visible nodes
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myBoard = new Board();
        whereIAm1 = 0;
        whereIAm2 = 0;
        whereIsJail = 21;
        diceRoll.setVisible(false);
        turn = true;
        lblTurn.setText("Go Player 1!");
        mediaPlayer.play();
    }
}
