import org.junit.*;
import static org.junit.Assert.*;

public class CDOrganizerTest {

  @Test
  public void newTitle_instanttiatesCorrectly() {
    CDOrganizer organize = new CDOrganizer("Title1");
    assertEquals(true, organize instanceof CDOrganizer);
  }

  @Test
  public void newTitle_returnsAddedTitle_Title1() {
    CDOrganizer organize = new CDOrganizer("Title1");
    assertEquals("Title1", organize.getTitle());
  }
}
