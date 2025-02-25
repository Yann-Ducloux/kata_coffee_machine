package org.example;

import org.example.checker.MoneyChecker;
import org.example.entity.Command;
import org.example.exception.LackMoneyException;
import org.example.exception.NegativeMoneyException;
import org.example.service.DrinkMakerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrinkMakerServiceTest {
    public static MoneyChecker moneyChecker;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        moneyChecker = new MoneyChecker();
    }
    
    @Test
   void shouldCommandTeaWithOneSugarReturnTeaOneSugarOneStick() {
      DrinkMakerService dms = new DrinkMakerService(moneyChecker);
      Command command = dms.make(Drink.TEA, 1, 0.4);
      assertEquals("T:1:0", command.getDrinkDemand());
      assertEquals(0.0, command.getRendered());
  }
    @Test
    void shouldCommandChocolateWithoutSugarReturnTeaNotSugarNotStick() {
        DrinkMakerService dms = new DrinkMakerService(moneyChecker);
        Command command = dms.make(Drink.CHOCOLATE, 0, 1.0);
        assertEquals("H::", command.getDrinkDemand());
        assertEquals(0.5, command.getRendered());
    }
    @Test
    void shouldCommandCofeeWithTwoSugarReturnTeaTwoSugarStick() {
        DrinkMakerService dms = new DrinkMakerService(moneyChecker);
        Command command = dms.make(Drink.COFFEE, 2, 0.8);
        assertEquals("C:2:0", command.getDrinkDemand());
        assertEquals(0.2, command.getRendered());
    }

    @Test
    void shouldCommandCoffeeWithLackMoneyReturnErrorLackMoney() {
        DrinkMakerService dms = new DrinkMakerService(moneyChecker);
        Throwable exception = assertThrows(
                LackMoneyException.class,
                () -> {
                    dms.make(Drink.COFFEE, 2, 0.3);
                }
        );
        assertEquals("Il manque 0,3€", exception.getMessage());
    }

    @Test
    void shouldCommandTeaWithLackMoneyReturnErrorLackMoney() {
        DrinkMakerService dms = new DrinkMakerService(moneyChecker);
        Throwable exception = assertThrows(
                LackMoneyException.class,
                () -> {
                    dms.make(Drink.TEA, 1, 0.2);
                }
        );
        assertEquals("Il manque 0,2€", exception.getMessage());
    }

    @Test
    void shouldCommandTeaWithMoneyNegativeReturnErrorMoneyNegative() {
        DrinkMakerService dms = new DrinkMakerService(moneyChecker);
        Throwable exception = assertThrows(
                NegativeMoneyException.class,
                () -> {
                    dms.make(Drink.CHOCOLATE, 1, -0.2);
                }
        );
        assertEquals("La somme est -0,2€ négative", exception.getMessage());
    }
}