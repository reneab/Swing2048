package components.physical;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import components.game.Grid;

public class GridPanel extends JPanel {

    public GridPanel( Grid grid ) {
        setBackground( Color.gray );
        setLayout( new GridLayout( 5, 5 ) );

        for ( int i = 0; i < 5; i++ ) {
            for ( int j = 0; j < 5; j++ ) {
                add( new Square( grid.getCell( i, j ) ) );
            }
        }
    }

}
