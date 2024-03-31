package telran.util;

import java.util.Comparator;
import java.util.function.Predicate;

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
		int left = 0;
		int right = array.length - 1;
		int result = -1;
		while (left <= right && result < 0) {
			int middle = (left + right) / 2;
			int compResult = comp.compare(key, array[middle]);
			if (compResult == 0) {
				result = middle;
			} else if (compResult < 0) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return result != -1 ? result : -(left + 1);
	}

	public static <T> T[] search(T[] array, Predicate<T> predicate) {
		T[] arResult = java.util.Arrays.copyOf(array, array.length);
		int index = 0;
		for (int i = 0; i < array.length; i++) {

			if (predicate.test(array[i])) {
				arResult[index++] = array[i];
			}
		}
		return java.util.Arrays.copyOf(arResult, index);
	}

	public static <T> T[] removeIf(T[] array, Predicate<T> predicate) {
		return search(array, predicate.negate());
	}

}
