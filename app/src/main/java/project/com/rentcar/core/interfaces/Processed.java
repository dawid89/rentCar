package project.com.rentcar.core.interfaces;


import java.util.ArrayList;

import project.com.rentcar.core.models.Vehicle;

public interface Processed {
    public void OnSuccess(ArrayList<Vehicle> vehicles);
    public void OnFail();
}
