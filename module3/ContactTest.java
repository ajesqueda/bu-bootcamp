import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
 
public class ContactTest {
 
 private Contact contact; 
 
  @BeforeEach
  void setUp() {
    contact = new Contact("Ada Lovelace", "+1 617 555 0101");
  } 
 
  @Test
  void getName_returnsCorrectName() {
    assertEquals("Ada Lovelace", contact.getName());
  } 
 
  @Test
  void getPhone_returnsCorrectPhone() {
    assertEquals("+1 617 555 0101", contact.getPhone());
  } 
 
  @Test
  void toString_containsBothFields() {
    assertTrue(contact.toString().contains("Ada Lovelace"));
    assertTrue(contact.toString().contains("+1 617 555 0101"));
  }
  //test that two different Contact objects with the same name are independent (changing one does not affect the other). 
  @Test
  void contactObjectsAreIndependent() {
    Contact contact1 = new Contact("Ada Lovelace", "+1 617 555 0101");
    Contact contact2 = new Contact("Ada Lovelace", "+1 617 555 0102");
    contact1.setName("Grace Hopper");
    assertNotEquals(contact1.getName(), contact2.getName());
  }
}
