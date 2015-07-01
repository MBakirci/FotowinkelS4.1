
import UnitTests.LoginTest;
import UnitTests.StatestiekenTests;
import org.junit.runner.JUnitCore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Coen
 */
public class StartTests {

    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        org.junit.runner.Result loginResult = junit.runClasses(LoginTest.class);

        if (loginResult.wasSuccessful()) {
            System.out.print("Login tests succesvol \n");
        }
        else{
            System.out.print("Login tests niet succesvol \n");
        }
        org.junit.runner.Result StatestiekenResult = junit.runClasses(StatestiekenTests.class);

        if (StatestiekenResult.wasSuccessful()) {
            System.out.print("Verkoopstatetieken tests succesvol \n");
        }
        else{
            System.out.print("Verkoopstatetieken tests niet succesvol \n");
        }
    }

}
