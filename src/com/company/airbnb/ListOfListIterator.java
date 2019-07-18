package com.company.airbnb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListOfListIterator implements Iterator<Integer> {
    Iterator<List<Integer>> iterators;
    Iterator<Integer> iterator;

    public ListOfListIterator(List<List<Integer>> vec2d) {
        iterators = vec2d.iterator();
        if (iterators.hasNext()) iterator = iterators.next().iterator();
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }});
        test.add(new ArrayList<Integer>() {{
            add(3);
        }});
        test.add(new ArrayList<Integer>() {{
            add(4);
            add(5);
            add(6);
        }});
        ListOfListIterator sol = new ListOfListIterator(test);
        assert (sol.hasNext());
        assert (1 == sol.next());
        sol.remove();
        List<Integer> res = new ArrayList<>();
        while (sol.hasNext()) {
            res.add(sol.next());
        }
        assert (5 == res.size());
        assert (2 == res.get(0));
        assert (4 == res.get(2));
        assert (6 == res.get(4));

        test = new ArrayList<>();
        test.add(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }});
        test.add(new ArrayList<Integer>() {{
            add(3);
        }});
        sol = new ListOfListIterator(test);
        assert (sol.hasNext());
        assert (1 == sol.next());
        assert (sol.hasNext());
        assert (2 == sol.next());
        sol.remove();
        assert (sol.hasNext());
        assert (3 == sol.next());
    }

    @Override
    public boolean hasNext() {
        while (!iterator.hasNext() && iterators.hasNext()) iterator = iterators.next().iterator();
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;
        return iterator.next();
    }

    @Override
    public void remove() {
        iterator.remove();
    }
}
