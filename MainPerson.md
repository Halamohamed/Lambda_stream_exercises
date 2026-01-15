# Person Processor Project

Simple Java/Maven example that demonstrates filtering, mapping and sorting a list of `Person` objects.

## Quick notes / known fixes
- Mapping names: replace any incorrect predicate using a `String` where a boolean is expected with a proper mapping pipeline. Example:
  \```java
people.stream()
      .map(Person::getName)        // Person -> String
      .map(String::toUpperCase)    // uppercase names
      .sorted()
      .forEach(System.out::println);
\```
- Avoid `.get(0)` on lists that may be empty. Prefer:
  \```java
Optional<Person> firstActive = processor.findPeople(people, Person::isActive).stream().findFirst();
\```

## Contact
Project user: `Halamohamed` (local development)
