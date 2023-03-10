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
 * 3. name == null || name == ""
 * 4. age < 0
 * 5. age != null
 * 6. gender != null
 * 7. not (gender == Male && gender == Female)
 * 8. lista persons == null para método averageAgePerGender
 * 9. lista persons es correcta para método averageAgePerGender
 */
public class PersonTest {
    Person person;


    @AfterEach
    void shutDown(){
        person = null;
    }

    //1. name != null
    @Test
    void personNameIsNotNull(){
        person = new Person("Marina",21, "Female");
        String obtainedName = person.name();

        assertNotNull(obtainedName);
    }

    //2. name != "" (cadena vacía)
    @Test
    void personNameIsNotEmpty(){
        person = new Person("Marina",21, "Female");
        String obtainedName = person.name();

        assertNotEquals("", obtainedName);
    }

    //3. name == null || name == ""
    @Test
    void personNameIsEmptyOrIsNull(){
        assertThrows(IncorrectNameException.class, () -> new Person("",21, "Female"));
    }


    //4. age < 0
    @Test
    void personAgeIsNegative(){
        assertThrows(NegativeAgeException.class, () -> new Person("Marina",-6, "Female"));
    }

    //5. age != null
    @Test
    void personAgeIsNotNull(){
        person = new Person("Marina",21, "Female");
        int obtainedAge = person.age();

        assertNotNull(obtainedAge);
    }

    //6. gender != null
    @Test
    void personGenderIsNotNull(){
        person = new Person("Marina",21, "Female");
        String obtainedGender = person.gender();

        assertNotNull(obtainedGender);
    }

    //7. not (gender == Male && gender == Female)
    @Test
    void personGenderIsIncorrect(){
       assertThrows(IncorrectGenderException.class, () -> new Person("Marina",21, "None"));
    }

    //8. lista persons == null para método averageAgePerGender
    @Test
    void listPersonsNullIs0(){
        person = new Person("Marina",21, "Female");
        double[] obtainedValue = person.averageAgePerGender(null);
        double[] expectedValue = new double[2];
        expectedValue[0] = 0; expectedValue[1] = 0;

        assertArrayEquals(expectedValue, obtainedValue);
    }

    //9. lista persons es correcta para método averageAgePerGender
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






}
