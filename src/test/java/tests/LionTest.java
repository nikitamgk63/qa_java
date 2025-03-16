package tests;

import org.mockito.Mockito;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void maleHasManeTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue("У самца должна быть грива", lion.doesHaveMane());
    }

    @Test
    public void femaleHasNoManeTest() throws Exception {
        Lion lioness = new Lion("Самка", feline);
        Assert.assertFalse("У самки не должно быть гривы", lioness.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void whenWrongSexThrowExceptionTest() throws Exception {
            Lion lion = new Lion("Null", feline);
    }

    @Test
    public void lionHasOneKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void lionGetMeatTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        Assert.assertEquals(expected, lion.getFood());
    }
}
