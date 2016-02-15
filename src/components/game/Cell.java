package components.game;

import java.util.Observable;

public class Cell extends Observable {
    private Tile tile;

    public Cell() {
        this.tile = null;
    }

    public Cell( Tile tile ) {
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile( Tile tile ) {
        this.tile = tile;
        setChanged();
        notifyObservers( display() );
    }

    public String display() {
        return ( !isEmpty() ? String.valueOf( tile.getValue() ) : " " );
    }

    public boolean isEmpty() {
        return ( null == tile );
    }

    public int getTileValue() {
        return tile.getValue();
    }
}
