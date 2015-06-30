/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import Test.Login;
import org.junit.Test;
import org.junit.Assert;


/**
 *
 * @author Coen
 */
public class LoginTest {
    
    @Test
    public void TestLogin(){
        try {
            Login loginTrue = new Login("Henk@yolo.nl", "password");
            Assert.assertTrue(loginTrue.Verbind());
            Login loginFalse1 = new Login("Henk@yolo.nl", "qwretryugsf");
            Assert.assertFalse(loginFalse1.Verbind());
            Login loginFalse2 = new Login("user@user.user", "user");
            Assert.assertFalse(loginFalse2.Verbind());
        } catch (Exception e) {
            System.out.print("an error had occured");
            Assert.assertTrue(false);
        }
        
    }
}
