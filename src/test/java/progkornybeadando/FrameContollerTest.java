package progkornybeadando;

import static org.junit.Assert.*;

import org.junit.Test;

import progkornybeadando.FrameController.HorizontalAlignment;
import progkornybeadando.FrameController.VerticalAlignment;

public class FrameContollerTest {
	/*
	@Test
	public void testKeretBeallitas() {
		assertFalse(FrameController.setKeret("abcdefghjklmno"));
		assertTrue(FrameController.setKeret("++++-|-|"));
	}
	
	@Test
	public void testVerticalAlign(){
		assertFalse(FrameController.isVerticalAlignment("eznemjó"));
		assertTrue(FrameController.isVerticalAlignment("TOP"));
	}
	
	@Test
	public void testHorizontalAlign(){
		assertFalse(FrameController.isHorizontalAlignment("eznemjó"));
		assertTrue(FrameController.isHorizontalAlignment("CENTER"));
	}
	
	@Test
	public void testCalculateCols1(){
		FrameController.width = 30;
		FrameController.height = 10;
		FrameController.setTextHorizontalAlign("CENTER");
		FrameController.setTextVerticalAlign("CENTER");		
		assertEquals(10, FrameController.calculateColStart(10));
	}
	
	@Test
	public void testCalculateCols2(){
		FrameController.width = 30;
		FrameController.height = 10;
		FrameController.setTextHorizontalAlign("LEFT");
		FrameController.setTextVerticalAlign("CENTER");		
		assertEquals(1, FrameController.calculateColStart(10));
	}
	
	@Test
	public void testCalculateCols3(){
		FrameController.width = 30;
		FrameController.height = 10;
		FrameController.setTextHorizontalAlign("LEFT");
		FrameController.setTextVerticalAlign("TOP");		
		assertEquals(1, FrameController.calculateColStart(10));
	}
	
	@Test
	public void testCalculateRows1(){
		FrameController.width = 30;
		FrameController.height = 12;
		FrameController.setTextHorizontalAlign("CENTER");
		FrameController.setTextVerticalAlign("LEFT");		
		assertEquals(4, FrameController.calculateRowStart(4));
	}
	
	@Test
	public void testCalculateRows2(){
		FrameController.width = 30;
		FrameController.height = 10;
		FrameController.setTextHorizontalAlign("CENTER");
		FrameController.setTextVerticalAlign("CENTER");		
		assertEquals(3, FrameController.calculateRowStart(4));
	}*/
	
	@Test
	public void testKeretDraw(){
		String s = "+----------------------------+\n"
				+ "|                            |\n"
				+ "|                            |\n"
				+ "|       Ez itt a szoveg      |\n"
				+ "|      ez meg egy új sor     |\n"
				+ "|       ez meg egy újabb     |\n"
				+ "|       de mostmár elég      |\n"
				+ "|                            |\n"
				+ "|                            |\n"
				+ "+----------------------------+\n";
		String szoveg = "Ez itt a szoveg\n ez meg egy új sor\nez meg egy újabb \n de mostmár elég";
		assertEquals(s, FrameController.showFrame(szoveg, 10, 30));
	}
	
	@Test
	public void testKeretDraw2(){
		String s = "+----------------------------+#\n"
				  +"|                            |#\n"
				  +"|                            |#\n"
				  +"|       Ez itt a szoveg      |#\n"
				  +"|      ez meg egy új sor     |#\n"
				  +"|       ez meg egy újabb     |#\n"
				  +"|       de mostmár elég      |#\n"
				  +"|                            |#\n"
				  +"|                            |#\n"
				  +"+----------------------------+#\n"
				  +"##############################\n"
				  +"#############################\n";
		String szoveg = "Ez itt a szoveg\n ez meg egy új sor\nez meg egy újabb \n de mostmár elég";
		assertEquals(s, FrameController.shieldingFrame(szoveg, 10, 30,FrameController.VerticalAlignment.CENTER,FrameController.HorizontalAlignment.CENTER,'#'));
	}
	
	@Test
	public void testKeretDraw3(){
		String s = "+----------------------------+\n"
				  +"|                            |\n"
				  +"|                            |\n"
				  +"|                            |\n"
				  +"|                            |\n"
				  +"| Ez itt a szoveg            |\n"
				  +"| ez meg egy új sor          |\n"
				  +"| ez meg egy újabb           |\n"
				  +"| de mostmár elég            |\n"
				  +"+----------------------------+\n";
		String szoveg = "Ez itt a szoveg\n ez meg egy új sor\nez meg egy újabb \n de mostmár elég";
		assertEquals(s, FrameController.frame(szoveg, 10, 30,VerticalAlignment.BOTTOM,HorizontalAlignment.LEFT));
	}
	
	@Test
	public void testKeretDraw4(){
		String s = "+----------------------------+\n"
				  +"|             Ez itt a szoveg|\n"
				  +"|           ez meg egy új sor|\n"
				  +"|            ez meg egy újabb|\n"
				  +"|             de mostmár elég|\n"
				  +"|                            |\n"
				  +"|                            |\n"
				  +"|                            |\n"
				  +"|                            |\n"
				  +"+----------------------------+\n";
		String szoveg = "Ez itt a szoveg\n ez meg egy új sor\nez meg egy újabb \n de mostmár elég";
		assertEquals(s, FrameController.frame(szoveg, 10, 30,VerticalAlignment.TOP,HorizontalAlignment.RIGHT));
	}
	
	@Test
	public void testKeretDraw5(){
		String s = "+----------------------------+$\n"
				  +"| Ez itt a szoveg            |$\n"
				  +"| ez meg egy új sor          |$\n"
				  +"| ez meg egy újabb           |$\n"
				  +"| de mostmár elég            |$\n"
				  +"|                            |$\n"
				  +"|                            |$\n"
				  +"|                            |$\n"
				  +"|                            |$\n"
				  +"+----------------------------+$\n"
				  +"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
				  +"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n";
		String szoveg = "Ez itt a szoveg\n ez meg egy új sor\nez meg egy újabb \n de mostmár elég";
		assertEquals(s, FrameController.shieldingFrame(szoveg, 10, 30,VerticalAlignment.TOP,HorizontalAlignment.LEFT,'$'));
	}
	
	@Test
	public void testKeretDraw6(){
		String s = "+----------------------------+\n"
				  +"|                            |\n"
				  +"|                            |\n"
				  +"|       Ez itt a szoveg      |\n"
				  +"|      ez meg egy új sor     |\n"
				  +"|       ez meg egy újabb     |\n"
				  +"|       de mostmár elég      |\n"
				  +"|                            |\n"
				  +"|                            |\n"
				  +"+----------------------------+\n";
		assertEquals(s, FrameController.showFrame("Ez itt a szoveg\n ez meg egy új sor\nez meg egy újabb \n de mostmár elég",10,30));
	}
	
	@Test
	public void testKeretDraw7(){
		String s = "/aaaaaaaaaaaaaaaaaaaaaaaaaaaa-\n"
				  +"b                            d\n"
				  +"b                            d\n"
				  +"b       Ez itt a szoveg      d\n"
				  +"b      ez meg egy új sor     d\n"
				  +"b       ez meg egy újabb     d\n"
				  +"b       de mostmár elég      d\n"
				  +"b                            d\n"
				  +"b                            d\n"
				  +"*cccccccccccccccccccccccccccc+\n";
		String szoveg = "Ez itt a szoveg\n ez meg egy új sor\nez meg egy újabb \n de mostmár elég";
		String keret = "/*+-abcd";
		FrameController.setKeret(keret);
		assertEquals(s, FrameController.showFrame(szoveg, 10, 30));
	}
}
