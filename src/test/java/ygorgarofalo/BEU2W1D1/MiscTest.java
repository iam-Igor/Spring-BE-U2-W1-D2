package ygorgarofalo.BEU2W1D1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ygorgarofalo.BEU2W1D2.U5D1Application;
import ygorgarofalo.BEU2W1D2.entities.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MiscTest {

    static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);

    @BeforeAll
    public static void testToppingConstructors() {
        System.out.println("Test sul costruttore di Topping");
        String toppingName = "Ham";
        int calories = 80;
        double price = 0.80;

        Topping t = new Topping(toppingName, calories, price);

        assertEquals(toppingName, t.getName());
        assertEquals(calories, t.getCalories());
        assertEquals(price, t.getPrice());
    }

    @AfterAll
    public static void testPizzaListSize() {
        Menu m = (Menu) ctx.getBean("menu");
        System.out.println("Test sulla lunghezza effettiva della List di pizze nel menu");
        int result = 4;
        assertEquals(result, m.getPizzaList().size());

    }

    @Test
    public void testDrinkListSize() {
        Menu m = (Menu) ctx.getBean("menu");
        System.out.println("Test sulla lunghezza effettiva della List di drinks nel menu");
        int result = 3;
        assertEquals(result, m.getDrinkList().size());

    }

    @Test
    public void testToppingListSize() {
        Menu m = (Menu) ctx.getBean("menu");
        System.out.println("Test sulla lunghezza effettiva della List di toppings nel menu");
        int result = 5;
        assertEquals(result, m.getToppingList().size());


    }

    @Test
    public void checkNotEqualsObkects() {
        System.out.println("Test sulla diversita di due oggetti pizza nel menu");
        Pizza p = (Pizza) ctx.getBean("salami_pizza");
        Pizza pXL = (Pizza) ctx.getBean("salami_pizza_xl");

        assertNotEquals(p, pXL);

    }

    @Test
    public void checkTableStatus() {
        System.out.println("Test sullo stato del tavolo libero");
        Tavolo t = (Tavolo) ctx.getBean("Tavolo_1");
        assertEquals(t.getStatoTavolo(), StatoTavolo.LIBERO);

        System.out.println("Test sullo stato del tavolo che non sia occupato");
        assertNotEquals(t.getStatoTavolo(), StatoTavolo.OCCUPATO);
    }


}
