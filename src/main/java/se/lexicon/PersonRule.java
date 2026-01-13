package se.lexicon;

@FunctionalInterface
public interface PersonRule {
    boolean test(Person person);
}
