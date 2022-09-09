Feature: Program Pages
#  Background:
#    Given User launches the "SGCUrl" URL

  Scenario: As a user, I Want to navigate to program page and view program page details
    Given User launches the "MarketingUrl" URL
    When user chooses to view program_name from course menu
    Then user is directed to program page "PageTitle"
    And user sees all the sections on the top nav of the program page
        |    Section_Names  |
        |     Instructors   |
        |      Syllabus     |
        |   Specialisation  |
        |     Projects      |
        |     Benefits      |
        |     Reviews       |
        |     Careers       |
        | Admission Process |
        |       Fees        |
        |    Refer & Earn   |


