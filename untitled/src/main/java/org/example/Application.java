package org.example;

import org.example.entities.Product;
import org.example.entities.Order;
import org.example.entities.Customer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//LISTA DI PRODOTTI
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1, "Il Nome della Rosa", "Book", 65.00));
        productList.add(new Product(2, "Il Codice Da Vinci", "Book", 70.00));
        productList.add(new Product(3, "Il Silmarillion", "Book", 80.00));
        productList.add(new Product(4, "Harry Potter e la Pietra Filosofale", "Book", 75.00));
        productList.add(new Product(5, "Kit di Accessori per la Scuola", "Boy", 120.00));
        productList.add(new Product(6, "La Ragazza con il Tatuaggio del Drago", "Book", 90.00));
        productList.add(new Product(7, "Il Gioco delle Ombre", "Book", 85.00));
        productList.add(new Product(8, "La Storia Infinita", "Book", 100.00));
        productList.add(new Product( 9, "Passeggino Leggero", "Baby", 65.00 ));
        productList.add(new Product( 10, "Giocattolo di Pelso", "Baby", 70.00 ));
        productList.add(new Product( 11, "Set di Vestiti per Neonato", "Baby", 80.00 ));
        productList.add(new Product( 12, "Letto per Bambino", "Baby", 75.00 ));
        productList.add(new Product( 13, "Carrozzina per Bambino", "Baby", 120.00 ));
        productList.add(new Product( 14, "Kit di Accessori per Allattamento", "Baby", 90.00 ));
        productList.add(new Product( 15, "Giocattolo Interattivo", "Baby", 85.00 ));
        productList.add(new Product( 16, "Tappeto per Giochi", "Baby", 100.00 ));
        productList.add(new Product(  17, "Maglietta con Stampa di Supereroe", "Boy", 65.00 ));
        productList.add(new Product( 18, "Set di Costruzione LEGO", "Boy", 70.00 ));
        productList.add(new Product( 19, "Pantaloni di Jeans per Bambino", "Boy", 80.00 ));
        productList.add(new Product( 20, "Giocattolo di Macchinina", "Boy", 75.00 ));
        productList.add(new Product( 21, "Kit di Accessori per la Scuola", "Boy", 120.00 ));
        productList.add(new Product( 22, "Felpa con Cappuccio", "Boy", 90.00 ));
        productList.add(new Product( 23, "Scarpe da Ginnastica", "Boy", 85.00 ));
        productList.add(new Product( 24, "Set di Pennarelli Colorati", "Boy", 100.00 ));
        //LISTA DI CLIENTI
        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Customer(1, "Luca Rossi", 2);
        Customer customer2 = new Customer(2, "Giulia Bianchi", 1);
        Customer customer3 = new Customer(3, "Marco Verdi", 3);
        Customer customer4 = new Customer( 4, "Francesca Neri", 1 );
        Customer customer5 = new Customer( 5, "Andrea Marini", 2 );
        Customer customer6 = new Customer( 6, "Sofia Conti", 3 );
        Customer customer7 = new Customer( 7, "Lorenzo Ferrari", 2 );
        Customer customer8 = new Customer( 8, "Elena Ricci", 1 );

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);
        customerList.add(customer6);
        customerList.add(customer7);
        customerList.add(customer8);

        //LISTA ORDINI
        List<Order> orderList = new ArrayList<>();

        orderList.add(new Order(1, "delivered", LocalDate.now(), LocalDate.now().plusDays(5), List.of(productList.get(3)), customerList.get(2)));
        orderList.add(new Order(2, "delivered", LocalDate.now(), LocalDate.now().plusDays(3), List.of(productList.get(2)), customerList.get(2)));
        orderList.add(new Order(3, "delivered", LocalDate.now(), LocalDate.now().plusDays(3), List.of(productList.get(7)), customerList.get(4)));


        Map<Customer, List<Order>> ordineCliente = orderList.stream().collect(Collectors.groupingBy(c -> c.getCustomer()));

        Map<Customer, Double> sommaOrdiniCliente = orderList.stream().collect(Collectors.groupingBy(Order::getCustomer), Collectors.summingDouble(ord -> ord.g));
        System.out.println("Ordine Cliente: " + ordineCliente);
        System.out.println(orderList);

    }
}
