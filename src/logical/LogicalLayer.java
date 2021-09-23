package logical;

import com.Route;

import java.util.*;

public class LogicalLayer {
    static int min=0;
    int totalDistance=0;
    int count=0,max=0;
    HashMap<Character,HashMap<Character,Integer>> cityMap=new HashMap<>();
    HashMap<Character,Integer> routeMap ;
    ArrayList<Set<Character>> paths=new ArrayList<>();
    Set <Character> path=new LinkedHashSet<>();
    public void loadMap(Route route)
    {
        int distance= route.getDistance();
        char end= route.getEnd();
        char start=route.getStart();
        routeMap=cityMap.get(start);
        if(routeMap==null)
        {
            routeMap=new HashMap<>();
            cityMap.put(start,routeMap);
        }
        routeMap.put(end,distance);

        routeMap=cityMap.get(end);
        if(routeMap==null)
        {
            routeMap=new HashMap<>();
            cityMap.put(end,routeMap);
        }
        routeMap.put(start,distance);

    }
    public ArrayList<Set<Character>> allPath(char start,char end,char element)
    {
        path.add(start);
        HashMap<Character, Integer> routes = new HashMap<>(cityMap.get(start));
        routes.remove(element);
        for (Map.Entry<Character,Integer> entry:routes.entrySet())
        {
            path.add(entry.getKey());
            if(entry.getKey()==end)
            {
                Set<Character>newPath=new LinkedHashSet<>(path);
                paths.add(newPath);
            }
            else
            {
                allPath(entry.getKey(),end,start);
            }
            path.remove(entry.getKey());
        }
        return paths;
    }
    public ArrayList<ArrayList<Character>> shortestPath(ArrayList<Set<Character>> list)
    {
        ArrayList<ArrayList<Character>> subList=new ArrayList<>();
        for (Set<Character> routes:list) {
            ArrayList<Character> newList = new ArrayList<>(routes);
            int distance=0;
            for (int i=0;i<newList.size()-1;i++) {
                routeMap=cityMap.get(newList.get(i));
                distance=routeMap.get(newList.get(i+1));
                totalDistance+=distance;
            }
            System.out.println(totalDistance);
            if(totalDistance<=min && min!=0)
            {
                subList.add(newList);
            }
            min=totalDistance;
            totalDistance=0;
        }
        return subList;
    }
    public void deleteRoute(char start,char end)
    {
        routeMap=cityMap.get(start);
        routeMap.remove(end);
    }
    public char busyCity()
    {
        char city=' ';
        for (Map.Entry<Character,HashMap<Character,Integer>> entry:cityMap.entrySet())
        {
            char c=entry.getKey();
            routeMap=cityMap.get(c);
            for (Map.Entry<Character,Integer> paths:routeMap.entrySet())
            {
                count++;
            }
            if (count>max&&max!=0)
            {
                count=max;
                city=c;
            }
        }
        return city;
    }
    public HashMap<Character, HashMap<Character, Integer>> getCityMap() {
        return cityMap;
    }

}
