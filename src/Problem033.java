import java.util.ArrayList;
import java.util.HashSet;

// Project Euler problem 33
// Solved on 12/16/2016
public class Problem033 {
    public static void main(String[] args) {
        // numerator and denominator products of the valid fractions
        int nCombined = 1;
        int dCombined = 1;
        
        // loop through valid fractions
        for (int n = 11; n < 100; n++) {
            for (int d = n; d < 100; d++) {
                if (n % 10 == 0 || d % 10 == 0 || n == d) {
                    continue;
                }
                // create character array of the digits so they can be compared
                char[] nArray = Integer.toString(n).toCharArray();
                char[] dArray = Integer.toString(d).toCharArray();
                
                Check:
                // loop through digits and check for matches
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (nArray[i] == dArray[j]) {
                            // cancel the matches and compare the fraction vale with the original value
                            int nRemaining = Character.getNumericValue(nArray[(i + 1) % 2]);
                            int dRemaining = Character.getNumericValue(dArray[(j + 1) % 2]);
                            if ((double)nRemaining / dRemaining == (double)n / d) {
                                nCombined *= n;
                                dCombined *= d;
                                break Check;
                            }
                        }
                    }
                }
            }
        }
        
        // use the Sieve of Eratosthenes to find primes 
        HashSet<Integer> sieve = new HashSet<>();
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= nCombined; i++) {
            if (!sieve.contains(i)) {
                primes.add(i);
                int j = 1;
                while (i * j <= nCombined) {
                    sieve.add(i * j);
                    j++;
                }
            }
        }
        
        // check for primes that reduce the fraction
        for (int i = 0; i < primes.size(); i++) {
            int tempPrime = primes.get(i);
            if (nCombined % tempPrime == 0 && dCombined % tempPrime == 0) {
                nCombined /= tempPrime;
                dCombined /= tempPrime;
                i--;
            }
        }
        System.out.println(dCombined);
    }
}
