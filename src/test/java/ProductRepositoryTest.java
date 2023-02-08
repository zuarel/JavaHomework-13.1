import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    Book item1 = new Book(11, "Пушкин", 210, "Ленин");
    Product item2 = new Product(12, "Лермонтов", 220);
    Product item3 = new Product(13, "Таматаева", 230);
    Product item4 = new Product(14, "Ботнарь", 240);
    Product item5 = new Product(15, "Онегин", 250);

    @Test
    public void shouldAddProduct() {
        ProductRepository repository = new ProductRepository();

        repository.saveProduct(item1);

        Product[] expected = {item1};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteProduct() {
        ProductRepository repository = new ProductRepository();


        repository.saveProduct(item1);
        repository.saveProduct(item2);
        repository.saveProduct(item3);

        repository.removeById(12);

        Product[] expected = {item1, item3};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

}