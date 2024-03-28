package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import telran.util.Arrays;

class ArraysTests {
	Integer[] numbers = { 100, -3, 23, 4, 8, 41, 56, -7 };
	String[] strings = { "abc", "lmn", "123", null, "a", "" };
	String[] stringsMin = { "abc", "lmn", "123", "y" };

	@Test
	void indexOfTest() {
		assertEquals(1, Arrays.indexOf(strings, "lmn"));
		assertEquals(3, Arrays.indexOf(strings, null));
		assertEquals(-1, Arrays.indexOf(numbers, 150));
		assertEquals(4, Arrays.indexOf(numbers, 8));
	}

	@Test
	void minValueTest() {
		// Lambda closure
		Comparator<String> compLength = (s1, s2) -> s1.length() - s2.length();
		// Same, but with lambda function:
		Comparator<String> compLength1 = (s1, s2) -> {
			return s1.length() - s2.length();
		};

		assertEquals("y", Arrays.min(stringsMin, compLength));
		// lambda expression:
		assertEquals("123", Arrays.min(stringsMin, (s1, s2) -> s1.compareTo(s2)));
	}

	@Test
	void bubbleSortTest() {
		Integer[] expected = { 4, 8, 56, 100, 41, 23, -3, -7 };
		Integer[] numbersCopy = java.util.Arrays.copyOf(numbers, numbers.length);

//		Comparator<Integer> evenOddComp = (o1, o2) -> {
//			evenOddComparator(o1, o2);
		// --------------
//			int res;
//			if((o1+o2)%2 == 0) {
//				res = o1 % 2 == 0 ? o1 - o2 : o2 - o1;
//			}else {
//				res = o1 % 2 == 0 ? -1 : 1;
//			}	
//			return res;

//		};
		// -------------
//		Arrays.bubbleSort(numbersCopy, evenOddComp);
		Comparator<Integer> evenOddComp = this::evenOddComparator;
		Arrays.bubbleSort(numbersCopy, evenOddComp);
		assertArrayEquals(expected, numbersCopy);
	}

	int evenOddComparator(Integer o1, Integer o2) {
		int res;
		if ((o1 + o2) % 2 == 0) {
			res = o1 % 2 == 0 ? o1 - o2 : o2 - o1;
		} else {
			res = o1 % 2 == 0 ? -1 : 1;
		}
		return res;
	}

	@Test
	void searchTest() {
		Integer[] expectedEven = { 100, 4, 8, 56 };
		assertArrayEquals(expectedEven, Arrays.search(numbers, 
				a -> a %2 == 0));
		Integer[] expectedNegative = { -3, -7 };
		assertArrayEquals(expectedNegative, Arrays.search(numbers, a -> a < 0));
	}
	@Test
	void binarySearchTest() {
		//TODO
	}
	
	@Test
	void removeIfTest() {
		//TODO
	}

}
