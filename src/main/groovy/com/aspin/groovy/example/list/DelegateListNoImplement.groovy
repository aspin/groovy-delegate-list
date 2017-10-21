package com.aspin.groovy.example.list

class DelegateListNoImplement {
    private List<String> lowerCaseStrings = []
    private DelegatingListImplementation uppercaseStrings = new DelegatingListImplementation()

    private abstract static class DelegatingList {
        abstract List<String> getDelegate()

        int size() {
            return delegate.size()
        }

        boolean isEmpty() {
            return delegate.isEmpty()
        }

        boolean contains(Object o) {
            return delegate.contain(o)
        }

        Iterator<String> iterator() {
            return delegate.iterator()
        }

        Object[] toArray() {
            return delegate.toArray()
        }

        def <T> T[] toArray(T[] a) {
            return delegate.toArray(a)
        }

        boolean add(String s) {
            return delegate.add(s)
        }

        boolean remove(Object o) {
            return delegate.remove(o)
        }

        boolean containsAll(Collection<?> c) {
            return delegate.containsAll(c)
        }

        boolean addAll(Collection<? extends String> c) {
            return delegate.addAll(c)
        }

        boolean addAll(int index, Collection<? extends String> c) {
            return delegate.addAll(index, c)
        }

        boolean removeAll(Collection<?> c) {
            return delegate.removeAll(c)
        }

        boolean retainAll(Collection<?> c) {
            return delegate.retainAll(c)
        }

        void clear() {
            delegate.clear()
        }

        String get(int index) {
            return delegate.get(index)
        }

        String set(int index, String element) {
            return delegate.set(index, element)
        }

        void add(int index, String element) {
            delegate.add(index, element)
        }

        String remove(int index) {
            return delegate.remove(index)
        }

        int indexOf(Object o) {
            return delegate.indexOf(o)
        }

        int lastIndexOf(Object o) {
            return delegate.lastIndexOf(o)
        }

        ListIterator<String> listIterator() {
            return delegate.listIterator()
        }

        ListIterator<String> listIterator(int index) {
            return delegate.listIterator(index)
        }

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

    DelegateListNoImplement(Collection<String> strings) {
        lowerCaseStrings = strings.toList().collect { it.toLowerCase() }
    }

    DelegatingList getUppercase() {
        return uppercaseStrings
    }

    static void main(String[] args) {
        def d = new DelegateListNoImplement(['hello', 'bye'])
        println d.getUppercase().size() // StackOverflowError
    }
}
