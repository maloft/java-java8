package java8.ex06;


import java.util.function.Supplier;

import org.junit.Test;

import java8.data.Person;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {


    // tag::formatAge[]
    // TODO compléter la méthode
    // TODO la méthode retourne une chaîne de caractères de la forme [age=<AGE>] (exemple : [age=12])
    String formatAge(Supplier<Person> supplier) {
        Person p = supplier.get();
        return "[age="+p.getAge()+"]";
    }
    // end::formatAge[]


    @Test
    public void test_supplier_formatAge() throws Exception {
        Supplier<Person> personAged35 = () -> {
        	Person p = new Person();
        	p.setAge(35);
        	return p;
        };
		// TODO compléter le test unitaire pour qu'il soit passant
        String result = formatAge(personAged35);

        assert result.equals("[age=35]");
    }

}
