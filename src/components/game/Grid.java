package components.game;

public class Grid {
    private Cell[][]  cells         = new Cell[5][5];
    private int       plays         = 0;

    private final int winningValue;

    public Grid(int winningValue) {
    	this.winningValue = winningValue;
        for ( int i = 0; i < 5; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                cells[i][j] = new Cell();
            }
        }
        addRandomTile();
    }

    public int getWinningValue() {
    	return this.winningValue;
    }
    
    public void addRandomTile() {
        int randCol;
        int randRow;
        do {
            randCol = (int) ( Math.random() * 5 );
            randRow = (int) ( Math.random() * 5 );
        } while ( !cells[randRow][randCol].isEmpty() );
        cells[randRow][randCol].setTile( new Tile( 2 ) );
    }

    public int getPlays() {
        return plays;
    }

    public void incrementPlays() {
        plays++;
    }

    public Cell getCell( int i, int j ) {
        return cells[i][j];
    }

    public void moveRight() {
        for ( int i = 0; i < 5; i++ ) {
            for ( int j = 4; j > -1; j-- ) {
                if ( !cells[i][j].isEmpty() && j < 4 ) {
                    int a = j;
                    while ( a < 4 ) {
                        if ( cells[i][a + 1].isEmpty() ) {
                            cells[i][a + 1].setTile( cells[i][a].getTile() );
                            cells[i][a].setTile( null );
                        } else if ( cells[i][a + 1].getTileValue() == cells[i][a].getTileValue() ) {
                            cells[i][a + 1].setTile( new Tile( 2 * cells[i][a].getTileValue() ) );
                            cells[i][a].setTile( null );
                        }
                        a++;
                    }
                }
            }
        }
    }

    public void moveLeft() {
        for ( int i = 0; i < 5; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                if ( !cells[i][j].isEmpty() && j > 0 ) {
                    int a = j;
                    while ( a > 0 ) {
                        if ( cells[i][a - 1].isEmpty() ) {
                            cells[i][a - 1].setTile( cells[i][a].getTile() );
                            cells[i][a].setTile( null );
                        } else if ( cells[i][a - 1].getTileValue() == cells[i][a].getTileValue() ) {
                            cells[i][a - 1].setTile( new Tile( 2 * cells[i][a].getTileValue() ) );
                            cells[i][a].setTile( null );
                        }
                        a--;
                    }
                }
            }
        }
    }

    public void moveUp() {
        for ( int i = 0; i < 5; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                if ( !cells[i][j].isEmpty() && i > 0 ) {
                    int a = i;
                    while ( a > 0 ) {
                        if ( cells[a - 1][j].isEmpty() ) {
                            cells[a - 1][j].setTile( cells[a][j].getTile() );
                            cells[a][j].setTile( null );
                        } else if ( cells[a - 1][j].getTileValue() == cells[a][j].getTileValue() ) {
                            cells[a - 1][j].setTile( new Tile( 2 * cells[a][j].getTileValue() ) );
                            cells[a][j].setTile( null );
                        }
                        a--;
                    }
                }
            }
        }
    }

    public void moveDown() {
        for ( int i = 4; i > -1; i-- ) {
            for ( int j = 0; j < 5; j++ ) {
                if ( !cells[i][j].isEmpty() && i < 4 ) {
                    int a = i;
                    while ( a < 4 ) {
                        if ( cells[a + 1][j].isEmpty() ) {
                            cells[a + 1][j].setTile( cells[a][j].getTile() );
                            cells[a][j].setTile( null );
                        } else if ( cells[a + 1][j].getTileValue() == cells[a][j].getTileValue() ) {
                            cells[a + 1][j].setTile( new Tile( 2 * cells[a][j].getTileValue() ) );
                            cells[a][j].setTile( null );
                        }
                        a++;
                    }
                }
            }
        }
    }

    public boolean checkWin() {
        for ( int i = 0; i < 5; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                if ( !cells[i][j].isEmpty() && cells[i][j].getTileValue() == winningValue ) {
                    return true;
                }
            }
        }
        return false;
    }
}
