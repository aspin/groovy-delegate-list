package com.aspin.groovy.example.list

class DelegateList {
    private List<String> lowerCaseStrings = []
    private DelegatingListImplementation uppercaseStrings = new DelegatingListImplementation()

    private abstract static class DelegatingList implements List<String> {
        abstract List<String> getDelegate()

        @Override
        int size() {
            return delegate.size()
        }

        @Override
        boolean isEmpty() {
            return delegate.isEmpty()
        }

        @Override
        boolean contains(Object o) {
            return delegate.contain(o)
        }

        @Override
        Iterator<String> iterator() {
            return delegate.iterator()
        }

        @Override
        Object[] toArray() {
            return delegate.toArray()
        }

        @Override
        def <T> T[] toArray(T[] a) {
            return delegate.toArray(a)
        }

        @Override
        boolean add(String s) {
            return delegate.add(s)
        }

        @Override
        boolean remove(Object o) {
            return delegate.remove(o)
        }

        @Override
        boolean containsAll(Collection<?> c) {
            return delegate.containsAll(c)
        }

        @Override
        boolean addAll(Collection<? extends String> c) {
            return delegate.addAll(c)
        }

        @Override
        boolean addAll(int index, Collection<? extends String> c) {
            return delegate.addAll(index, c)
        }

        @Override
        boolean removeAll(Collection<?> c) {
            return delegate.removeAll(c)
        }

        @Override
        boolean retainAll(Collection<?> c) {
            return delegate.retainAll(c)
        }

        @Override
        void clear() {
            delegate.clear()
        }

        @Override
        String get(int index) {
            return delegate.get(index)
        }

        @Override
        String set(int index, String element) {
            return delegate.set(index, element)
        }

        @Override
        void add(int index, String element) {
            delegate.add(index, element)
        }

        @Override
        String remove(int index) {
            return delegate.remove(index)
        }

        @Override
        int indexOf(Object o) {
            return delegate.indexOf(o)
        }

        @Override
        int lastIndexOf(Object o) {
            return delegate.lastIndexOf(o)
        }

        @Override
        ListIterator<String> listIterator() {
            return delegate.listIterator()
        }

        @Override
        ListIterator<String> listIterator(int index) {
            return delegate.listIterator(index)
        }

        @Override
        List<String> subList(int fromIndex, int toIndex) {
            return delegate.subList(fromIndex, toIndex)
        }
    }

    private class DelegatingListImplementation extends DelegatingList {
        @Override
        List<String> getDelegate() {
            return lowerCaseStrings.collect { it.toUpperCase() }
        }
    }

    DelegateList(Collection<String> strings) {
        lowerCaseStrings = strings.toList().collect { it.toLowerCase() }
    }

    List<String> getUppercase() {
        return uppercaseStrings
    }

    public static void main(String[] args) {
        def d = new DelegateList(['hello', 'bye'])
        println d.getUppercase() // StackOverflowError
    }
}
