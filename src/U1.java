public class U1 extends Rocket {

  public U1() {
    super(100, 10, 18);
  }

  public boolean launch() {
    float launchModifier = 5 * (getWeight() / 18) / 100;
    return getEventResult(launchModifier);
  }

  public boolean land() {
    float landModifier = (getWeight() / 18) / 100;
    return getEventResult(landModifier);
  }
}
