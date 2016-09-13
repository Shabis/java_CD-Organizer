import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("newOrganizer", request.session().attribute("newOrganizer"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/CDOrganizer", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<CDOrganizer> newOrganizer = request.session().attribute("newOrganizer");
      if (newOrganizer == null) {
        newOrganizer = new ArrayList<CDOrganizer>();
        request.session().attribute("newOrganizer", newOrganizer);
      }

      String title = request.queryParams("title");
      CDOrganizer userOrganizer = new CDOrganizer(title);
      newOrganizer.add(userOrganizer);
      Collections.sort(newOrganizer, new Comparator<CDOrganizer>() {
        @Override
        public int compare(CDOrganizer o1, CDOrganizer o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
      });

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
