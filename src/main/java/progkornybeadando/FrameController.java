package progkornybeadando;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Ez az osztály a megadott Stringgel különbőző módokon végez műveletet.
 * Három statikus metódus van:
 * <ul>
 *   <li>1.) showFrame(...)</li>
 *   <li>2.) frame(...)</li>
 *   <li>3.) shieldingFrame(...)</li>
 * </ul>
 * Ezeket a metódusokat felhasználva lehet a szöveget formázni.
 * @author Ádám
 *
 */
public class FrameController {
	/**
	 * Alapértelmezett függőleges pozicionálás.
	 */
	private String valign = "CENTER";
	/**
	 * Alapértelmezett vízszintes pozicionálás.
	 */
	private String halign = "CENTER";
	/**
	 * Keret magassága.
	 */
	static int height;
	/**
	 * Keret szélessége.
	 */
	static int width;
	/**
	 * Alapértelmezett keret jelölő értékek.
	 * Balról jobbra: bal felső sarok, bal alsó sarok, jobb alsó sarok, jobb felső sarok
	 * bal oldal, jobb oldal, felso oldal és alsó oldal.
	 */
	static char jfs = '+',jls = '+',bfs = '+',bls = '+',bal = '|',jobb = '|',felso = '-',also = '-';
	/**
	 * A logger példányosítása. 
	 */
	private static Logger logger = LoggerFactory.getLogger(FrameController.class);
	
	private Text text = null;
	
	/**
	 * Függőleges enum értékek.
	 */
	public static enum VerticalAlignment {
		/**
		 * A keret tetejére igazítás.
		 */
        TOP,
        /**
         * A keret közepére igazítás.
         */
        CENTER,
        /**
         * A keret alsó részéhez való igazítás.
         */
        BOTTOM;
    }
	
	/**
	 * Vízszintes enum értékek.
	 */
	public static enum HorizontalAlignment {
		/**
		 * A kerethez vízszintes baloldalra igazítás.
		 */
        LEFT,
        /**
         * A kerethez vízszintes középre igazítás.
         */
        CENTER,
        /**
         * A kerethez vízszintes jobbra igazítás.
         */
        RIGHT;
    }
	
	/**
	 * E metódus meghívásával van lehetőség a keret beállítására.
	 * A metódust mindenképp a keret kirajzolása előtt kell meghívni.
	 * @param s - a felhasználó által megadott 8 karakter hosszúságú String
	 * Az első karakter a bal felső szegélyt jelzi.
	 * A második karakter a bal alsó szegélyt.
	 * A harmadik karakter a jobb alsó szegélyt.
	 * A negyedik karakter a jobb felső szegélyt.
	 * Az ötödik karakter a felső oldalt.
	 * A hatodik karakter a bal oldalt.
	 * A hetedik karakter az alsó oldalt.
	 * A nyolcadik karakter a jobb oldalt.
	 * @return 
	 * 	<ul>
	 * 		<li>
	 * 			<b>true</b> ha sikerült a beállítás
	 * 		</li>
	 * 		<li>
	 * 			<b>false</b> ha nem sikerült a beállítás
	 * 		</li>
	 * </ul>
	 */
	public static boolean setKeret(String s){
		if(s.length() == 8){
			FrameController.jfs = s.charAt(0);
			FrameController.jls = s.charAt(1);
			FrameController.bls = s.charAt(2);
			FrameController.bfs = s.charAt(3);
			FrameController.felso = s.charAt(4);
			FrameController.bal = s.charAt(5);			
			FrameController.also = s.charAt(6);			
			FrameController.jobb = s.charAt(7);	
			logger.info("Sikeres keret karakter beállítás");
			return true;
		}else{
			logger.error("Sikeretelen keret karakter beállítás");
			return false;
		}
	}

	/**
	 * A drawFrame() metódus végzi el a kirajzolást. 
	 * Eredményül egy formázott stringet add vissza.
	 * @return Visszaad egy stringet ami meg van formázva.
	 */
	public String drawFrame(){
		StringBuilder tarolo = new StringBuilder();
		int text_start = calculateRowStart(text.getStringHeightSize());
		for(int i=0;i<height;i++){
			if(i==0){
				for(int j=0;j<width;j++){
					if(j==0){
						tarolo.append(FrameController.jfs);
					}
					else if(j == width-1){
						tarolo.append(FrameController.bfs);
					}else{
						tarolo.append(felso);
					}
					
				}
				tarolo.append("\n");
			}
			else if(i==height-1){
				for(int j=0;j<width;j++){
					if(j==0){
						tarolo.append(FrameController.jls);
					}
					else if(j == width-1){
						tarolo.append(FrameController.bls);
					}else{
						tarolo.append(also);
					}
				}
				tarolo.append("\n");
			}
			else if(text_start == i){
				for(int j=0;j<text.getStringHeightSize();j++){
					String row = text.getNextRows();
					int start_cols = calculateColStart(text.getStringWidthSize(row));					
					tarolo.append(FrameController.bal);
					for(int k=0;k<FrameController.width-1;k++){
						if(start_cols == k){
							tarolo.append(row);
							k += text.getStringWidthSize(row);
						}else{
							tarolo.append(" ");
						}
					}
					tarolo.append(FrameController.jobb+"\n");
					
				}
				i += (text.getStringHeightSize()-1);
			}else{
				tarolo.append(FrameController.bal);
				for(int k=0;k<FrameController.width-2;k++){
					tarolo.append(" ");
				}
				tarolo.append(FrameController.jobb+"\n");
			}
			
			
		}
		return tarolo.toString();
	}

	/**
	 * Árnyékos keret kirajzolását teszi lehetővé plusz lehet a szöveg pozicionálását is állítani.
	 * @param s - a felhasználó által megadott szöveg
	 * @param height - a keret magassága
	 * @param width - a keret szélessége
	 * @param vAlignment - a szöveg függőleges pozicionálása
	 * @param hAlignment - a szöveg vízszintes pozicionálása
	 * @param character - a felhasználó által megadott árnyék kerete
	 * @return visszatér a formázott kerettel és benne a szöveggel + egy kis árnyékkal
	 */
	public static String shieldingFrame(String s, int height, int width,VerticalAlignment vAlignment, HorizontalAlignment hAlignment,char character){
		logger.info("Árnyékos kerettel rajzolás");
		FrameController keret = new FrameController(s, height, width,vAlignment, hAlignment,character);
		return Shielding.shielding(keret.drawFrame());
	}

	/**
	 * Kirajzolja a keretet szövegpozicionálással.
	 * @param s - a felhasználó által megadott szöveg
	 * @param height - keret magassága
	 * @param width - keret szélessége 
	 * @param vAlignment - függőleges szöveg pozició
	 * @param hAlignment - vízszintes pozició
	 * @return Visszatér a formázott kerettel és benne a szöveggel.
	 */
	public static String frame(String s, int height, int width,VerticalAlignment vAlignment, HorizontalAlignment hAlignment) {
		logger.info("Szöveg pozicionálásos rajzolás");
		FrameController keret = new FrameController(s, height, width, vAlignment, hAlignment);
		return keret.drawFrame();
	}
	
	/**
	 * Kirajzolja a keretet az alapértelmezett beállításokal.
	 * @param s - a felhasználó által megadott szoveg
	 * @param height - keret magassága
	 * @param width - keret szélessége
	 * @return Visszatér a formázott kerettel és benne a szöveggel.
	 */
	public static String showFrame(String s, int height, int width) {
		logger.info("Sima rajzolás");
		FrameController keret = new FrameController(s, height, width);
		return keret.drawFrame();
	}
	
	/**
	 * Leelenőrzi, hogy a megadott függőleges pozició helyes-e.
	 * @param s a felhasználó által megadott függőleges pozició	      
	 * @return 
	 * 	<ul>
	 *    <li>
	 *      <b>true</b> ha helyes a függőleges pozició
	 *    </li>
	 *    <li>
	 *      <b>false</b> ha helytelen a megadott függőleges pozició
	 *    </li>
	 *  </ul>
	 */
	public boolean isVerticalAlignment(String s){
		try{
			FrameController.VerticalAlignment.valueOf(s);
		}catch(Exception e){
			logger.error("Hibás függőleges enum érték");
			return false;
		}
		return true;
	}
	
	/**
	 * Leelenőrzi, hogy a megadott vízszintes pozició helyes-e.
	 * @param s a felhasználó által megadott vízszintes pozició	      
	 * @return 
	 * 	<ul>
	 *    <li>
	 *      <b>true</b> ha helyes a vízszintes pozició
	 *    </li>
	 *    <li>
	 *      <b>false</b> ha helytelen a megadott vízszintes pozició
	 *    </li>
	 *  </ul>
	 */
	public boolean isHorizontalAlignment(String s){
		try{
			FrameController.HorizontalAlignment.valueOf(s);
		}catch(Exception e){
			logger.error("Hibás vízszintes enum érték");
			return false;
		}
		return true;
	}
	
	/**
	 * Beállítja a felhasználó által megadott függőleges poziciót.
	 * @param s a felhasználó által megadott függőleges pozició	      
	 */
	public void setTextVerticalAlign(String s){
		if(isVerticalAlignment(s)){
			valign = s;
			logger.info("Sikeres függőleges szöveg pozició beállítás");
		}
			
	}
	/**
	 * Beállítja a felhasználó által megadott vízszintes poziciót.
	 * @param s a felhasználó által megadott vízszintes pozició	      
	 */
	public void setTextHorizontalAlign(String s){
		if(isHorizontalAlignment(s)){
			halign = s;
			logger.info("Sikeres vízszintes szöveg pozició beállítás");
		}
			
		
	}
	/**
	 * Kiszámítja, hogy az aktuális sorú szövegnek hanyadik karakternél
	 * kell kezdődnie.
	 * @param textWidth a felhasználó által megadott szöveg sortördelés utáni egyik sorának
	 * a szöveg hosszúsága
	 * @return az adott sorban hanyadik karakternél kell kezdődnie a szövegnek	      
	 */
	public int calculateColStart(int textWidth){
		if(halign == "CENTER"){
			return (width - textWidth)/2;
		}
		if(halign =="RIGHT"){
			return width - textWidth-2;
		}
		return 1;
	}
	/**
	 * Kiszámítja, hogy a szövegnek hanyadik sorban kell kezdődnie.
	 * @param textHeight a felhasználó által megadott szöveg magassága
	 * @return egy int-el tér vissza ami megadja, hogy hanyadik sorban kell elkezdeni kirajzolni a szöveget.     
	 */
	public int calculateRowStart(int textHeight){
		
		if(valign == "CENTER"){
			return (height - textHeight)/2;
		}
		if(valign =="BOTTOM"){
			return height - textHeight-1;
		}
		return 1;
	}
	
	FrameController(String s, int height, int width){
		setHeight(height);
		setWidth(width);
		text = new Text(s);
	}
	
	FrameController(String s, int height, int width,VerticalAlignment vAlignment, HorizontalAlignment hAlignment){
		setHeight(height);
		setWidth(width);
		text = new Text(s);
		setTextVerticalAlign(vAlignment.name());
		setTextHorizontalAlign(hAlignment.name());
		
	}
	
	FrameController(String s, int height, int width,VerticalAlignment vAlignment, HorizontalAlignment hAlignment,char character){
		setHeight(height);
		setWidth(width);
		text = new Text(s);
		setTextVerticalAlign(vAlignment.name());
		setTextHorizontalAlign(hAlignment.name());
		Shielding.setCharacter(character);
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
}
