package View;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * Paints the needed graphics in the GUI. Prepares all images and colors
 * needed for visualization for the player. Does not carry any information
 * nor manipulate any data, it is purely frontend to display what is needed.
 * */
public class View {

	private JFrame frame;
    
    private JPanel gameBoard;
    private JPanel[][] tileSet;
    private int[][] tileCoordsX;
    private int[][] tileCoordsY;
    
    private JLabel turnLabel;
    private JLabel bottomText;
    private JPanel starterPanel;
    
    private JPanel panel;
    
    private PieceDisplay[][] pieces;
    
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    
    private JPanel redPanel;
    private JPanel bluePanel;
    
    /**
     * Instantiates all needed graphics for the GUI. Prepares the tileSet and the pieces
     * of the board. Note that these are not the actual data pieces, rather they are display
     * pieces purely for display and referencing.
     * */
    public View() {
    	turnLabel = new JLabel();
    	turnLabel.setText("Get Ready!");
        // Initialize the Window
        frame = new JFrame("Animal Chess");  
        frame.setSize(900, 700);           
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameBoard = new JPanel();
        gameBoard.setLayout(new BorderLayout());
        GridLayout chessBoard = new GridLayout(7,9);
        panel = new JPanel();
        tileSet = new JPanel[7][9];
        
        panel.setPreferredSize(new Dimension(540,420));
        panel.setLayout(chessBoard);

        Color tempColor;
        Boolean color = true;
        
        tileCoordsX = new int[7][9];
        tileCoordsY = new int[7][9];
        
        for (int i = 0; i < 7; i++) {
        	for (int j = 0; j < 9; j++) {
            	if (i==3 && j==0) { tempColor = Color.red;}
            	else if (i==3 && j==8)		{ tempColor = Color.blue;}
            	else if ((i == 2 || i == 4) 
            			&& (j==0 || j == 8)){tempColor = Color.decode("#36454F");}
            	else if (i == 3 
            			&& (j==1 || j==7)) 	{ tempColor = Color.decode("#36454F"); }
            	else if ((i==1 ||i==2||i==4||i==5)
            		 && (j==3||j==4||j==5)) { tempColor = Color.decode("#7393B3"); }
            	else if (!color) 			{ tempColor = Color.decode("#90a955"); }
            	else 						{ tempColor = Color.decode("#4f772d"); }
            	color=!color;
            	
            	int k = i; 
            	int l = j;
            	
				JPanel boardPanel = new JPanel();
            	
            	tileCoordsX[i][j] = l;
            	tileCoordsY[i][j] = k;

            	boardPanel.setBackground(tempColor);
            	boardPanel.setSize(100,100);
            	tileSet[i][j] = boardPanel;
            	panel.add(tileSet[i][j]);

        	}
        }
        panel.setBounds(0,0, 540,420);
        panel.setMinimumSize(new Dimension(540,420));
        panel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        
        gameBoard.add(panel, BorderLayout.CENTER);
        
        //LEFT PANEL
        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(160,280));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        
        redPanel = new JPanel();
        redPanel.setPreferredSize(new Dimension(100,100));
        redPanel.setBackground(Color.red);
        leftPanel.add(redPanel);
        leftPanel.add(Box.createGlue());
        
        //RIGHT Panel
        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(160,280));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        
        bluePanel = new JPanel();
        bluePanel.setPreferredSize(new Dimension(100,100));
        bluePanel.setBackground(Color.blue);
        rightPanel.add(bluePanel);
        rightPanel.add(Box.createGlue());
        
        //TOP Panel
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel titleBar = new JLabel("ANIMAL CHESS");

        titleBar.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        titleBar.setFont(new Font("Raleway", Font.BOLD, 20));
        
        topPanel.setPreferredSize(new Dimension(900, 120));
        topPanel.add(Box.createGlue());
        topPanel.add(titleBar);
        topPanel.add(Box.createGlue());
        turnLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        topPanel.add(turnLabel);
        topPanel.add(Box.createGlue());
        
        //Bottom Panel
        bottomText = new JLabel("Choose a piece for each player");
        bottomPanel = new JPanel();

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomText.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        bottomPanel.setPreferredSize(new Dimension(900, 120));
        bottomPanel.add(bottomText);
        bottomPanel.add(Box.createGlue());
        
        
        gameBoard.add(leftPanel, BorderLayout.WEST);
        gameBoard.add(rightPanel, BorderLayout.EAST);
        gameBoard.add(topPanel, BorderLayout.NORTH);
        gameBoard.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.add(gameBoard);
        
        pieces = new PieceDisplay[2][8];
        initializePieces();
        
        
        
        // updates the window
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }
    /**
     * Initializes the pieceDisplay of both players in the board
     * while filling the pieces array.
     * */
    public void initializePieces() {
    	String color = "red";
    	for (int i = 0; i < 2; i++) {
    		if (i == 0) {color = "Red";}
    		else	   {color = "Blue";}
    		for (int j = 0; j < 8; j++) {
    			pieces[i][j] = new PieceDisplay(j+1,color);
    		}
    	}
    	
    	tileSet[0][0].add(pieces[0][5]);
    	tileSet[0][2].add(pieces[0][7]);

    	tileSet[0][6].add(pieces[1][0]);
    	tileSet[0][8].add(pieces[1][6]);
    	
    	tileSet[1][1].add(pieces[0][1]);
    	tileSet[1][7].add(pieces[1][3]);
    	
    	tileSet[2][2].add(pieces[0][2]);
    	tileSet[2][6].add(pieces[1][4]);
    	
    	tileSet[4][2].add(pieces[0][4]);
    	tileSet[4][6].add(pieces[1][2]);
    	
    	tileSet[5][1].add(pieces[0][3]);
    	tileSet[5][7].add(pieces[1][1]);
    	
    	tileSet[6][0].add(pieces[0][6]);
    	tileSet[6][2].add(pieces[0][0]);

    	tileSet[6][6].add(pieces[1][7]);
    	tileSet[6][8].add(pieces[1][5]);
    	
    }
    
    /**
     * Prepares randomized pieces for choosing.
     * Uses a ranking of 9-16 for handling. Subtract by 8 for actual piece.
     * @param randPieces an array of random numbers to determine randPiece in the set.
     * */
    public void initializeIntro(int[] randPieces) {
    	starterPanel = new JPanel();
    	PieceDisplay[] secretPieces;
    	secretPieces = new PieceDisplay[8];
    	
    	for (int i = 0; i < 8; i++) {
    		secretPieces[i] = new PieceDisplay(randPieces[i]+10,"red");
    		starterPanel.add(secretPieces[i]);
    	}
    	
        bottomPanel.add(starterPanel);
        bottomPanel.add(Box.createGlue());
    	
    }
    
    /**
     * Empties the bottom panel's starter panel to begin the game.
     * Removes all masked pieces.
     * */
    public void emptyBottom() {
    	starterPanel.setVisible(false);
    	bottomPanel.remove(1);
    	
    	frame.revalidate();
        frame.repaint();
    }
    
    /**
     * Recolors the tiles to original colors after checking for available moves.
     * */
    public void recolorTiles() {
    	Color tempColor;
        Boolean color = true;
        
        for (int i = 0; i < 7; i++) {
        	for (int j = 0; j < 9; j++) {
        		//Special Points
            	if (i==3 && j==0) { tempColor = Color.red;}
            	else if (i==3 && j==8)		{ tempColor = Color.blue;}
            	else if ((i == 2 || i == 4) 
            			&& (j==0 || j == 8)){tempColor = Color.decode("#36454F");}
            	else if (i == 3 
            			&& (j==1 || j==7)) 	{ tempColor = Color.decode("#36454F"); }
            	else if ((i==1 ||i==2||i==4||i==5)
            		 && (j==3||j==4||j==5)) { tempColor = Color.decode("#7393B3"); }
            	else if (!color) 			{ tempColor = Color.decode("#90a955"); }
            	else 						{ tempColor = Color.decode("#4f772d"); }
            	color=!color;
            	
            	
            	tileSet[i][j].setBackground(tempColor);

        	}
        }
    }
    
    /**
     * Gets the frame of View.
     * @return frame the frame of the entire GUI.
     * */
    public JFrame getFrame() {
    	return frame;
    }
    
    /**
     * Gets the left panel of the GUI.
     * @return leftPanel the left panel of the GUI
     * */
    public JPanel getLeft() {
    	frame.revalidate();
        frame.repaint();
    	return leftPanel;
    }
    
    /**
     * Gets the right panel of the GUI.
     * @return rightPanel the right panel of the GUI
     * */
    public JPanel getRight() {
    	frame.revalidate();
        frame.repaint();
    	return rightPanel;
    }
    
    /**
     * Gets the bottom starterPanel of the GUI.
     * @return starterPanel the starting piece panel of the GUI
     * */
    public JPanel getBottom() {
    	return starterPanel;
    }
    
    /**
     * Gets the bottom panel of the GUI.
     * @return bottomPanel the left panel of the GUI
     * */
    public JPanel getBottomPanel() {
    	return bottomPanel;
    }

    /**
     * Gets a piece off the board using x and y coordinates.
     * @param x an integer of the x coordinate
     * @param y an integer of the y coordinate
     * @return PieceDisplay a piece off the View's displayed pieces
     * */
    public PieceDisplay getPiece(int x, int y) {
    	if (tileSet[x][y].getComponentCount()>0) {
    		return (PieceDisplay) tileSet[x][y].getComponent(0);
    	}
    	else 
    		return null;
    	
    }
    
    /**
     * Gets reference of tile at coordinate x,y
     * in order to update visual information.
     * 
     * @param x coordinate of tile in the x-axis
     * @param y coordinate of tile in the y-axis
     * @return tileSet[x][y] a JPanel in the 9x7 tileSet to be manipulated
     * */
    public JPanel getPanelTile(int x, int y) {
    	return tileSet[x][y];
    }
    
    /**
     * Gets all tiles in the gameBoard for
     * referencing.
     * 
     * @return tileSet of all 7x9 tiles.
     * */
    public JPanel[][] getPanelTiles() {
    	return tileSet;
    }
    
    /**
     * Returns the x coordinate of a certain tile in the board.
     * @param o an object to cross reference with the board's tiles.
     * @return x coordinate of the tile.
     * */
    public int getTileCoordX(Object o) {
    	int x = 0;
    	for (int i =0; i < 7; i++)
    		for (int j = 0; j < 9; j++)
    			if (o == tileSet[i][j]) 
    				x = j;
    	if (x >= 0)
    		return x;
    	else
    		return 0;
    }
    
    /**
     * Returns the y coordinate of a certain tile in the board.
     * @param o an object to cross reference with the board's tiles.
     * @return y coordinate of the tile.
     * */
    public int getTileCoordY(Object o) {
    	int y = 0;
    	for (int i =0; i < 7; i++)
    		for (int j = 0; j < 9; j++)
    			if (o == tileSet[i][j]) 
    				y = i;
    	if (y >=0)
    		return y;
    	else
    		return 0;
    }
    
    /**
     * Gets the gameboard, the mainframe of the GUI.
     * return gameBoard reference.
     * */
    public JPanel getGameBoard() {
    	return gameBoard;
    }
    
    /**
     * Moves piece to said tile/location using x and y coordinates.
     * @param piece is the component to relocate.
     * @param x is the coordinate in the x-axis of the board.
     * @param y is the coordinate in the y-axis of the board.
     * */
    public void setPieceLocation(PieceDisplay piece, int x, int y) {
    	PieceDisplay pieceDisp = piece;
    	tileSet[x][y].add(pieceDisp);
    }
    
    /**
     * Moves piece to said tile/location using a destination panel.
     * @param piece is the component to relocate
     * @param destPanel is the destination panel without using coordinates to move to.
     * */
    public void setPieceLocation(PieceDisplay piece, JPanel destPanel) {
    	//piece.setVisible(false);
    	JPanel refPanel = (JPanel) piece.getParent();
    	refPanel.remove(0);
    	refPanel.revalidate();
    	refPanel.repaint();
    	PieceDisplay pieceDisp = piece;
    	pieceDisp.setVisible(true);
    	destPanel.add(pieceDisp);
    	
    	destPanel.repaint();
    	
    }
    
    
    /**
     * Sets the text at the top to determine whose turn it is and if the game has ended.
     * */
    public void setTurnLabelText(String t) {
    	turnLabel.setText(t);
    }
    
    /**
     * Sets the bottom text's text to indicate the choice of pieces
     * */
    public void setBottomText(String t) {
    	bottomText.setText(t);
    }
    
}
