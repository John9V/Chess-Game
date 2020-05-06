package packageVaganov;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/** The knight class has a unique makeBody method that is used specifically
 *  to draw a knight. */
public class Knight extends Piece {
    
    /** Constructs a bishop for a specified team using a specified color. */
    public Knight(int t, Color c, Board b) {
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
        if (Math.abs(fromX - toX) == 2
                && Math.abs(fromY - toY) == 1
                && sameBoard) {
            return true;
        }
        if (Math.abs(fromX - toX) == 1
                && Math.abs(fromY - toY) == 2
                && sameBoard) {
            return true;
        }
        
        //3d moves
        if ((Math.abs(fromX - toX) == 2 && fromY == toY)
                && Math.abs(toZ - fromZ) == 1) {
            return true;
        }
        if ((Math.abs(fromX - toX) == 1 && fromY == toY)
                && Math.abs(toZ - fromZ) == 2) {
            return true;
        }
        if ((Math.abs(fromY - toY) == 2 && fromX == toX)
                && Math.abs(toZ - fromZ) == 1) {
            return true;
        }
        if ((Math.abs(fromY - toY) == 1 && fromX == toX)
                && Math.abs(toZ - fromZ) == 2) {
            return true;
        }
        return false;
    }
    
    /** Creates a knight out of shapes. */
    private Group makeBody(int y, int x, int z) {
        int zPos = BoardPosition.getDistance();
        xOffSet = originalOffset + z*zPos;
        Rectangle r = new Rectangle(x*scale+xOffSet + 1, y*scale+yOffSet + 30
                , width - 2, height - 30);
        Rectangle r2 = new Rectangle(x*scale+xOffSet + 7.5, y*scale+yOffSet + 10
                , width - 15, height -10);
        Ellipse r3 = new Ellipse(x*scale+xOffSet+10, y*scale+yOffSet + 11
                , width-22, height - 32);
        
        r.setFill(color); r.setStroke(Color.BLACK); r.setStrokeWidth(2);
        r2.setFill(color); r2.setStroke(Color.BLACK); r2.setStrokeWidth(2);
        r3.setFill(color); r3.setStroke(Color.BLACK); r3.setStrokeWidth(2);
        r3.setRotate(-46);
        
        hitBox = new Group(r2, r, r3);
        return hitBox;
    }
    
    /** Adds the image of a knight to the specified x and y on the given board.
     *  The tile event handler is passed in to allow the piece to be
     *  functional. When a piece is clicked it calls the event handler of the
     *  tile it is standing on. */
    public void draw(Group g, int x, int y, int z, EventHandler<MouseEvent> eHandler) {
        Group piece = makeBody(x, y, z);
        piece.setOnMousePressed(eHandler);
        g.getChildren().add(piece);
    }
    
}
