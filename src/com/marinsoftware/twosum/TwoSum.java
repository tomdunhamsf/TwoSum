package com.marinsoftware.twosum;

/**
* Provide an efficient implement for the interface below:
* 1) Store numbers (less frequently used).
* 2) Detecting if a number is the sum of two previously stored numbers (frequently used).
* 3) Test cases.
* Solution is expected to be efficient to the more frequent use case
* Please state the space and time complexity of your implementation
*/
public interface TwoSum {
/**
* Store the input value for later use in isSum
* @param value the value that needs to be stored
*/
public void store(int value);
/**
* Determine if value is the sum of exactly two values that have been passed to the store function
* @param value the value that we want to test
* @return true if value is the sum of two values passed to the store function
* false if it is not the sum of two values
*/
public boolean isSum(int value);
}