public class Person {

   String firstName;
   String lastName;
   String address;
   String city;
   String state;
   Integer zip;
   Integer phone;
/*
   Person() {
   }*/

   Person(String firstName, String lastName, String address, String city, String state, Integer zip,
          Integer phone) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
      this.city = city;
      this.state = state;
      this.zip = zip;
      this.phone = phone;
   }
}
