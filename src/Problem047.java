import java.util.HashSet;
import java.util.Iterator;

//Project Euler problem 47
// Solved on 1/3/2017
public class Problem047 {
    public static void main(String[] args) {
        int consecutive = 0;        // number of consecutive numbers with four distinct factors
        int n = 1;                  // number being checked
        HashSet<Integer> factors = new HashSet<>();     // holds factors to check for distinctness
        
        // keep looping until four consecutive numbers meeting the criteria are found
        while (consecutive < 4) {
            HashSet<Integer> currentFactors = primeFactorization(n);        // prime factors of the current number
            Iterator<Integer> factorIterator = currentFactors.iterator();
            // iterate through the factors
            while (factorIterator.hasNext()) {
                int nextFactor = factorIterator.next();
                // ...if the factor is distinct or there are four total factors...
                if (factors.contains(nextFactor) || currentFactors.size() != 4) {
                    consecutive = -1;       // set to -1 since 1 is added at the end of the initial while loop
                    factors.clear();
                    break;
                }
            }
            consecutive++;
            n++;
        }
        System.out.println(n - 4);
        
    }
    
    // returns a HashSet of all integer factors of n
    public static HashSet<Integer> primeFactorization(int n) {
        HashSet<Integer> primeFactors = new HashSet<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                primeFactors.addAll(primeFactorization(i));
                primeFactors.addAll(primeFactorization(n / i));
                break;
            }
        }
        if (primeFactors.size() == 0) {
            primeFactors.add(n);
        }
        return primeFactors;
    }
}
