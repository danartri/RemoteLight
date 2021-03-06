package de.lars.remotelightclient.utils;

import java.util.Arrays;

public class ArrayUtil {

	public static int sumOfArray(int[] array) {
		int sum = 0;
		for(int v : array)
			sum += v;
		return sum;
	}
	
	public static float sumOfArray(float[] array) {
		float sum = 0F;
		for(float v : array)
			sum += v;
		return sum;
	}
	
	
	public static int avgOfArray(int[] array) {
		int sum = sumOfArray(array);
		return sum / array.length;
	}
	
	public static float avgOfArray(float[] array) {
		float sum = sumOfArray(array);
		return sum / array.length;
	}
	
	
	public static float maxOfArray(float[] array) {
		float max = 0;
		for(float v : array) {
			if(v > max)
				max = v;
		}
		return max;
	}
	
	public static double maxOfArray(double[] array) {
		double max = 0;
		for(double v : array) {
			if(v > max)
				max = v;
		}
		return max;
	}
	
	
	/**
	 * Get subarray of an array
	 * @param ampl Original array
	 * @param startIndex From index (inclusive)
	 * @param endIndex To index (inclusive)
	 * @return Subarray
	 */
	public static float[] subArray(float[] ampl, int startIndex, int endIndex) {
		return Arrays.copyOfRange(ampl, startIndex, endIndex + 1);
	}
	
}
