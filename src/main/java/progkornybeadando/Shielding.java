package progkornybeadando;

import java.util.ArrayList;

/**
 * A statikus shielding() metódus meghívásával elvégzi a megadott stringen az árnyékolást.
 * @author Ádám
 *
 */
public class Shielding {
	
	protected ArrayList<String> splitSzoveg;
	
	/**
	 * Az alapértelmezett árnyékoló karakter.
	 */
	static char character = '#';
	
	/**
	 * Beállítja a megkapott stringre az árnyékolást.
	 * @param s egy String amire rá szeretnénk tenni az árnyékolást
	 * @return Visszatér a paraméterben megkapott stringel és a hozzá fűzött árnyékolással.
	 */
	public static String shielding(String s,int width){
		StringBuilder tarolo = new StringBuilder();
		String split[] = s.split("\n");
		for(String i : split){
			tarolo.append(i+Shielding.character+"\n");
		}
		for(int i=0;i<2;i++){
			for(int j=0;j<width-i;j++)
				tarolo.append(Shielding.character);
			tarolo.append("\n");
		}
		return tarolo.toString();
	}
	/**
	 * Beállítja az árnyékoló karaktert.
	 * Ezt a metódust a shielding() metódus előtt kell meghívni.
	 * @param c a felhasználó által megadott árnyékoló karakter.
	 */
	static void setCharacter(char c){
		Shielding.character = c;
	}
}
