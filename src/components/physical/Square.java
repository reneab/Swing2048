package components.physical;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import components.game.Cell;

public class Square extends JLabel implements Observer {

    private static final Color DEFAULT_COLOR = Color.gray;

    public Square( Cell cell ) {
        cell.addObserver( this );
        setText( cell.display() );

        setBackground( DEFAULT_COLOR );
        setForeground( Color.black );
        setFont( new Font( "Times", Font.PLAIN, 24 ) );
        setHorizontalAlignment( CENTER );
        setVerticalAlignment( CENTER );
        Border border = BorderFactory.createLineBorder( Color.BLUE, 3 );
        setBorder( border );
        setOpaque( true );
    }

    @Override
    public void update( Observable o, Object displayValue ) {
        setText( (String) displayValue );

        Cell cell = (Cell) o;
        if ( cell.isEmpty() ) {
            setBackground( DEFAULT_COLOR );
        } else {
            int value = cell.getTileValue();
            setCustomColor( value );
        }
    }

    public void setCustomColor( int value ) {
        if ( value == 2 ) {
            setBackground( new Color( 255, 255, 100 ) );
        } else {
            setBackground( new Color( 245,
                    Math.round( ( 3 * 255 ) / value ),
                    Math.round( ( 3 * 100 ) / value ) ) );
        }
    }
}
