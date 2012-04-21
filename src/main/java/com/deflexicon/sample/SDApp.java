package com.deflexicon.sample;

import java.util.*;

public class SDApp
{
	private static final int[] TESTINTS = {1337,9001,42};
	public void doStuff()
	{
		ex6Part1(TESTINTS[0],TESTINTS[1],TESTINTS[2]);
		ex6Part2(TESTINTS[0],TESTINTS[1],TESTINTS[2]);
	}

	public int[] ex6Part1(int first, int second, int third)
	{
		Integer[] array = {first,second,third};
		Arrays.sort(array,Collections.reverseOrder());
		int ret[]  = new int[array.length];
		for (int i = 0; i < array.length; i++) {
		    ret[i] = (int)array[i];
		}
		return ret;
	}

	public int[] ex6Part2(int first, int second, int third)
	{
		Integer[] array = {first,second,third};
		Arrays.sort(array, Collections.reverseOrder());
		int ret[]  = new int[array.length];
		for (int i = 0; i < array.length; i++) {
		    ret[i] = (int)array[i];
		}
		return ret;
	}
}
