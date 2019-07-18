package com.company.airbnb;

import java.util.*;

public class TravelBuddy {

    final List<Buddy> buddyList;
    final Set<String> wishList;

    TravelBuddy(Set<String> myWishList, Map<String, Set<String>> friendsWishList) {
        wishList = myWishList;
        buddyList = new ArrayList<>();

        for (Map.Entry<String, Set<String>> e : friendsWishList.entrySet()) {
            Buddy buddy = new Buddy(e.getKey(), e.getValue());

            Set<String> intersection = new HashSet<>(wishList);
            intersection.retainAll(e.getValue());
            buddy.similarity = intersection.size();

            buddyList.add(buddy);
        }

        Collections.sort(buddyList);
    }

    public static void main(String[] args) {
        Set<String> myWishList = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
        Set<String> wishList1 = new HashSet<>(Arrays.asList("a", "b", "e", "f"));
        Set<String> wishList2 = new HashSet<>(Arrays.asList("a", "c", "d", "g"));
        Set<String> wishList3 = new HashSet<>(Arrays.asList("c", "f", "e", "g"));
        Map<String, Set<String>> friendWishLists = new HashMap<>();
        friendWishLists.put("Buddy1", wishList1);
        friendWishLists.put("Buddy2", wishList2);
        friendWishLists.put("Buddy3", wishList3);
        TravelBuddy sol = new TravelBuddy(myWishList, friendWishLists);
        List<String> res = sol.recommendCities(10);

        assert (3 == res.size());
        assert ("g".equals(res.get(0)));
        assert ("e".equals(res.get(1)));
        assert ("f".equals(res.get(2)));
    }

    public List<Buddy> getSortedBuddies() {
        return buddyList;
    }

    private List<String> recommendCities(int k) {
        final List<String> cities = new ArrayList<>();

        for (Buddy b : buddyList) {
            final Set<String> list = new HashSet<>(b.wishList);
            list.removeAll(cities);
            list.removeAll(wishList);

            if (k >= list.size()) cities.addAll(list);
            else {
                Iterator<String> iterator = list.iterator();
                while (iterator.hasNext() && k-- > 0) cities.add(iterator.next());
            }
        }

        return cities;
    }

    private class Buddy implements Comparable<Buddy> {
        String name;
        Set<String> wishList;
        int similarity;

        Buddy(String name, Set<String> wishList) {
            this.name = name;
            this.wishList = wishList;
        }

        public int compareTo(Buddy that) {
            return that.similarity - this.similarity;
        }
    }
}
