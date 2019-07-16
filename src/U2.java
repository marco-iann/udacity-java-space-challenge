public class U2 extends Rocket {

  public U2() {
    super(120, 18, 29);
  }

  public boolean launch() {
    float launchModifier = 4 * (getWeight() / 18) / 100;
    return getEventResult(launchModifier);
  }

  public boolean land() {
    float landModifier = 8 * (getWeight() / 18) / 100;
    return getEventResult(landModifier);
  }
}
