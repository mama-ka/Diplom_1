package praktikum;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(FILLING, "cutlet", 100f);

    @Test
    public void getTypeIngredientFilling() {
        IngredientType expected = FILLING;
        assertEquals("Полученный тип не соответствует", expected, ingredient.getType());
    }

    @Test
    public void getNameIngredient() {
        String expected = "cutlet";
        assertEquals("Полученное имя не соответствует", expected, ingredient.getName());
    }
    @Test
    public void getPriceIngredient() {
        float expected = 100f;
        assertEquals("Полученная цена не соответствует", expected, ingredient.getPrice(), 0.00001);
    }

}
