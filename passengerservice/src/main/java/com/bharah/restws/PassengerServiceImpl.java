package com.bharah.restws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bharah.restws.model.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {

	List<Passenger> passengers = new ArrayList<>();
	int currentId = 123;
	
	@Override
	public List<Passenger> getPassengers(int start, int size) {
		System.out.println(start);
		System.out.println(size);
		return passengers;
	}

	@Override
	public void addPassenger(String firstName, String lastName) {
		System.out.println(firstName);
		System.out.println(lastName);
	}

}
