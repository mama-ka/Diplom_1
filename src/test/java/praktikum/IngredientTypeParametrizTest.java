package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParametrizTest {
    private int type;
    private String expected;

    public IngredientTypeParametrizTest(int type, String expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getType() {
        return new Object[][]{
                {0, "SAUCE"},
                {1, "FILLING"},
        };
    }

    @Test
    public  void getIngredientTypeTest(){
        assertEquals(expected, IngredientType.values()[type].name());
    }
}