package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrinkMakerServiceTest {
  @Test
   void shouldCommandTeaWithOneSugarReturnTeaOneSugarOneCuillere() {
      DrinkMakerService dms = new DrinkMakerService();
      Command command = dms.make(Drink.TEA, 1, 0.4F);
      assertEquals("T:1:0", command.getDrinkDemand());
  }
    @Test
    void shouldCommandChocolateWithouSugarReturnTeaNotSugarNotCuillere() {
        DrinkMakerService dms = new DrinkMakerService();
        Command command = dms.make(Drink.CHOCOLATE, 0, 0.5F);
        assertEquals("H::", command.getDrinkDemand());
    }
    @Test
    void shouldCommandCofeeWithTwoSugarReturnTeaTwoSugarCuillere() {
        DrinkMakerService dms = new DrinkMakerService();
        Command command = dms.make(Drink.COFFEE, 2, 0.6F);
        assertEquals("C:2:0", command.getDrinkDemand());
    }

    @Test
    void shouldCommandTeaWithOneSugarReturnErrorNotEnautEuro() {
        DrinkMakerService dms = new DrinkMakerService();
        Command command = dms.make(Drink.TEA, 1, 0.2F);
        assertEquals("T:1:0", command.getDrinkDemand());
    }
}