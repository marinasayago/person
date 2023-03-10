package es.uma.mps;

import java.util.List;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author Marina Sayago Gutiérrez
 */

public class Person {
    private final String name;
    private final int age;
    private final String gender; //Male, Female

    /**
     * Constructs a person with a name, age and gender.
     *
     * @param name    the name of the person
     * @param age     the age of the person
     * @param gender  the gender of the person
     *
     */

    public Person(String name, int age, String gender){

        if (name.equals("") || name.equals(null)) throw new IncorrectNameException("The name " + name + " is incorrect");
        this.name = name;

        if (age < 0) throw new NegativeAgeException("The age " + age + " is negative.");
        this.age = age;

        if(!gender.equals("Male") && !gender.equals("Female")) throw new IncorrectGenderException("The gender " + gender + " is incorrect");
        this.gender = gender;
    }

    public String name(){
        return name;
    }

    public int age(){
        return age;
    }

    public String gender(){
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in
     * a array of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     *
     * @param persons
     * @return
     */

    public double[] averageAgePerGender(List<Person> persons) {
        double [] maleMeanAge = new double[2];
        double [] femaleMeanAge = new double[2];
        double [] averageAge = new double[2];
        if(persons != null){
            for(Person p : persons){
                if(p.gender().equals("Male")){
                    maleMeanAge[0] += p.age();
                    ++maleMeanAge[1];
                }else if(p.gender().equals("Female")){
                    femaleMeanAge[1] += p.age();
                    ++femaleMeanAge[0];
                }
            }

            averageAge[0] = maleMeanAge[0] / maleMeanAge[1];
            averageAge[1] = femaleMeanAge[0] / femaleMeanAge[1];
        }


        return averageAge;
    }
}
