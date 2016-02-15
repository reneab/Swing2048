package components.physical;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import components.game.Grid;

public class WinningPanel extends JPanel {

    public WinningPanel( Grid grid ) {
        setBackground( Color.orange );
        setLayout( new BorderLayout() );
        add( new JLabel( "Congratulations, you reached " + grid.getWinningValue() + " !!"), BorderLayout.CENTER );
        add( new JLabel( "Number of turns : " + grid.getPlays() ), BorderLayout.SOUTH );
    }
}
