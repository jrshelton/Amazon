package io.pivotal.workshop.Controller;


import io.pivotal.workshop.Model.Account;
import io.pivotal.workshop.Model.Shipment;
import io.pivotal.workshop.Repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @PostMapping("/create")
    public Shipment createShipment(@Valid @RequestBody Shipment shipment) {

        return shipmentRepository.save(shipment);
    }

    @RequestMapping("/all")
    public Iterable<Shipment> findAll() {
        return shipmentRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Shipment> findById(@PathVariable("id") long id) {

        return shipmentRepository.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
        shipmentRepository.deleteById(id);

    }

    @PutMapping("edit/{id}")
    public Shipment editById(@PathVariable("id") long id, @RequestBody Shipment shipment) {
        Optional<Shipment> shipmentOptional = shipmentRepository.findById(id);
        if (!shipmentOptional.isPresent()) {
            return null;
        }
        shipment.setShipmentId(id);
        return shipmentRepository.save(shipment);

    }


    public Iterable<Shipment> findByAccount(Account account) {
        return shipmentRepository.find(account);
    }
}