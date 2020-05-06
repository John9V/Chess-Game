package packageVaganov;

/** Used to keep track of turns. */
public class GameControl {
    private int playerToMoveNext;
    private int players;
    
    public GameControl(int p) {
        players = p;
        playerToMoveNext = 1; //player 1 makes the first move
    }
    
    /** Alternates turns among the players. */
    public void registerMove() {
        playerToMoveNext++;
        System.out.println("registered move");
        if (playerToMoveNext > players) {
            playerToMoveNext = 1;
        }
    }
    
    /** Returns the integer representing the player who is to move next. */
    public int getPlayerTurn() {
        return playerToMoveNext;
    }
    
}
