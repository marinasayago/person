package es.uma.mps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases
 * 1. name != null
 * 2. name != "" (cadena vacía)
 * 3. age < 0
 * 4. age != null
 * 4. gender != null
 * 5. not (gender == Male && gender == Female)
 */
public class PersonTest {
    Person person;


    @AfterEach
    void shutDown(){
        person = null;
    }

    @Test
    void personNameIsNotNull(){
        person = new Person("Marina",21, "Female");
        String obtainedName = person.name();

        assertNotNull(obtainedName);
    }

    @Test
    void personNameIsNotEmpty(){
        person = new Person("Marina",21, "Female");
        String obtainedName = person.name();

        assertNotEquals("", obtainedName);
    }


    @Test
    void personAgeIsNegative(){
        person = new Person("Marina",-6, "Female");

        assertThrows(NegativeAgeException.class, () -> person.age());
    }

    @Test
    void personAgeIsNotNull(){
        person = new Person("Marina",21, "Female");
        int obtainedAge = person.age();

        assertNotNull(obtainedAge);
    }

    @Test
    void personGenderIsNotNull(){
        person = new Person("Marina",21, "Female");
        String obtainedGender = person.gender();

        assertNotNull(obtainedGender);
    }

    @Test
    void personGenderIsIncorrect(){
        person = new Person("Marina",21, "None");

        assertThrows(IncorrectGenderException.class, () -> person.gender());
    }

    @Test
    void listPersonsNullIs0(){
        person = new Person("Marina",21, "Female");
        double[] obtainedValue = person.averageAgePerGender(null);
        double[] expectedValue = new double[2];
        expectedValue[0] = 0; expectedValue[1] = 0;

        assertArrayEquals(expectedValue, obtainedValue);
    }

    @Test
    void listPersonsIsCorrect(){
        person = new Person("Marina",21, "Female");
        List<Person> lista = new ArrayList<Person>();
        lista.add(person);
        person = new Person("Lola", 33, "Female");
        lista.add(person);
        person = new Person("Antonio", 55, "Male");
        lista.add(person);
        double[] obtainedList = person.averageAgePerGender(lista);

        assertNotNull(obtainedList[0]);
        assertNotNull(obtainedList[1]);
    }

    @Test
    void listPersonsIsIncorrect(){
        person = new Person("Marina",21, "Female");
        List<Person> lista = new ArrayList<Person>();
        lista.add(person);
        person = new Person("Lola", 33, "None");
        lista.add(person);
        person = new Person("Antonio", 55, "Male");
        lista.add(person);

        assertThrows(IncorrectGenderException.class, () -> person.averageAgePerGender(lista));
    }




}
