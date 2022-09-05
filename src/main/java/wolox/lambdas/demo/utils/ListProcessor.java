package wolox.lambdas.demo.utils;

import wolox.lambdas.demo.constants.AvailableCurrencies;
import wolox.lambdas.demo.model.Hobby;
import wolox.lambdas.demo.model.Person;
import wolox.lambdas.demo.model.Wallet;

import java.util.List;
import java.util.stream.Collectors;

public class ListProcessor {

    public List<Person> peopleWhoLikeSwimming(List<Person> people) {
        return people.stream()
                .filter(it -> it.getHobbies().contains(Hobby.SWIMMING))
                .collect(Collectors.toList());
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

    public Double peopleSavedMoneyOlder(List<Person> people) {
        return people.stream()
                .filter(p -> p.getAge() > 18)
                .mapToDouble(Person::getMoney)
                .sum();
    }

    public List<Wallet> peopleWallets(List<Person> people) {
        return people.stream()
                .map(this::createWallet)
                .collect(Collectors.toList());
    }

    public List<Wallet> peopleWalletOnUsdAndGreaterThan(List<Person> people,Double amount) {
        return people.stream()
                .filter(w -> w != null)
                .map(this::createWallet)
                .filter(w -> w.getCurrency().equals(AvailableCurrencies.USD))
                .filter(w -> w.getMoney() > amount)
                .collect(Collectors.toList());
    }

    private Wallet createWallet(Person person) {
        return new Wallet(person.getCurrency(), person.getMoney());
    }

}
