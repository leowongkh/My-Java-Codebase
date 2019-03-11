package math;

import util.collection.SetOperation;

import java.util.ArrayList;

/**
 * Performs some math operations over a given set of {@link ArrayList}.
 * @author Leo Wong Kwan Ho
 * @version 0.1.0
 */
public class MathOperation{
	private static MathOperation instance = null;
	
	private MathOperation(){
	
	}
	
	public static MathOperation getInstance () {
		if (instance == null){
			instance = new MathOperation();
		}
		return instance;
	}
	/**
	 * Finds the maximum value of an {@link ArrayList}, within on the starting and the ending indices.
	 * @param tArrayList The whole {@link ArrayList} as an input.
	 * @param start The starting index of the sublist of the {@link ArrayList}.
	 * @param end The ending index of the sublist of the {@link ArrayList}.
	 * @param <T> The parameterized type of the {@link ArrayList}. This parameter must be consistent and implements {@link Comparable}.
	 * @return The maximum value of the sublist of the given {@link ArrayList}.
	 * @throws IllegalArgumentException if the start or end indices are out of bounds
	 */
	public static <T extends Comparable<T>> T findMax(ArrayList<T> tArrayList, int start, int end) throws IllegalArgumentException{
		if (start < 0){
			throw new IllegalArgumentException("The starting index cannot be less than 0!");
		} else if (end >= tArrayList.size()){
			throw new IllegalArgumentException("The starting index cannot be greater than the maximum index!");
		}
		if (tArrayList.size() == 0){
			return null;
		}
		int middle = ( start + end) /2;
		if (tArrayList.size() == 1){
			return tArrayList.get(0);
		} else if (tArrayList.size() == 2){
			if (tArrayList.get(0).compareTo(tArrayList.get(1)) > 0){
				return tArrayList.get(0);
			}else {
				return tArrayList.get(1);
			}
		} else{
			T leftMax = findMax((ArrayList<T>) tArrayList.subList(start, middle +1), start, middle);
			T rightMax = findMax((ArrayList<T>) tArrayList.subList(middle +1, end + 1), middle +1, end);
			if (leftMax == null && rightMax == null){
				return null;
			} else if (leftMax == null){
				return rightMax;
			} else if (rightMax == null){
				return leftMax;
			} else{
				if (leftMax.compareTo(rightMax) >-0){
					return leftMax;
				}else {
					return rightMax;
				}
			}
		}
	}
	
	/**
	 * Finds the minimum value of an {@link ArrayList}, within on the starting and the ending indices.
	 * @param tArrayList The whole {@link ArrayList} as an input.
	 * @param start The starting index of the sublist of the {@link ArrayList}.
	 * @param end The ending index of the sublist of the {@link ArrayList}.
	 * @param <T> The parameterized type of the {@link ArrayList}. This parameter must be consistent and implements {@link Comparable}.
	 * @return The minimum value of the sublist of the given {@link ArrayList}.
	 * @throws IllegalArgumentException if the start or end indices are out of bounds
	 */
	public static <T extends Comparable<T>> T findMin(ArrayList<T> tArrayList, int start, int end) throws IllegalArgumentException{
		if (start < 0){
			throw new IllegalArgumentException("The starting index cannot be less than 0!");
		} else if (end >= tArrayList.size()){
			throw new IllegalArgumentException("The starting index cannot be greater than the maximum index!");
		}
		if (tArrayList.size() == 0){
			return null;
		}
		int middle = (start + end) /2;
		if (tArrayList.size() == 1){
			return tArrayList.get(0);
		} else if (tArrayList.size() == 2){
			if (tArrayList.get(0).compareTo(tArrayList.get(1)) < 0){
				return tArrayList.get(0);
			}else {
				return tArrayList.get(1);
			}
		} else{
			T leftMax = findMin((ArrayList<T>) tArrayList.subList(start, middle +1), start, middle);
			T rightMax = findMin((ArrayList<T>) tArrayList.subList(middle +1, end + 1), middle +1, end);
			if (leftMax == null && rightMax == null){
				return null;
			} else if (leftMax == null){
				return rightMax;
			} else if (rightMax == null){
				return leftMax;
			} else{
				if (leftMax.compareTo(rightMax) >-0){
					return leftMax;
				}else {
					return rightMax;
				}
			}
		}
	}
}
