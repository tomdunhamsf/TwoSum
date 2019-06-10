package com.marinsoftware.twosum;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 
 * Linear time O(n) implementation, is not sensitive to jvm args
 * If isSum is called much more often than store, and n is not sufficiently large, this 
 * will run slower than precomuting all the sums.
 * However, precompututation requires O(n^2) space, if other applications are running, or
 * Eden is too small, this implementation will run faster in total time (but not
 * on isSum itself.
 * If isSum is not called much more than stoe, this solution is clearly better. 
 *
 */
public class HashTwoSum implements TwoSum {
	private ConcurrentHashMap<Integer,Boolean> nums=new 
			ConcurrentHashMap<Integer,Boolean>(10000,.75f,4);
	/**
	 * Stores each number in a concurrentMap, with a boolean value to handled a frequency
	 * greater than one.  Storage is O(n), compute O(n) for n stores if the map's initial capacity was
	 * chosen well.
	 */
	public void store(int num) {
		if(!nums.containsKey(num)) {
			nums.put(num,false);  //not a duplicate
		}else {
			nums.put(num,true);
		}
	}

	/**

	 * Uses parallel streams to process the HashMap, looking for the different between the 
	 * candidate entry and the Sum.  Duplicates are handled by checking the value of 
	 * the entry, if a number was added more than once, the entry will have a true value.
	 * Runs in O(n)
	 */
	public boolean isSum(int sum) {
		return nums.entrySet().parallelStream().anyMatch(e->{
			int diff=sum-e.getKey();
			if(diff!=e.getKey()) {
				return nums.containsKey(diff);
			}else if(nums.containsKey(diff)){
				return e.getValue();			
			}else {
				return false;
			}
		});
	}


}
