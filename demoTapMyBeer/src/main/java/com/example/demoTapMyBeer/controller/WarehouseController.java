package com.example.demoTapMyBeer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoTapMyBeer.model.Warehouse;
import com.example.demoTapMyBeer.model.WarehouseRepository;

@CrossOrigin(origins = "http://localhost:8081") // used for vue
@RestController
@RequestMapping("/api")
public class WarehouseController {

	@Autowired
	WarehouseRepository warehouseRepository;

	@GetMapping("/warehouses")
	public ResponseEntity<List<Warehouse>> getAllWarehouses(@RequestParam(required = false) String name) {
		try {
			List<Warehouse> warehouses = new ArrayList<Warehouse>();

			if (name == null)
				warehouseRepository.findAll().forEach(warehouses::add);
			else
				warehouseRepository.findByName(name).forEach(warehouses::add);

			if (warehouses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(warehouses, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/warehouses/{warehouseId}")
	public ResponseEntity<Warehouse> getWarehouseById(@PathVariable("warehouseId") Long warehouseId) {
		Optional<Warehouse> warehouseData = warehouseRepository.findById(warehouseId);

		if (warehouseData.isPresent()) {
			return new ResponseEntity<>(warehouseData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/warehouses")
	public ResponseEntity<Warehouse> createTutorial(@RequestBody Warehouse warehouse) {
		try {
			Warehouse _warehouse = warehouseRepository.save(new Warehouse(warehouse.getName(), warehouse.getwAddress(), warehouse.getNumInventory()));
			return new ResponseEntity<>(_warehouse, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/warehouses/{warehouseId}")
	public ResponseEntity<Warehouse> updateWarehouse(@PathVariable("warehouseId") Long warehouseId, @RequestBody Warehouse warehouse) {
		Optional<Warehouse> warehouseData = warehouseRepository.findById(warehouseId);

		if (warehouseData.isPresent()) {
			Warehouse _warehouse = warehouseData.get();
			_warehouse.setName(warehouse.getName());
			_warehouse.setwAddress(warehouse.getwAddress());
			_warehouse.setNumInventory(warehouse.getNumInventory());
			return new ResponseEntity<>(warehouseRepository.save(_warehouse), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/warehouses/{warehouseId}")
	public ResponseEntity<HttpStatus> deleteWarehouse(@PathVariable("warehouseId") Long warehouseId) {
		try {
			warehouseRepository.deleteById(warehouseId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/warehouses")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			warehouseRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

