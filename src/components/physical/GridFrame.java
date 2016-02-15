package components.physical;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import components.game.Grid;

public class GridFrame extends JFrame {

    private Grid grid;

    public GridFrame(Grid grid) {
    	this.grid = grid;
    	
        setTitle( "Game console" );
        setSize( 300, 300 );
        setResizable( false );
        setBackground( Color.white );
        setLocation( 300, 300 );
        setContentPane( new GridPanel( grid ) );
        this.addKeyListener( new Keyboard() );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

    public Grid getGrid() {
        return grid;
    }

    class Keyboard implements KeyListener {

        @Override
        public void keyTyped( KeyEvent e ) {
        }

        @Override
        public void keyPressed( KeyEvent e ) {
            if ( !grid.checkWin() ) {
                switch ( e.getKeyCode() ) {
                case 37:
                    System.out.println( "Moving left" );
                    grid.moveLeft();
                    break;
                case 38:
                    System.out.println( "Moving up" );
                    grid.moveUp();
                    break;
                case 39:
                    System.out.println( "Moving right" );
                    grid.moveRight();
                    break;
                case 40:
                    System.out.println( "Moving down" );
                    grid.moveDown();
                    break;
                }
                grid.addRandomTile();
                grid.incrementPlays();

            } else {
                setContentPane( new WinningPanel( grid ) );
                revalidate();
            }

        }

        @Override
        public void keyReleased( KeyEvent e ) {
        }

    }
}
