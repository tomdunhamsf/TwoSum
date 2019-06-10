package com.marinsoftware.twosum;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class PreComputeTwoSumTest {
	private TwoSum twoSum;
	private TwoSum dupes;
	private TwoSum randomLarge;
	@Before
	public void setUp() throws Exception {
		twoSum=new PreComputeTwoSum();
		twoSum.store(1);
		twoSum.store(5);
		twoSum.store(6);
		dupes=new PreComputeTwoSum();
		dupes.store(3);
		dupes.store(3);
		dupes.store(9);
		dupes.store(-100);
		dupes.store(-7);
		dupes.store(-7);
		dupes.store(-7);
		dupes.store(Integer.MAX_VALUE);
		randomLarge=new PreComputeTwoSum();
		long now=System.currentTimeMillis();
		for(int i=0;i<=1000;i++) {
			Random gen=new Random();
			int val=gen.nextInt();
			randomLarge.store(val);
		}
		System.out.println(System.currentTimeMillis()-now);
		System.out.println(((PreComputeTwoSum)randomLarge).getSizeSet());
		
		randomLarge=new PreComputeTwoSum();
		now=System.currentTimeMillis();
		for(int i=0;i<=10000;i++) {
			Random gen=new Random();
			int val=gen.nextInt();
			randomLarge.store(val);
		}
		System.out.println(System.currentTimeMillis()-now);
		System.out.println(((PreComputeTwoSum)randomLarge).getSizeSet());
	}

	@Test
	public void test() {
		assertFalse(twoSum.isSum(5));
		assertTrue(twoSum.isSum(6));
				assertFalse(twoSum.isSum(10));
				assertTrue(twoSum.isSum(11));
				assertFalse(twoSum.isSum(12));
				assertFalse(twoSum.isSum(13));
				
		assertTrue(dupes.isSum(6));
		assertTrue(dupes.isSum(-91));
		assertTrue(dupes.isSum(Integer.MAX_VALUE-100));
		assertFalse(dupes.isSum(Integer.MIN_VALUE+100));
		assertFalse(dupes.isSum(Integer.MIN_VALUE+99));
		assertFalse(dupes.isSum(Integer.MIN_VALUE+101));
		assertFalse(dupes.isSum(9));
		assertFalse(dupes.isSum(-7));
		assertTrue(dupes.isSum(-14));
		assertFalse(dupes.isSum(-3));
		Random gen=new Random();
		long then=System.currentTimeMillis();
		for(int i=0;i<200000;i++) {
			randomLarge.isSum(gen.nextInt());
		}
		System.out.println(System.currentTimeMillis()-then);
	}

}
