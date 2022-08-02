package wolox.lambdas.demo.utils;

import wolox.lambdas.demo.model.Hobby;
import wolox.lambdas.demo.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class ListProcessor {

    public List<Person> peopleWhoLikeSwimming(List<Person> people) {
        return people.stream().filter(it -> it.getHobbies().contains(Hobby.SWIMMING)).collect(Collectors.toList());
    }

    public List<String> peoplesNames(List<Person> people) {
        return people.stream().map(Person::getName).collect(Collectors.toList());
    }

    public List<Person> peopleOlderThanEighteen(List<Person> people) {
        // TODO
        return null;
    }

    public List<Person> peopleWhoseNameStartsWithA(List<Person> people) {
        // TODO
        return null;
    }

}
