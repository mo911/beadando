package progkornybeadando;

import progkornybeadando.FrameController.HorizontalAlignment;
import progkornybeadando.FrameController.VerticalAlignment;

/**
 * A program belépési pontja.
 * @author Ádám
 *
 */
public class Main {

	public static void main(String[] args) {
		//FrameController.setTextHorizontalAlign("LEFT");
				//FrameController.setTextVerticalAlign("BOTTOM");
				//FrameController.setKeret("*/*-abcd");
				//System.out.println(FrameController.showFrame("Ez itt a szoveg\n ez meg egy új sor\nez meg egy újabb \n de mostmár elég",10,30));
				String s = "Ez itt a szoveg\n ez meg egy új sor\nez meg egy újabb \n de mostmár elég";
				//String keret = "/*+-abcd";
				//FrameController.setKeret(keret);
				//System.out.println(FrameController.showFrame(s, 10, 30));
				//System.out.println(FrameController.showFrame(s, 10, 30));
				System.out.println(FrameController.shieldingFrame(s,10,30,FrameController.VerticalAlignment.CENTER,FrameController.HorizontalAlignment.CENTER,'#'));
				//System.out.println(FrameController.frame(s, 10, 30,VerticalAlignment.BOTTOM,HorizontalAlignment.LEFT));
				//System.out.println(FrameController.frame(s, 10, 30,VerticalAlignment.TOP,HorizontalAlignment.RIGHT));
				//System.out.println(FrameController.shieldingFrame(s, 10, 30,VerticalAlignment.TOP,HorizontalAlignment.LEFT,'$'));
	}

}
