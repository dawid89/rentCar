package project.com.rentcar.core.models;


public class Bus {
    private Engine engine;
    private String busMake;
    private String busModel;
    private int busVin;
    private int busYear;
    private int busRegistration;
    private int numberSeats;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getBusMake() {
        return busMake;
    }

    public void setBusMake(String busMake) {
        this.busMake = busMake;
    }

    public String getBusModel() {
        return busModel;
    }

    public void setBusModel(String busModel) {
        this.busModel = busModel;
    }

    public int getBusVin() {
        return busVin;
    }

    public void setBusVin(int busVin) {
        this.busVin = busVin;
    }

    public int getBusYear() {
        return busYear;
    }

    public void setBusYear(int busYear) {
        this.busYear = busYear;
    }

    public int getBusRegistration() {
        return busRegistration;
    }

    public void setBusRegistration(int busRegistration) {
        this.busRegistration = busRegistration;
    }



}