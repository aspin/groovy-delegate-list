package com.aspin.java.example.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DelegateList {
    private List<String> lowerCaseStrings = new ArrayList<>();
    private DelegatingListImplementation uppercaseStrings = new DelegatingListImplementation();

    private abstract static class DelegatingList implements List<String> {
        abstract List<String> getDelegate();

        @Override
        public int size() {
            return getDelegate().size();
        }

        @Override
        public boolean isEmpty() {
            return getDelegate().isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return getDelegate().contains(o);
        }

        @Override
        public Iterator<String> iterator() {
            return getDelegate().iterator();
        }

        @Override
        public void forEach(Consumer<? super String> action) {
            getDelegate().forEach(action::accept);
        }

        @Override
        public Object[] toArray() {
            return getDelegate().toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return getDelegate().toArray(a);
        }

        @Override
        public boolean add(String s) {
            return getDelegate().add(s);
        }

        @Override
        public boolean remove(Object o) {
            return getDelegate().remove(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return getDelegate().containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends String> c) {
            return getDelegate().addAll(c);
        }

        @Override
        public boolean addAll(int index, Collection<? extends String> c) {
            return getDelegate().addAll(index, c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return getDelegate().removeAll(c);
        }

        @Override
        public boolean removeIf(Predicate<? super String> filter) {
            return getDelegate().removeIf(filter);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return getDelegate().retainAll(c);
        }

        @Override
        public void replaceAll(UnaryOperator<String> operator) {
            getDelegate().replaceAll(operator);
        }

        @Override
        public void sort(Comparator<? super String> c) {
            getDelegate().sort(c);
        }

        @Override
        public void clear() {
            getDelegate().clear();
        }

        @Override
        public String get(int index) {
            return getDelegate().get(index);
        }

        @Override
        public String set(int index, String element) {
            return getDelegate().set(index, element);
        }

        @Override
        public void add(int index, String element) {
            getDelegate().add(index, element);
        }

        @Override
        public String remove(int index) {
            return getDelegate().remove(index);
        }

        @Override
        public int indexOf(Object o) {
            return getDelegate().indexOf(o);
        }

        @Override
        public int lastIndexOf(Object o) {
            return getDelegate().lastIndexOf(o);
        }

        @Override
        public ListIterator<String> listIterator() {
            return getDelegate().listIterator();
        }

        @Override
        public ListIterator<String> listIterator(int index) {
            return getDelegate().listIterator(index);
        }

        @Override
        public List<String> subList(int fromIndex, int toIndex) {
            return getDelegate().subList(fromIndex, toIndex);
        }

        @Override
        public Spliterator<String> spliterator() {
            return getDelegate().spliterator();
        }

        @Override
        public Stream<String> stream() {
            return getDelegate().stream();
        }

        @Override
        public Stream<String> parallelStream() {
            return getDelegate().parallelStream();
        }
    }

    private class DelegatingListImplementation extends DelegatingList {
        @Override
        List<String> getDelegate() {
            return lowerCaseStrings.stream().map(String::toUpperCase).collect(Collectors.toList());
        }
    }

    private DelegateList(Collection<String> strings) {
        lowerCaseStrings = strings.stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    private List<String> getUppercase() {
        return uppercaseStrings;
    }

    public static void main(String[] args) {
        DelegateList d = new DelegateList(Arrays.asList("hello", "bye"));
        System.out.println(d.getUppercase());
    }
}
