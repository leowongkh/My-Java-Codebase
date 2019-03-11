package util.collection;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.collection.SetOperation.*;

class SetOperationTest {
	
	private Set<Integer> integers1 = Set.of(1, 2, 3, 4);
	private Set<Integer> integers2 = Set.of(2, 3, 4, 5);
	private Set<Integer> integers3 = Set.of(3, 4, 5, 6);
	
	@Test
	void intersectTest () {
		assertEquals(2, Objects.requireNonNull(intersect(integers1, integers2, integers3)).size());
		assertTrue(Objects.requireNonNull(intersect(integers1, integers2, integers3)).contains(3));
		assertTrue(Objects.requireNonNull(intersect(integers1, integers2, integers3)).contains(4));
	}
	
	@Test
	void unionTest () {
		assertEquals(6, Objects.requireNonNull(union(integers1, integers2, integers3)).size());
		assertIterableEquals(Set.of(1, 2, 3, 4, 5, 6), union(integers1,integers2, integers3));
	}
}