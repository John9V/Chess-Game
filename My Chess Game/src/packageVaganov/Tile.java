package packageVaganov;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile {
    Tile thisTile = this;
    Group mainGroup; //the group that the tile will be displayed to
    Board parentBoard;
    Piece storedPiece;
    Rectangle hitBox;
    Color color;
    //Color givenColor;
    int x;
    int y;
    int z;
    int width = 50;
    int height = 50;
    EventHandler<MouseEvent> mouseEvent; //the even handler that handles a click
    GameControl control;
    
    /** Constructs a tile of the appropriate color. */
    Tile(Board b, int givenY, int givenX, int givenZ, Color c, GameControl GameC) {
        x = givenX;
        y = givenY;
        z = givenZ;
        parentBoard = b;
        storedPiece = null;
        color = c;
        //givenColor = c;
        control = GameC;
    }
    
    /** Returns the event handler. This is used to pass functionality on to
     *  the piece that occupies the tile. */
    public EventHandler<MouseEvent> getHandler() {
        return mouseEvent;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getZ() {
        return z;
    }
    
    /** Puts a specified piece on the tile and draws it. */
    public void setStoredPiece(Piece p){
        storedPiece = p;
        if (storedPiece != null) {
            p.draw(mainGroup, y, x, z, mouseEvent);
        }
    }
    
    /** Returns the stored piece. */
    public Piece getStoredPiece(){
        return storedPiece;
    }
    
    /** Returns true if the tile has a stored piece. */
    public boolean isOccupied(){
        if (storedPiece != null) {
            return true;
        }
        return false;
    }
    
    /** Removes the stored piece from the tile. */
    public void removeStoredPiece() {
        if (storedPiece != null) {
            storedPiece.removePiece(mainGroup);
        }
        storedPiece = null;
    }
    
    /** Displays the tile to a specified group. */
    public void draw(Group g) {
        Rectangle tile = makeBody(y, x, z);
        addFunctionality(tile);
        g.getChildren().add(tile);
        mainGroup = g;
    }
    
    public void paint(Color c) {
        hitBox.setFill(c);
    }
    
    public void paintOriginal() {
        hitBox.setFill(color);
    }
    
    private Color getColor() {
        return color;
    }
    
    /** Used to determine if a piece can go to a tile. This only checks to make
     *  sure a piece does not go on a tile that has a piece of the same
     *  color or team */
    private boolean peiceCanGoFromTo(Tile selectedTile, Tile toTile) {
        if (selectedTile.getStoredPiece() == null) {
            return false;
        }
        if (toTile.getStoredPiece() == null) {
            return true;
        }
        if (selectedTile.getStoredPiece().getTeam()
                != toTile.getStoredPiece().getTeam()) {
            return true;
        } else {
            return false;
        }
    }
    
    /** Creates a rectangle for a tile. */
    private Rectangle makeBody(int y, int x, int z) {
        int zPos = BoardPosition.getDistance();
        Rectangle r = new Rectangle(x*52+z*zPos, y*52, 50, 50);
        r.setFill(color);
        return r;
    }
    
    /** Creates a mouse event and assigns it to the tile so that when the tile
     *  is clicked the event is triggered. This allows the transfer of pieces
     *  from one tile to another by clicking them. */
    private void addFunctionality(Rectangle r) {
        hitBox = r;
        
        mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0){
                try{
                    Tile selectedTile = parentBoard.getSelectedTile();
                    //r.setFill(Color.LAVENDER); //optional indicator
                    if (selectedTile == null
                            || selectedTile.getStoredPiece() == null) {
                        
                        parentBoard.selectTile(thisTile);
                        Tile previousTile = parentBoard.getPreviousTile();
                        
                        selectedTile = thisTile;
                        if (isOccupied() && control.getPlayerTurn()
                                == getStoredPiece().getTeam()) {
                            paint(Color.YELLOW); //optional indicator
                        }
                        
                        if (previousTile != null) {
                            previousTile.paintOriginal();
                        }
                        System.out.println("selected");
                    } else {
                        if (peiceCanGoFromTo(selectedTile, thisTile)
                                && selectedTile.getStoredPiece().isValidMove(
                                        selectedTile, thisTile)
                                && selectedTile.getStoredPiece().getTeam()
                                    == control.getPlayerTurn()) {
                            
                            if (selectedTile.getStoredPiece() instanceof Pawn) {
                                ((Pawn) (selectedTile.getStoredPiece()))
                                    .changeMovedStatus();
                            }
                            
                            if (getStoredPiece() != null) {
                                getStoredPiece().removePiece(mainGroup);
                            }
                            
                            storedPiece = selectedTile.getStoredPiece();
                            
                            if (selectedTile!= null
                                    && selectedTile.getStoredPiece() != null) {
                                
                                selectedTile.getStoredPiece().removePiece(
                                        mainGroup);
                                
                                selectedTile.setStoredPiece(null);
                            }
                            
                            if (storedPiece != null) {
                                storedPiece.draw(mainGroup, y, x, z, mouseEvent);
                            }
                            
                            parentBoard.selectTile(null);
                            //r.setFill(Color.GREY); //optional indicator
                            control.registerMove();
                            
                            parentBoard.getPreviousTile().paintOriginal();
                            System.out.println("placed");
                        } else {
                            parentBoard.selectTile(thisTile);
                            Tile previousTile = parentBoard.getPreviousTile();
                            
                            if (isOccupied() && control.getPlayerTurn()
                                    == getStoredPiece().getTeam()) {
                                paint(Color.YELLOW); //optional indicator
                            }
                            if (previousTile != null) {
                                previousTile.paintOriginal();
                            }
                            
                            System.out.println("couldnt place, but selected"
                                    + " this tile");
                        }
                        
                    }
                } catch (Exception except) {
                    System.out.println(except);
                }
                
            }};
        r.setOnMousePressed(mouseEvent);
    }
    
}
