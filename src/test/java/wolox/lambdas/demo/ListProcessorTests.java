package wolox.lambdas.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wolox.lambdas.demo.model.Hobby;
import wolox.lambdas.demo.model.Person;
import wolox.lambdas.demo.utils.ListProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

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
}
