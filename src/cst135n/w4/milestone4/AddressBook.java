package cst135n.w4.milestone4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	List<BaseContact> baseContacts = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void open() {
		baseContacts.add(new PersonContact(434, "Bill Johnson", "608-458-1578", "picWithFriend picWithDog", "426 N Lorem Dr, Buckeye, AZ", "04-22-1989", "tallAndLanky", new Location(856, 455, "W Pincot Dr", "Glendale", "AZ"), new Photo(122, "BillJPhotos", "04-17-2012", "picWithCat picWithBoat")));
		baseContacts.add(new PersonContact(427, "Carrie Lager", "623-272-2683", "picWithDaughter", "517 S Wilson Ln, Goodyear, AZ", "08-13-1967", "smilesPlenty", new Location(925, 45568, "S Wilson Rd", "SunCity", "AZ"), new Photo(145, "CarrieLPhotos", "06-05-2017", "picWithFriends picWithMountain")));
		baseContacts.add(new PersonContact(511, "Ben Wilson", "623-292-4458", "picWithBestFriend, picOnSled", "8789 W Layman Ave, Scottsdale, AZ", "02-05-1952", "talksALot", new Location(876, 49853, "N Piedmont Ave", "Avondale", "AZ"), new Photo(172, "BenWPhotos", "02-19-2012", "picWithDad picWithCar")));
		baseContacts.add(new BusinessContact(521, "Judy Stucks", "480-342-5662", "picAtFootballGame", "245 Main St, Avondale, AZ", "9amTo6pm", "https://www.stucksRealty.com", new Location(824, 235, "S Raymond Ln", "Scottsdale", "AZ"), new Photo(149, "JudySPhotos", "12-07-2019", "picWithAssociate picAtConference")));
		baseContacts.add(new BusinessContact(743, "John Blaine", "623-834-4573", "picWithSam picWithJudy", "58698 S Bayberry Rd, Cave Creek, AZ", "11amTo8pm", "https://www.blainePizza.com", new Location(896, 6572, "W Stanley Ln", "Goodyear", "AZ"), new Photo(136, "JohnBPhotos", "09-22-2009", "picWithMayor, picAtCampfire")));
		baseContacts.add(new BusinessContact(768, "Alice Goodwin", "480-854-5789", "picWithMayor picWithAssociates", "135 N Main St, Scottsdale, AZ", "10amTo10pm", "https://www.goodwinServices.com", new Location(884, 287, "21st St", "Goodyear", "AZ"), new Photo(153, "AliceGPhotos", "03-18-2014", "picAtFootballGame, picAtWork")));
		
		baseContacts = DataAccessService.readAllContacts();   // comment out to populate above 6 contacts
		
		menu();
		
	}

	public void menu() {
		do {
			System.out.println(" ========= ");
			System.out.println(" MAIN MENU ");
			System.out.println(" ========= ");
			System.out.println(" 1. Create Person Contact ");   // create
			System.out.println(" 2. Create Business Contact ");
			System.out.println(" 3. Show All Contacts ");  // read
			System.out.println(" 4. Show Details of One Contact");
			System.out.println(" 5. Update a Contact ");   // update
			System.out.println(" 6. Delete a Contact ");   // delete
			System.out.println(" 7. Search for a Contact by Name");
			System.out.println(" 8. Sort All Contacts by Name");
			System.out.println(" 9. Exit ");
			System.out.println(" ========= ");
			System.out.println("What option to perform? ");
			int option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			case 1:
				createPersonContact();
				break;
			case 2:
				createBusinessContact();
				break;
			case 3:
				showAllContacts();
				break;
			case 4:
				showDetailsOfOneContact();
				break;
			case 5:
				updateAContact();
				break;
			case 6:
				deleteAContact();
				break;
			case 7:	
				searchContactByName();
				break;	
			case 8:	
				sortContactsByName();
				break;
			case 9:	
				System.out.println("Thank you for using our Address Book");
				DataAccessService.writeAllContacts(baseContacts);
				System.exit(0);
				break;
			default:
				System.out.println("Please enter different option");
			}
		} while (true);
	}
	
	private void searchContactByName() {
		System.out.println("===========");
		System.out.println(" SEARCH CONTACT BY NAME ");
		System.out.println("===========");
		System.out.println("Who do you want to search for? ");
		String search = sc.nextLine();
		
		int counter = 1;
		
		for (BaseContact bc : baseContacts) {
			if (bc.getName().toUpperCase().contains(search.toUpperCase())) {
				System.out.println(counter++ + ". " + bc.toString());
			}
		}
	}

	private void sortContactsByName() {
		System.out.println("===========");
		System.out.println(" SORT CONTACTS BY NAME ");
		System.out.println("===========");
		ComparatorName cn = new ComparatorName();
		baseContacts.sort(cn);
		showAllContacts(); 
		
	}

	private void showDetailsOfOneContact() {
		System.out.println("===========");
		System.out.println(" SHOW DETAILS OF ONE CONTACT ");
		System.out.println("===========");
		showAllContacts(); 
		System.out.println("Details of which Contact? ");
		int item = sc.nextInt();
		sc.nextLine();
		System.out.println("CONTACT ID: \t" + baseContacts.get(item - 1).getContactId());
		System.out.println("NAME: \t" + baseContacts.get(item - 1).getName());
		System.out.println("PHONE: \t" + baseContacts.get(item - 1).getPhone());
		System.out.println("LIST OF PHOTOS: \t" + baseContacts.get(item - 1).getListOfPhotos());
		System.out.println("LOCATION: \t" + baseContacts.get(item - 1).getLocation());
		if (baseContacts.get(item - 1) instanceof PersonContact) {
			System.out.println("LOCATION DETAILS");
			System.out.println("DATE OF BIRTH: \t" + ((PersonContact)baseContacts.get(item - 1)).getDateOfBirth());
			System.out.println("DESCRIPTION: \t" + ((PersonContact)baseContacts.get(item - 1)).getDescription());
			System.out.println("LOCATION: \t" + ((PersonContact)baseContacts.get(item - 1)).getLocationClass());
			System.out.println("PHOTO: \t" + ((PersonContact)baseContacts.get(item - 1)).getPhotoClass());
		}
		else if (baseContacts.get(item - 1) instanceof BusinessContact) {
			System.out.println("BUSINESS HOURS: \t" + ((BusinessContact)baseContacts.get(item - 1)).getBusinessHours());
			System.out.println("WEBSTIE URL: \t" + ((BusinessContact)baseContacts.get(item - 1)).getWebsiteURL());
		}
	}

	public void deleteAContact() {
		System.out.println(" ========= ");
		System.out.println(" DELETE A CONTACT ");
		System.out.println(" ========= ");
		System.out.println("Removing a Base Contact Name.");
		showAllContacts();
		System.out.println("===========");
		System.out.println("What Contact to delete? ");
		int item = sc.nextInt();
		sc.nextLine();
		baseContacts.remove(item - 1);
	}

	public void updateAContact() {
		System.out.println(" ========= ");
		System.out.println(" UPDATE A CONTACT NAME ");
		System.out.println(" ========= ");
		System.out.println("Updating a Base Contact Name.");
		showAllContacts();
		System.out.println("===========");
		System.out.println("What Contact to update? ");
		int item = sc.nextInt();                   //  item
		sc.nextLine();

		if (baseContacts.get(item - 1) instanceof PersonContact) {
			updatePersonContact(item); 
		}
		else if (baseContacts.get(item - 1) instanceof BusinessContact) {
			updateBusinessContact(item);
		}
		else {
			System.out.println("I do not recognize that Contact");
		}
//		updatePersonContact(item);
//		updateBusinessContact(item);
	}

	private void createPersonContact() {
		System.out.println(" ========= ");
		System.out.println(" PERSON CONTACT ");
		System.out.println(" ========= ");
		System.out.println("Adding a Person Contact.");

//		PersonContact(int contactId, String name, String phone, String listOfPhotos, String location, String dateOfBirth, String description)
		System.out.println("What is the Contact ID number? (ex 427)");
		int contactId = sc.nextInt();
		sc.nextLine();

		System.out.println("What is the Contact Name? ");
		String name = sc.nextLine();

		System.out.println("What is the Contact Phone number? (ex: 623-423-8468) ");
		String phone = sc.nextLine();

		System.out.println("Present list of Contact photos. ");
		String listOfPhotos = sc.nextLine();

		System.out.println("Where is the Contact location? (ex: 143 Main St, Glendale, AZ) ");
		String location = sc.nextLine();

		System.out.println("What is the Contact Date of Birth? (MM/DD/YYYY)");
		String dateOfBirth = sc.nextLine();

		System.out.println("What is good description of the Contact? (ex: outstanding feature)");
		String description = sc.nextLine();

//		(int locationId, String streetName, int streetNumber, String city, String state)
		System.out.println("Location for Contact? (ID(1-50), Street Number(568), Street Name(Main St), City(Goodyear), State(AZ)");
		Location locationClass = new Location(sc.nextInt(), sc.nextInt(), sc.nextLine(), sc.nextLine(), sc.nextLine());
		
//		(int photoId, String fileName, String dateOfPhoto, String description)
		System.out.println("Photos for Contact? (ex: ID(51-200), File Name(photoFileName), Photo Date(04-25-2018), Description(photo description)");
		Photo photoClass = new Photo(sc.nextInt(), sc.nextLine(), sc.nextLine(), sc.nextLine());
		
		baseContacts.add(new PersonContact(contactId, name, phone, listOfPhotos, location, dateOfBirth, description, locationClass, photoClass));
		
	}
	
	private void updatePersonContact(int item) {
		System.out.println("===========");
		System.out.println(" UPDATE PERSON CONTACT ");
		System.out.println("===========");

//		PersonContact(int contactId, String name, String phone, String listOfPhotos, String location, String dateOfBirth, String description)
		System.out.println("What is the Contact ID number? [ " + baseContacts.get(item - 1).getContactId() + "]");
		int contactId = sc.nextInt();
		sc.nextLine();
		baseContacts.get(item - 1).setContactId(contactId);

		System.out.println("What is the Contact name? [ " + baseContacts.get(item - 1).getName() + "]");
		String name = sc.nextLine();
		baseContacts.get(item - 1).setName(name);

		System.out.println("What is the Contact phone number? (ex: 623-423-8468) [ " + baseContacts.get(item - 1).getPhone() + "]");
		String phone = sc.nextLine();
		baseContacts.get(item - 1).setPhone(phone);

		System.out.println("Show Contacts List of Photos? [ " + baseContacts.get(item - 1).getListOfPhotos() + "]");
		String listOfPhotos = sc.nextLine();
		baseContacts.get(item - 1).setListOfPhotos(listOfPhotos);

		System.out.println("What is the Contact's Location? (ex: 143 Main St, Glendale, AZ) [ " + baseContacts.get(item - 1).getLocation() + "]");
		String location = sc.nextLine();
		((PersonContact)baseContacts.get(item - 1)).setLocation(location);  // experiment

		System.out.println("What is the Contact's Date of Birth (MM/DD/YYYY)? [ " + ((PersonContact)baseContacts.get(item - 1)).getDateOfBirth() + "]");
		String dateOfBirth = sc.nextLine();
		((PersonContact)baseContacts.get(item - 1)).setDateOfBirth(dateOfBirth);
		
		System.out.println("What is good description of the Contact? (ex: outstanding feature) [ " + ((PersonContact)baseContacts.get(item - 1)).getDescription() + "]");
		String description = sc.nextLine();
		((PersonContact)baseContacts.get(item - 1)).setDescription(description);

	}
	
	private void updateBusinessContact(int item) {
		System.out.println("===========");
		System.out.println(" UPDATE BUSINESS CONTACT ");
		System.out.println("===========");

//		BusinessContact(int contactId, String name, String phone, String listOfPhotos, String location,String businessHours, String websiteURL)
		System.out.println("What is the Contact ID number? [ " + baseContacts.get(item - 1).getContactId() + "]");
		int contactId = sc.nextInt();
		sc.nextLine();
		baseContacts.get(item - 1).setContactId(contactId);

		System.out.println("What is the Contact name? [ " + baseContacts.get(item - 1).getName() + "]");
		String name = sc.nextLine();
		baseContacts.get(item - 1).setName(name);

		System.out.println("What is the Contact phone number? [ " + baseContacts.get(item - 1).getPhone() + "]");
		String phone = sc.nextLine();
		baseContacts.get(item - 1).setPhone(phone);

		System.out.println("Show Contacts List of Photos? [ " + baseContacts.get(item - 1).getListOfPhotos() + "]");
		String listOfPhotos = sc.nextLine();
		baseContacts.get(item - 1).setListOfPhotos(listOfPhotos);

		System.out.println("What is the Contact's Location? [ " + baseContacts.get(item - 1).getLocation() + "]");
		String location = sc.nextLine();
		baseContacts.get(item - 1).setLocation(location);

		System.out.println("What is the Contact's Hours of Business (ex 9am to 5pm)? [ " + ((BusinessContact)baseContacts.get(item - 1)).getBusinessHours() + "]");
		String businessHours = sc.nextLine();
		((BusinessContact)baseContacts.get(item - 1)).setBusinessHours(businessHours);
		
		System.out.println("What is the Contact's website URL? [ " + ((BusinessContact)baseContacts.get(item - 1)).getWebsiteURL() + "]");
		String websiteURL = sc.nextLine();
		((BusinessContact)baseContacts.get(item - 1)).setWebsiteURL(websiteURL);

	}
	
	private void createBusinessContact() {
		System.out.println(" ========= ");
		System.out.println(" BUSINESS CONTACT ");
		System.out.println(" ========= ");
		System.out.println("Adding a Business Contact.");

		System.out.println("What is the Contact ID number? ");
		int contactId = sc.nextInt();
		sc.nextLine();

		System.out.println("What is the Contact Name? ");
		String name = sc.nextLine();

		System.out.println("What is the Contact Phone number? (ex: 623-423-8468) ");
		String phone = sc.nextLine();

		System.out.println("Present list of Contact photos. ");
		String listOfPhotos = sc.nextLine();

		System.out.println("Where is the Contact location? (ex: 143 Main St, Glendale, AZ) ");
		String location = sc.nextLine();

		System.out.println("Business hours for Contact? (ex: 8am to 5pm)");
		String businessHours = sc.nextLine();

		System.out.println("Website URL for Contact? (ex: https://www.fishingequipment.com)");
		String websiteURL = sc.nextLine();
		
//		(int locationId, int streetNumber, String streetName, String city, String state)
		System.out.println("Location for Contact? (ID(1-50), Street Number(568), Street Name(Main St), City(Goodyear), State(AZ)");
		Location locationClass = new Location(sc.nextInt(), sc.nextInt(), sc.nextLine(), sc.nextLine(), sc.nextLine());
		
//		(int photoId, String fileName, String dateOfPhoto, String description)
		System.out.println("Photos for Contact? (ex: ID(51-200), File Name(photoFileName), Photo Date(04-25-2018), Description(photo description)");
		Photo photoClass = new Photo(sc.nextInt(), sc.nextLine(), sc.nextLine(), sc.nextLine());
		
		baseContacts.add(new BusinessContact(contactId, name, phone, listOfPhotos, location, businessHours, websiteURL, locationClass, photoClass));
	}

	public void showAllContacts() {
		for (BaseContact bc : baseContacts) {
			System.out.println(bc.toString());
		}
	}
}
