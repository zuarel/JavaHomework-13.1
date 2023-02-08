import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Product item1 = new Product(11, "Пушкин", 210);
    Product item2 = new Product(12, "Лермонтов", 220);
    Product item3 = new Product(13, "Толстой", 230);
    Product item4 = new Product(14, "Ботнарь", 240);
    Product item5 = new Product(15, "Гоголь", 250);


    @Test
    public void shouldSearchProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {item4};
        Product[] actual = manager.searchBy("Ботнарь");

        Assertions.assertArrayEquals(expected, actual);
    }

}