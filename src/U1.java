public class U1 extends Rocket {

  public U1() {
    super(100, 10, 18);
  }

  public boolean launch() {
    double launchModifier = 5 * (getWeight() / 18.00) / 100;
    return getEventResult(launchModifier);
  }

  public boolean land() {
    double landModifier = (getWeight() / 18.00) / 100;
    return getEventResult(landModifier);
  }
}
