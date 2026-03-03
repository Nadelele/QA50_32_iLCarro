package dto;

import lombok.*;
import utils.enums.FuelTypes;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    private String city;
    private String manufacturer;
    private String model;
    private String year;
    private FuelTypes fuel;
    private int seats;
    private String carClass;
    private String serialNumber;
    private Double pricePerDay;
    private String about;
    private String image;
}