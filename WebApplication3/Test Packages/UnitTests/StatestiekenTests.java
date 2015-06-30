/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import org.junit.Test;
import Test.VerkoopStatestieken;
import java.util.GregorianCalendar;
import java.util.Map;
import org.junit.Assert;

/**
 *
 * @author Coen
 */
public class StatestiekenTests {
    
    @Test
    public void verkoop() {
        try {
            Map<String, Object> result = VerkoopStatestieken.JaarVerkoop(new GregorianCalendar(2015, 1, 1));
            Assert.assertNotSame(result.get("items"), "xxx");
            result = VerkoopStatestieken.MaandVerkoop(new GregorianCalendar(2015, 1, 1));
            Assert.assertNotSame(result.get("items"), "xxx");
        } catch (Exception e) {
            System.out.print("an error had occured");
            Assert.assertTrue(false);
        }
    }

    @Test
    public void FotograafVerkoop() {
        Map<String, Object> result = VerkoopStatestieken.FotograafJaarVerkoop(new GregorianCalendar(2015, 1, 1), "Henk@yolo.nl");
        Assert.assertNotSame(result.get("items"), "xxx");
        result = VerkoopStatestieken.FotograafJaarVerkoop(new GregorianCalendar(2015, 1, 1), "asdfasdfadsfd");
        Assert.assertEquals(result.get("items"), "xxx");
        result = VerkoopStatestieken.FotograafMaandVerkoop(new GregorianCalendar(2015, 1, 1), "Henk@yolo.nl");
        Assert.assertNotSame(result.get("items"), "xxx");
        result = VerkoopStatestieken.FotograafMaandVerkoop(new GregorianCalendar(2015, 1, 1), "äfasdfasdfsadf");
        Assert.assertEquals(result.get("items"), "xxx");
    }

}
