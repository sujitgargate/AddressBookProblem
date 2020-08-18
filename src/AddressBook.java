import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

   String firstName;
   String lastName;
   String address;
   String city;
   String state;
   int zipCode;
   int phoneNumber;
   private static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) {
      AddressBook addressBookObj = new AddressBook();
      System.out.println("Welcome to AddressBook");

      //Initialization of map
      Map<String, List<Object>> addressBook = new TreeMap<>();

      System.out.println("Enter options \n1.Add Person \n2.Edit Person \n3.Delete Person");
      int choiceOfOperation = sc.nextInt();

      switch (choiceOfOperation) {
         case 1:
            System.out.println("Enter Number Of Persons To be Added in AddressBook");
            int addPersonCount = sc.nextInt();

            while (addPersonCount != 0) {
               addressBookObj.addPerson(addressBook);
               addPersonCount--;
            }
            addressBookObj.sortByPersonName(addressBook);
            break;

         case 2:
            addressBookObj.editingAddressBook(addressBook);
            break;

         case 3:
            addressBookObj.deletePerson(addressBook);
            break;

         default:
            System.out.println("Enter valid Option");
            break;
      }
   }

   /**
    * ADDPERSON RETURNS HASH MAP AND ALSO TAKES PARAMETERS HASH MAP
    * 1ST IS NAME OF PERSON AND 2ND IS LIST OF OTHER DETAILS
    */
   public Map<String, List<Object>> addPerson(Map<String, List<Object>> addressBook) {

      System.out.print("Enter The First Name :- \n");
      sc.nextLine();
      String firstName = sc.next();


      System.out.print("Enter The Last Name :- \n");
      String lastName = sc.next();

      String fullName = firstName + "" + lastName;

      if (addressBook.containsKey(fullName)) {
         System.out.println("The Person Data is Already Present : " + addressBook.get(fullName));
      } else {

         System.out.print("Enter The address :- \n");
         String address = sc.next();

         System.out.print("Enter The City :- \n");
         String city = sc.next();

         System.out.print("Enter The State :- \n");
         String state = sc.next();

         System.out.print("Enter The Zip Code :- \n");
         int zipCode = sc.nextInt();

         System.out.print("Enter The Phone Number :- \n");
         int phoneNumber = sc.nextInt();

         //Creating list For Person details
         List<Object> personData = new ArrayList<>();
         personData.add(firstName);
         personData.add(lastName);
         personData.add(address);
         personData.add(city);
         personData.add(state);
         personData.add(zipCode);
         personData.add(phoneNumber);

         String nameofPerson = firstName + "" + lastName;

         //PesonData is list
         addressBook.put(nameofPerson, personData);
         displayAddressBook(addressBook, nameofPerson);
      }
      return addressBook;
   }

   //Displaying Person Data
   public void displayAddressBook(Map<String, List<Object>> addressBook, String nameOfPerson) {
      if (addressBook.containsKey(nameOfPerson)) {
         System.out.println("The Person Data is : " + addressBook.get(nameOfPerson));
      }
   }

   //For Editing Existing Person Data
   private Map<String, List<Object>> editingAddressBook(Map<String, List<Object>> addressBook) {

      Map<String, List<Object>> addPersonForEditing = addPerson(addressBook);
      System.out.println("Enter Name To Edit Person Data");
      String findPersonName = sc.next();

      //Checking If The Name Is There
      if (addPersonForEditing.containsKey(findPersonName) != false) {

         //Finding name from addressBook
         List<Object> personName = new ArrayList<>(addPersonForEditing.get(findPersonName));

         System.out.println("Choose Below To Edit");
         System.out.println("\n 1. Address");
         System.out.println("\n 2. City");
         System.out.println("\n 3. State");
         System.out.println("\n 4. Zip");
         System.out.println("\n 5. Phone");

         int choice = sc.nextInt();

         switch (choice) {
            case 1:
               System.out.println("Enter Address");
               String editAddress = sc.next();
               personName.set(2, editAddress);
               addressBook.replace(findPersonName, personName);
               break;
            case 2:
               System.out.println("Enter City");
               String editCity = sc.next();
               personName.set(3, editCity);
               addressBook.replace(findPersonName, personName);
               break;
            case 3:
               System.out.println("Enter State");
               String editState = sc.next();
               personName.set(4, editState);
               addressBook.replace(findPersonName, personName);
               break;
            case 4:
               System.out.println("Enter Zip Code");
               int editZip = sc.nextInt();
               personName.set(5, editZip);
               addressBook.replace(findPersonName, personName);
               break;
            case 5:
               System.out.println("Enter Phone Number");
               int editPhone = sc.nextInt();
               personName.set(6, editPhone);
               addressBook.replace(findPersonName, personName);
               break;
            default:
               System.out.println("Enter Valid Option");
         }

         displayAddressBook(addressBook, findPersonName);
         return addressBook;
      } else {
         System.out.println("Entered Name Not Found");
         return null;
      }
   }

   //Method To Delete Person        
   private void deletePerson(Map<String, List<Object>> addressBook) {

      //Adding person
      Map<String, List<Object>> addPersonToDelete = addPerson(addressBook);
      System.out.println("Enter Name To Delete Person Data");
      String findPersonName = sc.next();

      //Checking If The Name Is There
      if (addPersonToDelete.containsKey(findPersonName) == true) {
         addressBook.remove(findPersonName);
         System.out.println("Person were removed");
         displayAddressBook(addressBook, findPersonName);
      } else {
         System.out.println("Person Not Found");
      }
   }

   /*Sorting AddressBook By Name
   * TreeMap is used To Sort Entries
   */
   private void sortByPersonName(Map<String, List<Object>> addressBook) {

      //First Add Person And Then Sort
      addPerson(addressBook);
      Map<String, List<Object>> temporaryAddressBook = new TreeMap(addressBook);
      displayAddressBook(temporaryAddressBook,null);
   }

   //Overriding toString To Get Hex Values In String Values
   @Override
   public String toString() {
      return "FirstName: "+firstName+", LasName: "+lastName+", Address: "+address+", City: "+city+", State: "+state+", ZIP code: "+zipCode+", Phone Number: "+phoneNumber;
   }
}

