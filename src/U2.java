public class U2 extends Rocket {

  public U2() {
    super(120, 18, 29);
  }

  public boolean launch() {
    double launchModifier = 4 * (getWeight() / 29.00) / 100;
    return getEventResult(launchModifier);
  }

  public boolean land() {
    double landModifier = 8 * (getWeight() / 29.00) / 100;
    return getEventResult(landModifier);
  }
}
