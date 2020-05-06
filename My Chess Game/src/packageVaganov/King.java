package packageVaganov;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/** The king class has a unique makeBody method that is used specifically
 *  to draw a king. */
public class King extends Piece {
    
    /** Constructs a king for a specified team using a specified color. */
    public King(int t, Color c, Board b) {
        super(t, c, b);
    }
    
    /** Accepts two tiles and checks their x and y to determine if the piece
     *  can make the move. */
    public boolean isValidMove(Tile fromTile, Tile toTile) {
        int fromX = fromTile.getX();
        int fromY = fromTile.getY();
        int fromZ = fromTile.getZ();
        int toX = toTile.getX();
        int toY = toTile.getY();
        int toZ = toTile.getZ();
        boolean sameBoard = fromZ == toZ;
        
        //regular moves
        if (Math.abs(fromX - toX) < 2
                && Math.abs(fromY - toY) < 2
                && sameBoard) {
            return true;
        }
        
        //3d moves
        if (Math.abs(fromX - toX) < 2
                && Math.abs(fromY - toY) < 2
                && Math.abs(fromZ - toZ) == 1
                && (fromX != toX || fromY != toY)) {
            return true;
        }
        return false;
    }
    
    /** Creates a king out of shapes. */
    private Group makeBody(int y, int x, int z) {
        int zPos = BoardPosition.getDistance();
        xOffSet = originalOffset + z*zPos;
        Rectangle r = new Rectangle(x*scale+xOffSet+1, y*scale+yOffSet+30
                , width-2, height-30);
        Ellipse r2 = new Ellipse(x*scale+xOffSet+15, y*scale+yOffSet+20
                , width-22, height-28);
        Ellipse r3 = new Ellipse(x*scale+xOffSet+25, y*scale+yOffSet+20
                , width-22, height-28);
        Ellipse r4 = new Ellipse(x*scale+xOffSet+16, y*scale+yOffSet+20
                , width-24, height-30);
        Rectangle r5 = new Rectangle(x*scale+xOffSet+14, y*scale+yOffSet
                , width-28, height-28);
        
        r.setFill(color); r.setStroke(Color.BLACK); r.setStrokeWidth(2);
        r2.setFill(color); r2.setStroke(Color.BLACK); r2.setStrokeWidth(2);
        r2.setRotate(55);
        r3.setFill(color); r3.setStroke(Color.BLACK); r3.setStrokeWidth(2);
        r3.setRotate(-55);
        r4.setFill(color); r4.setRotate(55);
        r5.setFill(color); r5.setStroke(Color.BLACK); r5.setStrokeWidth(2);
        
        hitBox = new Group(r2, r3, r4, r, r5);
        return hitBox;
    }
    
    /** Adds the image of a king to the specified x and y on the given board.
     *  The tile event handler is passed in to allow the piece to be
     *  functional. When a piece is clicked it calls the event handler of the
     *  tile it is standing on. */
    public void draw(Group g, int x, int y, int z, EventHandler<MouseEvent> eHandler) {
        Group piece = makeBody(x, y, z);
        piece.setOnMousePressed(eHandler);
        g.getChildren().add(piece);
    }
    
}
