package com.github.rshtishi;

import java.util.*;

public class Exercise5 {

    static class SDAHashSet<E> implements Set<E> {
        private Set<E> data = new HashSet<>();
        @Override
        public int size() {
            return data.size();
        }

        @Override
        public boolean isEmpty() {
            return data.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return data.contains(o);
        }

        @Override
        public Iterator<E> iterator() {
            return data.iterator();
        }

        @Override
        public Object[] toArray() {
            return data.toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return data.toArray(a);
        }

        @Override
        public boolean add(E e) {
            return data.add(e);
        }

        @Override
        public boolean remove(Object o) {
            return data.remove(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return data.containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return data.addAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return data.retainAll(c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return data.removeAll(c);
        }

        @Override
        public void clear() {
            data.clear();
        }
    }

    public static void main(String[] args){
        SDAHashSet<String> set = new SDAHashSet<>();

        set.addAll(Arrays.asList("John","Jane","Jeremy"));
        System.out.println(set.size());
        set.remove("Jane");
        System.out.println(set.contains("Jane"));
        set.clear();

    }
}
