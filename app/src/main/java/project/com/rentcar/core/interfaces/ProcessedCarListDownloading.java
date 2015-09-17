package project.com.rentcar.core.interfaces;

import java.util.ArrayList;

import project.com.rentcar.core.models.Vehicle;

public interface ProcessedCarListDownloading {
    void onSucces(ArrayList<Vehicle> vehicleList);
    void onFail();


}
