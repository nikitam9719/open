Feature: тест на проверку заголовка

  Scenario: зайти на сайт и проверить заголовок
    When I access the page at url http://beta.legiontd2.com/
    Then I should see the title Google
    Then check if it`s true
