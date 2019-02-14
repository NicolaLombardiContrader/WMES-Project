package it.contrader.sprint3.model;

import it.contrader.sprint3.service.GommaService;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gomme")
public class GommaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String model;

    @Column
    private String manufacturer;

    @Column
    private double price;

    public GommaEntity () {}

    public GommaEntity(String model, String manufacturer, double price) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GommaEntity gommaEntity = (GommaEntity) o;

        if (Double.compare(gommaEntity.price, price) != 0) return false;
        if (model != null ? !model.equals(gommaEntity.model) : gommaEntity.model != null) return false;
        return manufacturer != null ? manufacturer.equals(gommaEntity.manufacturer) : gommaEntity.manufacturer == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = model != null ? model.hashCode() : 0;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Model: " + model + "\nManufacturer: " +manufacturer + "\nPrice: "+price+"\n";

    }
}
