package com.marinsoftware.twosum;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
	/**
	 * Total time will beat a linear time implementation of isSum if isSum is called
	*  much more often than store, if jvm can be tuned for this algorithm 
	 * 
	 *
	 */
public class PreComputeTwoSum implements TwoSum {
	private Set<Integer> sums=new ConcurrentHashMap<Long,Boolean>(1000000000,.75f,4).newKeySet();
	private List<Integer> nums=new ArrayList<Integer>();
	/**
	 * 
	* Store the input value and calculate all the sums
	* Requires O(n^2) space and time, but time will be worse in practice
	* if Eden is not large enough - highly sensitive to -Xmn jvm arg
	* 
	*/
	public void store(int value) {
		if(nums.size()>0){
				nums.parallelStream()
				.mapToLong(e->e+value)
				.forEach(e->{if(e<=Integer.MAX_VALUE&&e>=Integer.MIN_VALUE) {
					sums.add((int) e);	
				}});	
		}//While this was a stateful lambda, if the number of partitions were chosen
		// well on the concurrent map, contention should be minimal.
		nums.add(value);
	}
	/**
	 * Determine if value is the sum of exactly two values that have been passed to the store function
* @param value the value that we want to test
* @return true if value is the sum of two values passed to the store function
* false if it is not the sum of two values 
	* Very fast O(1) implementation
	*/
	public boolean isSum(int value) {
		return sums.contains(value);
	}
	public int getSizeSet() {
		return sums.size();
	}

}
