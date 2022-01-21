package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void addIngredientBurger() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        int expected = 2;
        assertEquals("Длина списка ингридиентов не совпадает",expected, burger.ingredients.size());
    }

    @Test
    public void moveIngredientBurger() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        burger.moveIngredient(1,2);
        String expected = "dinosaur";
        assertEquals("Название ингредиента не совпадает", expected, burger.ingredients.get(1).name);
    }

    @Test
    public void removeIngredientBurger() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int expected = 2;
        assertEquals("Ингридиент не удалился",expected, burger.ingredients.size());
    }

    @Test
    public void getPriceBurger() {
        float expected = 210f;
        when(bun.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        when(ingredient.getPrice()).thenReturn(10f);
        burger.addIngredient(ingredient);
        assertEquals("Расчёт цены не совпадает",expected, burger.getPrice(), 0.000001);
    }

    @Test
    public void getReceiptBurger() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String nameBun = "black bun";
        String nameIngredient = "cutlet";
        float price = 210f;
        String chekPrice = "210,000000";
        String expectedReceipt = "(==== " + nameBun + " ====)\r\n" +
                "= filling " + nameIngredient + " =\r\n" +
                "(==== " + nameBun + " ====)\r\n" +
                "\r\n" + "Price: " + chekPrice + "" + "\r\n";

        IngredientType type = IngredientType.FILLING;
        when(bun.getName()).thenReturn(nameBun);
        when(ingredient.getType()).thenReturn(type);
        when(ingredient.getName()).thenReturn(nameIngredient);
        when(burger.getPrice()).thenReturn(price);
        assertEquals("Рецепт не совпадает", expectedReceipt,  burger.getReceipt());
    }
}
