package packageVaganov;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/** The rook class has a unique makeBody method that is used specifically
 *  to draw a rook. */
public class Rook extends Piece {
    
    /** Constructs a rook for a specified team using a specified color. */
    public Rook(int t, Color c, Board b) {
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
        //not blocked by default 
        boolean blocked1 = false; // (right line)
        boolean blocked2 = false; // (left line)
        boolean blocked3 = false; // (top line)
        boolean blocked4 = false; // (bottom line)
        boolean blocked5 = false; // (right line up 3d)
        boolean blocked6 = false; // (left line up 3d)
        boolean blocked7 = false; // (top line up 3d)
        boolean blocked8 = false; // (bottom line up 3d)
        boolean blocked9 = false; // (right line down 3d)
        boolean blocked10 = false; // (left line down 3d)
        boolean blocked11 = false; // (top line down 3d)
        boolean blocked12 = false; // (bottom line down 3d)
        boolean sameBoard = fromZ == toZ;
        
        //regular movements
        for (int i = 0; i < 7; i++) {
            
            //right line same board
            if (sameBoard
                    && !blocked1
                    && fromX +i+1 == toX
                    && fromY == toY) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX +i+1, fromY, toZ)) {
                    blocked1 = true;
                }
            }
            
            //left line same board
            if (sameBoard
                    && !blocked2
                    && fromX -i-1 == toX
                    && fromY == toY) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX -i-1, fromY, toZ)) {
                    blocked2 = true;
                }
            }
            
            //top line same board
            if (sameBoard
                    && !blocked3
                    && fromY +i+1 == toY
                    && fromX == toX) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX, fromY +i+1, toZ)) {
                    blocked3 = true;
                }
            }
            
            //bottom line same board
            if (sameBoard
                    && !blocked4
                    && fromY -i-1 == toY
                    && fromX == toX) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX, fromY -i-1, toZ)) {
                    blocked4 = true;
                }
            }
            
        }
        
        //3d movements
        for (int i = 0; i < 2; i++) {
            
            //up
            
            //right line up to a different board
            if (!sameBoard
                    && !blocked5
                    && fromX +i+1 == toX
                    && fromY == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX +i+1, fromY, fromZ +i+1)) {
                    blocked5 = true;
                }
            }
            
            //left line up to a different board
            if (!sameBoard
                    && !blocked6
                    && fromX -i-1 == toX
                    && fromY == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX -i-1, fromY, fromZ +i+1)) {
                    blocked6 = true;
                }
            }
            
            //top line up to a different board
            if (!sameBoard
                    && !blocked7
                    && fromX == toX
                    && fromY +i+1 == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX, fromY +i+1, fromZ +i+1)) {
                    blocked7 = true;
                }
            }
            
            //bottom line up to a different board
            if (!sameBoard
                    && !blocked8
                    && fromX == toX
                    && fromY -i-1 == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX, fromY -i-1, fromZ +i+1)) {
                    blocked8 = true;
                }
            }
            
            //down
            
            //right line down to a different board
            if (!sameBoard
                    && !blocked9
                    && fromX +i+1 == toX
                    && fromY == toY && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX +i+1, fromY, fromZ -i-1)) {
                    blocked9 = true;
                }
            }
            
            //left line down to a different board
            if (!sameBoard
                    && !blocked10
                    && fromX -i-1 == toX
                    && fromY == toY
                    && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX -i-1, fromY, fromZ -i-1)) {
                    blocked10 = true;
                }
            }
            
            //top line down to a different board
            if (!sameBoard
                    && !blocked11
                    && fromX == toX
                    && fromY +i+1 == toY
                    && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX, fromY +i+1, fromZ -i-1)) {
                    blocked11 = true;
                }
            }
            
            //bottom line down to a different board
            if (!sameBoard
                    && !blocked12
                    && fromX == toX
                    && fromY -i-1 == toY
                    && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX, fromY -i-1, fromZ -i-1)) {
                    blocked12 = true;
                }
            }
        }
        return false;
    }
    
    /** Creates a queen out of shapes. */
    Group makeBody(int y, int x, int z) {
        int zPos = BoardPosition.getDistance();
        xOffSet = originalOffset + z*zPos;
        Rectangle r = new Rectangle(x*scale+xOffSet + 1, y*scale+yOffSet + 30
                , width - 2, height - 30);
        Rectangle rr = new Rectangle(x*scale+xOffSet+5, y*scale+yOffSet + 8
                , width-10, height - 33);
        Rectangle r2 = new Rectangle(x*scale+xOffSet + 7.5, y*scale+yOffSet + 10
                , width - 15, height -10);
        Rectangle r3 = new Rectangle(x*scale+xOffSet+3, y*scale+yOffSet + 7
                , width-6, height - 30);
        Rectangle r4 = new Rectangle(x*scale+xOffSet+3, y*scale+yOffSet+1
                , width-32, height-25);
        Rectangle r5 = new Rectangle(x*scale+xOffSet+16, y*scale+yOffSet+1
                , width-32, height-25);
        Rectangle r6 = new Rectangle(x*scale+xOffSet+29.5, y*scale+yOffSet+1
                , width-32, height-25);
        
        r.setFill(color); r.setStroke(Color.BLACK); r.setStrokeWidth(2);
        rr.setFill(color);
        r2.setFill(color); r2.setStroke(Color.BLACK); r2.setStrokeWidth(2);
        r3.setFill(color); r3.setStroke(Color.BLACK); r3.setStrokeWidth(2);
        r4.setFill(color); r4.setStroke(Color.BLACK); r4.setStrokeWidth(2);
        r5.setFill(color); r5.setStroke(Color.BLACK); r5.setStrokeWidth(2);
        r6.setFill(color); r6.setStroke(Color.BLACK); r6.setStrokeWidth(2);
        
        hitBox = new Group(r3, r2, r, r4, r5, r6, rr);
        return hitBox;
    }
    
    /** Adds the image of a rook to the specified x and y on the given board.
     *  The tile event handler is passed in to allow the piece to be
     *  functional. When a piece is clicked it calls the event handler of the
     *  tile it is standing on. */
    public void draw(
            Group g, int x, int y, int z, EventHandler<MouseEvent> eHandler) {
        Group piece = makeBody(x, y, z);
        piece.setOnMousePressed(eHandler);
        g.getChildren().add(piece);
    }
    
}
