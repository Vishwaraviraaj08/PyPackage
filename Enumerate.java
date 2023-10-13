import java.util.*;

public class Enumerate {
    public static <T> Iterable<Pair<?>> enumerate(final Collection<? extends T> collection) {
        return new Iterable<Pair<?>>() {
            @Override
            public Iterator<Pair<?>> iterator() {
                return new Iterator<Pair<?>>() {
                    private Iterator<? extends T> iterator = collection.iterator();
                    private int index = 0;

                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public Pair<?> next() {
                        if (!hasNext()) {
                            throw new java.util.NoSuchElementException();
                        }
                        Pair<?> pair = new Pair<>(index, iterator.next());
                        index++;
                        return pair;
                    }
                };
            }
        };
    }

    public static <T> Iterable<Pair<?>> enumerate(final T[] array) {
        return new Iterable<Pair<?>>() {
            @Override
            public Iterator<Pair<?>> iterator() {
                return new Iterator<Pair<?>>() {
                    private int index = 0;

                    @Override
                    public boolean hasNext() {
                        return index < array.length;
                    }

                    @Override
                    public Pair<?> next() {
                        if (!hasNext()) {
                            throw new java.util.NoSuchElementException();
                        }
                        Pair<?> pair = new Pair<>(index, array[index]);
                        index++;
                        return pair;
                    }
                };
            }
        };
    }

    public static class Pair<T> {
        private final int index;
        private final T value;

        private Pair(int index, T value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public T getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + index + ", " + value + ")";
        }
    }

    public static void main(String[] args) {
        String[] itemsArray = {"apple", "banana", "cherry"};
        List<String> itemsList = List.of("apple", "banana", "cherry");

        for (Pair<?> pair : enumerate(itemsArray)) {
            System.out.println(pair.getIndex() + " " + pair.getValue());
        }

        for (Pair<?> pair : enumerate(itemsList)) {
            System.out.println(pair);
        }
    }
}
