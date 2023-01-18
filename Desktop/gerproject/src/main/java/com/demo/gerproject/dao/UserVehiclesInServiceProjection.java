package com.demo.gerproject.dao;

import java.util.Date;

import com.demo.gerproject.model.PaymentStatus;
import com.demo.gerproject.model.VehicleStatus;


public interface UserVehiclesInServiceProjection {
	int getId();
	String getBrand();
	String getModel();
	String getKm();
	String getDescription();
	String getType();
	Date getBk_Date();
	VehicleStatus getVehicle_Status();
}
