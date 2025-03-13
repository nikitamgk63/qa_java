package tests;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.example.Animal;

public class AnimalTest {
    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                animal.getFamily());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenAnimalKindWrongExceptionThrown() throws Exception {
        Animal animal = new Animal();
        String wrongAnimalKind = "Null";
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        animal.getFood(wrongAnimalKind);
    }

}
