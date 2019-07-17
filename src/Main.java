import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    Simulation simulation = new Simulation();
    ArrayList<Item> phase1Items = simulation.loadItems("src/resources/phase-1.txt");
    ArrayList<Item> phase2Items = simulation.loadItems("src/resources/phase-2.txt");
    System.out.println("Running simulation using U1 rockets");
    ArrayList<Rocket> phase1U1Fleet = simulation.loadRockets("U1", phase1Items);
    ArrayList<Rocket> phase2U1Fleet = simulation.loadRockets("U1", phase2Items);
    int u1Cost = simulation.runSimulation(phase1U1Fleet, phase2U1Fleet);
    System.out.println("Mission Completed! Total cost " + u1Cost + " million\n");
    System.out.println("Running simulation using U2 rockets");
    ArrayList<Rocket> phase1U2Fleet = simulation.loadRockets("U2", phase1Items);
    ArrayList<Rocket> phase2U2Fleet = simulation.loadRockets("U2", phase2Items);
    int u2Cost = simulation.runSimulation(phase1U2Fleet, phase2U2Fleet);
    System.out.println("Mission Completed! Total cost " + u2Cost + " million");
  }
}
