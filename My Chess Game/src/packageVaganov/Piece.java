package packageVaganov;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/** The piece class has all necessary variables for drawing an image in a
 *  specific location. */
public abstract class Piece {
    protected Board parentBoard;
    protected Group hitBox;
    protected Color color;
    int originalOffset = 5;
    int xOffSet = 5;
    int yOffSet = 5;
    int xGlobalOffset;
    protected final double width = 40;
    protected final double height = 40;
    protected final int scale = 52;
    protected int team;
    
    /** Constructs a piece for a specified team using a specified color. */
    public Piece(int t, Color c, Board b) {
        team = t;
        color = c;
        parentBoard = b;
    }
    
    /** Accepts two tiles and checks their x and y to determine if the piece
     *  can make the move. */
    public abstract boolean isValidMove(Tile fromTile, Tile toTile);
    
    /** Adds the image of a pawn to the specified x and y on the given board.
     *  The tile event handler is passed in to allow the piece to be
     *  functional. When a piece is clicked it calls the event handler of the
     *  tile it is standing on. */
    public abstract void draw(Group g, int x, int y, int z, EventHandler<MouseEvent> eHandler);
    
    /** removes the piece from the specified group. */
    public void removePiece(Group g) {
        g.getChildren().remove(hitBox);
        //System.out.println("removed"); //optional
    }
    
    /** Returns the team number of the piece. */
    public int getTeam() {
        return team;
    }
    
    /** Creates a general piece using a rectangle. */
    private Group makeBody(int y, int x, int z) {
        Rectangle r = new Rectangle(x*scale+xOffSet+xGlobalOffset + 7.5 + 150*x
                , y*scale+yOffSet + 10
                , width - 15, height -10);
        
        r.setFill(color); r.setStroke(Color.BLACK); r.setStrokeWidth(2);
        
        hitBox = new Group(r);
        return hitBox;
    }
    
}
