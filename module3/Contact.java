public class Contact {
    // fields: the data each contact object will hold
    private String name;
    private String phone;

    //constructor: runs when you write new Contact(...) to create a contact object
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    //getters: controlled read access to private fields
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public void setName(String name) { this.name = name; }
    // TOSTRING: what prints when you System.out.println(contact)
    @Override
    public String toString() {
        return name + " | " + phone;
    }
}
