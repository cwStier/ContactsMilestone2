package cst135n.w4.milestone4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataAccessService {
	
	public static List<BaseContact> readAllContacts() {
		
		List<BaseContact> items = new ArrayList<>();
		
		try {
			FileInputStream fis = new FileInputStream("contacts.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			items = (ArrayList<BaseContact>) ois.readObject();
			ois.close(); // added because ois on line 28 fussing
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}

	public static void writeAllContacts(List<BaseContact> items) {   
		
		try {
			FileOutputStream fos = new FileOutputStream("contacts.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(items);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
