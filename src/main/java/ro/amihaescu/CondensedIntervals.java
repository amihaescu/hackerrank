package ro.amihaescu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CondensedIntervals {

    public static void main(String[] args) {
        int[] array = {1,2,4,6,7,8,9,11}; // {1-2,4,6-9,11}

        String result = condenseArray(array);
        System.out.println(result);
    }

    private static String condenseArray(int[] array) {
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

    private static String condenseArrayStreams(int[] array) {
        List<String> result = IntStream.of(array)
                .boxed()
                .collect(Collector.of(
                        () -> {
                            List<List<Integer>> list = new ArrayList<>();
                            list.add(new ArrayList<>());
                            return list;
                        },
                        (list, x) -> {
                            List<Integer> inner = list.get(list.size() - 1);
                            if (inner.size() == 0) {
                                inner.add(x);
                            } else {
                                int lastElement = inner.get(inner.size() - 1);
                                if (lastElement == x - 1) {
                                    inner.add(x);
                                } else {
                                    List<Integer> oneMore = new ArrayList<>();
                                    oneMore.add(x);
                                    list.add(oneMore);
                                }
                            }
                        },
                        (left, right) -> {
                            throw new IllegalArgumentException("No parallel!");
                        },

                        list -> {

                            return list.stream()
                                    .map(inner -> {
                                        if (inner.size() > 1) {
                                            return inner.get(0) + "-" + inner.get(inner.size() - 1);
                                        }
                                        return "" + inner.get(0);
                                    }).collect(Collectors.toList());

                        }));
        return result.toString();
    }

    private static int diff(int[] array, int position) {
        if (position == array.length - 1)
            return -1;
        return array[position + 1] - array[position];
    }
}
