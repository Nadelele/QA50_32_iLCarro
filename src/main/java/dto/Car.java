package dto;

import lombok.*;

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
    private String fuel;
    private int seats;
    private String carClass;
    private String serialNumber;
    private Double pricePerDay;
    private String about;
    private String image;
}