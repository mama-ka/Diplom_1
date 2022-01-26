package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DatabaseNewTest {

    @Mock
    Database newDatabase;

    @Test
    public void getAvailableListBuns() {
        List<Bun> expectedList = List.of(new Bun("bun", 500));
        when(newDatabase.availableBuns()).thenReturn(expectedList);
        assertEquals("полученный список не соответствует", expectedList, newDatabase.availableBuns());
    }
    @Test
    public void getAvailableListIngredients() {
        List<Ingredient> expectedList = List.of(new Ingredient(IngredientType.FILLING, "ingredient", 600));
        when(newDatabase.availableIngredients()).thenReturn(expectedList);
        assertEquals("полученный список не соответствует", expectedList, newDatabase.availableIngredients());
    }
}
