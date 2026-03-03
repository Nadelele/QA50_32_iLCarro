package utils.enums;

import net.datafaker.providers.base.ElectricalComponents;

public enum FuelTypes {
    DIESEL("//option[text() = ' Diesel ']"),
    PETROL("//option[text() = ' Petrol ']"),
    HYBRID("//option[text() = ' Hybrid ']"),
    ELECTRIC("//option[text() = ' Electric ']"),
    GAS("//option[text() = ' Gas ']");

    private String locator;
    FuelTypes(String locator){
        this.locator = locator;
    }
    public String getLocator(){
        return  locator;
    }
}
