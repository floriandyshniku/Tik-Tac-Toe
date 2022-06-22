package projekt2;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	public static void shfaqTabelen(char[][] tabela) {
		System.out.println("---------");
		for (char[] r : tabela) {
			System.out.println(Arrays.toString(r));
		}
		System.out.println("---------");
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[][] tabela = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
		char simboli1 = 'X', simboli2 = 'O';
		char lojtariSimbol = simboli1;
		shfaqTabelen(tabela);
		if ((byte) (Math.random() * 2) == 1) {
			lojtariSimbol = simboli2;
		}
		System.out.println("Lojtari me simbolin '" + lojtariSimbol + "' ka radhen per te vendosur ne tabele.");
		System.out.print("Vendos numrin identifikues te rreshtit [1-3]: ");
		int ir = input.nextInt();
		while (ir < 1 || ir > 3) {
			System.out.println("Input i papershtatshem!");
			System.out.print("Vendos numrin identifikues te rreshtit [1-3]: ");
			ir = input.nextInt();
		}
		System.out.print("Vendos numrin identifikues te kolones [1-3]: ");
		int ik = input.nextInt();
		while (ik < 1 || ik > 3) {
			System.out.println("Input i papershtatshem!");
			System.out.print("Vendos numrin identifikues te kolones [1-3]: ");
			ik = input.nextInt();
		}
		if (tabela[ir - 1][ik - 1] != '-') {
			System.out.println("Input i papershtatshem!");
		}
		tabela[ir - 1][ik - 1] = lojtariSimbol;
		shfaqTabelen(tabela);
		if(lojtariSimbol == simboli1) {
			lojtariSimbol = simboli2;
		}
		else {
			lojtariSimbol = simboli1;
		}

		while (kaFitues(tabela) == false && mundTeKeteFitues(tabela)  ) {
			/////

			System.out.println("Lojtari me simbolin '" + lojtariSimbol + "' ka radhen per te vendosur ne tabele.");
			System.out.print("Vendos numrin identifikues te rreshtit [1-3]: ");
			ir = input.nextInt();
			while (ir < 1 || ir > 3) {
				System.out.println("Input i papershtatshem!");
				System.out.print("Vendos numrin identifikues te rreshtit [1-3]: ");
				ir = input.nextInt();
			}
			System.out.print("Vendos numrin identifikues te kolones [1-3]: ");
			ik = input.nextInt();
			while (ik < 1 || ik > 3) {
				System.out.println("Input i papershtatshem!");
				System.out.print("Vendos numrin identifikues te kolones [1-3]: ");
				ik = input.nextInt();
			}
			if (tabela[ir - 1][ik - 1] != '-') {
				System.out.println("Input i papershtatshem!");
				continue;
			}
			tabela[ir - 1][ik - 1] = lojtariSimbol;
			shfaqTabelen(tabela);
			if(lojtariSimbol == simboli1) {
				lojtariSimbol = simboli2;
			}
			else {
				lojtariSimbol = simboli1;
			}
		}
		if(lojtariSimbol == simboli1) {
			lojtariSimbol = simboli2;
		}
		else {
			lojtariSimbol = simboli1;
		}
		if(kaFitues(tabela)) {
			System.out.println("Fituesi eshte " + lojtariSimbol + ".");
		}
		else {
			System.out.println("Loja doli barazim!");
		}
		
	}

	private static boolean mundTeKeteFitues(char [][] tabela) {
		for (int i = 0; i < tabela.length; i++) {
			if(kaDeriNe1Simbol(tabela[i]) ||
					   kaDeriNe1Simbol(konvertoNeVektorKolonen(tabela, i))) {
						return true;
					}
			if(kaDeriNe1Simbol(konvertoNeVektorDiagonale1(tabela)) ||
					   kaDeriNe1Simbol(konvertoNeVektorDiagonale2(tabela))) {
						return true;
					}
		}
		return false;
	}

	private static boolean kaDeriNe1Simbol(char[] v) {
		String str = "";
		for (int i = 0; i < v.length; i++) {
			if (v[i] == 'O' || v[i] == 'X') {
				str = str + v[i];
				
			}
		}
		return str.length() <= 2;
	}

	private static boolean kaFitues(char[][] tabela) {
		for (int i = 0; i < tabela.length; i++) {
			if (kaTeNjejtinSimbol(tabela[i]) 
				|| kaTeNjejtinSimbol(konvertoNeVektorKolonen(tabela, i))) {
              return true;
			}
			if(kaTeNjejtinSimbol(konvertoNeVektorDiagonale1(tabela)) 
		    ||kaTeNjejtinSimbol(konvertoNeVektorDiagonale2(tabela))) {
						return true;
					}
		}
		return false;

	}


	private static char[] konvertoNeVektorDiagonale2(char[][] tabela) {
		char[] v = new char[tabela.length];
		int r = tabela.length;
		for (int i = 0; i < v.length; i++) {
			r--;
			v [i] = tabela [i][r];
		}
		return v;
	}

	private static char [] konvertoNeVektorDiagonale1(char[][] tabela) {
		char[] v = new char[tabela.length];
		for (int i = 0; i < v.length; i++) {
				v [i] = tabela[i][i];
			
		}
	
	return v;
	}

	private static char[] konvertoNeVektorKolonen(char[][] tabela, int i) {
		if (i < 0 || i > tabela.length) {
			return null;
		}
		char[] v = new char[tabela.length];
		for (int j = 0; j < v.length; j++) {
			v[j] = tabela[j][i];
		}
		return v;
	}

	private static boolean kaTeNjejtinSimbol(char[] v) {
		if (v == null) {
			return false;
		}
		if (v[0] == '-' || v[1] == '-' || v[2] == '-') {
			return false;
		}
		if (v[0] == 'X' && v[1] == 'X' && v[2] == 'X') {
			return true;
		}
		if (v[0] == 'O' && v[1] == 'O' && v[2] == 'O') {
			return true;
		}
		return false;
	}
}
