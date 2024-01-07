package study.data.structures.CourseWork.Navigator;

import study.data.structures.CourseWork.CustomMap.CustomKeyValue;
import study.data.structures.CourseWork.CustomMap.CustomMapImpl;
import study.data.structures.CourseWork.List.CustomList;
import study.data.structures.CourseWork.List.CustomNode;
import study.data.structures.CourseWork.Route.Route;

import java.util.Comparator;

public class NavigatorImpl implements Navigator {
    private CustomMapImpl<String, Route> routesMap;

    public NavigatorImpl() {
        this.routesMap = new CustomMapImpl<>();
    }

    @Override
    public void addRoute(Route newRoute) {
        for (CustomKeyValue<String, Route> entry : routesMap) {
            Route existingRoute = entry.getValue();
            if (newRoute.equals(existingRoute)) {
                System.out.println("This route already exists and will not be added again.");
                return;
            }
        }
        routesMap.put(newRoute.getId(), newRoute);
    }


    @Override
    public void removeRoute(String routeId) {
        routesMap.remove(routeId);
    }

    @Override
    public boolean contains(Route route) {
        return routesMap.containsKey(route.getId());
    }

    @Override
    public int size() {
        return routesMap.size();
    }

    @Override
    public Route getRoute(String routeId) {
        return routesMap.get(routeId);
    }

    @Override
    public void chooseRoute(String routeId) {
        Route route = routesMap.get(routeId);
        if (route != null) {
            route.setPopularity(route.getPopularity() + 1);
        }
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        CustomList<Route> foundRoutes = new CustomList<>();
        for (CustomKeyValue<String, Route> entry : routesMap) {
            Route route = entry.getValue();
            if (route.getLocationPoints().getFirst().equals(startPoint) && route.getLocationPoints().getLast().equals(endPoint)) {
                foundRoutes.addLast(route);
            }
        }
        // Сортируем сначала избранные маршруты, потом по расстоянию и популярности
        sortCustomList(foundRoutes, Comparator.comparing(Route::isFavorite).reversed()
            .thenComparing(Route::getDistance)
            .thenComparing(Comparator.comparing(Route::getPopularity).reversed()));
        return foundRoutes;
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        CustomList<Route> favoriteRoutes = new CustomList<>();
        for (CustomKeyValue<String, Route> entry : routesMap) {
            Route route = entry.getValue();
            if (route.isFavorite() && route.getLocationPoints().contains(destinationPoint)) {
                favoriteRoutes.addLast(route);
            }
        }
        // Сортируем по расстоянию (возрастание) и популярности (убывание)
        sortCustomList(favoriteRoutes, Comparator.comparing(Route::getDistance)
            .thenComparing(Comparator.comparing(Route::getPopularity).reversed()));
        return favoriteRoutes;
    }

    @Override
    public Iterable<Route> getTop3Routes() {
        CustomList<Route> allRoutes = new CustomList<>();
        for (CustomKeyValue<String, Route> entry : routesMap) {
            allRoutes.addLast(entry.getValue());
        }
        // Сортируем по популярности (убывание), расстоянию (возрастание) и количеству точек (возрастание)
        sortCustomList(allRoutes, Comparator.comparing(Route::getPopularity).reversed()
            .thenComparing(Route::getDistance)
            .thenComparing(r -> r.getLocationPoints().size()));

        return allRoutes.subList(0, 3);
    }


    private void sortCustomList(CustomList<Route> list, Comparator<Route> comparator) {
        if (list.head != null) {
            list.head = mergeSort(list.head, comparator);
            updateTail(list);
        }
    }

    private CustomNode<Route> mergeSort(CustomNode<Route> head, Comparator<Route> comparator) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        CustomNode<Route> middle = getMiddle(head);
        CustomNode<Route> nextOfMiddle = middle.getNext();

        middle.setNext(null); // разрыв связи для создания двух списков

        CustomNode<Route> left = mergeSort(head, comparator);
        CustomNode<Route> right = mergeSort(nextOfMiddle, comparator);

        return sortedMerge(left, right, comparator);
    }

    private CustomNode<Route> sortedMerge(CustomNode<Route> a, CustomNode<Route> b, Comparator<Route> comparator) {
        CustomNode<Route> result;
        if (a == null) return b;
        if (b == null) return a;

        if (comparator.compare(a.getData(), b.getData()) <= 0) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b, comparator));
        } else {
            result = b;
            result.setNext(sortedMerge(a, b.getNext(), comparator));
        }
        return result;
    }

    private CustomNode<Route> getMiddle(CustomNode<Route> head) {
        if (head == null) return head;
        CustomNode<Route> slow = head, fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private void updateTail(CustomList<Route> list) {
        CustomNode<Route> current = list.head;
        while (current != null && current.getNext() != null) {
            current = current.getNext();
        }
        list.tail = current;
    }
}

