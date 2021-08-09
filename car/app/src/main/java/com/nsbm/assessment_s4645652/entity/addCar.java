package com.nsbm.assessment_s4645652.entity;

public class addCar {

    private int id;
    private String carBrand;
    private String carModel;
    private String carPrice;

    public addCar(int id,String carBrand,String carModel,String carPrice){
        this.id = id;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carPrice = carPrice;
    }

    public addCar(String carBrand,String carModel,String carPrice){

        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carPrice = carPrice;
    }

    public addCar(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }
}
