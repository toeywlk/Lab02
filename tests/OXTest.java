import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OXTest {

    @Test
    public void Over() {
        OX ox = new OX();

        assertFalse(ox.put(0,-1));
        assertFalse(ox.put(0,3));
        assertFalse(ox.put(3,-1));
        assertFalse(ox.put(-1,3));
    }
    @Test
    public void getOver() {
        OX ox = new OX();

        assertNull(ox.put(0,-1));
        assertNull(ox.put(0,3));
        assertNull(ox.put(3,-1));
        assertNull(ox.put(-1,3));
    }
    @Test
    public void switchPlayer(){
        OX ox = new OX();
        ox.switchPlayer();
        assertEquals(" O",ox.getCurrentPlayer());

        ox.switchPlayer();
        assertEquals(" X",ox.getCurrentPlayer());

    }
    @Test
    void putAt() {
        OX ox = new OX();
        ox.put(0,0);
        assertEquals("  0 1 2\n0 - - -\n1 - - -\n2 - - -\n",ox.getTableString());
    }

    @Test
    void putAtTwice() {
        OX ox = new OX();
        assertTrue(ox.put(0,0));
        assertFalse(ox.put(0,0));
    }


    @Test
    public void getAt() {
        OX ox = new OX();
        ox.put(0,0);
        assertEquals("  0 1 2\n0 X - -\n1 - - -\n2 - - -\n",ox.getTableString());
        assertEquals(" X",ox.get(0,0));
    }


    @Test
    public void checkWinCol(){
        OX ox = new OX();

        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);

        assertEquals(true,ox.checkWin(0,0));
        assertEquals(true,ox.checkWin(1,0));
        assertEquals(true,ox.checkWin(2,0));


    }
    @Test
    public void checkWinCol1(){
        OX ox = new OX();

        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);

        assertEquals(true,ox.checkWin(0,1));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(2,1));
        assertEquals(false,ox.checkWin(2,0));
        assertEquals(false,ox.checkWin(2,1));
        assertEquals(false,ox.checkWin(2,2));
    }
    @Test
    public void checkWinCol2(){
        OX ox = new OX();

        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);

        assertEquals(true,ox.checkWin(0,2));
        assertEquals(true,ox.checkWin(1,2));
        assertEquals(true,ox.checkWin(2,2));

    }
    @Test
    public void checkWinRow(){
        OX ox = new OX();

        ox.put(0,0);
        ox.put(1,0);
        ox.put(2,0);

        assertEquals(true,ox.checkWin(0,0));
        assertEquals(true,ox.checkWin(0,1));
        assertEquals(true,ox.checkWin(0,2));

    }
    @Test
    public void checkWinRow1(){
        OX ox = new OX();

        ox.put(0,1);
        ox.put(1,1);
        ox.put(2,1);

        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(1,2));


    }
    @Test
    public void checkWinRow2(){
        OX ox = new OX();

        ox.put(0,2);
        ox.put(1,2);
        ox.put(2,2);

        assertEquals(true,ox.checkWin(2,0));
        assertEquals(true,ox.checkWin(2,1));
        assertEquals(true,ox.checkWin(2,2));


    }
    @Test
    public void checkWinDown(){
        OX ox = new OX();

        ox.put(0,0);
        ox.put(1,1);
        ox.put(2,2);

        assertEquals(true,ox.checkWin(0,0));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(2,2));

    }
    @Test
    public void checkWinUp(){
        OX ox = new OX();

        ox.put(2,0);
        ox.put(1,1);
        ox.put(0,2);

        assertEquals(true,ox.checkWin(2,0));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(0,2));

    }
    @Test
    public void reset() {
        OX ox = new OX();
        ox.put(2,0);
        ox.put(1,1);
        ox.put(0,2);
        ox.reset();
        assertEquals("  0 1 2\n0 - - -\n1 - - -\n2 - - -\n",ox.getTableString());
        assertEquals(" X", ox.getCurrentPlayer());
        assertEquals(0, ox.getTurn());
    }

    @Test
    public void getTurn() {
        OX ox = new OX();
        assertEquals(0, ox.getTurn());
        ox.put(0,0);
        assertEquals(1, ox.getTurn());
    }

    @Test
    public void Draw() {
        OX ox = new OX();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertFalse(ox.Draw());
        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertFalse(ox.Draw());
        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertTrue(ox.Draw());
    }
    @Test
    void getCountX() {
        OX ox = new OX();
        assertEquals(0, ox.getCountX());
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertEquals(1, ox.getCountX());
    }

    @Test
    void getCountO() {
        OX ox = new OX();
        ox.switchPlayer();
        assertEquals(0, ox.getCountO());
        ox.put(0,0);
        ox.put(1,1);
        ox.put(2,2);
        assertEquals(1, ox.getCountO());
    }

    @Test
    void getCountDraw() {
        OX ox = new OX();
        assertEquals(0, ox.getCountDraw());
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertFalse(ox.Draw());
        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertFalse(ox.Draw());
        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertTrue(ox.Draw());
        assertEquals(1, ox.getCountDraw());
    }


}