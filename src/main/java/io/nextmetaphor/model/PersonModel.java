package io.nextmetaphor.model;

public class PersonModel {
    private int id;
    private String name;
    private int age;
    private AddressModel homeAddressModel;
    private AddressModel workAddressModel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AddressModel getHomeAddressModel() {
        return homeAddressModel;
    }

    public void setHomeAddressModel(AddressModel homeAddressModel) {
        this.homeAddressModel = homeAddressModel;
    }

    public AddressModel getWorkAddressModel() {
        return workAddressModel;
    }

    public void setWorkAddressModel(AddressModel workAddressModel) {
        this.workAddressModel = workAddressModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
