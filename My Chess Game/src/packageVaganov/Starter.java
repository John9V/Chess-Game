package packageVaganov;

/** Used to start the game. Instantiates a board and draws it. */
public class Starter {

    public static void main(String[] args) {
        
        Board b = new ChessBoard();
        //b.draw();
        
        Board b2 = new ChessBoard3D();
        b2.draw();
      
    }

}
