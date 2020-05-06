package packageVaganov;

import javafx.scene.paint.Color;

/** Stores sets of colors in an array. This is used to give the same color to
 *  multiple pieces and tiles at once. */
public class ColorSet {
    int setNumberForTiles;
    int setNumberForPieces;
    
    private Color[] whiteTeamColors = {Color.rgb(235, 225, 164), Color.WHITE};
    private Color[] blackTeamColors = {Color.rgb(62, 99, 128), Color.BLACK};
    private Color[][] PieceColorSets = {whiteTeamColors, blackTeamColors};
    
    private Color[] whiteTileColors = {Color.rgb(207, 226, 230), Color.WHITE};
    private Color[] blackTileColors = {Color.rgb(78, 112, 71), Color.DARKGREY};
    private Color[][] TileColorSets = {whiteTileColors, blackTileColors};
    
    public ColorSet(int setNumForTiles, int setNumForPieces) {
        setNumberForTiles = setNumForTiles;
        setNumberForPieces = setNumForPieces;
    }
    
    public Color getTileColor(int colorIndicator) {
        return TileColorSets[colorIndicator-1][setNumberForTiles-1];
    }
    
    public Color getTeamColor(int team) {
        return PieceColorSets[team-1][setNumberForPieces-1];
    }
    
    
    
}
