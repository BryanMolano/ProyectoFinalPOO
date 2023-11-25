package Presentacion;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Logic.Othello;






public class FOthello extends JFrame {
	private PTablero pTablero;
	private Othello othello;
	
	
	public static void main(String[] args) {
		Othello othello = new Othello();
        FOthello fOthello = new FOthello(othello);
        fOthello.setVisible(true);
        fOthello.pTablero.actualizarTablero(); 
        
    }
	public FOthello(Othello othello) {
		this.setTitle("Othello");
		this.setSize(600,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JButton bIniciar = new JButton("Iniciar");
		this.add(bIniciar, BorderLayout.SOUTH);
		bIniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.othello = othello;
        this.pTablero = new PTablero(this.othello);
        this.pTablero.setVisible(true);
        this.add(this.pTablero, BorderLayout.CENTER);
	    
		
	}
	

	

	
}