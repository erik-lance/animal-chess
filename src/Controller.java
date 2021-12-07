import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Model;
import Model.Player;
import View.PieceDisplay;
import View.View;

/**
 * The main brain of the game. It acts as the mode of communication between the model
 * and view. This is where all listeners will be instantiated to allow communication
 * to run smoothly and all actions be monitored in order to update values in the model
 * to update view.
 * */
public class Controller {
	private View view;
	private Model model;
	
	/*This variable is used to determine if 1st piece has been chosen and is attempting to
	  reach a destination.
	*/
	
	/**
	 * Constructs the initial framework of the game and stitches all the classes together.
	 * @param v the View class for frontend work of the game.
	 * @param m the Model class for backend work of the game.
	 * */
	public Controller (View v, Model m) {
		this.view = v;
		this.model = m;		
		
		m.setTurn(true);
		
		int []randPiece;
		randPiece = m.randomStart();
		
			v.initializeIntro(randPiece);
			m.setPlaying(false);
			
			for (int i = 0; i < 8; i++) {
				v.getBottom().getComponent(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				v.getBottom().getComponent(i).addMouseListener(new MouseListener() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						
						// TODO Auto-generated method stub
						if (m.getCurP()==null) {
							PieceDisplay p = ((PieceDisplay) e.getSource());
							m.setCurP(p);
							m.setChoice();
							p.setRank(p.getRank()-10, "Red");
							//m.setPlaying(true);
						}
						else if ((PieceDisplay)e.getSource() != m.getCurP() && !m.getPlaying()) {
							PieceDisplay p = ((PieceDisplay) e.getSource());
							
							m.setCurP(p);
							p.setRank(p.getRank()-10, "Blue");
							
							m.setPlaying(true);
							initializeTeams();
							
							if (p.getRank() < m.getChoice()) {
								//v.emptyBottom();
								
								p.setOpaque(true);
								p.setBackground(Color.red);
								
								m.setMascot1(new PieceDisplay(m.getChoice(), "Red"));
								m.setMascot2(p);
							}
							else {
								//v.emptyBottom();
								m.setMascot2(new PieceDisplay(m.getChoice(), "Red"));
								m.setMascot1(p);
								
								p.setOpaque(true);
								p.setBackground(Color.green);
							}
							
							//v.getBottomPanel().add(m.getMascot1());
							//v.getBottomPanel().add(m.getMascot2());
						}
					}

					@Override
					public void mousePressed(MouseEvent e) {}

					@Override
					public void mouseReleased(MouseEvent e) {}

					@Override
					public void mouseEntered(MouseEvent e) {}

					@Override
					public void mouseExited(MouseEvent e) {}
				
				});
			}
		
        
	}
	
	/**
	 * This set of instructions initializes the choosing of colors.
	 * Allows the player to click a coloured panel to choose the team of their favour.
	 * It will connect to initialize other assets important to the game such as the listeners
	 * for each piece and tiles.
	 * */
	public void initializeTeams() {
		for (int i = 0; i < 8; i++) {
			Component pM = ((Component) getView().getBottom().getComponent(i));
			pM.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			pM.removeMouseListener(pM.getMouseListeners()[0]);
		}
		
		((Component) getView().getLeft().getComponent(0)).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		((JPanel) getView().getLeft().getComponent(0)).addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (getModel().getPlaying()) {
					
					getModel().setPlaying(true);
					initializeListeners();
					initializeTiles();
					
					getModel().setCurP(null);
					getModel().addPlayers("Red");
					getModel().setTurn(true);
					
					PieceDisplay m1 = new PieceDisplay(getModel().getMascot1().getRank()-10, "Red");
					PieceDisplay m2 = new PieceDisplay(getModel().getMascot2().getRank()-10, "Blue");
					
					m1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					m2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					
					getView().getLeft().add(m1);
					getView().getRight().add(m2);
					
					getView().getLeft().add(Box.createGlue());
					getView().getRight().add(Box.createGlue());
					
					Component pM2 = ((Component) getView().getRight().getComponent(0));
					pM2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					pM2.removeMouseListener(pM2.getMouseListeners()[0]);
					
					
					Component pM = ((Component) e.getSource());
					pM.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					pM.removeMouseListener(pM.getMouseListeners()[0]);
				}
				getView().getFrame().revalidate();
				getView().getFrame().repaint();
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		((Component) getView().getRight().getComponent(0)).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		((JPanel) getView().getRight().getComponent(0)).addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (getModel().getPlaying()) {
					
					getModel().setPlaying(true);
					initializeListeners();
					initializeTiles();
					
					getModel().setCurP(null);
					getModel().addPlayers("Blue");
					getModel().setTurn(true);
					
					PieceDisplay m1 = new PieceDisplay(getModel().getMascot1().getRank()-10, "Blue");
					PieceDisplay m2 = new PieceDisplay(getModel().getMascot2().getRank()-10, "Red");
					
					m1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					m2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					
					getView().getLeft().add(m2);
					getView().getRight().add(m1);
					
					getView().getLeft().add(Box.createGlue());
					getView().getRight().add(Box.createGlue());
					
					Component pM2 = ((Component) getView().getLeft().getComponent(0));
					pM2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					pM2.removeMouseListener(pM2.getMouseListeners()[0]);
					
					
					Component pM = ((Component) e.getSource());
					pM.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					pM.removeMouseListener(pM.getMouseListeners()[0]);
				}
				getView().getFrame().revalidate();
				getView().getFrame().repaint();
				
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
	}
	
	/**
	 * Prepares the listeners for each piece in play. Allows player click interaction between the GUI and game.
	 * */
	public void initializeListeners() {
		for (int i = 0; i < 7; i++) {
        	for (int j = 0; j < 9; j++) {
        		if ( view.getPiece(i, j) != null) {
        			view.getPiece(i, j).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        			view.getPiece(i, j).addMouseListener(new MouseListener() {
        				
        			Model m;
        			View v;
        			Player p1;
        			Player p2;
          	  	    
					@Override
          	  	      public void mouseClicked(MouseEvent e) 
          	  	      { 
          	  	    	  int[][] destinations;
          	  	    	  destinations = new int[4][2];
          	  	    	  boolean[] availableMoves;
          	  	    	  
          	  	    	m = getModel();
          	  	    	v = getView();
	          	  	    p1 = m.getPlayer1();
	        			p2 = m.getPlayer2();
          	  	    	  //If P1's turn and piece selected is their own
          	  	    	  if (m.getTurn() && p1.getColor().equals(((PieceDisplay) e.getSource()).getColor())) 
          	  	    	  {
          	  	    		//If no current selection
          	  	    		if (m.getCurP() == null) {
              	  	    		m.setCurP((PieceDisplay) e.getSource());
              	  	    		v.setBottomText("Piece selected!");
              	  	    		
              	  	    		availableMoves = m.getBoard().checkAvailableMoves(p1.getPiece(m.getCurP().getRank()), destinations);
              	  	    		if (availableMoves[0]) 
              	  	    			v.getPanelTile(destinations[0][0], destinations[0][1]).setBackground(Color.green);
              	  	    		if (availableMoves[1])
              	  	    			v.getPanelTile(destinations[1][0], destinations[1][1]).setBackground(Color.green);
              	  	    		if (availableMoves[2])
              	  	    			v.getPanelTile(destinations[2][0], destinations[2][1]).setBackground(Color.green); 
              	  	    		if (availableMoves[3])
              	  	    			v.getPanelTile(destinations[3][0], destinations[3][1]).setBackground(Color.green);
              	  	    		if ((!availableMoves[0] && !availableMoves[1] && !availableMoves[2] && !availableMoves[3]))
              	  	    			v.setBottomText("Piece selected, but no available moves.");
              	  	    	}
              	  	    	else if (e.getSource() == m.getCurP()) {
              	  	    		v.recolorTiles();
    	    	  	    		v.setBottomText("Deselected, choose another piece!");
              	  	    		m.setCurP(null);
              	  	    	}
          	  	    		
          	  	    	  }
          	  	    	  //IF Selected piece is not the same color as player 1's
          	  	    	  else if (((JPanel)((PieceDisplay) e.getSource()).getParent()).getBackground() == Color.green && m.getCurP() != null && m.getTurn() && ((e.getSource() != m.getCurP()) && (((PieceDisplay) e.getSource()).getColor()).equals(p2.getColor()))) {
          	  	    		//TIME TO CAPTURE!!!!
          	  	    		getView().recolorTiles();
	  	  	    			  //Moves piece to said tile
	  	  	    			  getView().setBottomText("Choose a piece");
	  	  	    			  
	  	  	    			  //Gets coordinates of tile
	  	  	    			  Object o = e.getComponent().getParent();
	  	  	    			  int[] newCords = getCoordinates(o);
	  	  	    			  
	  	  	    			  p1.movePiece(m.getBoard(), p1.getPiece(m.getCurP().getRank()), newCords, p2);
	  	  	    			  m.setPlaying(!p1.CheckWin(p2));
	  	  	    			  
	  	  	    			  int destX = v.getTileCoordX((JPanel)((PieceDisplay) e.getSource()).getParent());
	  	  	    			  int destY = v.getTileCoordY((JPanel)((PieceDisplay) e.getSource()).getParent());

	  	  	    			  ((PieceDisplay) e.getSource()).getParent().remove(0);
	  	  	    			  getView().setPieceLocation(m.getCurP(), v.getPanelTile(destY, destX));
	  	  	    			  
	  	  	    			  endTurn();
	  	  	    			  m.setCurP(null);
	  	  	    			  endGame(m.getPlaying());
          	  	    	  }
          	  	    	  
          	  	    	  
          	  	    	  else if (!m.getTurn() && p2.getColor().equals(((PieceDisplay) e.getSource()).getColor())) 
          	  	    	  {
          	  	    		if (m.getCurP() == null) {
              	  	    		m.setCurP((PieceDisplay) e.getSource());
              	  	    		v.setBottomText("Piece selected!");
              	  	    		
              	  	    		availableMoves = m.getBoard().checkAvailableMoves(p2.getPiece(m.getCurP().getRank()), destinations);
              	  	    		
              	  	    		if (availableMoves[0]) 
              	  	    			v.getPanelTile(destinations[0][0], destinations[0][1]).setBackground(Color.green);
              	  	    		if (availableMoves[1])
              	  	    			v.getPanelTile(destinations[1][0], destinations[1][1]).setBackground(Color.green);
              	  	    		if (availableMoves[2])
              	  	    			v.getPanelTile(destinations[2][0], destinations[2][1]).setBackground(Color.green); 
              	  	    		if (availableMoves[3])
              	  	    			v.getPanelTile(destinations[3][0], destinations[3][1]).setBackground(Color.green);
              	  	    		if ((!availableMoves[0] && !availableMoves[1] && !availableMoves[2] && !availableMoves[3]))
              	  	    			v.setBottomText("Piece selected, but no available moves.");
              	  	    		
              	  	    	}
              	  	    	else if (e.getSource() == m.getCurP()) {
              	  	    		v.recolorTiles();
    	    	  	    		v.setBottomText("Deselected, choose another piece!");
              	  	    		m.setCurP(null);
              	  	    	}
          	  	    	  }
          	  	    	  //If piece is not the same as player 2
          	  	    	  else if (((JPanel)((PieceDisplay) e.getSource()).getParent()).getBackground() == Color.green && m.getCurP() != null && !m.getTurn() && ((e.getSource() != m.getCurP()) && (((PieceDisplay) e.getSource()).getColor()).equals(p1.getColor()))) {
          	  	    		//TIME TO CAPTURE!!!!
          	  	    		  getView().recolorTiles();
  	  	  	    			  //Moves piece to said tile
  	  	  	    			  getView().setBottomText("Choose a piece");
  	  	  	    			  
  	  	  	    			  //Gets coordinates of tile
  	  	  	    			  Object o = e.getComponent().getParent();
  	  	  	    			  int[] newCords = getCoordinates(o);
  	  	  	    			  
  	  	  	    			  p2.movePiece(m.getBoard(), p2.getPiece(m.getCurP().getRank()), newCords, p1);
  	  	  	    			  m.setPlaying(!p2.CheckWin(p1));
  	  	  	    			  
  	  	  	    			  int destX = v.getTileCoordX((JPanel)((PieceDisplay) e.getSource()).getParent());
  	  	  	    			  int destY = v.getTileCoordY((JPanel)((PieceDisplay) e.getSource()).getParent());

  	  	  	    			  ((PieceDisplay) e.getSource()).getParent().remove(0);
  	  	  	    			  getView().setPieceLocation(m.getCurP(), v.getPanelTile(destY, destX));
  	  	  	    			  
  	  	  	    			  endTurn();
  	  	  	    			  m.setCurP(null);
  	  	  	    			  
  	  	  	    			  endGame(m.getPlaying());
	          	  	     }
          	  	    	  
          	  	    	  
          	  	      }
          	  	      
          	  	      @Override
          	  	      public void mousePressed(MouseEvent e) { }
          	  	      @Override
          	  	      public void mouseReleased(MouseEvent e) { }
          	  	      @Override
          	  	      public void mouseEntered(MouseEvent e) { }
          	  	      @Override
          	  	      public void mouseExited(MouseEvent e) { }

          	  		});
        		}
        		
        		
        		
        	}
        }
	}
	
	/**
	 * Prepares the listeners for each tile in play. Allows player click interaction when moving between tiles
	 * and prepares available moves to tackle for each piece.
	 * */
	public void initializeTiles() {
		for (int i=0; i < 7; i++) {
	    	  for (int j=0; j < 9; j++) {
	    		  getView().getPanelTile(i,j).addMouseListener(new MouseListener() {
	    			  
	    			  Model m;
    				  Player p1;
    				  Player p2;
	    			  @Override
	    	  	      public void mouseClicked(MouseEvent e) { 
	    				  m = getModel();
	    				  p1 = m.getPlayer1();
	    				  p2 = m.getPlayer2();
	    				  
	    				  if (m.getTurn() && ((JPanel) e.getComponent()).getBackground().equals(Color.green)) {
	    					  if (m.getCurP() != null) {
		    	  	    		  if (e.getSource() == m.getCurP().getParent())  {
		    	  	    			getView().setBottomText("Deselected, choose another piece!");
		    	  	    			m.setCurP(null);
		    	  	    		  }
		    	  	    			  
		    	  	    		  else if (((JPanel) e.getSource()).getComponentCount() != 0) {
		    	  	    			getView().setBottomText("Deselected, choose another piece!");
		    	  	    			m.setCurP(null);
		    	  	    		  }
		    	  	    		  else {
		    	  	    			  getView().recolorTiles();
		    	  	    			  //Moves piece to said tile
		    	  	    			  getView().setBottomText("Choose a piece");
		    	  	    			  getView().setPieceLocation(m.getCurP(), (JPanel) e.getSource());
		    	  	    			  
		    	  	    			  //Gets coordinates of tile
		    	  	    			  Object o = e.getSource();
		    	  	    			  int[] newCords = getCoordinates(o);
		    	  	    			  
		    	  	    			  p1.movePiece(m.getBoard(), p1.getPiece(m.getCurP().getRank()), newCords, p2);
		    	  	    			  m.setPlaying(!p1.CheckWin(p2));
		    	  	    			  
		    	  	    			  endTurn();
		    	  	    			  m.setCurP(null);
		    	  	    			  
		    	  	    			  endGame(m.getPlaying());
		    	  	    		  }
		    	  	    	  }
	    				  }
	    				  else if (!m.getTurn() && ((JPanel) e.getComponent()).getBackground().equals(Color.green)) {
	    					  if (m.getCurP() != null) {
		    	  	    		  if (e.getSource() == m.getCurP().getParent())  {
		    	  	    			getView().setBottomText("Deselected, choose another piece!");
		    	  	    			m.setCurP(null);
		    	  	    		  }
		    	  	    			  
		    	  	    		  else if (((JPanel) e.getSource()).getComponentCount() != 0) {
		    	  	    			getView().setBottomText("Deselected, choose another piece!");
		    	  	    			m.setCurP(null);
		    	  	    		  }
		    	  	    		  else {
		    	  	    			  getView().recolorTiles();
		    	  	    			  //Moves piece to said tile
		    	  	    			  getView().setBottomText("Choose a piece");
		    	  	    			  getView().setPieceLocation(m.getCurP(), (JPanel) e.getSource());
		    	  	    			  
		    	  	    			  //Gets coordinates of tile
		    	  	    			  Object o = e.getSource();
		    	  	    			  int[] newCords = getCoordinates(o);
		    	  	    			  
		    	  	    			  p2.movePiece(m.getBoard(), p2.getPiece(m.getCurP().getRank()), newCords, p2);
		    	  	    			  m.setPlaying(!p2.CheckWin(p1));
		    	  	    			  
		    	  	    			  endTurn();
		    	  	    			  m.setCurP(null);
		    	  	    			  
		    	  	    			  endGame(m.getPlaying());
		    	  	    		  }
		    	  	    	  }
	    				  }
	    				  
	    	  	      }
	    			  
	    			  @Override
	    	  	      public void mousePressed(MouseEvent e) {}

	    	  	      @Override
	    	  	      public void mouseReleased(MouseEvent e) { }
	    			  
	    			  @Override
	    	  	      public void mouseEntered(MouseEvent e) {
	    				  m = getModel();
	    				  if (((JPanel) e.getSource()).getBackground() == Color.green && m.getCurP() != null && ((JPanel) e.getSource()).getComponentCount() == 0) {
	    					  ((Component) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    	  	    	  }
	    				  else {
	    					  ((Component) e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	    				  }
	    				  
	    			  }

	    	  	      @Override
	    	  	      public void mouseExited(MouseEvent e) { }
	    			  
	    		  });
	    		  
	    		  
	    	  }
	      }
	}
	
	/**
	 * Removes all listeners on the board to prevent any more interaction between the player and GUI.
	 * This is only done at the end of the game once a winner is decided.
	 * */
	public void removeListeners() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				if ( getView().getPiece(i, j) != null) {
					getView().getPiece(i, j).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					getView().getPiece(i, j).removeMouseListener(getView().getPiece(i, j).getMouseListeners()[0]);
				}
			}
		}
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				getView().getPanelTile(i, j).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				getView().getPanelTile(i,j).removeMouseListener(getView().getPanelTile(i, j).getMouseListeners()[0]);
			}
		}
	}
	
	/**
	 * Condition checker if no more possible moves are available. This is checked every move committed and if a statement ever returns false, it will determine the winner.
	 * @param bWin is the opposite of the Model's "isPlaying()" variable.
	 * */
	public void endGame(boolean bWin) {
		if (!bWin) {
			Model m = getModel();
			if (m.getPlayer1().CheckWin(m.getPlayer2())) {
				getView().setTurnLabelText("Player 1 wins!");
			}
			else
				getView().setTurnLabelText("Player 2 wins !");
			
			removeListeners();
			
		}
	}
	
	/**
	 * Ends current turn to switch to the other player's turn to move pieces. Merely toggles Model's turn variable.
	 * */
	public void endTurn() {
		getModel().setTurn(!getModel().getTurn());
		String turn;
		if (getModel().getTurn())
			turn = (getModel().getPlayer1().getColor().equals("Red")) ? "Red" : "Blue";
		else
			turn = (getModel().getPlayer2().getColor().equals("Red")) ? "Red" : "Blue";
		getView().setTurnLabelText(turn+"'s turn!");
	}

	/**
	 * Grabs the Model class for reference convenience.
	 * */
	public Model getModel() {
		return model;
	}
	
	/**
	 * Grabs the View class for reference convenience.
	 * */
	public View getView() {
		return view;
	}
	
	/**
	 * Grabs the coordinates of a tile onto a point integer for referencing.
	 * @param o object of type JPanel that is cross-referenced from View's board.
	 * @return a two-point coordinate where [0] = Y and [1] = X.
	 * */
	public int[] getCoordinates(Object o) {
		int[] newCords;
		  newCords = new int[2];
		  newCords[1] = getView().getTileCoordX(o);
		  newCords[0] = getView().getTileCoordY(o);
		  
		  return newCords;
	}
}
