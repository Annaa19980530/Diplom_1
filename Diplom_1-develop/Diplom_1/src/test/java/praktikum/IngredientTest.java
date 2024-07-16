package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] ingredientData(){
        return new Object[][]{
                {SAUCE, "Соус Spicy-X", 90},
                {SAUCE, "Соус фирменный Space Sauce", 80},
                {FILLING,"Хрустящие минеральные кольца", 300},
                {FILLING,"Биокотлета из марсианской Магнолии", 424}
        };
    }
    @Before
    public void setUp(){
        ingredient = new Ingredient(type,name,price);
    }

    @Test
    public void checkGetPrice(){
        float expectedPrice = price;
        float actualPrice = ingredient.getPrice();
        assertEquals("Неверная цена",expectedPrice,actualPrice,0);
    }

    @Test
    public void checkGetName(){
        String expectedName = name;
        String actualName = ingredient.getName();
        assertEquals("Неверное название",expectedName,actualName);
    }

    @Test
    public void checkGetType() {
        IngredientType expectedType = type;
        IngredientType actualType = ingredient.getType();
        assertEquals("Неверный тип ингридиента", expectedType, actualType);
    }
}
