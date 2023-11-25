package Logic;

import java.util.ArrayList;

public class Othello {
	private int matriz[][]= {
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 2, 1, 0, 0, 0},
			{0, 0, 0, 1, 2, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0}
			};
	
	public ArrayList<String> NsugeridasN;
	public ArrayList<String> BsugeridasB;
	
	public Othello() {
		this.BsugeridasB = new ArrayList<String>();
		this.NsugeridasN = new ArrayList<String>();
		this.actualizarMovimientosLegales(1, NsugeridasN);
		this.actualizarMovimientosLegales(2, BsugeridasB);
		this.mostrarMatriz();
		this.mostrarSugeridasNegras();
		this.mostrarSugeridasBlancas();

		
		
	}


	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int matriz[][]) {
		this.matriz = matriz;
	}
	
	public void mostrarMatriz() {
	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[i].length; j++) {
	            System.out.print(matriz[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
	public void mostrarSugeridasNegras() {
		System.out.println("Las fichas sugeridas negras son:");
		for(String sugeridaNegra:NsugeridasN) {
			System.out.println(sugeridaNegra);
		}
	}
	public void mostrarSugeridasBlancas() {
		System.out.println("Las fichas sugeridas blancas son:");
		for(String sugeridaBlanca:BsugeridasB) {
			System.out.println(sugeridaBlanca);
		}
	}
	public boolean esMovimientoLegalNegras(int x, int y) {
		String coordenadaClick = x + "," + y;
		for(String fichaSugeridaNegra: NsugeridasN) {
			if(fichaSugeridaNegra.equals(coordenadaClick)) {
				return true;
			}
			
		}
		return false;
		
	}
	
	public void realizarMovimientoNegras(int x, int y) {
		matriz[x][y] = 1;
		voltearFichas(x, y, 1);
		this.actualizarMovimientosLegales(1, NsugeridasN);
		this.actualizarMovimientosLegales(1, BsugeridasB);


	}
	
	public boolean esMovimientoLegalBlancas(int x, int y) {
		String coordenadaClick = x + "," + y;
		for(String fichaSugeridaBlanca: BsugeridasB) {
			if(fichaSugeridaBlanca.equals(coordenadaClick)) {
				BsugeridasB.removeAll(BsugeridasB);
				return true;
				
			}
			
		}
		return false;
		
	}
	

	public void realizarMovimientoBlancas(int x, int y) {
	    matriz[x][y] = 2;
		voltearFichas(x, y, 2);

	    this.actualizarMovimientosLegales(1, NsugeridasN);
		this.actualizarMovimientosLegales(1, BsugeridasB);
	}

	
	
	
	public void voltearFichas(int x, int y, int jugador) {
	    int oponente = 3 - jugador;

	    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	    for (int dir = 0; dir < 8; dir++) {
	        int i = x + dx[dir];
	        int j = y + dy[dir];

	        if (i >= 0 && i < 8 && j >= 0 && j < 8 && matriz[i][j] == oponente) {
	            do {
	                i += dx[dir];
	                j += dy[dir];
	            } while (i >= 0 && i < 8 && j >= 0 && j < 8 && matriz[i][j] == oponente);
	            
	            if (i >= 0 && i < 8 && j >= 0 && j < 8 && matriz[i][j] == jugador) {
	                int xi = x + dx[dir];
	                int yj = y + dy[dir];
	                while (xi != i || yj != j) {
	                    matriz[xi][yj] = jugador;
	                    xi += dx[dir];
	                    yj += dy[dir];
	                }
	            }
	        }
	    }
	}


	
	
	public void actualizarMovimientosLegales(int jugadorActual, ArrayList<String> movimientosLegales) {
	    int oponente = 3 - jugadorActual;
	    movimientosLegales.clear();

	    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	    for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            if (matriz[i][j] == jugadorActual) {
	                for (int dir = 0; dir < 8; dir++) {
	                    int x = i + dx[dir];
	                    int y = j + dy[dir];
	                    if (x >= 0 && x < 8 && y >= 0 && y < 8 && matriz[x][y] == oponente) {
	                        do {
	                            x += dx[dir];
	                            y += dy[dir];
	                        } while (x >= 0 && x < 8 && y >= 0 && y < 8 && matriz[x][y] == oponente);
	                        if (x >= 0 && x < 8 && y >= 0 && y < 8 && matriz[x][y] == 0) {
	                            movimientosLegales.add(x + "," + y);
	                        }
	                    }
	                }
	            }
	        }
	    }
	}
}

