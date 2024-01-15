package study.data.structures.CourseWork.Navigator;

import study.data.structures.CourseWork.Route.Route;

import static study.data.structures.CourseWork.Route.Route.createRoutePoints;

public class NavigatorTest {
    public static void main(String[] args) {
        NavigatorImpl navigator = new NavigatorImpl();

        // Создаем и добавляем маршруты
        Route route1 = new Route(100.0, 10, true, createRoutePoints("CityA", "CityB"));
        Route route2 = new Route(150.0, 5, false, createRoutePoints("CityA", "CityC"));
        Route route3 = new Route(200.0, 15, true, createRoutePoints("CityB", "CityC"));
        Route route4 = new Route(120.0, 7, false, createRoutePoints("CityD", "CityE", "CityF"));
        Route route5 = new Route(180.0, 20, true, createRoutePoints("CityG", "CityB"));
        Route route6 = new Route(240.0, 3, false, createRoutePoints("CityA", "CityC", "CityG", "CityB"));
        Route route7 = new Route(110.0, 12, false, createRoutePoints("CityA", "CityB"));
        Route route8 = new Route(160.0, 8, true, createRoutePoints("CityA", "CityC"));
        Route route9 = new Route(210.0, 18, false, createRoutePoints("CityB", "CityC"));
        Route route10 = new Route(130.0, 9, true, createRoutePoints("CityD", "CityE", "CityF"));
        Route route11 = new Route(190.0, 22, false, createRoutePoints("CityG", "CityB"));
        Route route12 = new Route(250.0, 4, true, createRoutePoints("CityA", "CityC", "CityG", "CityB"));
//        Route routeTest1 = new Route(100.0, 10, true, createRoutePoints("CityA", "CityC","CityD","CityB"));
//        Route routeTest2 = new Route(50.0, 10, true, createRoutePoints("CityB"));
//        Fail
//        Route routeTest3 = new Route(200.0, 100, true, createRoutePoints("CityA", "CityB", "CityB", "CityB"));
//        navigator.addRoute(routeTest1);
//        navigator.addRoute(routeTest2);
//        navigator.addRoute(routeTest3);
        navigator.addRoute(route1);
        navigator.addRoute(route2);
        navigator.addRoute(route3);
        navigator.addRoute(route4);
        navigator.addRoute(route5);
        navigator.addRoute(route6);
        navigator.addRoute(route7);
        navigator.addRoute(route8);
        navigator.addRoute(route9);
        navigator.addRoute(route10);
        navigator.addRoute(route11);
        navigator.addRoute(route12);




        // Тестирование навигатора
        testNavigator(navigator);
    }

    private static void testNavigator(NavigatorImpl navigator) {
        // Тесты для различных функций навигатора
        System.out.println("Contains route1: " + navigator.contains(navigator.getRoute("0001")));
        System.out.println("Route with ID 0001: " + navigator.getRoute("0001"));
        navigator.chooseRoute("0001");

        System.out.println("Routes from CityA to CityB:");
        navigator.searchRoutes("CityA", "CityB").forEach(System.out::println);

        System.out.println("Favorite routes with CityB:");
        navigator.getFavoriteRoutes("CityB").forEach(System.out::println);

        System.out.println("Top 3 routes:");
        navigator.getTop3Routes().forEach(System.out::println);

        System.out.println("Size after adding routes: " + navigator.size());
        navigator.removeRoute("0002");
        System.out.println("Size after removing route2: " + navigator.size());
    }
}

