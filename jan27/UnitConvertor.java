public class UnitConvertor {

    public static final double km2miles = 0.621371;
    public static final double miles2km = 1.60934;
    public static final double meters2feet = 3.28084;
    public static final double feet2meters = 0.3048;
    public static final double yards2feet = 3;
    public static final double feet2yards = 0.333333;
    public static final double meters2inches = 39.3701;
    public static final double inches2meters = 0.0254;
    public static final double inches2cm = 2.54;
    public static final double farhenheit2celsius = (5.0 / 9.0);
    public static final double celsius2farhenheit = (9.0 / 5.0);
    public static final double pounds2kilograms = 0.453592;
    public static final double kilograms2pounds = 2.20462;
    public static final double gallons2liters = 3.78541;
    public static final double liters2gallons = 0.264172;

    public static double convertKmToMiles(double km) {
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * feet2meters;
    }

    public static double convertYardsToFeet(double yards) {
        return yards * yards2feet;
    }

    public static double convertFeetToYards(double feet) {
        return feet * feet2yards;
    }

    public static double convertMetersToInches(double meters) {
        return meters * meters2inches;
    }

    public static double convertInchesToMeters(double inches) {
        return inches * inches2meters;
    }

    public static double convertInchesToCentimeters(double inches) {
        return inches * inches2cm;
    }

    public static double convertFarhenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * farhenheit2celsius;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * celsius2farhenheit) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * liters2gallons;
    }
}