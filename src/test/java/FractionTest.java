import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest {
    @Test
    public void testConstructor(){
        Fraction fraction = new Fraction(1, 2);
        assertEquals(fraction.numerator, 1);
        assertEquals(fraction.denominator, 2);
        Fraction testNegative = new Fraction(-1, -2);
        assertEquals(testNegative.numerator, 1);
        assertEquals(testNegative.denominator, 2);
        Fraction testZeroDenom = new Fraction(1, 0);
        assertEquals(testZeroDenom.denominator, 1);
        assertEquals(testZeroDenom.numerator, 0);
    }
    @Test
    public void testToString(){
        Fraction fraction = new Fraction();
        assertEquals(fraction.toString(), "0/1");
    }
    @Test
    public void testGetRealValue(){
        Fraction fraction = new Fraction(1, 2);
        double actual = 0.5;
        assertEquals(fraction.getRealValue(), actual, 0.5);
    }
    @Test
    public void testReduce(){
        Fraction fraction = new Fraction(3, 6);
        Fraction actual = new Fraction(1, 2);
        assertEquals(fraction.reduce(fraction), actual);
    }
   /* @Test
    public void testAdd(){
        Fraction one  = new Fraction(2, 6);
        Fraction two = new Fraction(2, 6);
        Fraction actual = new Fraction(2, 3);
        assertEquals(one.add(two), actual);
    }*/
    @Test
    public void testEquals(){
        Fraction one = new Fraction(1, 2);
        Fraction two = new Fraction(1, 2);
        assertEquals(one.equals(two), true);
    }
    @Test
    public void testCompareTo(){
        Fraction one = new Fraction(1, 2);
        Fraction two = new Fraction(1, 2);
        assertEquals(one.compareTo(two), 0);
    }
}
