package es.uma.mps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases
 * 1. name != null
 * 2. name != "" (cadena vacía)
 * 3. age >= 0
 * 4. age != null
 * 4. gender != null
 * 5. gender == Male or gender == Female
 */
public class PersonTest {
    Person person;

    @BeforeEach
    void setUp(){

    }

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



}
