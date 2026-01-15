package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class PersonProcessor {

    List<Person> findPeople(List<Person> people, PersonRule rule) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (rule.test(person)) {
                result.add(person);
            }
        }
        return result;

    }
    void applyToMatching(List<Person> people, PersonRule rule, PersonAction action) {
         for (Person person : people) {
              if (rule.test(person)) {
                  action.action(person);
              }
         }

    }
}
