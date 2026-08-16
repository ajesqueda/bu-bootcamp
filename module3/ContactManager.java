import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Alice", new Contact("Alice", "123-456-7890"));
        contacts.put("Alfonso", new Contact("Alfonso", "234-567-8901"));
        contacts.put("Bob", new Contact("Bob", "098-765-4321"));
        contacts.put("Charlie", new Contact("Charlie", "555-555-5555"));

        // Step 5: look up a contact 
        String nameToFind = "Ada Lovelace";
        Contact foundContact = contacts.get(nameToFind);
        if (foundContact != null) {
            System.out.println("Found contact: " + foundContact);
        } else {
            System.out.println("Contact not found: " + nameToFind);
        }
        String nameToFind2 = "David";
        Contact foundContact2 = contacts.get(nameToFind2);
        if (foundContact2 != null) {
            System.out.println("Found contact: " + foundContact2);
        } else {
            System.out.println("Contact not found: " + nameToFind2);
        }
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values()); 
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("=== All Contacts ===");
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    } 
}