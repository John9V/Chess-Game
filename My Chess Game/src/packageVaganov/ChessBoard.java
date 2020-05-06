package packageVaganov;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** Creates tiles, puts pieces on them and stores them in an array. */
public class ChessBoard extends Application implements Board{
    Board thisBoard = this;
    final int numOfTiles = 64;
    final int sideLength = 8;
    Tile[][] tiles;
    Tile selectedTile;
    Tile previousTile;
    ColorSet colorSet; //default color set
    Color whitePieceColor;
    Color blackPieceColor;
    Color whiteTileColor;
    Color blackTileColor;
    GameControl control = new GameControl(2); //two players
    static final int Z = 0;
    
    public ChessBoard() {
        tiles = new Tile[sideLength][sideLength];
        colorSet = new ColorSet(1, 1);
        whitePieceColor = colorSet.getTeamColor(1);
        blackPieceColor = colorSet.getTeamColor(2);
        whiteTileColor = colorSet.getTileColor(1);
        blackTileColor = colorSet.getTileColor(2);
    }
    
    /** Checks the occupancy of a tile given its x and y. */
    public boolean isTileOccupied(int x, int y, int z) {
        if (x > 7 || y > 7 || x < 0 || y < 0) {
            return true;
        }
        if (tiles[y][x].isOccupied()) {
            return true;
        }
        return false;
    }
    
    /** Sets the specified tile as the selected one and adjusts the previous
     *  tile accordingly */
    public void selectTile(Tile t) {
        previousTile = selectedTile;
        selectedTile = t;
    }
    
    /** Returns the currently selected tile. */
    public Tile getSelectedTile() {
        return selectedTile;
    }
    
    /** returns the previous tile. */
    public Tile getPreviousTile() {
        return previousTile;
    }
    
    public void draw() {
        launch();
    }
    
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        setUpTiles(root);

        Scene scene = new Scene(root, 415, 415, Color.BLACK);
        primaryStage.setTitle("My Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    /** Creates tiles and stores them in an array. */
    private void setUpTiles(Group g) {
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    tiles[i][j] = new Tile(this, i, j, Z, whiteTileColor, control);
                } else {
                    tiles[i][j] = new Tile(this, i, j, Z, blackTileColor, control);
                }
                selectedTile = tiles[i][j];
                selectedTile.draw(g);
                setUpPiece(i, j);
            }
        }
        selectedTile = null;
        previousTile = null;
    }
    
    /** Puts the starting pieces on the needed tiles. */
    private void setUpPiece(int y, int x) {
        int team = 1; //white team
        if (x == 7 && y == 7 || x == 0 && y == 7) {
            Piece wr = new Rook(team, whitePieceColor, thisBoard);
            selectedTile.setStoredPiece(wr);
        }
        if (x == 6 && y == 7 || x == 1 && y == 7) {
            Piece wn = new Knight(team, whitePieceColor, thisBoard);
            selectedTile.setStoredPiece(wn);
        }
        if (x == 5 && y == 7 || x == 2 && y == 7) {
            Piece wb = new Bishop(team, whitePieceColor, thisBoard);
            selectedTile.setStoredPiece(wb);
        }
        if (x == 4 && y == 7) {
            Piece wk = new King(team, whitePieceColor, thisBoard);
            selectedTile.setStoredPiece(wk);
        }
        if (x == 3 && y == 7) {
            Piece wq = new Queen(team, whitePieceColor, thisBoard);
            selectedTile.setStoredPiece(wq);
        }
        if (y == 6) {
            Piece wp = new Pawn(team, whitePieceColor, thisBoard);
            selectedTile.setStoredPiece(wp);
        }
        
        team = 2; //black team
        if (x == 0 && y == 0 || x == 7 && y == 0) {
            Piece br = new Rook(team, blackPieceColor, thisBoard);
            selectedTile.setStoredPiece(br);
        }
        if (x == 1 && y == 0 || x == 6 && y == 0) {
            Piece bn = new Knight(team, blackPieceColor, thisBoard);
            selectedTile.setStoredPiece(bn);
        }
        if (x == 2 && y == 0 || x == 5 && y == 0) {
            Piece bb = new Bishop(team, blackPieceColor, thisBoard);
            selectedTile.setStoredPiece(bb);
        }
        if (x == 4 && y == 0) {
            Piece bk = new King(team, blackPieceColor, thisBoard);
            selectedTile.setStoredPiece(bk);
        }
        if (x == 3 && y == 0) {
            Piece bq = new Queen(team, blackPieceColor, thisBoard);
            selectedTile.setStoredPiece(bq);
        }
        if (y == 1) {
            Piece bp = new Pawn(team, blackPieceColor, thisBoard);
            selectedTile.setStoredPiece(bp);
        }
        
    }
    
}
