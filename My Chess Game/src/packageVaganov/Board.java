package packageVaganov;

public interface Board {
    
    public void draw();
    
    public void selectTile(Tile t);
    
    public Tile getSelectedTile();
    
    public boolean isTileOccupied(int x, int y, int z);
    
    public Tile getPreviousTile();
    
}
