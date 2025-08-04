import java.util.LinkedList;
import java.util.ListIterator;

public class Itinerary {
    private LinkedList<Town> towns;
    private ListIterator<Town> iterator;


    public Itinerary() {
        towns = new LinkedList<>();

        Town sydney = new Town("Sydney", 0);
        towns.add(sydney);

        Town test1 = new Town("test1", 1);
        towns.add(test1);

        Town test2 = new Town("test2", 2);
        towns.add(test2);

        iterator = towns.listIterator();
    }

    public String addTown(String name, int distance) {
        for (Town town : towns) {
            if (town.getName().equals(name)) {
                return "Town already in the list. ";
            }
        }
        Town added = new Town(name, distance);

        ListIterator<Town> sortingIterator = towns.listIterator(1);

        while (sortingIterator.hasNext()) {
            if (sortingIterator.next().getDistance() > added.getDistance()) {
                sortingIterator.previous();
                sortingIterator.add(added);
                return "New town " + name + " added.";
            }
        }
        towns.addLast(added);
        return "New town " + name + " added.";
    }



    public String forward() {
        if (iterator.hasNext()) {
            Town town = iterator.next();
            return "Town name: " + town.getName() + "\nDistance from start: " + town.getDistance();
        } else {
            return "End of list reached.\n";
        }
    }

    public String backward() {
        if (iterator.hasPrevious()) {
            Town town = iterator.previous();
            return "Town name: " + town.getName() + "\nDistance from start: " + town.getDistance();
        } else {
            return "Front of list reached.";
        }
    }

    public void list() {
        ListIterator<Town> temp = towns.listIterator();
        while (temp.hasNext()) {
            Town town = temp.next();
            System.out.println("\nTown name: " + town.getName() + "\nDistance from start: " + town.getDistance());
        }
        System.out.println("~~~~~~~~~~~~~");
    }
}
