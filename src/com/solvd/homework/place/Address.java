package com.solvd.homework.place;

public class Address {
    private String city;
    private String district;
    private String village;
    private String street;
    private int homeAddress;

    public Address(String city, String district, String village, String street, int homeAddress) {
        this.city = city;
        this.district = district;
        this.village = village;
        this.street = street;
        this.homeAddress = homeAddress;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getVillage() {
        return village;
    }

    public String getStreet() {
        return street;
    }

    public int getHomeAddress() {
        return homeAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        if (city != null)
            sb.append("city='").append(city).append('\'');
        if (district != null)
            sb.append(", district='").append(district).append('\'');
        if (village != null)
            sb.append(", village='").append(village).append('\'');
        if (street != null)
            sb.append(", street='").append(street).append('\'');

        sb.append(", homeAddress='").append(homeAddress).append('\'');
        sb.append('}');

        return sb.toString();
    }

    /**
     * Class builder through which we will initialize the object of the class Address via setters
     * and return this address via the build () method
     */
    public static class Builder {
        private String city;
        private String district;
        private String village;
        private String street;
        private int houseNumber;

        public Builder() {
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder setVillage(String village) {
            this.village = village;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setHouseNumber(int houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Address build() {
            return new Address(city, district, village, street, houseNumber);
        }
    }

}
