Feature: Website-Navigation-Header
  As a user, I want to navigate to different pages of the marketing Website from header/footer links


  Background: Login to the URL
    Given User launches the Login "LoginURL"

   @web_marketing_staging_P1_desktop @web_marketing_prod_P1_desktop @Marketing_E2E
  Scenario Outline: Verify the presence of All expected Courses
    Then Verify the Presence of the Header "COURSES"
    And  Verify the Presence of the "<Courses>" and the Program count "<ProgramCount>"
    And  Verify the Presence of the "<ProgramName>" of univ "<University>" under it "<Courses>" along with its HREF "<HREF>" of duration "<Duration>"
    Then Verify the Sections and headers present in the Application page where ProgramName name is "<ProgramName>"
    Examples:
      | Courses          | ProgramName                                | ProgramCount | University             | HREF                              | Duration  |
      | MBA & DBA        | MBA (Global)                               | 12           | Deakin Business School | mba-deakin-university             | 1 year    |
     # | MBA & DBA        | MBA (Global)                               | 12           | Deakin Business School | mba-imt-deakin-university         | 2 years   |
    #  | MBA & DBA        | MBA (Global)                               | 12           | Deakin Business School | mba-digital-marketing-deakin-mica | -- months |
    #  | Data Science     | Master of Science in Data Science          | 7            | University of Arizona  | data-science-ms-uoa               | 24 Months |
   #   | Machine Learning | Master of Science in Machine Learning & AI | 6            | LJMU & IIT Madras      | machine-learning-ms-ljmu-iitm     |-- months  |












