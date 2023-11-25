package Presentacion;
import Logic.Othello;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PTablero extends JPanel implements MouseListener {
    private Othello othello;
    private int[][] matrizJuego;

    private int turno=2;

    public PTablero(Othello othello) {
        this.othello = othello;
		this.addMouseListener(this);
		

	  }
	
	
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(new Color(1, 176, 105));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));
        for(int i=this.getWidth()/8; i<this.getWidth(); i+=this.getWidth()/8) {
            g2d.drawLine(i, 0, i, this.getHeight());
        }
        for(int i=this.getHeight()/8; i<this.getHeight(); i+=this.getHeight()/8) {
            g2d.drawLine(0, i, this.getWidth(), i);
        }
        //super.paint(g);
        if (this.matrizJuego != null) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.matrizJuego[i][j] == 1) {
                        Image img = new ImageIcon("img/millonarios.png").getImage();
                        g2d.drawImage(img, j * this.getWidth() / 8, i * this.getHeight() / 8, this.getWidth() / 8, this.getHeight() / 8, this);
                    } else if (this.matrizJuego[i][j] == 2) {
                        Image img = new ImageIcon("img/nacional.png").getImage();
                        g2d.drawImage(img, j * this.getWidth() / 8, i * this.getHeight() / 8, this.getWidth() / 8, this.getHeight() / 8, this);
                    }
                }
            }
        }
    }


	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int coord1 = x / (this.getWidth() / 8);
		int coord2 = y / (this.getHeight() / 8);
		System.out.println("Coords:"+ coord2 + coord1);

		if (getTurno()% 2 == 0) {
			if (othello.esMovimientoLegalNegras(coord2, coord1)) {
				
				othello.realizarMovimientoNegras(coord2, coord1);
				actualizarTablero();				
				setTurno(getTurno() + 1);
		        othello.actualizarMovimientosLegales(1, othello.NsugeridasN);
		        othello.actualizarMovimientosLegales(2, othello.BsugeridasB);
				othello.mostrarMatriz();
				othello.mostrarSugeridasNegras();
				othello.mostrarSugeridasBlancas();
				}
		} else {
			if (othello.esMovimientoLegalBlancas(coord2, coord1)) {
				
				othello.realizarMovimientoBlancas(coord2, coord1);
				actualizarTablero();
				setTurno(getTurno() + 1);
		        othello.actualizarMovimientosLegales(1, othello.NsugeridasN);
		        othello.actualizarMovimientosLegales(2, othello.BsugeridasB);

				othello.mostrarMatriz();
				othello.mostrarSugeridasNegras();
				othello.mostrarSugeridasBlancas();
			}

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		      

	public void actualizarTablero() {
	    this.matrizJuego = this.othello.getMatriz();
	    this.repaint();
	}


	public int getTurno() {
		return turno;
	}


	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	

		
		  }
		  


