package designpattern.factorymethod.idcard;

import designpattern.factorymethod.framework.*;
import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
    private List<String> owners = new ArrayList<>();

    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }

    public List<String> getOwners() {
        return this.owners;
    }
}
