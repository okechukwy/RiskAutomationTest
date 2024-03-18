Feature:
  As a job seeker I want to search for available jobs in the career page

  Scenario: Search available jobs
    Given I navigate to the risk home page "https://risk.lexisnexis.co.uk/"
    And I accept the cookies
    When I click the About Us page
    And I open the Career page
    And I click the search all link
    And  I search for "automation tester" job
    Then I see the number of jobs available displayed