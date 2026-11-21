package model;

public abstract class Person {
    private String id;
    private String name;
    private String contactNumber;

    public Person(String id, String name, String contactNumber) throws ClinicException {
        this.id = id;
        setName(name);
        this.contactNumber = contactNumber;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }

    public void setName(String name) throws ClinicException {
        if (name == null || name.trim().isEmpty()) {
            throw new ClinicException("Name cannot be blank.");
        }
        this.name = name.trim();
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public abstract String getRole();
}
