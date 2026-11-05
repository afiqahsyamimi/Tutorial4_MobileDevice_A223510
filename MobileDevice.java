public class MobileDevice implements RadioTuner {
    
    protected String manufacturer;
    protected String model;
    protected String station;
    protected double frequency;

    public MobileDevice(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public void printDetails() {
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Model: " + model);
    }
 }
