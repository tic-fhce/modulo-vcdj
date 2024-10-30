package com.sgd.sgdfback.object;

public class ListarCYRequest {
    private String carrera;
    private Integer year;


    public ListarCYRequest() {
    }

    public ListarCYRequest(String carrera, Integer year) {
        this.carrera = carrera;
        this.year = year;
    }

    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
