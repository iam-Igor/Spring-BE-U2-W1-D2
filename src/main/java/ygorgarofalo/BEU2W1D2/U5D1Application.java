package ygorgarofalo.BEU2W1D2;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class U5D1Application {

    public static void main(String[] args) {
        SpringApplication.run(U5D1Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);

//        Menu m = (Menu) ctx.getBean("menu");
//
//        m.printMenu();
//        ctx.close();
    }

}
