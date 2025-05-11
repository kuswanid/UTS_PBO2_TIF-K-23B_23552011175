package org.kuswanid.service;

import org.kuswanid.model.Property;
import org.kuswanid.repository.PropertyRepository;

import java.util.List;
import java.util.UUID;

public class PropertyService {
    private final PropertyRepository repository = new PropertyRepository();

    public boolean addProperty(String address, Double area, String name, Double price, String type) {
        String id = UUID.randomUUID().toString();
        boolean available = true;
        return repository.addProperty(id, address, area, available, name, price, type);
    }

    public boolean deleteProperty(String id) {
        return repository.deleteProperty(id);
    }

    public List<Property> getAllProperties() {
        return repository.getAllProperties();
    }

    public Property getPropertyDetail(String id) {
        return repository.getPropertyDetail(id);
    }

    public boolean updateProperty(String id, String address, Double area, boolean available, String name, Double price, String type) {
        return repository.updateProperty(id, address, area, available, name, price, type);
    }
}
