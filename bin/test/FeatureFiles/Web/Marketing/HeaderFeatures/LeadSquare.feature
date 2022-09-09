Feature: Lead Flow - All Sources
  As a user, I want to signup via different CTAs and Verify-in LeadSquare

  @web_marketing_staging_P0_desktop @leadsquare
  Scenario Outline: Verify Signup via X
    Given User is on "<PageUrl>"
    When User click on "<CTA>"
    Then User enters the credentials
    Then verify user signUp Successfully
    And Lead is created in the lead sqaure portal for "<Page>"
    Examples:
      | Page | PageUrl | CTA |
     # | Home                                                     | http://staging-mpc.upgrad.dev/                             | Sign Up             |
     # | Home                                                     | http://staging-mpc.upgrad.dev/                             | GET CAREER HANDBOOK        |
      #| Master's In Machine Learning and Artificial Intelligence | https://staging-mpc.upgrad.dev/masters-in-ml-ai-ljmu-iiitb | Apply Now         |
      #| Master's In Machine Learning and Artificial Intelligence | https://staging-mpc.upgrad.dev/masters-in-ml-ai-ljmu-iiitb | Download Syllabus |
      | Master's In Machine Learning and Artificial Intelligence | https://staging-mpc.upgrad.dev/masters-in-ml-ai-ljmu-iiitb | Download Brochure          |
     # | Master's In Machine Learning and Artificial Intelligence | https://staging-mpc.upgrad.dev/masters-in-ml-ai-ljmu-iiitb | Career Transition Handbook |

  @web_marketing_staging_P0_desktop @leadsquareProgramPage
  Scenario Outline: Verify Signup via X
    Given User is on "<PageUrl>"
    Then User select the courses
    When User click on "<CTA>"
    Then User enters the credentials
    Then verify user signUp Successfully
    And Lead is created in the lead sqaure portal for "<Page>"
    Examples:
      | Page                                                     | PageUrl                        | CTA               |
      | Master's In Machine Learning and Artificial Intelligence | http://staging-mpc.upgrad.dev/ | Download Brochure |