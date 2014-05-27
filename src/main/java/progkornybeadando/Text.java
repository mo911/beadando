package progkornybeadando;

import java.util.ArrayList;
/**
 * Ennek az osztálynak a segítségével tudjuk a szöveget kiiratni. 
 * Feldarabolja a szövegetés meghatározza ,hogy melyik a következő elem.
 * @author Ádám
 *
 */
public class Text {
	/**
	 * A beállítandó szöveg.
	 */
	protected String szoveg = null;
	/**
	 * Ez az attribútum tartalmazza, hogy melyik a következő elem.
	 */
	protected int next = 0;
	/**
	 * A feldarabolt szöveget tartalmazza.
	 */
	protected ArrayList<String> splitSzoveg;
	
	protected int rows_id = 0;
	
	/**
	 * Beállítja az adott példányban a szöveget.
	 * @param s a felhasználó által megadott string
	 */
	public void setString(String s){
		this.szoveg = s;
	}
	
	Text(String s){
		this.szoveg = s;
	}
	
	
	/**
	 * Visszaadja a felhasználó által megadott szöveget.
	 * @return string a felhasználó által megadott szöveg
	 */
	public String getString(){
		return this.szoveg;
	}
	
	/**
	 * Visszaadja a következő id- string értéket.
	 * @param id string key
	 * @return visszatér egy stringel amiből el van távolítva a felesleges szóközök
	 */
	private String getNextStringID(int id){
		this.getSplitSzoveg();
		return splitSzoveg.get(id).trim();
	}
	
	public String getNextRows(){
		String res = this.getNextStringID(rows_id);
		this.rows_id++;
		return res;
	}
	/**
	 * Visszaadja a feldarabolt szöveget. Ha a szöveg még nem volt feldarabolva, akkor
	 * feldarabolja a szöveget.
	 * @return visszatér a feldarabolt stringel.
	 */
	private ArrayList<String> getSplitSzoveg(){
		if(splitSzoveg == null){
			this.splitText();
		}
		return splitSzoveg;
	}
	
	/**
	 * Feldarabolja a felhasználó által megadott stringet.
	 * @return visszatér egy ArrayListel amiben a feldarabolt szöveg szerepel.
	 */
	protected ArrayList<String> splitText(){
		splitSzoveg = new ArrayList<String>();
		String split[] = this.getString().split("\n");
		for(String i : split){
			splitSzoveg.add(i);
		}
		return splitSzoveg;
	}
	/**
	 * Visszaadja a string feldarabolt magasságát.
	 * @return a feldrabolt string magassága
	 */
	public int getStringHeightSize(){
		return splitText().size();
	}
	
	/**
	 * Vissszaaja a paraméterben megadott string hosszát.
	 * @param s - a feldarabolt string egyik sora
	 * @return visszatér az adott string hosszával
	 */
	public int getStringWidthSize(String s){
		return s.length();
	}
	
}
