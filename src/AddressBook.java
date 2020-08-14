public class AddressBook {

   public static void main(String[] args) {
      System.out.println("Welcome To AddressBook");
   }

   String personFirstName, personLastName, personAddress, personCity, personState;
   int personZip, personPhoneNumber;

   AddressBook(String personFirstName, String personLastName, String personAddress,
               String personCity, String personState, int personZip, int personPhoneNumber) {

      this.personFirstName = personFirstName;
      this.personLastName = personLastName;
      this.personAddress = personAddress;
      this.personCity = personCity;
      this.personState = personState;
      this.personZip = personZip;
      this.personPhoneNumber = personPhoneNumber;
   }
}
