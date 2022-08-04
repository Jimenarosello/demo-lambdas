package wolox.lambdas.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wolox.lambdas.demo.model.Hobby;
import wolox.lambdas.demo.model.Person;
import wolox.lambdas.demo.utils.ListProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ListProcessorTests {

	ListProcessor listProcessor = new ListProcessor();

	@Test
	void givenListOfPeople_whenFindPeopleWhoLikeSwimming_thenReturnListOfPeopleWhoSwim() {
		List<Person> people = Arrays.asList(
				new Person("Juan", 20, Arrays.asList(Hobby.SWIMMING, Hobby.PAINTING)),
				new Person("Pedro", 10, Arrays.asList(Hobby.FOOTBALL)),
				new Person("Laura", 30, Arrays.asList(Hobby.CROCHET, Hobby.READING)),
				new Person("Jose", 40, Arrays.asList(Hobby.SWIMMING, Hobby.READING))
		);

		List<Person> results = listProcessor.peopleWhoLikeSwimming(people);
		List<String> names = results.stream().map(Person::getName).collect(Collectors.toList());

		assertEquals(2, results.size());
		assertAll(() -> assertTrue(names.contains("Juan")),
				() -> assertTrue(names.contains("Jose")),
				() -> assertFalse(names.contains("Laura")),
				() -> assertFalse(names.contains("Pedro")));
	}

	@Test
	void givenListOfPeople_whenFindPeopleWhoAreOlderThanEighteen_thenReturnListOfPeopleWhoAreOlder() {
		List<Person> people = Arrays.asList(
				new Person("Juan", 20, null),
				new Person("Pedro", 10, null),
				new Person("Laura", 17, null),
				new Person("Jose", 40,null)
		);

		List<Person> peopleOlder = listProcessor.peopleOlderThanEighteen(people);

		assertEquals(2, peopleOlder.size());
		assertEquals(people.get(0).getAge(), peopleOlder.get(0).getAge());
		assertEquals(people.get(3).getAge(), peopleOlder.get(1).getAge());


	}

	@Test
	void givenListOfPeople_whenFindPeopleWhoseNamesStartWithA_thenReturnListOfPeople() {
		List<Person> people = Arrays.asList(
				new Person("Alejandra", 20, null),
				new Person("Amado", 10, null),
				new Person("Alan", 17, null),
				new Person("Jose", 40,null)
		);

		List<Person> peopleNamesStartWithA = listProcessor.peopleWhoseNameStartsWithA(people);

		assertEquals(3, peopleNamesStartWithA.size());
		assertEquals(people.get(0), peopleNamesStartWithA.get(0));
		assertEquals(people.get(1), peopleNamesStartWithA.get(1));
		assertEquals(people.get(2), peopleNamesStartWithA.get(2));

	}

	@Test
	void givenListOfPeople_whenSortAscByName_thenReturnListOfPeopleOrdered() {
		List<Person> people = Arrays.asList(
				new Person("Ximena", 20, null),
				new Person("Carlos", 10, null),
				new Person("Ale", 40,null),
				new Person("Jose", 17, null)
		);

		List<Person> peopleOrderedByNameAsc = listProcessor.peopleOrderByNameAsc(people);

		assertEquals(people.get(0), peopleOrderedByNameAsc.get(3));
		assertEquals(people.get(2), peopleOrderedByNameAsc.get(0));

	}

	@Test
	void givenListOfPeople_whenAllThePeopleAreOlderThanEighteen_thenReturnTrue() {
		List<Person> people = Arrays.asList(
				new Person("Ximena", 20, null),
				new Person("Carlos", 19, null),
				new Person("Ale", 40,null),
				new Person("Jose", 27, null)
		);
		Boolean areOlder = listProcessor.arePeopleOlderThanEighteen(people);

		assertEquals(areOlder, true);

	}

}
