package packageVaganov;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/** The queen class has a unique makeBody method that is used specifically
 *  to draw a queen. */
public class Queen extends Piece {
    
    /** Constructs a queen for a specified team using a specified color. */
    public Queen(int t, Color c, Board b) {
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
        boolean blocked5 = false; // (first diagonal)
        boolean blocked6 = false; // (second diagonal)
        boolean blocked7 = false; // (third diagonal)
        boolean blocked8 = false; // (fourth diagonal)
        boolean blocked9 = false; // (right line up 3d)
        boolean blocked10 = false; // (left line up 3d)
        boolean blocked11 = false; // (top line up 3d)
        boolean blocked12 = false; // (bottom line up 3d)
        boolean blocked13 = false; // (right line down 3d)
        boolean blocked14 = false; // (left line down 3d)
        boolean blocked15 = false; // (top line down 3d)
        boolean blocked16 = false; // (bottom line down 3d)
        boolean blocked17 = false; // (first diagonal up 3d)
        boolean blocked18 = false; // (second diagonal up 3d)
        boolean blocked19 = false; // (third diagonal up 3d)
        boolean blocked20 = false; // (fourth diagonal up 3d)
        boolean blocked21 = false; // (first diagonal down 3d)
        boolean blocked22 = false; // (second diagonal down 3d)
        boolean blocked23 = false; // (third diagonal down 3d)
        boolean blocked24 = false; // (fourth diagonal down 3d)
        boolean sameBoard = fromZ == toZ;
        
        //regular movements
        for (int i = 0; i < 7; i++) {
            
          //right line
            if (!blocked1
                    && fromX +i+1 == toX
                    && fromY == toY
                    && sameBoard) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX +i+1, fromY, toZ)) {
                    blocked1 = true;
                }
            }
            
            //left line
            if (!blocked2
                    && fromX -i-1 == toX 
                    && fromY == toY
                    && sameBoard) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX -i-1, fromY, toZ)) {
                    blocked2 = true;
                }
            }
            
            //top line
            if (!blocked3
                    && fromY +i+1 == toY
                    && fromX == toX
                    && sameBoard) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX, fromY +i+1, toZ)) {
                    blocked3 = true;
                }
            }
            
            //bottom line
            if (!blocked4
                    && fromY -i-1 == toY
                    && fromX == toX
                    && sameBoard) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX, fromY -i-1, toZ)) {
                    blocked4 = true;
                }
            }
            
            //bottom right diagonal
            if (!blocked5
                    && fromX +i+1 == toX
                    && fromY +i+1 == toY
                    && sameBoard) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX +i+1, fromY +i+1, toZ)) {
                    blocked5 = true;
                }
            }
            
            //bottom left diagonal
            if (!blocked6
                    && fromX -i-1 == toX
                    && fromY +i+1 == toY
                    && sameBoard) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX -i-1, fromY +i+1, toZ)) {
                    blocked6 = true;
                }
            }
            
            //top-right diagonal
            if (!blocked7
                    && fromX +i+1 == toX
                    && fromY -i-1 == toY
                    && sameBoard) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX +i+1, fromY -i-1, toZ)) {
                    blocked7 = true;
                }
            }
            
            //top-left diagonal
            if (!blocked8
                    && fromX -i-1 == toX
                    && fromY -i-1 == toY
                    && sameBoard) {
                return true;
            } else {
                if (parentBoard.isTileOccupied(fromX -i-1, fromY -i-1, toZ)) {
                    blocked8 = true;
                }
            }
            
        }
        
        //3d movements
        for (int i = 0; i < 2; i++) {
            
            //up
            
            //rook moves
            
            //right line up to a different board
            if (!sameBoard
                    && !blocked9
                    && fromX +i+1 == toX
                    && fromY == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX +i+1, fromY, fromZ +i+1)) {
                    blocked9 = true;
                }
            }
            
            //left line up to a different board
            if (!sameBoard
                    && !blocked10
                    && fromX -i-1 == toX
                    && fromY == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX -i-1, fromY, fromZ +i+1)) {
                    blocked10 = true;
                }
            }
            
            //top line up to a different board
            if (!sameBoard
                    && !blocked11
                    && fromX == toX
                    && fromY +i+1 == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX, fromY +i+1, fromZ +i+1)) {
                    blocked11 = true;
                }
            }
            
            //bottom line up to a different board
            if (!sameBoard
                    && !blocked12
                    && fromX == toX
                    && fromY -i-1 == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX, fromY -i-1, fromZ +i+1)) {
                    blocked12 = true;
                }
            }
            
            //bishop moves
            
            //bottom right diagonal up to a different board
            if (!sameBoard
                    && !blocked17
                    && fromX +i+1 == toX
                    && fromY +i+1 == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX +i+1, fromY +i+1, fromZ +i+1)) {
                    blocked17 = true;
                }
            }
            
            //bottom left diagonal up to a different board
            if (!sameBoard
                    && !blocked18
                    && fromX -i-1 == toX
                    && fromY +i+1 == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX -i-1, fromY +i+1, fromZ +i+1)) {
                    blocked18 = true;
                }
            }
            
            //top right diagonal up to a different board
            if (!sameBoard
                    && !blocked19
                    && fromX +i+1 == toX
                    && fromY -i-1 == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX +i+1, fromY -i-1, fromZ +i+1)) {
                    blocked19 = true;
                }
            }
            
            //top left diagonal up to a different board
            if (!sameBoard
                    && !blocked20
                    && fromX -i-1 == toX
                    && fromY -i-1 == toY
                    && fromZ +i+1 == toZ) {
                return true;
            } else {
                if (fromZ +i+1 <= 2
                        && parentBoard.isTileOccupied(
                                fromX -i-1, fromY -i-1, fromZ +i+1)) {
                    blocked20 = true;
                }
            }
            
            //down
            
            //rook moves
            
            //right line down to a different board
            if (!sameBoard
                    && !blocked13
                    && fromX +i+1 == toX
                    && fromY == toY && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX +i+1, fromY, fromZ -i-1)) {
                    blocked13 = true;
                }
            }
            
            //left line down to a different board
            if (!sameBoard
                    && !blocked14
                    && fromX -i-1 == toX
                    && fromY == toY
                    && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX -i-1, fromY, fromZ -i-1)) {
                    blocked14 = true;
                }
            }
            
            //top line down to a different board
            if (!sameBoard
                    && !blocked15
                    && fromX == toX
                    && fromY +i+1 == toY
                    && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX, fromY +i+1, fromZ -i-1)) {
                    blocked15 = true;
                }
            }
            
            //bottom line down to a different board
            if (!sameBoard
                    && !blocked16
                    && fromX == toX
                    && fromY -i-1 == toY
                    && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX, fromY -i-1, fromZ -i-1)) {
                    blocked16 = true;
                }
            }
            
            //bishop moves
            
            //bottom right diagonal down to a different board
            if (!sameBoard
                    && !blocked21
                    && fromX +i+1 == toX
                    && fromY +i+1 == toY
                    && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX +i+1, fromY +i+1, fromZ -i-1)) {
                    blocked21 = true;
                }
            }
            
            //bottom left diagonal down to a different board
            if (!sameBoard
                    && !blocked22
                    && fromX -i-1 == toX
                    && fromY +i+1 == toY
                    && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX -i-1, fromY +i+1, fromZ -i-1)) {
                    blocked22 = true;
                }
            }
            
            //top right diagonal down to a different board
            if (!sameBoard
                    && !blocked23
                    && fromX +i+1 == toX
                    && fromY -i-1 == toY
                    && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX +i+1, fromY -i-1, fromZ -i-1)) {
                    blocked23 = true;
                }
            }
            
            //top left diagonal down to a different board
            if (!sameBoard
                    && !blocked24
                    && fromX -i-1 == toX
                    && fromY -i-1 == toY
                    && fromZ -i-1 == toZ) {
                return true;
            } else {
                if (fromZ -i-1 >= 0
                        && parentBoard.isTileOccupied(
                                fromX -i-1, fromY -i-1, fromZ -i-1)) {
                    blocked24 = true;
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
        Rectangle r2 = new Rectangle(x*scale+xOffSet + 16, y*scale+yOffSet + 8
                , width - 32, height -10);
        Rectangle r3 = new Rectangle(x*scale+xOffSet + 8, y*scale+yOffSet + 12
                , width - 32, height -20);
        Rectangle r4 = new Rectangle(x*scale+xOffSet + 24, y*scale+yOffSet + 12
                , width - 32, height -20);
        Ellipse r5 = new Ellipse(x*scale+xOffSet+20, y*scale+yOffSet+7
                , width-34, height-34);
        Ellipse r6 = new Ellipse(x*scale+xOffSet+5, y*scale+yOffSet+10
                , width-34, height-34);
        Ellipse r7 = new Ellipse(x*scale+xOffSet+35, y*scale+yOffSet+10
                , width-34, height-34);
        Rectangle r8 = new Rectangle(x*scale+xOffSet + 5, y*scale+yOffSet + 26
                , width - 10, height - 30);
        
        r.setFill(color); r.setStroke(Color.BLACK); r.setStrokeWidth(2);
        r2.setFill(color); r2.setStroke(Color.BLACK); r2.setStrokeWidth(2);
        r3.setFill(color); r3.setStroke(Color.BLACK); r3.setStrokeWidth(2);
        r3.setRotate(-30);
        r4.setFill(color); r4.setStroke(Color.BLACK); r4.setStrokeWidth(2);
        r4.setRotate(30);
        r5.setFill(color); r5.setStroke(Color.BLACK); r5.setStrokeWidth(2);
        r6.setFill(color); r6.setStroke(Color.BLACK); r6.setStrokeWidth(2);
        r7.setFill(color); r7.setStroke(Color.BLACK); r7.setStrokeWidth(2);
        r8.setFill(color); r8.setStroke(Color.BLACK); r8.setStrokeWidth(2);
        
        hitBox = new Group(r3, r4, r2, r8, r, r5, r6, r7);
        return hitBox;
    }
    
    /** Adds the image of a queen to the specified x and y on the given board.
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
