package test.entitties;

import entities.Financing;
import org.junit.Assert;
import org.junit.Test;

public class TestFinancing {

    @Test
    public void constructorShouldCreateObjectWhenDataisCorrectly(){
        Financing acc = new Financing(100000.0, 2000.00, 80);

        Assert.assertEquals(100000.0, acc.getTotalAmount(),0.01);
        Assert.assertEquals(2000.0, acc.getIncome(),0.01);
        Assert.assertTrue(80== acc.getMonths());

    }
    @Test
    public void constructorShouldThrowExceptionWhenDataisNotCorrectly(){

        Assert.assertThrows(IllegalArgumentException.class, ()->{
            Financing acc = new Financing(100000.00, 2000.00, 20);
        });
    }

    @Test
    public void setTotalShouldUpdateValueWhenDataIsVallid(){
        Financing acc = new Financing(100000.0, 2000.0, 80);
            acc.setTotalAmount(80000.0);
        Assert.assertEquals(80000.0, acc.getTotalAmount(), 0.01);
    }

    @Test
    public void setTotalShouldTrhowExceptionWhenDataIsNotVallid(){
        Financing acc = new Financing(100000.0, 2000.0, 80);
        Assert.assertThrows(IllegalArgumentException.class, ()->{
            acc.setTotalAmount(101000.0);
        });
    }

    @Test
    public void setIncomeShouldUpdateValueWhenDataIsVallid(){
        Financing acc = new Financing(100000.0, 2000.0, 80);
        acc.setIncome(3000.0);
        Assert.assertEquals(3000.0, acc.getIncome(), 0.01);
    }

    @Test
    public void setIncomeShouldTrhowExceptionWhenDataIsNotVallid(){
        Financing acc = new Financing(100000.0, 2000.0, 80);

        Assert.assertThrows(IllegalArgumentException.class, ()->{
            acc.setIncome(1000.0);
        });
    }

    @Test
    public void entryShouldCaulculateValue(){
        Financing acc = new Financing(100000.0, 2000.0, 80);
        Assert.assertEquals(20000.0 ,acc.entry(), 0.01);
    }

    @Test
    public void quotaShouldCalculate(){
        Financing acc = new Financing(100000.0, 2000.0 ,80);
        Assert.assertEquals(1000.0, acc.quota(), 0.01);
    }

}
