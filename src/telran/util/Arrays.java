package telran.util;

import java.util.Comparator;

public class Arrays {
	public static <T> int indexOf(T[] array, T element) {
		int index = 0;
		while (index < array.length && !equals(array[index], element)) {
			index++;
		}
		return index == array.length ? -1 : index;
	}

//на случай, если в массиве попадется элемент null - вот такой фильтр. 
//ПОтому что налл сравнивается не equals, а ==
	private static <T> boolean equals(T elem1, T elem2) {
		return elem1 == null ? elem1 == elem2 : elem1.equals(elem2);
	}

	public static <T> T min(T[] array, Comparator<T> comp) {
		T res = null;
		if (array != null && array.length > 0) {
			res = array[0];
			for (int i = 1; i < array.length; i++) {
				if (comp.compare(res, array[i]) > 0) {
					res = array[i];
				}
			}
		}
		return res;
	}

//HomeWork
	public static <T> void bubbleSort(T[] array, Comparator<T> comp) {
		boolean isSorted = true;
		for (int j = 0; j < array.length - 1 && isSorted; j++) {
			isSorted = false;
			for (int i = 0; i < array.length - j - 1; i++) {
				if (comp.compare(array[i], array[i + 1]) > 0) {
					T tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					isSorted = true;
				}
			}
		}
	}
	
	public static <T> int binarySearch(T[] array, T key, Comparator<T> comp) {
		//TODO
		//only sorted array!
		//if key == length/2  -  return length/2??
		//if key < length/2 - search again in first half. else - in second half
		//left index = 0;
		//right index = array.length-1;
		//middle index = (left + right) /2;
		//left part: left index; right  = middle-1;
		//right part: left index = middle + 1; right index;
		//while  left <= right - additional statement;
		//returns as binary search;
		//if there are several equal elements, 
		//any of indexes can be returned - no guarantee
		return -1;
	}

}
