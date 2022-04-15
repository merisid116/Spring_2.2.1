package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("James", "Smith", "james@gmail.com");
      User user2 = new User("Robert", "Wilson", "wilson@gmail.com");
      User user3 = new User("Susan", "Miller", "miller@gmail.com");
      User user4 = new User("Barbara", "Brown", "barbara@gmail.com");

      Car car1 = new Car("BMW", 2021);
      Car car2 = new Car("Mercedes", 1997);
      Car car3 = new Car("Audi", 2003);
      Car car4 = new Car("Porsche", 2019);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
         System.out.println(" ");
      }

      System.out.println(userService.getUserByCar("Audi", 2003));
      System.out.println(" ");


      context.close();
   }
}
