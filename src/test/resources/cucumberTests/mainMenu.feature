Feature: MainMenu test scenario
  @mainMenuTest
  Scenario Outline: Follow the links and check the quantity of goods
    When I go to login page
    And I click on the category and subcategory link "<menuItems>" "<subMenuItem>"
    And I check the number of products in a category "<count>"
    Examples:
      |menuItems                  |subMenuItem          |count  |
      |Desktops                   |PC                   |0      |
      |Desktops                   |Mac                  |1      |
      |Laptops & Notebooks        |Macs                 |0      |
      |Laptops & Notebooks        |Windows              |0      |
      |Components                 |Mice and Trackballs  |0      |
      |Components                 |Monitors             |2      |
      |Components                 |Printers             |0      |
      |Components                 |Scanners             |0      |
      |Components                 |Web Cameras          |0      |
      |Tablets                    |null                 |1      |
      |Software                   |null                 |0      |
      |Phones & PDAs              |null                 |3      |
      |Cameras                    |null                 |2      |
      |MP3 Players                |test 11              |0      |
      |MP3 Players                |test 12              |0      |
      |MP3 Players                |test 15              |0      |
      |MP3 Players                |test 16              |0      |
      |MP3 Players                |test 17              |0      |
      |MP3 Players                |test 18              |0      |
      |MP3 Players                |test 19              |0      |
      |MP3 Players                |test 20              |0      |
      |MP3 Players                |test 21              |0      |
      |MP3 Players                |test 22              |0      |
      |MP3 Players                |test 23              |0      |
      |MP3 Players                |test 24              |0      |
      |MP3 Players                |test 4               |0      |
      |MP3 Players                |test 5               |0      |
      |MP3 Players                |test 6               |0      |
      |MP3 Players                |test 7               |0      |
      |MP3 Players                |test 8               |0      |
      |MP3 Players                |test 9               |0      |