package com.solvd.homework.dao;

import com.solvd.homework.place.Address;

public class AddressDAO {

    public AddressDAO() {
    }

    public String fromAddressToString(Address address) {
        StringBuilder sb = new StringBuilder();

        sb.append(address.getCity()).append(",");
        if (address.getDistrict() != null)
            sb.append(address.getDistrict()).append(",");
        if (address.getDistrict() != null)
            sb.append(address.getVillage()).append(",");
        sb.append(address.getStreet()).append(",");
        sb.append(address.getHomeAddress()).append(",");

        return sb.toString();
    }

    public Address fromStringToAddress(String line) {
        if (line.equals(""))
            return null;

        String[] addressToString = line.split(",");

        Address.Builder builder = new Address.Builder();
        if (addressToString.length == 5) {
            builder.setCity(addressToString[0]);
            builder.setDistrict(addressToString[1]);
            builder.setVillage(addressToString[2]);
            builder.setStreet(addressToString[3]);
            try {
                builder.setHouseNumber(Integer.parseInt(addressToString[4]));
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException. Error adding audiA6 to file.");
                return null;
            }
        }
        else if (addressToString.length == 4) {
            builder.setCity(addressToString[0]);
            builder.setDistrict(addressToString[1]);
            builder.setStreet(addressToString[2]);
            try {
                builder.setHouseNumber(Integer.parseInt(addressToString[3]));
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException. Error adding audiA6 to file.");
                return null;
            }
        }
        else if (addressToString.length == 3) {
            builder.setCity(addressToString[0]);
            builder.setStreet(addressToString[1]);
            try {
                builder.setHouseNumber(Integer.parseInt(addressToString[2]));
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException. Error adding audiA6 to file.");
                return null;
            }
        }

        return builder.build();
    }

}
