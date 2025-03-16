package tests;

import org.junit.Assert;
import org.junit.Test;
import com.example.Feline;

import java.util.List;

public class FelineTest {
    @Test
    public void eatMeatTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Feline feline = new Feline();
        Assert.assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void noParameterReturnOneKittensTest() {
        Feline feline = new Feline();
        int defaultKittensCount = 1;
        Assert.assertEquals(defaultKittensCount, feline.getKittens());
    }

    @Test
    public void positiveParameterReturnKittensCountTest() {
        Feline feline = new Feline();
        Assert.assertEquals(10, feline.getKittens(10));
    }
}
