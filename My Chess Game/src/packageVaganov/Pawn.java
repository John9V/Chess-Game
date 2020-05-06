package packageVaganov;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/** The pawn class has a unique makeBody method that is used specifically
 *  to draw a pawn. */
public class Pawn extends Piece {
    boolean hasMoved = false;
    
    /** Constructs a pawn for a specified team using a specified color. */
    public Pawn(int t, Color c, Board b) {
        super(t, c, b);
    }
    
    public void changeMovedStatus() {
        hasMoved = true;
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
        
        //for pawns going down the board (assuming team 2 is going down)
        
        //regular moves
        
        if(team == 2 && !hasMoved
                && !parentBoard.isTileOccupied(fromX, fromY+1, toZ)
                && Math.abs(fromY - toY) == 2
                && fromX == toX
                && sameBoard) {
            return true;
        }
        if(team == 2 && !parentBoard.isTileOccupied(fromX, fromY+1, toZ)
                && toY - fromY == 1
                && fromX == toX
                && sameBoard) {
            return true;
        }
        if (team == 2 && toTile.isOccupied() && Math.abs(fromX - toX) == 1
                && toY - fromY == 1 && sameBoard) {
            return true;
        }
        
        //3d moves
        
        //up the board levels
        
        if(team == 2 && !hasMoved && toZ-1 >= 0
                && !parentBoard.isTileOccupied(fromX, fromY+1, toZ-1)
                && Math.abs(fromY - toY) == 2
                && fromZ - toZ == -2
                && fromX == toX
                && !sameBoard) {
            return true;
        }
        if(team == 2 && !parentBoard.isTileOccupied(fromX, fromY+1, toZ)
                && toY - fromY == 1
                && fromZ - toZ == -1
                && fromX == toX
                && !sameBoard) {
            return true;
        }
        if (team == 2 && toTile.isOccupied() && Math.abs(fromX - toX) == 1
                && toY - fromY == 1 && fromZ - toZ == -1 && !sameBoard) {
            return true;
        }
        
        //down the board levels
        
        if(team == 2 && !hasMoved && toZ+1 <= 2
                && !parentBoard.isTileOccupied(fromX, fromY+1, toZ+1)
                && Math.abs(fromY - toY) == 2
                && fromZ - toZ == 2
                && fromX == toX
                && !sameBoard) {
            return true;
        }
        if(team == 2 && !parentBoard.isTileOccupied(fromX, fromY+1, toZ)
                && toY - fromY == 1
                && fromZ - toZ == 1
                && fromX == toX
                && !sameBoard) {
            return true;
        }
        if (team == 2 && toTile.isOccupied() && Math.abs(fromX - toX) == 1
                && toY - fromY == 1 && fromZ - toZ == 1 && !sameBoard) {
            return true;
        }
        
        //for pawns going up the board (assuming team 1 is going up)
        
        //regular moves
        
        if(team == 1 && !hasMoved
                && !parentBoard.isTileOccupied(fromX, fromY-1, toZ)
                && Math.abs(fromY - toY) == 2
                && fromX == toX
                && sameBoard) {
            return true;
        }
        if(team == 1 && !parentBoard.isTileOccupied(fromX, fromY-1, toZ)
                && toY - fromY == -1
                && fromX == toX
                && sameBoard) {
            return true;
        }
        if (team == 1 && toTile.isOccupied() && Math.abs(fromX - toX) == 1
                && toY - fromY == -1 && sameBoard) {
            return true;
        }
        
        //3d moves
        
        //up the board levels
        
        if(team == 1 && !hasMoved && toZ-1 >= 0
                && !parentBoard.isTileOccupied(fromX, fromY-1, toZ-1)
                && Math.abs(fromY - toY) == 2
                && fromZ - toZ == -2
                && fromX == toX
                && !sameBoard) {
            return true;
        }
        if(team == 1 && !parentBoard.isTileOccupied(fromX, fromY-1, toZ)
                && toY - fromY == -1
                && fromZ - toZ == -1
                && fromX == toX
                && !sameBoard) {
            return true;
        }
        if (team == 1 && toTile.isOccupied() && Math.abs(fromX - toX) == 1
                && toY - fromY == -1 && fromZ - toZ == -1 && !sameBoard) {
            return true;
        }
        
        //down the board levels
        
        if(team == 1 && !hasMoved && toZ+1 <= 2
                && !parentBoard.isTileOccupied(fromX, fromY-1, toZ+1)
                && Math.abs(fromY - toY) == 2
                && fromZ - toZ == 2
                && fromX == toX
                && !sameBoard) {
            return true;
        }
        if(team == 1 && !parentBoard.isTileOccupied(fromX, fromY+1, toZ)
                && toY - fromY == -1
                && fromZ - toZ == 1
                && fromX == toX
                && !sameBoard) {
            return true;
        }
        if (team == 1 && toTile.isOccupied() && Math.abs(fromX - toX) == 1
                && toY - fromY == -1 && fromZ - toZ == 1 && !sameBoard) {
            return true;
        }
        return false;
        
    }
    
    /** Creates a pawn out of shapes. */
    Group makeBody(int y, int x, int z) {
        int zPos = BoardPosition.getDistance();
        xOffSet = originalOffset + z*zPos;
        Rectangle r = new Rectangle(x*scale+xOffSet + 5, y*scale+yOffSet + 30
                , width - 10, height - 30);
        Rectangle r2 = new Rectangle(x*scale+xOffSet + 13, y*scale+yOffSet + 10
                , width - 26, height -10);
        Ellipse r3 = new Ellipse(x*scale+xOffSet+20, y*scale+yOffSet+10
                , width-31, height-31);
        
        r.setFill(color); r.setStroke(Color.BLACK); r.setStrokeWidth(2);
        r2.setFill(color); r2.setStroke(Color.BLACK); r2.setStrokeWidth(2);
        r3.setFill(color); r3.setStroke(Color.BLACK); r3.setStrokeWidth(2);
        
        hitBox = new Group(r2, r, r3);
        return hitBox;
    }
    
    /** Adds the image of a pawn to the specified x and y on the given board.
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
