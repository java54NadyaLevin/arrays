package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {
	public int compare(Integer o1, Integer o2) {
		int res;
		if((o1+o2)%2 == 0) {
			res = o1 % 2 == 0 ? o1 - o2 : o2 - o1;
		}else {
			res = o1 % 2 == 0 ? -1 : 1;
		}	
		return res;
		
	}

}
