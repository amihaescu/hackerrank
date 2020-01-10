package ro.amihaescu;

public class JumpingClouds {

    static int jumpingOnClouds(int[] c) {
        int noOfJumps = 0, i = 0;
        int N = c.length;
        while(true) {
            if(i + 2 < N && c[i + 2] == 0) {
                i += 2;
            } else if(i + 1 < N) {
                i++;
            } else {
                break;
            }
            noOfJumps++;
        }
        return noOfJumps;
    }
}
