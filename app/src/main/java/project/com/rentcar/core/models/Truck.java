package project.com.rentcar.core.models;


public class Truck {
    private Engine engine;
    private String truckMake;
    private String truckModel;
    private int truckVin;
    private int truckYear;
    private int truckRegistration;
    private int wheelsNumber;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getPayloadTruck() {
        return payloadTruck;
    }

    public void setPayloadTruck(int payloadTruck) {
        this.payloadTruck = payloadTruck;
    }

    public String getTruckMake() {
        return truckMake;
    }

    public void setTruckMake(String truckMake) {
        this.truckMake = truckMake;
    }

    public String getTruckModel() {
        return truckModel;
    }

    public void setTruckModel(String truckModel) {
        this.truckModel = truckModel;
    }

    public int getTruckVin() {
        return truckVin;
    }

    public void setTruckVin(int truckVin) {
        this.truckVin = truckVin;
    }

    public int getTruckRegistration() {
        return truckRegistration;
    }

    public void setTruckRegistration(int truckRegistration) {
        this.truckRegistration = truckRegistration;
    }

    public int getTruckYear() {
        return truckYear;
    }

    public void setTruckYear(int truckYear) {
        this.truckYear = truckYear;
    }

    public int getWheelsNumber() {
        return wheelsNumber;
    }

    public void setWheelsNumber(int wheelsNumber) {
        this.wheelsNumber = wheelsNumber;
    }

    private int payloadTruck;

}
