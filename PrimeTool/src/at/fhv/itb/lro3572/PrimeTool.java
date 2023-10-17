package at.fhv.itb.lro3572;

import java.util.Arrays;

public class PrimeTool {
	public static boolean[] _primes = new boolean[1];
	public static int _highestChecked = 0;
	
	public boolean isPrime(int number) {
		if (number > _highestChecked) {  // First time checking or new _highestChecked
			boolean[] newPrimes = new boolean[number + 1];
			Arrays.fill(newPrimes, true);
			newPrimes[0] = false;
			newPrimes[1] = false;
			_primes = sieveForPrimes(newPrimes);
			_highestChecked = number;
		}

		// The new number has already been checked before -> get result from array _primes
		if (_primes[number] == true) {
			return true;
		}
		else {
			return false;
		}	
	}

	public int[] getPrimesInRange(int lowerBound, int upperBound) {
		if (upperBound > _highestChecked) {  // First time checking
			boolean[] newPrimes = new boolean[upperBound + 1];
			Arrays.fill(newPrimes, true);
			newPrimes[0] = false;
			newPrimes[1] = false;
			_primes = sieveForPrimes(newPrimes);
			_highestChecked = upperBound;
		}

//		counts primes in range and defines the length for the new array
		int count = 0;
		int i;
		for (i = lowerBound; i <= upperBound; i += 1) {
			if (_primes[i] == true) {
				count += 1;
			}
		}
		
		i = 0;
		int[] rangeOfPrimes = new int[count];
		
//		copies primes from array _primes into new array rangeOfPrimes
		while (lowerBound <= upperBound) {
			if (_primes[lowerBound] == true) {
				rangeOfPrimes[i] = lowerBound;
				i += 1;
			}
			lowerBound += 1;
		}
		return rangeOfPrimes;
	}
	
	private boolean[] sieveForPrimes(boolean[] primes) {
		int i;
		int j;
		for (i = 2; (i < Math.sqrt(primes.length - 1)); i += 1) {
			if (primes[i] == true) {
				for (j = i + i; j < primes.length; j += i) {
					primes[j] = false;
				}				
			}
		}
		return primes;
	}
	
	@Override
	public String toString() {
		return "PrimeTool []";
	}

	public static void main(String[] args) {
		PrimeTool primeTool1 = new PrimeTool();
		System.out.println("isPrime(10): " + primeTool1.isPrime(10)); 
		System.out.println("isPrime(20): " + primeTool1.isPrime(20)); 
		System.out.println("isPrime(5): " + primeTool1.isPrime(5)); 
		
		PrimeTool primeTool2 = new PrimeTool();
		int[] arr1 = primeTool2.getPrimesInRange(4, 17);
		int[] arr2 = primeTool2.getPrimesInRange(6, 14);
		int[] arr3 = primeTool2.getPrimesInRange(15, 32);
		
		System.out.print("\n\ngetPrimesInRange(4, 17): ");
		for(int i = 0; i < arr1.length; i += 1) {
			System.out.print(arr1[i] + "\t");
		}
		
		System.out.print("\n\ngetPrimesInRange(6, 14): ");
		for(int i = 0; i < arr2.length; i += 1) {
			System.out.print(arr1[i] + "\t");
		}
		
		System.out.print("\n\ngetPrimesInRange(15, 32): ");
		for(int i = 0; i < arr3.length; i += 1) {
			System.out.print(arr3[i] + "\t");
		}
	}

}
