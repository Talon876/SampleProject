package com.deflexicon.sample;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SDAppTest
{

	@Test
	public void testEx6Part1()
	{
		System.out.println("ex6Part1 equal numbers");
		int first = 0;
		int second = 0;
		int third = 0;
		SDApp instance = new SDApp();
		int[] expResult = { 0, 0, 0 };
		int[] result = instance.ex6Part1(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part1 first,second,third");
		expResult[0] = 3;
		expResult[1] = 2;
		expResult[2] = 1;

		first = 3;
		second = 2;
		third = 1;
		result = instance.ex6Part1(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part1 first,third,second");
		first = 3;
		second = 1;
		third = 2;
		result = instance.ex6Part1(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part1 second,first,third");
		first = 2;
		second = 3;
		third = 1;
		result = instance.ex6Part1(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part1 second,first,third");
		first = 1;
		second = 3;
		third = 2;
		result = instance.ex6Part1(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part1 third,second,first");
		first = 1;
		second = 2;
		third = 3;
		result = instance.ex6Part1(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part1 third,first,second");
		first = 2;
		second = 1;
		third = 3;
		result = instance.ex6Part1(first, second, third);
		assertArrayEquals(expResult, result);
	}

	@Test
	public void testEx6Part2()
	{
		System.out.println("ex6Part2 equal numbers");
		int first = 0;
		int second = 0;
		int third = 0;
		SDApp instance = new SDApp();
		int[] expResult = { 0, 0, 0 };
		int[] result = instance.ex6Part2(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part2 first,second,third");
		expResult[0] = 3;
		expResult[1] = 2;
		expResult[2] = 1;

		first = 3;
		second = 2;
		third = 1;
		result = instance.ex6Part2(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part2 first,third,second");
		first = 3;
		second = 1;
		third = 2;
		result = instance.ex6Part2(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part2 second,first,third");
		first = 2;
		second = 3;
		third = 1;
		result = instance.ex6Part2(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part2 second,first,third");
		first = 1;
		second = 3;
		third = 2;
		result = instance.ex6Part2(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part2 third,second,first");
		first = 1;
		second = 2;
		third = 3;
		result = instance.ex6Part2(first, second, third);
		assertArrayEquals(expResult, result);

		System.out.println("ex6Part2 third,first,second");
		first = 2;
		second = 1;
		third = 3;
		result = instance.ex6Part2(first, second, third);
		assertArrayEquals(expResult, result);
	}

}
