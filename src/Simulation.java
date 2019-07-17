import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

  public ArrayList<Item> loadItems(String fileName) {
    File phaseFile = new File(fileName);
    ArrayList<Item> itemsToLoad = new ArrayList<>();
    try {
      Scanner scanner = new Scanner(phaseFile);
      while(scanner.hasNextLine()) {
        String[] itemString = scanner.nextLine().split("=");
        Item item = new Item(itemString[0], Integer.parseInt(itemString[1]) / 1000);
        itemsToLoad.add(item);
      }
    }
    catch(FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return itemsToLoad;
  }

  public ArrayList<Rocket> loadRockets(String type, ArrayList<Item> itemsToLoad) {
    ArrayList<Rocket> fleet = new ArrayList<>();
    Rocket rocket = type.equals("U1") ? new U1() : new U2();
    for (Item item : itemsToLoad) {
      if (!rocket.canCarry(item)) {
        fleet.add(rocket);
        rocket = type.equals("U1") ? new U1() : new U2();
      }
      rocket.carry(item);
    }
    fleet.add(rocket);
    return fleet;
  }

  private int simulatePhase(ArrayList<Rocket> fleet) {
    int phaseCost = 0;
    for (Rocket rocket : fleet) {
      phaseCost += rocket.getCost();
      while (!rocket.launch()) {
        phaseCost += rocket.getCost();
        System.out.println("Rocket exploded right after launch");
      }
      System.out.println("Rocket launched successfully");
      while(!rocket.land()) {
        phaseCost += rocket.getCost();
        System.out.println("Rocket crashed while landing");
      }
      System.out.println("Rocket landed successfully");
    }
    return phaseCost;
  }

  public int runSimulation(ArrayList<Rocket> fleet1, ArrayList<Rocket> fleet2) {
    int missionCost = 0;
    System.out.println("Phase 1");
    missionCost += simulatePhase(fleet1);
    System.out.println("Phase 2");
    missionCost += simulatePhase(fleet2);
    return missionCost;
  }
}
