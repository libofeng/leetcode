package com.lintcode.geometry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No820Rectangle {
    /**
     * @param pointSet: The point set
     * @return: The answer
     */
    public String rectangle(Point[] pointSet) {
        Map<Integer, List<Point>> xMap = new HashMap<>(), yMap = new HashMap<>();
        for (Point point : pointSet) {
            xMap.putIfAbsent(point.x, new ArrayList<>());
            yMap.putIfAbsent(point.y, new ArrayList<>());
            xMap.get(point.x).add(point);
            yMap.get(point.y).add(point);
        }

        for (List<Point> list : xMap.values()) {
            for (int x1 = 0; x1 < list.size(); x1++) {
                for (int x2 = x1 + 1; x2 < list.size(); x2++) {
                    Point pointX1 = list.get(x1), pointX2 = list.get(x2);

                    for (Point pointY1 : yMap.get(pointX1.y)) {
                        for (Point pointY2 : yMap.get(pointX2.y)) {
                            if (pointY1.x == pointY2.x && pointX1.x != pointY1.x) return "YES";
                        }
                    }
                }
            }
        }

        return "NO";
    }
}
