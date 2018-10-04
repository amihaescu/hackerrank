package ro.amihaescu;

public class CondensedIntervals {

    public static void main(String[] args) {
        int[] array = {1,2,4,6,7,8,9,11}; // {1-2,4,6-9,11}

        String result = condenseArray(array);
        System.out.println(result);
    }

     static String condenseArray(int[] array) {
        boolean isSequence = false;
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < array.length; index++) {
            int diff = diff(array, index);
            if (diff != 1 && !isSequence) {
                sb.append(array[index]);
                if (index != array.length - 1) sb.append(",");
            } else if (diff == 1 && !isSequence)  {
                isSequence = true;
                sb.append(array[index]).append("-");
            } else if (diff != 1 && isSequence) {
                sb.append(array[index]);
                if (index != array.length - 1) sb.append(",");
                isSequence = false;
            }
        }
        return sb.toString();
    }

    private static int diff(int[] array, int position) {
        if (position == array.length - 1)
            return -1;
        return array[position + 1] - array[position];
    }
}
