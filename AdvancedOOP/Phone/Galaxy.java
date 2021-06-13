public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        // your code here
        return "Galaxy " + getVersionNum() + " says " + getRingTone();
    }
    @Override
    public String unlock() {
        // your code here
        return "Unlocking via finger print" ;
    }
    @Override
    public void displayInfo() {
        // your code here    
        System.out.println("Galaxy " + getVersionNum() + " from " + getCarrier());
    }
}
