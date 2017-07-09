$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DemoCucumberTest.feature");
formatter.feature({
  "line": 1,
  "name": "тест на проверку заголовка",
  "description": "",
  "id": "тест-на-проверку-заголовка",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "зайти на сайт и проверить заголовок",
  "description": "",
  "id": "тест-на-проверку-заголовка;зайти-на-сайт-и-проверить-заголовок",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I access the page at url http://beta.legiontd2.com/",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "I should see the title Google",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "check if it`s true",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://beta.legiontd2.com/",
      "offset": 25
    }
  ],
  "location": "DemoCucumber.geturl(String)"
});
formatter.result({
  "duration": 356750028,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Google",
      "offset": 23
    }
  ],
  "location": "DemoCucumber.gettitle(String)"
});
formatter.result({
  "duration": 86813,
  "status": "passed"
});
formatter.match({
  "location": "DemoCucumber.testall()"
});
formatter.result({
  "duration": 21497889106,
  "error_message": "java.lang.IllegalStateException: Не удалось проверить заголовок\r\n\tat pages.home.HomePageTestSteps.checkTitle(HomePageTestSteps.java:66)\r\n\tat testClasses.demo.steps.DemoCucumber.testall(DemoCucumber.java:52)\r\n\tat ✽.Then check if it`s true(DemoCucumberTest.feature:6)\r\n",
  "status": "failed"
});
});