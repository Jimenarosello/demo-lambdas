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
        return people.stream()
                .filter(p -> p.getAge() > 18)
                .collect(Collectors.toList());
    }

    public List<Person> peopleWhoseNameStartsWithA(List<Person> people) {
        return people.stream()
                .filter(p -> p.getName().charAt(0) == 'A')
                .collect(Collectors.toList());
    }

    public List<Person> peopleOrderByNameAsc(List<Person> people) {
        return people.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());
    }

    public Boolean arePeopleOlderThanEighteen(List<Person> people) {
        return people.stream()
                .allMatch(p -> p.getAge() > 18);
    }

}
