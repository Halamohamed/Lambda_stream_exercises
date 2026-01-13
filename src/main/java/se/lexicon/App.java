package se.lexicon;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    static App app = new App();
    PersonRule isActive = person -> person.isActive();
    PersonRule isAdult = person -> person.getAge() >= 18;
    PersonRule livesInStockholm = person -> person.getCity().equalsIgnoreCase("Stockholm");
    public static void main( String[] args )
    {
        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );
        System.out.println("----- Active People -----");
        for (Person person : people) {
            if(person.isActive()) {
                System.out.println("Person: " + person);
            }
        }
        System.out.println("----- Adults -----");
        for (Person person : people) {
            if(person.getAge() >= 18) {
                System.out.println("Person: " + person);
            }
        }
        System.out.println("----- People living in Stockholm -----");
        for (Person person : people) {
            if(person.getCity().equalsIgnoreCase("Stockholm")) {
                System.out.println("Person: " + person);
            }
        }
        System.out.println("----- Using filterPeople method -----");
        System.out.println("----- Using filterPeople method for Active People -----");
        List<Person> activePeople = app.filterPeople(people, app.isActive);
        for (Person person : activePeople) {
            System.out.println("Active Person: " + person);
        }
        System.out.println("----- Using filterPeople method for Adults -----");
        List<Person> adultPeople = app.filterPeople(people, app.isAdult);
        for (Person person : adultPeople) {
            System.out.println("Adult Person: " + person);
        }
        System.out.println("----- Using filterPeople method for People living in Stockholm -----");
        List<Person> stockholmPeople = app.filterPeople(people, app.livesInStockholm);
    for (Person person : stockholmPeople) {
        System.out.println("Person in Stockholm: " + person);
    }
    }


    public List<Person> filterPeople(List<Person> people, PersonRule rule) {
        List<Person> result = new ArrayList<>();

        for (Person person : people) {
            if(rule.test(person)) {
                result.add(person);
            }
        }

        return result;
    }
}
