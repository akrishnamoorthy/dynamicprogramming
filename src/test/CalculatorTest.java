package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {

 @BeforeTest
 public void doSomething(){
     System.out.println("do somethings");
 }

    @Test
    public void testAdd(){

        Calculator test = new Calculator();
        test.setRoundNumber(Mockito.mock(RoundNumber.class));
        Assert.assertEquals(34, test.add(1,2));

        Mockito
    }

}
