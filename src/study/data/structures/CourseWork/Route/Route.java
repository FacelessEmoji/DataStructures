package study.data.structures.CourseWork.Route;

import study.data.structures.CourseWork.List.CustomList;
import study.data.structures.CourseWork.List.CustomNode;

import java.util.Iterator;
import java.util.Objects;

public class Route {
    private static int idCounter = 1;
    private final String id;
    private double distance;
    private int popularity;
    private boolean isFavorite;
    private CustomList<String> locationPoints;

    public Route(double distance, int popularity, boolean isFavorite, CustomList<String> locationPoints) {
        this.id = generateId();
        this.distance = distance;
        this.popularity = popularity;
        this.isFavorite = isFavorite;
        this.locationPoints = locationPoints;
    }

    // Статический метод для создания списка точек маршрута
    public static CustomList<String> createRoutePoints(String... cities) {
        if (cities.length < 2) {
            throw new IllegalArgumentException("A route must consist of at least two cities.");
        }

        CustomList<String> locationPoints = new CustomList<>();
        for (String city : cities) {
            locationPoints.addLast(city);
        }
        return locationPoints;
    }

    private static String generateId() {
        return String.format("%04d", idCounter++);
    }

    public String getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        if (distance > 0) {
            this.distance = distance;
        } else {
            throw new IllegalArgumentException("Distance must be positive");
        }
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        if (popularity >= 0) {
            this.popularity = popularity;
        } else {
            throw new IllegalArgumentException("Popularity cannot be negative");
        }
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public CustomList<String> getLocationPoints() {
        return locationPoints;
    }

    public void setLocationPoints(CustomList<String> locationPoints) {
        this.locationPoints = locationPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Route route = (Route) o;
        return Double.compare(route.distance, distance) == 0 &&
            Objects.equals(locationPoints.getFirst(), route.locationPoints.getFirst())
            && Objects.equals(locationPoints.getLast(), route.locationPoints.getLast());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distance, popularity, isFavorite, locationPoints);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Route ID: ").append(id)
            .append(", Distance: ").append(distance)
            .append(", Popularity: ").append(popularity)
            .append(", Is Favorite: ").append(isFavorite ? "Yes" : "No")
            .append(", Location Points: ");

        CustomNode<String> current = locationPoints.head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(" -> ");
            }
            current = current.getNext();
        }

        return sb.toString();
    }
}
