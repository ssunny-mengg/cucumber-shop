package ku.shop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Given("the store is ready to service customers")
    public void the_store_is_ready_to_service_customers() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product {string} with price {float} and stock of {int} exists")
    public void a_product_exists(String name, double price, int stock) {
        catalog.addProduct(name, price, stock);
    }

    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @Then("{string} stock should be {int}")
    public void existing_stock(String name,int stock) {
        assertEquals(stock, catalog.getProduct(name).getStock());
    }

    @Then("quantity remaining in stock of {string} should be {int}")
    public void quantity_remaining_in_stock_of_should_be(String name, Integer quantity) {
        // Write code here that turns the phrase above into concrete actions
        int quantity_in_stock = catalog.getProduct(name).getStock();
        assertEquals(quantity, quantity_in_stock);
    }

    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }
}

