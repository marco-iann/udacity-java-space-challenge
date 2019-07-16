import java.util.ArrayList;

public class Rocket implements SpaceShip {

  private int cost;
  private int weight;
  private int maxWeight;
  private ArrayList<Item> cargo = new ArrayList<>();

  public Rocket(int cost, int weight, int maxWeight) {
    this.cost = cost;
    this.weight = weight;
    this.maxWeight = maxWeight;
  }

  public int getCost() {
    return cost;
  }

  public int getWeight() {
    return weight;
  }

  public boolean getEventResult(float modifier) {
    return Math.random() > modifier;
  }

  public boolean launch() {
    return true;
  }

  public boolean land() {
    return true;
  }

  public boolean canCarry(Item item) {
    return item.getWeight() <= maxWeight;
  }

  public void carry(Item item) {
    cargo.add(item);
    weight += item.getWeight();
  }
}
