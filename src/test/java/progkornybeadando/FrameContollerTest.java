package progkornybeadando;

import static org.junit.Assert.*;

import org.junit.Test;

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
		String s = "+----------------------------+\n|                            |\n|                            |\n|       Ez itt a szoveg      |\n|      ez meg egy új sor     |\n|       ez meg egy újabb     |\n|       de mostmár elég      |\n|                            |\n|                            |\n+----------------------------+\n";
		String szoveg = "Ez itt a szoveg\n ez meg egy új sor\nez meg egy újabb \n de mostmár elég";
		assertEquals(s, FrameController.showFrame(szoveg, 10, 30));
	}


}
