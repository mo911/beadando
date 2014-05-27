package progkornybeadando;
/**
 * Beállítja a keretre az árnyékolást.
 * A statikus shielding metódusát meghívva elvégzi a megadott stringen az árnyékolást.
 * @author Ádám
 *
 */
public class Shielding {
	/**
	 * Alapértelmezett árnyékoló karakter.
	 */
	static char character = '#';
	
	/**
	 * Beállítja a megkapott stringre az árnyékolást.
	 * @param s egy String amire rá szeretnénk tenni az árnyékolást
	 * @return Visszatér a paraméterben megkapott stringel és a hozzá fűzött árnyékolással.
	 */
	public static String shielding(String s){
		StringBuilder tarolo = new StringBuilder();
		Text newtext = new Text(s);
		int utolso_elem = 0;
		for(int i=0;i<newtext.getStringHeightSize();i++){
			String row = newtext.getNextRows();
			tarolo.append(row+Shielding.getCharacter()+"\n");
			utolso_elem = row.length();
		}
		for(int j=0;j<2;j++){
			utolso_elem -= 1;
			for(int i=0;i<utolso_elem;i++){
				tarolo.append(Shielding.getCharacter());
			}
			tarolo.append("\n");
		}
		tarolo.append("");
		return tarolo.toString();
	}
	
	/**
	 * Visszaadja a beállított árnyékolókaraktert.
	 * @return árnyékoló karakter
	 */
	static char getCharacter(){
		return Shielding.character;
	}
	/**
	 * Beállítja az árnyékoló karaktert.
	 * @param c a felhasználó által megadott árnyékoló karakter.
	 */
	static void setCharacter(char c){
		Shielding.character = c;
	}
}
