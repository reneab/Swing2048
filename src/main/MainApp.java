package main;

import java.io.IOException;

import javax.swing.SwingUtilities;

import components.game.Grid;
import components.physical.GridFrame;

public class MainApp {

	public static final int WINNING_VALUE = 64;
	
    public static void main( String[] args ) throws IOException {

        SwingUtilities.invokeLater( new Runnable() {

            @Override
            public void run() {
            	System.out.println("Starting game with winning value = " + WINNING_VALUE);
                GridFrame window = new GridFrame(new Grid(WINNING_VALUE));
                window.setVisible( true );
            }

        } );

    }

}
