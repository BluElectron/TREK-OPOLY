/*===============================================
|* Course # :  COP 3303C
|* Project  :  Monopoly
|* File     :  Game.java
|* © 2017 Alison Hart
|* Florida Polytechnic University
|*===============================================
*/

package monopoly;

import java.util.Random;


/**
 *
 * @author Ali
 */
public class Game {
    
    // Variable definitions
    private Random rand;
    private int rollNum;
    private int turn;
 
    // Constructor
    public Game() {
        rollNum = 0;
        turn = 1;
        rand = new Random();
    }
    
    // Roll method for the dice
    public int roll(){
        rollNum = rand.nextInt(6) + 1;
        return rollNum;
    }

    // Return method for the dice roll 
    public int getRollNum() {
        return rollNum;
    }   
    
}
