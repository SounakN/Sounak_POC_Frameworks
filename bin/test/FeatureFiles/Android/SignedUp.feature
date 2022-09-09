Feature: Program page features downloading file

Description: The purpose of this feature is to test the scenarios when user is logged in

Background: User is logged in
  Given user on upGrad homepage
  When user clicks on "Account" icon
  And user clicks on "START LEARNING"
  And user do sign up with phone number as "1234567890" and OTP recieved as "1234"
  And user clicks on "Home" icon

Scenario: To validate if user is able to download syllabus
  Given user on upGrad homepage
  When user selects "PG Program" from navigation tabs
  And user clicks on view program cta
  And user scroll vertically till "DOWNLOAD CAREER REPORT" is found
  Then file "DOWNLOAD CAREER REPORT" should be opened

Scenario: To validate if user is able to download syllabus
  Given user on upGrad homepage
  When user selects "PG Program" from navigation tabs
  And user clicks on view program cta
  And user scroll vertically till "DOWNLOAD SYLLABUS" is found
  Then file "DOWNLOAD SYLLABUS" should be opened

Scenario: To validate if user is able to download brochure
  Given user on upGrad homepage
  When user selects "PG Program" from navigation tabs
  And user clicks on view program cta
  And user scroll vertically till "DOWNLOAD BROCHURE" is found
  Then file "DOWNLOAD BROCHURE" should be opened

Scenario: To validate if user is not able to download brochure if permission denied
  Given user on upGrad homepage
  When user selects "PG Program" from navigation tabs
  And user clicks on view program cta
  And user scroll vertically till "DOWNLOAD BROCHURE" is found
  And user clicked on "DOWNLOAD BROCHURE"
  And user deny's storage permission
  But user remains on the same page









  



