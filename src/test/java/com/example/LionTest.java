package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void testLionMaleHasMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionFemaleNoMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testLionInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестный пол", feline);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLionNullFelineThrowsException() throws Exception {
        new Lion("Самец", null);
    }

    @Test
    public void testGetKittensReturnsCorrectValue() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);

        int result = lion.getKittens();

        assertEquals(3, result);
    }

    @Test
    public void testGetKittensCallsFelineMethod() throws Exception {
        Lion lion = new Lion("Самец", feline);

        lion.getKittens();

        verify(feline, times(1)).getKittens();
    }

    @Test
    public void testGetFoodReturnsCorrectList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);

        List<String> result = lion.getFood();

        assertEquals(expectedFood, result);
    }

    @Test
    public void testGetFoodCallsFelineEatMeat() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);

        lion.getFood();

        verify(feline, times(1)).eatMeat();
    }
}