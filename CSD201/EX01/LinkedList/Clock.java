package LinkedList;

public class Clock {
    String id = "", manufacturer = "";
    int price = 0, guarantee = 0;

    //Default constructor
    public Clock() {}
    //Constructor using 1 parameter
    public Clock(String id) {
        this.id = id;
    }
    //Constructor using 4 parameters
    public Clock(String id, String manufacturer, int price, int guarantee) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.price = price;
        this.guarantee = guarantee;
    }

    //Getters, setters
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getManufacturer() {
        return this.manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getGuarantee() {
        return this.guarantee;
    }
    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    @Override
    public String toString() {
        return id + ", " + manufacturer + ", " + price + ", " + guarantee;
    }

    public void input() throws Exception {
        System.out.print("Manufacturer: ");
        manufacturer = ValidInput.validString();
        System.out.print("Price: $");
        price = ValidInput.validInt();
        System.out.print("Guarantee months: ");
        guarantee = ValidInput.validInt();
    }

    //2 clocks are equal if they have the same ID
    //This method is applied for searching in the linked list
    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((Clock)obj).id);
    }
}
