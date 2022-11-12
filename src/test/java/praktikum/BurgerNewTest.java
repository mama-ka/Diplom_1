package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerNewTest {
    @Mock
    Ingredient ingredient;
    @Mock
    Burger newBurger;

    @Test
    public void addIngredientBurger() {
        newBurger.addIngredient(ingredient);
        newBurger.addIngredient(ingredient);
       verify(newBurger, Mockito.times(2)).addIngredient(ingredient);
    }

    @Test
    public void moveIngredientBurger() {
        newBurger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        newBurger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        newBurger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        newBurger.moveIngredient(1,2);
        verify(newBurger, Mockito.times(1)).moveIngredient(1,2);
    }

    @Test
    public void removeIngredientBurger() {
        newBurger.addIngredient(ingredient);
        newBurger.addIngredient(ingredient);
        newBurger.removeIngredient(0);
        verify(newBurger, Mockito.times(1)).removeIngredient(0);
    }

    @Test
    public void getPriceBurger() {
        float expected = 210f;
        when(newBurger.getPrice()).thenReturn(expected);
        assertEquals("Расчёт цены не совпадает", expected, newBurger.getPrice(), 0.000001);
    }

    @Test
    public void getReceiptBurger() {
        String nameBun = "black bun";
        String nameIngredient = "cutlet";
        String chekPrice = "210,000000";
        String expectedReceipt = "(==== " + nameBun + " ====)\r\n" +
                "= filling " + nameIngredient + " =\r\n" +
                "(==== " + nameBun + " ====)\r\n" +
                "\r\n" + "Price: " + chekPrice + "" + "\r\n";

        when(newBurger.getReceipt()).thenReturn(expectedReceipt);
        assertEquals("Рецепт не совпадает", expectedReceipt, newBurger.getReceipt());
    }
}


