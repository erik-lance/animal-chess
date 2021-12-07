package Model;

import View.PieceDisplay;

/**
 * Contains all data needed for accessing or manipulation between classes. It contains
 * an exhaustive collection of getters and setters to communicate stored information
 * to the view through the controller.
 * */
public class Model {
    private PieceDisplay currentP;
    
    //Players house the pieces, must reference through player.
    private Player player1;
    private Player player2;
    
    private boolean turn;
    private Board board;
    
    private boolean isPlaying;
    
    private int chosenPiece;
    
    private PieceDisplay mascot1;
    private PieceDisplay mascot2;
    
    /**
     * Initializes the players onto the internal game's board. Only grabs color to 
     * automatically instantiate both players where the second color is automatically
     * what wasn't chosen.
     * @param c color of player 1
     * */
    public void addPlayers(String c) {
    	player1 = new Player(c);
    	String d = (c.equals("Red")) ? "Blue" : "Red";
    	player2 = new Player(d);
    	
    	if (d.equals("Blue"))
    		board = new Board(player1,player2);
    	else
    		board = new Board(player2,player1);
    }
    
    /**
     * Prepares 8 random pieces for the starting board to determine player 1.
     * @return nArray[] of 8 pieces determined by rank only.
     * */
    public int[] randomStart() {
    	int[] random = new int[8];
    	int[] nArray = new int[8];
    	
    	for (int x = 0; x < random.length; x++) 
    		random[x] = x+1; 
    	
    	int nRand;
    	for (int x = 0; x < random.length; x++) {
    		//Checks for copies for each num in random
    		nArray[x] = 0;
    		while(nArray[x] == 0) {
    			nRand = (int)(Math.random()*8);
        		
    			if(random[nRand] !=0) {
        		nArray[x] = random[nRand];
        		random[nRand] = 0;
    			}
    		}
    	}
    	return nArray;
    }
    
    /**
     * Sets the mascot of player 1.
     * @param p a PieceDisplay object as mascot
     * */
    public void setMascot1(PieceDisplay p) {
    	mascot1 = p;
    }
    
    /**
     * Sets the mascot of player 2.
     * @param p a PieceDisplay object as mascot
     * */
    public void setMascot2(PieceDisplay p) {
    	mascot2 = p;
    }
     
    /**
     * Sets the choice of the 1st starter piece to determine 1st player
     * */
    public void setChoice() {
    	chosenPiece = getCurP().getRank();
    }
    
    /**
     * Sets the game's playing mode reference
     * @param b boolean to alter isPlaying variable
     * */
    public void setPlaying(boolean b) {
    	isPlaying = b;
    }
    
    /**
     * Sets current piece selected in the game's board
     * @param p selected piece
     * */
    public void setCurP(PieceDisplay p) {
    	currentP = p;
    }
    
    /**
     * Sets the turn at play of the game
     * @param t true for player1, false for player2
     * */
    public void setTurn(boolean t) {
    	turn = t;
    }
    
    /**
     * Gets the reference of player1's mascot
     * @return mascot of player 1
     * */
    public PieceDisplay getMascot1() {
    	return mascot1;
    }
    
    /**
     * Gets the reference of player2's mascot
     * @return mascot of player 2
     * */
    public PieceDisplay getMascot2() {
    	return mascot2;
    }
    
    /**
     * Gets the chosen piece of the first person at the start in determining 1st player
     * @return reference piece rank of the chosen mascot
     * */
    public int getChoice() {
    	return chosenPiece;
    }
    
    /**
     * Gets the status of play of the game
     * @return isPlaying if game is ongoing or not
     * */
    public boolean getPlaying() {
    	return isPlaying;
    }
    
    /**
     * Gets player1's reference
     * @return player1 for manipulation or accessing
     * */
    public Player getPlayer1() {
    	return player1;
    }
    
    /**
     * Gets player2's reference
     * @return player2 for manipulation or accessing
     * */
    public Player getPlayer2() {
    	return player2;
    }
    
    /**
     * Gets the internal game's board, where the main data of all pieces are kept.
     * @return board for manipulation or accessing
     * */
    public Board getBoard() {
    	return board;
    }
    
    /**
     * Gets the current piece selected in the game.
     * @return currentP in play
     * */
    public PieceDisplay getCurP() {
    	return currentP;
    }

    /**
     * Gets the current state of turn at the game to determine which player is to move.
     * @return turn true if player1 and false if player2.
     * */
    public boolean getTurn() {
    	return turn;
    }
   
}
