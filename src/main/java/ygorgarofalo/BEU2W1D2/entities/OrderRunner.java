package ygorgarofalo.BEU2W1D2.entities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ygorgarofalo.BEU2W1D2.U5D1Application;

@Component
public class OrderRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);
        Menu m = (Menu) ctx.getBean("menu");
        m.printMenu();


        Ordine o = ctx.getBean("order_2", Ordine.class);
        o.printOrder();


        ctx.close();

    }
}
