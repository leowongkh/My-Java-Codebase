package algo;

import java.util.HashMap;

public class Arrays {
	
	/**
	 * Returns a map that maps the count for each element in the array to each value in the array.
	 *
	 * <p>
	 *     Time complexity: <code>O(n)</code>
	 * </p>
	 * @param array The array that is to be mapped.
	 * @param <T> The data type for each element of the array. Must implement equals() and not be primitive.
	 * @return A {@link HashMap} that maps counts of an element in the array to the corresponding element.
	 */
	public static <T> HashMap<T, Integer> hashCount(T[] array){
		HashMap<T, Integer> tHashMap = new HashMap<>();
		
		for (int i = 0;  i < array.length; i++){
			if (tHashMap.containsKey(array[i])){
				tHashMap.replace(array[i], tHashMap.get(array[i]) + 1);
			}else{
				tHashMap.put(array[i], 1);
			}
		}
		return tHashMap;
	}
}
