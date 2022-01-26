package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BunNewTest {
    @Mock
    Bun newBun;

    @Test
    public void getNameBun() {
        String expectedName = "black bun";
        when(newBun.getName()).thenReturn(expectedName);
        assertEquals("Имя не соответсвует", expectedName, newBun.getName());
    }

    @Test
    public void getPriceBun() {
        float expectedPrice = 100f;
        when(newBun.getPrice()).thenReturn(expectedPrice);
        assertEquals("Полученная цена не соответствует", expectedPrice, newBun.getPrice(), 0.00001);

    }
}
