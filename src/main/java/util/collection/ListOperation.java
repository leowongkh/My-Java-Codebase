package util.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
* Provides method to obtain outputs from multiple large number of {@link List lists}.
* @author Leo Wong Kwan Ho
* @version 1.0
* @see List
*/
public class ListOperation {
	private static ListOperation instance = null;
	
	private ListOperation(){
	}
	
	public static ListOperation getInstance () {
		if (instance == null){
			instance = new ListOperation();
		}
		return instance;
	}
	
	/**
	 * Performs intersect operations over a large number of {@link List lists}.
	 * @param lists {@link List Lists}as an input for the intersection
	 * @param <T> Parameterized type for each {@link List} in the input
	 * @return Intersection of all {@link List lists} as a single {@link List}, null if the first list is null.
	 */
	@SafeVarargs
	public final <T> List<T> intersect (@NotNull List<T>... lists){
		List<T> returnList = List.copyOf(lists[0]);
		for (var currentList: lists) {
			returnList = returnList
					.parallelStream()
					.filter(currentList::contains)
					.collect(Collectors.toList());
		}
		return returnList;
	}
	
	/**
	 * Performs union operations over a large number of {@link List lists}.
	 * @param lists {@link List Lists}as an input for the union
	 * @param <T> Parameterized type for each {@link List} in the input
	 * @return Union of all {@link List lists} as a single {@link List}, null if the first list is null.
	 */
	@SafeVarargs
	public final <T> List<T> union (@NotNull List<T>... lists){
		return Arrays
				.stream(lists)
				.flatMap(List::stream)
				.distinct()
				.collect(Collectors.toList());
	}
}
