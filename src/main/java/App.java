import java.util.*;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/addWord", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/addWord.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String newWordTitle = request.queryParams("newWord");
      Word newWord = new Word(newWordTitle);
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clearWords", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word.clearWords();
      model.put("template", "templates/clearWords.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("definitions", word.getDefinitions());
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/:id/addDefinition", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/addDefinition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String newDefinitionTitle = request.queryParams("newDefinition");
      Definition newDefinition = new Definition(newDefinitionTitle);
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      word.addDefinition(newDefinition);
      model.put("word", word);
      model.put("definitions", word.getDefinitions());
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/:id/clearDefinitions", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      word.clearDefinitions();
      model.put("word", word);
      model.put("template", "templates/clearDefinitions.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/removeWord/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      Word.removeWord(word);
      model.put("word", word);
      model.put("template", "templates/removeWord.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
