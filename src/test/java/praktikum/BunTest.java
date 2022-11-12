package praktikum;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun ("black bun",100f);

    @Test
    public void getNameBun() {
        String expectedName = "black bun";
        assertEquals("Имя не соответсвует", expectedName, bun.getName());
    }

    @Test
    public void getPriceBun() {
        float expectedPrice = 100f;
        assertEquals("Цена не соответсвует",expectedPrice, bun.getPrice(), 0.0001);
    }
}
