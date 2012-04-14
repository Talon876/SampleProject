package com.deflexicon.sample;

import java.util.Arrays;
import java.util.Date;

public class SDApp
{

	public void doStuff()
	{
		System.out.println("SD " + new Date().toString());
		System.out.println(Arrays.toString(ex6Part1(1337,9001,42)));
	}

	public int[] ex6Part1(int first, int second, int third)
	{
		int max = 0, mid = 0, min = 0;
		int[] array = new int[3];
		if (first >= second && first >= third)
		{
			max = first;
			if (second >= third)
			{
				mid = second;
				min = third;
			} else
			{
				mid = third;
				min = second;
			}
		} else if (second >= first && second >= third)
		{
			max = second;
			if (first >= third)
			{
				mid = first;
				min = third;
			} else
			{
				mid = third;
				min = first;
			}
		} else
		{
			max = third;
			if (first >= second)
			{
				mid = first;
				min = second;
			} else
			{
				mid = second;
				min = first;
			}
		}
		array[0] = max;
		array[1] = mid;
		array[2] = min;
		return array;
	}

	public int[] ex6Part2(int first, int second, int third)
	{
		int max = 0, mid = 0, min = 0;
		int[] array = new int[3];
		if (first >= second && second >= third)
		{
			max = first;
			mid = second;
			min = third;
		} else if (first >= third && third >= second)
		{
			max = first;
			mid = third;
			min = second;
		} else if (second >= first && first >= third)
		{
			max = second;
			mid = first;
			min = third;
		} else if (second >= third && third >= first)
		{
			max = second;
			mid = third;
			min = first;
		} else if (third >= first && first >= second)
		{
			max = third;
			mid = first;
			min = second;
		} else if (third >= second && second >= first)
		{
			max = third;
			mid = second;
			min = first;
		}
		array[0] = max;
		array[1] = mid;
		array[2] = min;
		return array;
	}
}
