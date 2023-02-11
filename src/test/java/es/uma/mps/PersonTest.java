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
        person = new Person("Marina",21, "Female");
    }

    @AfterEach
    void shutDown(){
        person = null;
    }

    @Test
    void personNameIsNotNull(){
        String obtainedName = person.name();
        assertNotNull(obtainedName);
    }

    @Test
    void personNameIsNotEmpty(){
        String obtainedName = person.name();
        assertNotEquals("", obtainedName);
    }

    @Test
    void personAgeIsNotNull(){
        int obtainedAge = person.age();
        assertNotNull(obtainedAge);
    }

    @Test
    void personGenderIsNotNull(){
        String obtainedGender = person.gender();
        assertNotNull(obtainedGender);
    }



}
