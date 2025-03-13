package tests;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Animal;
import java.util.List;

@RunWith(Parameterized.class)

public class ParameterizedTest {
    private final List<String> food;
    private final String animalKind;

    public ParameterizedTest(List<String> food, String animalKind) {
        this.food = food;
        this.animalKind = animalKind;
    }

    @Parameterized.Parameters (name = "Список еды для животных {1}: {0}")
    public static Object[][] getFoodData() {
        return new Object[][]{
                {List.of("Трава", "Различные растения"), "Травоядное"},
                {List.of("Животные", "Птицы", "Рыба"), "Хищник"},
        };
    }

    @Test
    public void getFoodForAnimalKindTest() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(food, animal.getFood(animalKind));
    }
}
