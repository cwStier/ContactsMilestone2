package cst135n.w2.milestone2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	List<BaseContact> baseContacts = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void open() {
		baseContacts.add(new PersonContact(434, "Bill Johnson", "608-458-1578", "picWithCat, picWithBoat", "Glendale", "04-22-1989", "tallAndLanky"));
		baseContacts.add(new PersonContact(427, "Carrie Lager", "623-272-2683", "picWithFriends, picWithMountain", "SunCity", "08-13-1967", "smilesPlenty"));
		baseContacts.add(new PersonContact(511, "Ben Wilson", "623-292-4458", "picWithDad, picWithCar", "Avondale", "02-05-1952", "talksALot"));
		baseContacts.add(new BusinessContact(521, "Judy Stucks", "480-342-5662", "picWithAssociate, picAtConference", "Scottsdale", "9amTo6pm", "https://www.stucksRealty.com"));
		baseContacts.add(new BusinessContact(743, "John Blaine", "623-834-4573", "picWithMayor, picAtCampfire", "Goodyear", "11amTo8pm", "https://www.blainePizza.com"));
		baseContacts.add(new BusinessContact(768, "Alice Goodwin", "480-854-5789", "picAtFootballGame, picAtWork", "Goodyear", "10amTo10pm", "https://www.goodwinServices.com"));

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
//			System.out.println("Show Details of One Contact");
			System.out.println(" 4. Update a Contact ");   // update
			System.out.println(" 5. Delete a Contact ");   // delete
//			System.out.println("Search for a Contact by Name");
//			System.out.println("Sort All Contacts by Name");
			System.out.println(" 6. Exit ");
			System.out.println(" ========= ");
			System.out.println("What option to perform? ");
			int option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			case 1:
				addPersonContact();
				break;
			case 2:
				addBusinessContact();
				break;
			case 3:
				viewAllBaseContacts();
				break;
			case 4:
				updateBaseContacts();
				break;
			case 5:
				deleteBaseContact();
				break;
//			case 6:
//				displayOneBaseContact();
//				break;
//			case 7:	
//				sortByBaseContactName();
//				break;
//			case 8:	
//				searchByBaseContactName();
//				break;	
			case 6:	
				System.out.println("Thank you for using our Address Book");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter different option");
			}
		} while (true);
	
	}
	
	public void deleteBaseContact() {
		System.out.println(" ========= ");
		System.out.println(" REMOVING NAME ");
		System.out.println(" ========= ");
		System.out.println("Removing a Base Contact Name.");
		viewAllBaseContacts();
		System.out.println("===========");
		System.out.println("What Contact to delete? ");
		int item = sc.nextInt();
		sc.nextLine();
		baseContacts.remove(item - 1);
	}

	public void updateBaseContacts() {
		System.out.println(" ========= ");
		System.out.println(" UPDATE NAME ");
		System.out.println(" ========= ");
		System.out.println("Updating a Base Contact Name.");
		viewAllBaseContacts();
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

//	public void displayOneBaseContact() {
//		System.out.println(" ========= ");
//		System.out.println(" DISPLAY ONE NAME ");
//		System.out.println(" ========= ");
//		System.out.println("Display one Base Contact Name.");
//	}
//
//	public void sortByBaseContactName() {
//		System.out.println(" ========= ");
//		System.out.println(" SORT ALL NAMES ");
//		System.out.println(" ========= ");
//		System.out.println("Sort all Base Contact Names.");
//	}
//
//	public void searchByBaseContactName() {
//		System.out.println(" ========= ");
//		System.out.println(" SEARCH BY NAME ");
//		System.out.println(" ========= ");
//		System.out.println("Search for a Base Contact Name.");
//	}

	private void addPersonContact() {
		System.out.println(" ========= ");
		System.out.println(" BASE CONTACT ");
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

		baseContacts.add(new PersonContact(contactId, name, phone, listOfPhotos, location, dateOfBirth, description));
	

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
	
	

	private void addBusinessContact() {
		System.out.println(" ========= ");
		System.out.println(" BASE CONTACT ");
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

		baseContacts.add(new BusinessContact(contactId, name, phone, listOfPhotos, location, businessHours, websiteURL));

	}

	public void viewAllBaseContacts() {
		for (BaseContact bc : baseContacts) {
			System.out.println(bc.toString());
		}
	}
}
