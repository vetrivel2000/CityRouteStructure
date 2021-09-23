import com.Route;
import logical.LogicalLayer;

import java.util.*;

public class CityRunner {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        LogicalLayer logical = new LogicalLayer();
        int option;
        do {
            System.out.println("1.AddToMap\n2.ListAddedCities\n3.FindCity\n4.ShortestRoute\n5.PrintRoutes\n6.DeleteRoute\n7.BusyCity\n9.Exit");
            option=scan.nextInt();
            switch (option)
            {
                case 1:
                {
                    System.out.println("Enter start");
                    char start= scan.next().charAt(0);
                    System.out.println("Enter destiny");
                    char end = scan.next().charAt(0);
                    System.out.println("Enter distance");
                    int distance= scan.nextInt();
                    Route route= new Route();
                    route.setDistance(distance);
                    route.setEnd(end);
                    route.setStart(start);
                    logical.loadMap(route);
                    break;
                }
                case 2:
                {
                    HashMap<Character,HashMap<Character,Integer>> cities= logical.getCityMap();
                    for (Map.Entry<Character,HashMap<Character,Integer>> entry:cities.entrySet())
                    {
                        System.out.println(entry.getKey());
                    }
                    break;
                }
                case 3:
                {
                    System.out.println("Enter city");
                    char city= scan.next().charAt(0);
                    HashMap<Character,HashMap<Character,Integer>> cities= logical.getCityMap();
                    if(cities.get(city)==null)
                    {
                        System.out.println("No cities found");
                        return;
                    }
                    System.out.println("City found");
                    break;
                }
                case 4:
                {
                    System.out.println("Enter start");
                    char start= scan.next().charAt(0);
                    System.out.println("Enter destiny");
                    char end = scan.next().charAt(0);
                    ArrayList<Set<Character>> list=logical.allPath(start,end,' ');
                    ArrayList<ArrayList<Character>> list1=logical.shortestPath(list);
                    System.out.println(list1);
                    break;
                }
                case 5:
                {
                    System.out.println("Enter start");
                    char start= scan.next().charAt(0);
                    System.out.println("Enter destiny");
                    char end = scan.next().charAt(0);
                    ArrayList<Set<Character>> list=logical.allPath(start,end,' ');
                    System.out.println(list);
                    break;
                }
                case 6:
                {
                    System.out.println("Enter start");
                    char start= scan.next().charAt(0);
                    System.out.println("Enter destiny");
                    char end = scan.next().charAt(0);
                    logical.deleteRoute(start,end);
                    System.out.println("Route"+start+","+end+"deleted");
                    break;
                }
                case 7:
                {
                    char city= logical.busyCity();
                    System.out.println("The busy city is"+city);
                    break;
                }
            }
        }while (option<8);
    }
}
