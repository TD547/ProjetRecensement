import junit.framework.*;
import fr.epsi.b3.recensement.*;

public class Test extends TestCase {

    public void testNoCaps() throws Exception {
        Recensement rec = new Recensement();
        assertEquals(41183,rec.getPopuVille("melun"));
    }

    public void testFullCaps() throws Exception {
        Recensement rec = new Recensement();
        assertEquals(41183,rec.getPopuVille("MELUN"));
    }

    public void testRandomCaps() throws Exception {
        Recensement rec = new Recensement();
        assertEquals(41183,rec.getPopuVille("MeLUn"));
    }

    public void testVilleQuiExistePas() throws Exception {
        Recensement rec = new Recensement();
        assertEquals(-1,rec.getPopuVille("biuegzpebiuegzbiuegzbiu"));
    }
}