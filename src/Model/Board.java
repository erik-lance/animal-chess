package Model;

import java.util.ArrayList;
import Model.Animals.*;
import Model.Terrain.*;

/*
	This class replaces the Board in real life BoardGames. it contains all the rules
	in playing the game such as the valid moves, win condition, and the format of the
	Board. Using a two dimensional array List to simulate a real world boardgame board.
	This class handles the communication between each move and verify them
*/
public class Board{
	  private static ArrayList<ArrayList<Tile>> tiles;
	  

	  /*  This is the constructor for Board Class which requires the parameter of 2 Player instances player 1 and player 2. This initializes the 2 dimensional array list of tiles. It first initializes an array list of array lists making 7 rows for the array list. It then calls the SetBoard to set up each individual tile and tile type according to the provided gameboard. And lastly, it call the reset board function to copy each player's pieces to their respective spots in the initial gameboard.

		  @param p1 Player 1 : Player class type
		  @param p2 Player 2 : Player class type
	  */
	  public Board(Player p1, Player p2){
	    tiles = new ArrayList<ArrayList<Tile>>();
	    for(int x = 0; x < 7; x++)
	      tiles.add(new ArrayList<Tile>());
	    setBoard();
	    resetBoard(p1, p2);
	  } 
	  /*
	    This function sets up the tiles of the board. It uses two for loops which dictate the row and column of the tile being set up. When these two are determined it then goes through conditions in which will determine the type of tile it will be initializing.
	  */
	  private void setBoard(){
	    for(int x = 0; x < 7; x++)
	      for(int y = 0; y < 9; y++){
	        if((x == 1 || x == 2 || x == 4 || x == 5) && (y == 3 || y == 4 || y == 5))
	          tiles.get(x).add(new River());
	        else if(x == 3 && (y == 0 || y == 8))
	          tiles.get(x).add(new Den());
	        else if(((x == 2 || x == 4) && (y == 0 || y == 8)) || x == 3 && (y == 1 || y == 7))
	          tiles.get(x).add(new Trap());
	        else
	          tiles.get(x).add(new Grass());
	      }
	  }
	  /*
	    This function replaces the real world action of setting up the pieces on the board. Before setting up the player's pieces it first clears the board of any pieces by setting them to null. After clearing the Board it then places or copies the pieces of the player to their designated starting tiles using functions setPiece(), setCords(), and setAlive().

	    @param p1 Player 1: Player Type Class
	    @param p2 Player 2: Player Type Class
	  */
	  public void resetBoard(Player p1, Player p2){
	    //This erases all pieces in the board
	    for(int x = 0; x < 7; x++)
	      for(int y = 0; y < 9; y++)
	        tiles.get(x).get(y).setPiece(null);
	    //Sets Red Left
	      //Red Mouse 6, 2
	      tiles.get(6).get(2).setPiece(p1.getPiece(1));
	      p1.getPiece(1).setCords(6, 2, "Grass");
	      p1.getPiece(1).setAlive();
	      //Red Cat 1, 1
	      tiles.get(1).get(1).setPiece(p1.getPiece(2));
	      p1.getPiece(2).setCords(1, 1, "Grass");
	      p1.getPiece(2).setAlive();
	      //Red Wolf 2, 2
	      tiles.get(2).get(2).setPiece(p1.getPiece(3));
	      p1.getPiece(3).setCords(2, 2, "Grass");
	      p1.getPiece(3).setAlive();
	      //Red Dog 5, 1
	      tiles.get(5).get(1).setPiece(p1.getPiece(4));
	      p1.getPiece(4).setCords(5, 1, "Grass");
	      p1.getPiece(4).setAlive();
	      //Red Leopard 4, 2
	      tiles.get(4).get(2).setPiece(p1.getPiece(5));
	      p1.getPiece(5).setCords(4, 2, "Grass");
	      p1.getPiece(5).setAlive();
	      //Red Tiger 0, 0
	      tiles.get(0).get(0).setPiece(p1.getPiece(6));
	      p1.getPiece(6).setCords(0, 0, "Grass");
	      p1.getPiece(6).setAlive();
	      //Red Lion 6, 0
	      tiles.get(6).get(0).setPiece(p1.getPiece(7));
	      p1.getPiece(7).setCords(6, 0, "Grass");
	      p1.getPiece(7).setAlive();
	      //Red Elephant 0, 2
	      tiles.get(0).get(2).setPiece(p1.getPiece(8));
	      p1.getPiece(8).setCords(0, 2, "Grass");
	      p1.getPiece(8).setAlive();

	      
	    //Blue Right
	      //Blue Mouse 0, 6
	      tiles.get(0).get(6).setPiece(p2.getPiece(1));
	      p2.getPiece(1).setCords(0, 6, "Grass");
	      p2.getPiece(1).setAlive();
	      //Blue Cat 5, 7
	      tiles.get(5).get(7).setPiece(p2.getPiece(2));
	      p2.getPiece(2).setCords(5, 7, "Grass");
	      p2.getPiece(2).setAlive();
	      //Blue Wolf 4, 6
	      tiles.get(4).get(6).setPiece(p2.getPiece(3));
	      p2.getPiece(3).setCords(4, 6, "Grass");
	      p2.getPiece(3).setAlive();
	      //Blue Dog 1, 7
	      tiles.get(1).get(7).setPiece(p2.getPiece(4));
	      p2.getPiece(4).setCords(1, 7, "Grass");
	      p2.getPiece(4).setAlive();
	      //Blue Leopard 2, 6
	      tiles.get(2).get(6).setPiece(p2.getPiece(5));
	      p2.getPiece(5).setCords(2, 6, "Grass");
	      p2.getPiece(5).setAlive();
	      //Blue Tiger 6, 8
	      tiles.get(6).get(8).setPiece(p2.getPiece(6));
	      p2.getPiece(6).setCords(6, 8, "Grass");
	      p2.getPiece(6).setAlive();
	      //Blue Lion 0, 8
	      tiles.get(0).get(8).setPiece(p2.getPiece(7));
	      p2.getPiece(7).setCords(0, 8, "Grass");
	      p2.getPiece(7).setAlive();
	      //Blue Elephant 6, 6
	      tiles.get(6).get(6).setPiece(p2.getPiece(8));
	      p2.getPiece(8).setCords(6, 6, "Grass");
	      p2.getPiece(8).setAlive();
	  }

	  /*
	    This function checks the available moves of a given piece. It returns a boolean array
	    called move which is of size 4. The size of 4 is for the 4 cardinal directions a piece
	    can move. The direction is based on which index it is stored such that 
	    0 = up, 1 = down, 2 = left, 3 = right. 
	    
	    It returns the value of the element true if the piece can move in that direction. 
	    This function also returns the possible destinations of the piece through the two dimensional
	    integer parameter destinations. First it assigns the values of true to all elements of moves[]
	    array. It then calls the checkBounds() function which returns all moves that are in bounds. It
	    then assigns the coordinate values of the given piece to each row of destinations. It then
	    individually checks validity of each move by considering the River clause and Capture Clause.
		If the piece checks all clauses then the function will edit the coordinates in the destinations
		parameter. After all moves are checked it returns the moves boolean array.
	  
	    @param p Piece: Piece Type Class
	    @param destinations : integer[][] type
	    @return availableMoves[4]; where [0] = up; [1] = down; [2] = left; [3] = right
	  */

	  public boolean[] checkAvailableMoves(Piece p, int[][] destinations){
	    boolean[] moves = new boolean[4];
	    /*
	      x = index of moves[]
	      x = 0 = up
	      x = 1 = down
	      x = 2 = left
	      x = 3 = right
	    */

	    //This assigns all default values of moves[] to true
	    moves[0] = moves[1] = moves[2] = moves[3] = true;

	    //This checks if any of the cardinal directions results in out of bounds and updates the values of moves[]
	    checkBounds(p.getCords(), moves);
	    
	    //This assigns the cords values of the piece to all indexes to destinations[]
	    for(int z = 0; z < 4; z++)
	      destinations[z][0] = p.getCords()[0];
	    
	    for (int z = 0; z < 4; z++)
	    	destinations[z][1] =p.getCords()[1];
	    
	    //Checks Cardinal Directions
	      //check up direction
	      if(moves[0] == true){
	        destinations[0][0] -= 1;
	        //River Clause
	        if(tiles.get(destinations[0][0]).get(destinations[0][1]) instanceof River){
	          moves[0] = false;
	          if(p instanceof Lion || p instanceof Tiger || p instanceof Mouse) {
	            if(p instanceof Lion || p instanceof Tiger) {
	              if(checkLeap(destinations[0], 'u')){
	                destinations[0][0] -= 2;
	                moves[0] = true;
	              }
	            }
	            else if (p instanceof Mouse)
	                moves[0] = true;
	          }
	            
	        }
	        //Checks if the destination piece will be capturable
	        if(moves[0] == true && tiles.get(destinations[0][0]).get(destinations[0][1]).checkOccupied()){
	          if(!checkCapture(p, tiles.get(destinations[0][0]).get(destinations[0][1])))
	            moves[0] = false;
	        }
	        //Check Den Clause
	        if(tiles.get(destinations[0][0]).get(destinations[0][1]) instanceof Den && ( (p.getColor() == "Red" && destinations[0][1] < 4) || (p.getColor() == "Blue" && destinations[0][1] > 4) ))
	          moves[0] = false;
	      }
	      //check down
	      if(moves[1] == true){
	        destinations[1][0] += 1;
	        //River Clause
	        if(tiles.get(destinations[1][0]).get(destinations[1][1]) instanceof River){
	          moves[1] = false;
	          if(p instanceof Lion || p instanceof Tiger || p instanceof Mouse) {
	            if(p instanceof Lion || p instanceof Tiger) {
	              if(checkLeap(destinations[1], 'd')){
	                destinations[1][0] += 2;
	                moves[1] = true;
	              }
	            }
	            else if (p instanceof Mouse)
	                moves[1] = true;
	          }
	        }
	        //Checks if the destination piece will be capturable
	        if(moves[1] == true && tiles.get(destinations[1][0]).get(destinations[1][1]).checkOccupied()){
	          if(!checkCapture(p, tiles.get(destinations[1][0]).get(destinations[1][1])))
	            moves[1] = false;
	        }
	        //Check Den Clause
	        if(tiles.get(destinations[1][0]).get(destinations[1][1]) instanceof Den && ( (p.getColor() == "Red" && destinations[1][1] < 4) || (p.getColor() == "Blue" && destinations[1][1] > 4) ))
	          moves[1] = false;
	      }
	      //check left
	      if(moves[2] == true){
	        destinations[2][1] -= 1;
	        //River Clause
	        if(tiles.get(destinations[2][0]).get(destinations[2][1]) instanceof River){
	          moves[2] = false;
	          if(p instanceof Lion || p instanceof Tiger || p instanceof Mouse) {
	            if(p instanceof Lion || p instanceof Tiger) {
	              if(checkLeap(destinations[2], 'l')){
	                destinations[2][1] -= 3;
	                moves[2] = true;
	              }
	            }
	            else if (p instanceof Mouse)
	                moves[2] = true;
	          }
	        }
	        //Checks if the destination piece will be capturable
	        if(moves[2] == true && tiles.get(destinations[2][0]).get(destinations[2][1]).checkOccupied()){
	          if(!checkCapture(p, tiles.get(destinations[2][0]).get(destinations[2][1])))
	            moves[2] = false;
	        }
	        //Check Den Clause
	        if(tiles.get(destinations[2][0]).get(destinations[2][1]) instanceof Den && ( (p.getColor() == "Red" && destinations[2][1] < 4) || (p.getColor() == "Blue" && destinations[2][1] > 4) ))
	          moves[2] = false;
	      }
	      //check right
	      if(moves[3] == true){
	        destinations[3][1] += 1;
	        //River Clause
	        if(tiles.get(destinations[3][0]).get(destinations[3][1]) instanceof River){
	          moves[3] = false;
	          if(p instanceof Lion || p instanceof Tiger || p instanceof Mouse) {
	            if(p instanceof Lion || p instanceof Tiger) {
	              if(checkLeap(destinations[3], 'r')){
	                destinations[3][1] += 3;
	                moves[3] = true;
	              }
	            }
	            else if (p instanceof Mouse)
	                moves[3] = true;
	          }
	        }
	        //Checks if the destination piece will be capturable
	        if(moves[3] == true && tiles.get(destinations[3][0]).get(destinations[3][1]).checkOccupied()){
	          if(!checkCapture(p, tiles.get(destinations[3][0]).get(destinations[3][1])))
	            moves[3] = false;
	        }
	        //Check Den Clause
	        if(tiles.get(destinations[3][0]).get(destinations[3][1]) instanceof Den && ( (p.getColor() == "Red" && destinations[3][1] < 4) || (p.getColor() == "Blue" && destinations[3][1] > 4) ))
	          moves[3] = false;
	      }
	      
	    return moves;
	  }
	  /*
	    This function checks if any direction the piece moves to will result
	    in an out of bounds. The function uses a for loop that will loop 2 times 
		for either a row or column change. x == 0 will signify a row change and 
		x == 1 a column change. Each type of change has 2 seperate if statements 
		which add and remove the value 1 respectively. They then check if the resulting 
		values will be in bounds of the board. If they are out of bounds they then 
		update their respective moves element value to false

	    @param cords[2] where [0] is the y coordinate and [1] is the x coordinate
	    @param moves[4] the cardinal directions where moves are possible
	  */
	  private void checkBounds(int[] cords, boolean[] moves){
	    int temp;
	    
	    for(int x = 0; x < 2; x++){
	      temp = cords[x];
	      if(x == 0){
	        //Checks up bounds
	        if(temp - 1 < 0)
	          moves[0] = false;
	        //Checks down bounds
	        if(temp + 1 > 6)
	           moves[1] = false;
	      }
	      else{
	        //Checks left bounds
	        if(temp - 1 < 0)
	          moves[2] = false;
	        //Checks right bounds
	        if(temp + 1 > 8)        
	          moves[3] = false;
	      }
	    }
	  }

	  /*
	    Checks River for Leap if there are mouses in the Way. The function uses a switch function 
		wherein the parameter move is used. The 4 cases are based on the 4 cardinal directions. 
		Each case uses a for loop that will loop depending on the row ro column change. If it is a 
		row change it will loop 2 times and if its a column change then it will loop 3 times. Each 
		loop will check the river tile if there is an instance of a mouse inside. If there is then 
		it will return false and if not then true

	    @param cords Coordinates: Integer[] Type
	    @param move  Move: Char Type
	    @return leap capability of piece, where true is that they can and false otherwise.
	  */
	  private boolean checkLeap(int[] cords, char move){
	    switch(move){
	      case 'u':
	        //Checks Leap up
	        for(int x = 0; x < 2; x++)
	          if(tiles.get(cords[0] - x).get(cords[1]).getPiece() instanceof Mouse)
	            return false;
	      break;
	      case 'd': 
	        //Checks Leap down
	        for(int x = 0; x < 2; x++)
	          if(tiles.get(cords[0] + x).get(cords[1]).getPiece() instanceof Mouse)
	            return false;
	      break;
	      case 'l':
	        //Checks Leap left
	        for(int x = 0; x < 3; x++)
	          if(tiles.get(cords[0]).get(cords[1] - x).getPiece() instanceof Mouse)
	            return false;
	      break;
	      case 'r':
	        //Checks Leap right
	        for(int x = 0; x < 3; x++)
	          if(tiles.get(cords[0]).get(cords[1] + x).getPiece() instanceof Mouse)
	            return false;
	      break;
	    }
	    return true;
	  }

	  /*
	    Checks if the piece of the moving player may capture the piece in the prey tile. 
		This function uses a boolean variable named result. This function checks for the 
		primary clauses of Color Clause, Trap Clause, Mouse Elephant Clause, Elephant 
		Mouse Clause and Rank Clause. If the predator piece and the piece in the prey 
		tile have the same color then it will return false. If the prey tile is an instance 
		of a Trap and if the trap is the oppenents' then it will automatically return true. 
		If the predator is an instance of a Mouse and the prey is an instance of an element 
		then it will change the value of the boolean variable result into true. If the predator 
		is an instance of a elephant and the piece in the prey tile is a mouse then it will return 
		false. if the rank of the predator is greater than the piece in the prey tile then it will 
		change the value of result into true. The function uses a boolean variable of result instead 
		of automatically returning a value all the time because of the mouse if in river clause as it 
		will need to check if the predator is a mouse in the river as this will prevent it from capturing any piece.

	    @param predator : Piece Type Class
	    @param prey : Tile Type Class
	    @return capture capabiliy where true is that they can capture the prey, and false otherwise.
	  */
	  private boolean checkCapture(Piece predator, Tile prey){
	    boolean result = false;
	      //Color Clause
	      if(predator.getColor() == prey.getPiece().getColor())
	        return false;
	      //Trap Clause
	      int[] trapC = prey.getPiece().getCords();
	      if(prey instanceof Trap && ( (prey.getPiece().getColor() == "Red" && trapC[1] > 4) || (prey.getPiece().getColor() == "Blue" && trapC[1] < 4) ))
	        return true;
	      //Mouse Elephant Clause
	      else if(predator instanceof Mouse && prey.getPiece() instanceof Elephant)
	        result = true;
	      //Elephant Mouse Clause
	      else if(predator instanceof Elephant && prey.getPiece() instanceof Mouse)
	        return false;
	      //Rank Clause
	      else if(predator.getRank() >= prey.getPiece().getRank())
	        result = true;

	      //Mouse if in River Clause
	      if(predator instanceof Mouse){
	        int[] cords = predator.getCords();
	        if(tiles.get(cords[0]).get(cords[1]) instanceof River && prey.getPiece() instanceof Mouse && prey instanceof River)
	            result = true;
	        else if(tiles.get(cords[0]).get(cords[1]) instanceof River)
	          result = false;
	      }

	      return result;
	  }

	  
	  /*
	    This returns the string type terrain of the tile in the given respective row and column. 
		It checks by using conditional statements that check the instance of the tile in the provided coordinates.

	    @param row : integer type
	    @param col column : integer type
	    @return tileType in String.
	  */
	  public String getTerrain(int row, int col){
	    if(tiles.get(row).get(col) instanceof River)
	      return "River";
	    else if(tiles.get(row).get(col) instanceof Grass)
	      return "Grass";
	    else if(tiles.get(row).get(col) instanceof Den)
	      return "Den";
	    else 
	      return "Trap";
	  }

	  /*
	    This function assigns the occupant of the tile in the given coordinates with the given piece by calling function setPiece()

	    @param mPiece Moved Piece: Piece Type Class
	    @param row: integer type
	    @param col column: integer type
	  */
	  public void setTile(Piece mPiece, int row, int col){
	    tiles.get(row).get(col).setPiece(mPiece);
	  }
	  /*
	    This function returns the tile in the given row and column in the tiles two dimensional array list

	    @param row: integer type
	    @param col column: integer type
	    @return tile instance
	  */
	  public Tile getTile(int row, int column){
	    return tiles.get(row).get(column);
	  }
	}