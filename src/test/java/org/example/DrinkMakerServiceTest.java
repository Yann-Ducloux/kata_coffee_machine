package org.example;

import org.example.checker.MoneyChecker;
import org.example.entity.Command;
import org.example.entity.Drink;
import org.example.service.DrinkMakerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrinkMakerServiceTest {
    public static MoneyChecker moneyChecker;

    @BeforeAll
    static void setUpBeforeClass() {
        moneyChecker = new MoneyChecker();
    }
    
    @Test
   void shouldCommandTeaWithOneSugarReturnTeaOneSugarOneStick() {
      Report report = new Report();
      DrinkMakerService dms = new DrinkMakerService(moneyChecker, report);
      Command command = dms.make(Drink.TEA, 1, 0.4);
      assertEquals("T:1:0", command.getDrinkDemand());
  }
    @Test
    void shouldCommandChocolateWithoutSugarReturnTeaNotSugarNotStick() {
        Report reportOfDay = new Report();
        DrinkMakerService dms = new DrinkMakerService(moneyChecker, reportOfDay);
        Command command = dms.make(Drink.CHOCOLATE, 0, 1.0);
        assertEquals("H::", command.getDrinkDemand());
    }
    @Test
    void shouldCommandCoffeeWithTwoSugarReturnTeaTwoSugarStick() {
        Report reportOfDay = new Report();
        DrinkMakerService dms = new DrinkMakerService(moneyChecker, reportOfDay);
        Command command = dms.make(Drink.COFFEE, 2, 0.8);
        assertEquals("C:2:0", command.getDrinkDemand());
    }

    @Test
    void shouldCommandCoffeeWithLackMoneyReturnErrorLackMoney() {
        Report reportOfDay = new Report();
        DrinkMakerService dms = new DrinkMakerService(moneyChecker, reportOfDay);
        Command command = dms.make(Drink.COFFEE, 2, 0.3);
        assertEquals("M: Il manque 0,3€", command.getDrinkDemand());
    }

    @Test
    void shouldCommandTeaWithLackMoneyReturnErrorLackMoney() {
        Report reportOfDay = new Report();
        DrinkMakerService dms = new DrinkMakerService(moneyChecker, reportOfDay);
        Command command = dms.make(Drink.TEA, 1, 0.2);
        assertEquals("M: Il manque 0,2€", command.getDrinkDemand());
    }

    @Test
    void shouldCommandOrangeJuiceReturnOrangeWithoutSugarAndWithoutStick() {
        Report reportOfDay = new Report();
        DrinkMakerService dms = new DrinkMakerService(moneyChecker, reportOfDay);
        Command command = dms.make(Drink.ORANGE_JUICE, 0, 0.6);
        assertEquals("O::", command.getDrinkDemand());
    }

    @Test
    void shouldCommandHotTeaWithTwoSugarReturnTeaTwoSugarOneStick() {
        Report reportOfDay = new Report();
        DrinkMakerService dms = new DrinkMakerService(moneyChecker, reportOfDay);
        Command command = dms.make(Drink.HOT_TEA, 2, 0.4);
        assertEquals("Th:2:0", command.getDrinkDemand());
    }
    @Test
    void shouldCommandHotChocolateWithOneSugarReturnTeaNotSugarAndOneStick() {
        Report reportOfDay = new Report();
        DrinkMakerService dms = new DrinkMakerService(moneyChecker, reportOfDay);
        Command command = dms.make(Drink.HOT_CHOCOLATE, 1, 0.5);
        assertEquals("Hh:1:0", command.getDrinkDemand());
    }
    @Test
    void shouldCommandHotCoffeeWithTwoSugarReturnTeaTwoSugarStick() {
        Report reportOfDay = new Report();
        DrinkMakerService dms = new DrinkMakerService(moneyChecker, reportOfDay);
        Command command = dms.make(Drink.HOT_COFFEE, 0, 0.6);
        assertEquals("Ch::", command.getDrinkDemand());
    }
    @Test
    void shouldPrintReportPrintOfDay() {
        Report reportOfDay = new Report();
        DrinkMakerService dms = new DrinkMakerService(moneyChecker, reportOfDay);        dms.make(Drink.HOT_COFFEE, 0, 0.6);
        dms.make(Drink.COFFEE, 0, 0.6);
        dms.make(Drink.ORANGE_JUICE, 0, 0.6);
        dms.make(Drink.ORANGE_JUICE, 0, 0.6);
        dms.make(Drink.CHOCOLATE, 0, 0.5);
        dms.make(Drink.TEA, 0, 0.4);
        dms.make(Drink.TEA, 0, 0.4);
        dms.make(Drink.HOT_TEA, 0, 0.4);
        String reportExpected = "report:" + System.lineSeparator() +
                "Drinks : quantity" + System.lineSeparator() +
                "C      : 1" + System.lineSeparator() +
                "Ch     : 1" + System.lineSeparator() +
                "H      : 1" + System.lineSeparator() +
                "Hh     : 0" + System.lineSeparator() +
                "O      : 2" + System.lineSeparator() +
                "T      : 2" + System.lineSeparator() +
                "Th     : 1" + System.lineSeparator() +
                "Total amount: 4,1€";
        assertEquals(reportExpected, dms.reportPrint());
    }

    @Test
    void shouldPrintReportPrintOfDayWithLackMoney() {
        Report reportOfDay = new Report();
        DrinkMakerService dms = new DrinkMakerService(moneyChecker, reportOfDay);
        dms.make(Drink.HOT_COFFEE, 0, 0.6);
        dms.make(Drink.COFFEE, 0, 0.6);
        dms.make(Drink.HOT_TEA, 0, 0.4);
        dms.make(Drink.ORANGE_JUICE, 0, 0.6);
        dms.make(Drink.CHOCOLATE, 0, 0.5);
        dms.make(Drink.HOT_TEA, 0, 0.4);
        dms.make(Drink.ORANGE_JUICE, 0, 0.6);
        dms.make(Drink.TEA, 0, 0.4);
        Command commandLack = dms.make(Drink.TEA, 0, 0.2);
        dms.make(Drink.HOT_COFFEE, 0, 0.6);

        String reportExpected = "report:" + System.lineSeparator() +
                "Drinks : quantity" + System.lineSeparator() +
                "C      : 1" + System.lineSeparator() +
                "Ch     : 2" + System.lineSeparator() +
                "H      : 1" + System.lineSeparator() +
                "Hh     : 0" + System.lineSeparator() +
                "O      : 2" + System.lineSeparator() +
                "T      : 1" + System.lineSeparator() +
                "Th     : 2" + System.lineSeparator() +
                "Total amount: 4,7€";
        assertEquals(reportExpected, dms.reportPrint());
        assertEquals("M: Il manque 0,2€", commandLack.getDrinkDemand());
    }
}