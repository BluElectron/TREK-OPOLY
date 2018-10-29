/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  Board.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/

package monopoly;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class Board {
    
    
    // All the Tile object definitions
    
    private List<Tile> boardTiles;   
    // Corner tiles
    private CornerTile go, jail, base, court;
    // RealEstate tiles
    private RealEstate brown1, brown2, ltBlue1, ltBlue2, ltBlue3, 
            pink1, pink2, pink3, orange1, orange2, orange3, 
            red1, red2, red3, yellow1, yellow2, yellow3, 
            green1, green2, green3, dkBlue1, dkBlue2,
            romulan, klingon, ferengi, vulcan;
    
    // Chance tiles
    private Chance spock1, spock2, spock3, spock4;
    // Mission (community chest) tiles
    private Mission mission1, mission2, mission3;
    
    // Utility tiles
    private UtilityTile utility1, utility2, utility3, utility4;
   

    
    // create list of board tiles
    public Board() {
        System.out.println("Board class\n");
        boardTiles = new ArrayList<>();
        go = new CornerTile(200,new Image("go.jpg"),"go");
        boardTiles.add(go);  
        
        brown1 = new RealEstate(60, 2, new Image ("wesley.jpg"), "officer");
        boardTiles.add(brown1);
        
        mission1 = new Mission(100, new Image("mission.jpg"));    // Explore galaxy, earn 100 credits for finding a new system
        boardTiles.add(mission1);
        
        brown2 = new RealEstate(60, 4, new Image ("kelvin.jpg"), "ship");
        boardTiles.add(brown2);
        
        utility1 = new UtilityTile(0, 75, new Image("utilityUpgrade.jpg"), true);
        boardTiles.add(utility1);
        
        romulan = new RealEstate(200, 25, new Image ("Romulans.jpg"), "rr");
        boardTiles.add(romulan);
        
        ltBlue1 = new RealEstate(100, 6, new Image ("janeway.jpg"), "officer");
        boardTiles.add(ltBlue1);
        
        spock1 = new Chance(100, new Image("spockAdvice.jpg"));   // Spock warns you that you could run into some Romulans. You don't listen and your ship sustains damage. 
                                                                // Pay 100 credits to fix the damages. 
        boardTiles.add(spock1);
        
        ltBlue2 = new RealEstate(100, 6, new Image ("hugh.jpg"), "officer");
        boardTiles.add(ltBlue2);
        
        ltBlue3 = new RealEstate(120, 8, new Image ("narada.jpg"), "ship");
        boardTiles.add(ltBlue3);        
        
        jail = new CornerTile(0,new Image("jail.jpg"),"jail");
        boardTiles.add(jail);
 
        pink1 = new RealEstate(140, 10, new Image ("nx01.jpg"), "ship");
        boardTiles.add(pink1);
        
        utility2 = new UtilityTile(150,35, new Image("utilityWarp.jpg"), false);
        boardTiles.add(utility2);
        
        pink2 = new RealEstate(140, 10, new Image ("chekov.jpg"), "officer");
        boardTiles.add(pink2);
        
        pink3 = new RealEstate(160, 12, new Image ("StarfleetCommand_SanFrancisco.jpg"), "ship");
        boardTiles.add(pink3);
        
        klingon = new RealEstate(200, 25, new Image ("klingon.jpg"), "rr");
        boardTiles.add(klingon);
        
        orange1 = new RealEstate(180, 14, new Image ("Montgomery_Scott.jpg"), "officer");
        boardTiles.add(orange1);
        
        mission2 = new Mission(0, new Image("mission.jpg")); // You're ordered to dock at a starbase for emergency repairs and have to pay
        boardTiles.add(mission2);                            // entrance fees for each of your crew members. PAY 200 CREDITS
        
        orange2 = new RealEstate(180, 14, new Image ("enterprised.jpg"), "ship");
        boardTiles.add(orange2);
        
        orange3 = new RealEstate(200, 14, new Image ("deepSpace9.jpg"), "ship");
        boardTiles.add(orange3);
        
        base = new CornerTile(0,new Image("starbase.jpg"),"starbase");
        boardTiles.add(base);
        
        red1 = new RealEstate(220, 18, 
                new Image ("Khan_Noonien_Singh_(alternate_reality).jpg"), "officer");
        boardTiles.add(red1);
        
        spock2 = new Chance(0, new Image("spockAdvice.jpg"));   // Spock says you'll find good fortune at a nearby planet. You find a giant space creature that tries to tear your head off. Thanks Spock!
                                                                // LOSE 50 CREDITS
        boardTiles.add(spock2);                                 
        
        red2 = new RealEstate(220, 18, new Image ("bones.jpg"), "officer");
        boardTiles.add(red2);
        
        red3 = new RealEstate(240, 20, new Image ("vulcanCommand.jpg"), "ship");
        boardTiles.add(red3);
        
        ferengi = new RealEstate(200, 25, new Image ("ferengi.jpg"), "rr");
        boardTiles.add(ferengi);
        
        yellow1 = new RealEstate(260, 22, new Image ("borgShip.jpg"), "ship");
        boardTiles.add(yellow1);
        
        yellow2 = new RealEstate(260, 22, new Image ("data.jpg"), "officer");
        boardTiles.add(yellow2);
        
        utility3 = new UtilityTile(150,35, new Image("utilityBreach.jpg"), false);
        boardTiles.add(utility3); 
        
        yellow3 = new RealEstate(280, 24, new Image ("kronos.jpg"), "ship");
        boardTiles.add(yellow3);
        
        court = new CornerTile(0,new Image("court.jpg"),"court");
        boardTiles.add(court);
        
        green1 = new RealEstate(300, 26, new Image ("vengence.jpg"), "ship");
        boardTiles.add(green1);
        
        green2 = new RealEstate(300, 26, new Image ("tngBridge.jpg"), "ship");
        boardTiles.add(green2);
        
        mission3 = new Mission(100, new Image("mission.jpg"));        // Starfleet assigns you to delegate a meeting between the Ferengi and Bajorans.
        boardTiles.add(mission3);                                   // The meeting goes smoothly under your direction.
                                                                    // You recieve 100 credits in gratitude from the Bajorans. 
        
        green3 = new RealEstate(320, 28, new Image ("kirk.jpg"), "officer");
        boardTiles.add(green3);
        
        vulcan = new RealEstate(200, 25, new Image ("vulcan.jpg"), "rr");
        boardTiles.add(vulcan);
        
        spock3 = new Chance(0, new Image("spockAdvice.jpg"));       // Spock keeps saying everything is "illogical." In frustration, you 
        boardTiles.add(spock3);
      
        dkBlue1 = new RealEstate(350, 35, new Image ("newSpock.jpg"), "officer");
        boardTiles.add(dkBlue1);
        
        utility4 = new UtilityTile(0, 75, new Image("utilityRecruits.jpg"), true);
        boardTiles.add(utility4);
        
        dkBlue2 = new RealEstate(400, 40, new Image ("Picard.jpg"), "officer");
        boardTiles.add(dkBlue2);        
    }
    
    public Tile getTile(int tileNum){
        return boardTiles.get(tileNum);
    }
}
