package ro.amihaescu.dynamic;

/**
 * Catalan number: C(n) = (2n)!/[(n+1)!n!] = product of (n+k)/k for k=2,n
 */
public class CatalanNumber {

    private final Integer n;

    public CatalanNumber(Integer n) {
        this.n = n;
    }

    public static void main(String[] args) {
        var start = System.nanoTime();
        CatalanNumber catalanNumber = new CatalanNumber(4);
        var result = catalanNumber.compute(false);
        var stop = System.nanoTime();
        System.out.printf("Computing %d took %d ns\n", result, stop - start);
        System.out.println("###################");
        var dyckPathResult = catalanNumber.dyckPath();
        System.out.printf("Computing dyck path %d", dyckPathResult);
    }

    public Long compute(boolean recursive) {
        if (recursive) {
            return recursive(this.n);
        }
        return dynamicProg(this.n);
    }
    /*
    Time complexity exponential
    Auxiliary space O(n)
     */
    private Long recursive(Integer n) {
        long res = 0;
        if (n <= 1) {
            return 1L;
        }
        for (int i = 0; i< n; i++) {
            res += recursive(i) * recursive(n -i -1);
        }
        return res;
    }

    private Long dynamicProg(Integer n) {
        long catalan[] = new long[n+2];
        catalan[0] = 1;
        catalan[1] = 1;
        for (int i = 2 ; i <=n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i -j -1];
            }
        }
        return catalan[n];
    }

    public Long dyckPath() {
        if (n <=1 ) {
            return 1L;
        }
        var product = 1L;
        for (int k = 2; k <= n; k++ ) {
            product *= ((double) (n + k) / k);
        }
        return product;
    }
}
