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
    private static PersonRule isActive = person -> person.isActive();
    private static PersonRule isAdult = person -> person.getAge() >= 18;
    private static PersonRule livesInStockholm = person -> person.getCity().equalsIgnoreCase("Stockholm");
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
        List<Person> activePeople = filterPeople(people, isActive);
        for (Person person : activePeople) {
            System.out.println("Active Person: " + person);
        }
        System.out.println("----- Using filterPeople method for Adults -----");
        List<Person> adultPeople = filterPeople(people, isAdult);
        for (Person person : adultPeople) {
            System.out.println("Adult Person: " + person);
        }
        System.out.println("----- Using filterPeople method for People living in Stockholm -----");
        List<Person> stockholmPeople = filterPeople(people, livesInStockholm);
    for (Person person : stockholmPeople) {
        System.out.println("Person in Stockholm: " + person);
    }
        System.out.println("----- Using makeAction method to set all people as inactive -----");
        PersonAction sendEmail = person -> person.setName("Send email to " + person.getName());
        List<String> updatedPeople = makeAction(people, sendEmail);
        for (String person  : updatedPeople) {
            System.out.println("Updated Person: " + person);
        }
    }


    public static List<Person> filterPeople(List<Person> people, PersonRule rule) {
        List<Person> result = new ArrayList<>();

        for (Person person : people) {
            if(rule.test(person)) {
                result.add(person);
            }
        }

        return result;
    }
    public static List<String> makeAction(List<Person> people, PersonAction action) {
        List<String> result = new ArrayList<>();

        for (Person person : people) {
            action.action(person);
            result.add("Send email to " + person.getName());
        }

        return result;
    }
}
