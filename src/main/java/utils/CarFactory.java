package utils;

import dto.Car;
import net.datafaker.Faker;

public class CarFactory {
    static Faker faker = new Faker();

    public static Car positiveCar() {
        Car car = Car.builder()
                .city(faker.address().cityName())
                .manufacturer(faker.vehicle().manufacturer())
                .model(faker.vehicle().model())
                .year(String.valueOf(faker.number().numberBetween(2000,2025)))
                .fuel(faker.vehicle().fuelType())
                .seats(faker.number().numberBetween(2,12))
                .carClass(faker.vehicle().carType())
                .serialNumber(faker.vehicle().licensePlate())
                .pricePerDay(faker.number().randomDouble(2, 300, 1000))
                .about(faker.text().text())
                .build();
        return car;
    }
}

