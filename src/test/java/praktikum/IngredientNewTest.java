package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class IngredientNewTest {
    @Mock
    Ingredient newIngredient;

    @Test
    public void getTypeIngredientFilling() {
        IngredientType expectedType = FILLING;
        when(newIngredient.getType()).thenReturn(expectedType);
        assertEquals("Полученный тип не соответствует", expectedType, newIngredient.getType());
    }

    @Test
    public void getNameIngredient() {
        String expectedName = "cutlet";
        when(newIngredient.getName()).thenReturn(expectedName);
        assertEquals("Полученное имя не соответствует", expectedName, newIngredient.getName());
    }
    @Test
    public void getPriceIngredient() {
        float expectedPrice = 100f;
        when(newIngredient.getPrice()).thenReturn(expectedPrice);
        assertEquals("Полученная цена не соответствует", expectedPrice, newIngredient.getPrice(), 0.00001);
    }
}
