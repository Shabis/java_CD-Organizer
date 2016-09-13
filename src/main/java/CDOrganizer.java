import java.util.*;

public class CDOrganizer {
  private String mTitle;

  public CDOrganizer (String title) {
    mTitle = title;
  }

  public String getTitle() {
    return mTitle;
  }



  // public class cdNameComparator implements Comparator<CDOrganizer> {
  //   public int compare(CDOrganizer cd1, CDOrganizer cd2) {
  //       return cd1.getTitle().compareTo(cd2.getTitle());
  //   }
  // }
}
