package Presentacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Logic.Othello;

public class FOthello extends JFrame {
	PTablero pTablero;
	private Othello othello;
	private JLabel numeroFichas;

	public static void main(String[] args) {
		Othello othello = new Othello();
		FOthello fOthello = new FOthello(othello);
		fOthello.setVisible(true);
		fOthello.pTablero.actualizarTablero();

	}

	public FOthello(Othello othello) {
		this.setTitle("Othello");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.numeroFichas = new JLabel(
				"Blancas: " + othello.verFichasBlancas() + " Negras : " + othello.verFichasNegras());
		this.add(numeroFichas, BorderLayout.NORTH);
		JButton bIniciar = new JButton("Reiniciar");
		this.add(bIniciar, BorderLayout.SOUTH);
		bIniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Othello othello2 = new Othello();
				FOthello fOthello = new FOthello(othello2);
				fOthello.setVisible(true);
				fOthello.pTablero.actualizarTablero();
				dispose();
			}
		});

		this.othello = othello;
		this.pTablero = new PTablero(this.othello, this);
		this.pTablero.setVisible(true);
		this.add(this.pTablero, BorderLayout.CENTER);

	}

	public void actualizarNumeroFichas() {
		numeroFichas.setText("Blancas: " + othello.verFichasBlancas() + " Negras : " + othello.verFichasNegras());
	}

}