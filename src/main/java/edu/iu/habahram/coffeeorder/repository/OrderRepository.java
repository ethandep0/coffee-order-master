package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Random;

@Repository
public class OrderRepository {
    public Receipt add(OrderData order) throws Exception {
        Beverage beverage = switch (order.beverage().toLowerCase()) {
            case "dark roast" -> new DarkRoast();
            case "espresso" -> new Espresso();
            case "house blend" -> new HouseBlend();
            default -> null;
        };
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }
        for(String condiment : order.condiments()) {
            beverage = switch (condiment.toLowerCase()) {
                case "milk" -> new Milk(beverage);
                case "mocha" -> new Mocha(beverage);
                case "soy" -> new Soy(beverage);
                case "whip" -> new Whip(beverage);
                default -> throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            };
        }
        Random random = new Random();
        int id = random.nextInt(10000000);
        File database = new File("db.txt");
        Writer wr = new FileWriter(database, true);
        wr.write("%d %s %f\n".formatted(id, beverage.getDescription(), beverage.cost()));
        wr.close();
        Receipt receipt = new Receipt(beverage.getDescription(), beverage.cost(), id);
        return receipt;
    }
}
