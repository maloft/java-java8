package java8.ex01;

import java8.data.Data;
import java8.data.domain.Order;
import java8.data.domain.Pizza;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 01 - Recherche
 */
public class Stream_01_Test {

    @Test
    public void test_stream_filter() throws Exception {
        List<Pizza> pizzas = new Data().getPizzas();

        // TODO récupérer la liste des pizzas dont le prix est >= 1300
        // TODO utiliser l'API Stream
        
        Stream<Pizza> sp = pizzas.stream();
        
        List<Pizza> result = sp.filter(pizza -> pizza.getPrice() >= 1300)
        		.collect(Collectors.toList());

        assertThat(result, hasSize(3));
        assertThat(result, everyItem(hasProperty("price", anyOf(equalTo(1300), greaterThan(1300)))));
    }

    @Test
    public void test_stream_anyMatch() throws Exception {

        List<Pizza> pizzas = new Data().getPizzas();

        List<Pizza> result = pizzas.stream().filter(pizza -> pizza.getPrice() >= 1300)
        		.collect(Collectors.toList());
        
        // TODO valider si au moins une pizza à un prix >= 1300
        Boolean result1 = (result.size() >= 1);

        List<Pizza> resultBis = result.stream().filter(pizza -> pizza.getPrice() >= 2000)
        		.collect(Collectors.toList());
        // TODO valider si au moins une pizza à un prix >= 2000
        Boolean result2 = (resultBis.size() >= 1);

        assertThat(result1, is(true));
        assertThat(result2, is(false));
    }

    @Test
    public void test_stream_allMatch() throws Exception {

        List<Pizza> pizzas = new Data().getPizzas();

        List<Pizza> result = pizzas.stream().filter(pizza -> pizza.getPrice() >= 1300)
        		.collect(Collectors.toList());
        // TODO valider que toutes les pizzas ont un prix >= 1300
        Boolean result1 = (pizzas.size() == result.size());

        List<Pizza> resultBis = pizzas.stream().filter(pizza -> pizza.getPrice() >= 900)
        		.collect(Collectors.toList());
        // TODO valider que toutes les pizzas ont un prix >= 900
        Boolean result2 = (pizzas.size() == resultBis.size());

        assertThat(result1, is(false));
        assertThat(result2, is(true));
    }


    @Test
    public void test_stream_noneMatch() throws Exception {

        List<Pizza> pizzas = new Data().getPizzas();

        List<Pizza> result = pizzas.stream().filter(pizza -> pizza.getPrice() >= 2000)
        		.collect(Collectors.toList());
        // TODO valider qu'aucune pizza n'a un prix >= 2000
        Boolean result1 = (result.size()== 0);

        assertThat(result1, is(true));
    }

    @Test
    public void test_stream_findFirst() throws Exception {
        List<Order> orders = new Data().getOrders();

        
        // TODO récupérer une commande faite par un client dont le prénom est "Sophie"
        
        
        Optional<Order> result = orders.stream().findFirst()
        		.filter(order -> order.getCustomer().getFirstname().equals("Sophie"));

        assertThat(result.isPresent(), is(false));
    }
}
