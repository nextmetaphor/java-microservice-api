package io.nextmetaphor.service;

import io.nextmetaphor.model.AddressModel;
import io.nextmetaphor.model.PersonModel;
import org.springframework.stereotype.Component;

@Component
public class PersonService {
  public PersonModel getPersonByID(int personId) {
      PersonModel person = null;
      if (personId == 200) {
          AddressModel homeAddress = new AddressModel();
          homeAddress.setHouseName("house-name");
          homeAddress.setHouseNumber(1);
          homeAddress.setAddressLine1("home-address-line-1");
          homeAddress.setAddressLine2("home-address-line-2");
          homeAddress.setAddressLine3("home-address-line-3");
          homeAddress.setCounty("county");
          homeAddress.setCountry("country");
          homeAddress.setPostcode("postcode");

          person = new PersonModel();
          person.setId(200);
          person.setAge(37);
          person.setName("person-name");
          person.setHomeAddressModel(homeAddress);
          person.setWorkAddressModel(null);

      }
      return person;
  }
}
