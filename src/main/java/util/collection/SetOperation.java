package util.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Provides method to obtain outputs from multiple large number of {@link Set sets}.
 * @author Leo Wong Kwan Ho
 * @version 1.0
 * @see Set
 */
public class SetOperation {
	private static SetOperation instance = null;
	
	private SetOperation(){
	
	}
	
	public static SetOperation getInstance () {
		if (instance == null){
			instance = new SetOperation();
		}
		return instance;
	}
	
	/**
	 * Performs intersect operations over a large number of {@link Set sets}.
	 * @param <T> Type for each {@link Set} in the input
	 * @param sets {@link Set Sets}as an input for the intersection
	 * @return Intersection of all {@link Set sets} as a single {@link Set}, null if the first set contains null values.
	 */
	@SafeVarargs
	public static <T> Set<T> intersect (@NotNull Set<T>... sets){
		if ( sets[0].isEmpty())
		{
			return null;
		}
		Set<T> returnSet = Set.copyOf(sets[0]);
		for (Set<T> currentSet : sets) {
			returnSet = returnSet.parallelStream()
					.filter(currentSet::contains)
					.collect(Collectors.toSet());
		}
		return returnSet;
	}
	
	/**
	 * Performs union operation on a large number of {@link Set sets}.
	 * @param <T> Type for each {@link Set} in the input
	 * @param sets {@link Set Sets}as an input for the union
	 * @return Union of all {@link Set sets} as a single {@link Set}, null if the first set contains null values.
	 */
	@SafeVarargs
	public static <T> Set<T> union (@NotNull Set<T>... sets){
		if (sets[0].isEmpty()) {
			return null;
		}
		
		return Arrays.asList(sets)
				.parallelStream()
				.flatMap(Set::stream)
				.collect(Collectors.toSet());
	}
}
