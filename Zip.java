import java.util.*;

class Zip<T> {

    @SafeVarargs
    public final Iterable<List<T>> zipArrays(T[]... arrays) {
        List<List<T>> result = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;

        for (T[] array : arrays) {
            minLength = Math.min(minLength, array.length);
        }

        for (int i = 0; i < minLength; i++) {
            List<T> tuple = new ArrayList<>();
            for (T[] array : arrays) {
                tuple.add(array[i]);
            }
            result.add(tuple);
        }

        return result;
    }

    public final Iterable<List<?>> zipLists(List<?>... lists) {
        List<List<?>> result = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;

        for (List<?> list : lists) {
            minLength = Math.min(minLength, list.size());
        }
        for (int i = 0; i < minLength; i++) {
            List<Object> tuple = new ArrayList<>();
            for (List<?> list : lists) {
                tuple.add(list.get(i));
            }
            result.add(tuple);
        }
        return result;
    }

    public static void main(String[] args) {
        Zip<Object> zip = new Zip<>();

        Integer[] arr1 = {1, 2, 3};
        String[] arr2 = {"a", "b", "c"};
        Boolean[] arr3 = {true, false};

        for (List<?> tuple : zip.zipArrays(arr1, arr2, arr3)) {
            System.out.println(tuple);
        }

        Integer[][] arr2D = {{100, 200, 300}, {1000, 2000, 3000}};

        for (List<?> tuple : zip.zipArrays(arr2D)) {
            System.out.println(tuple);
        }

        List<Integer> list1 = List.of(10, 20, 30);
        List<String> list2 = List.of("apple", "banana", "orange");
        List<Boolean> list3 = List.of(false, true, true);


        for (List<?> tuple : zip.zipLists(list1, list2, list3)) {
            System.out.println(tuple);
        }
    }
}