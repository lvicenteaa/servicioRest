package com.openbootcamp.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openbootcamp.demo.models.Bootcamper;

@Service
public class BootcamperService {

	private List<Bootcamper> bootcampers = new ArrayList<>();
	
	public List<Bootcamper> getAll(){
		return bootcampers;
	}
	
	public void add(Bootcamper bootcamper) {
		bootcampers.add(bootcamper);
	}
	
	public Bootcamper get(String nombre) {
		for(Bootcamper bootcamper: this.bootcampers) {
			if(bootcamper.getNombre().equalsIgnoreCase(nombre)) {
				return bootcamper;
			}
		}
		return null;
	}
	
}
