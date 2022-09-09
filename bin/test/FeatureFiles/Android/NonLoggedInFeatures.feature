Feature: Homepage features

Description: The purpose of this feature is to test the functional feature available on Homepage without logged in

Background: User is on Homepage
        Given User launches the App
        Then User should navigates to upGrad app homepage


Scenario: Validate ordering of the secondary navigation tabs
        Given user on upGrad homepage
        And user see's four icons at the bottom
        And all four icons should display in order as "Home","My courses", "Careers", "Account"
        And Masters should be se selected by default in secondary navigation tabs
        Then user sees four CTAs at secondary navigation tabs as "Master\'s", "PG Program", "Certification", "Bachelor\'s", and "Doctorate"

Scenario: Validate navigation tabs selection should be constant
        Given user on upGrad homepage
        When user selects "Doctorate" from navigation tabs
        And user scroll vertically
        Then "Doctorate" Selection should be retained

Scenario: Redirects to List of Program cards under the relevant category of Program
        Given user on upGrad homepage
        When user selects "PG Program" navigation tab
        Then Navigation tab "PG Program" displays "Data Science" in carousal title

Scenario: Validate student reviews and Detailed review CTA functionality
        Given user on upGrad homepage
        When user go to Student review sections
        And user see list of reviews
        And user clicks on Detailed review cta on one of the review
        Then user redirects to full review post in browser

Scenario: Validate explore other categories area functionality
        Given user on upGrad homepage
        When user selects "Certification" from navigation tabs
        And user go to Explore other categories area
        And user check the relavent categories displayed correctly as "Master\'s", "PG Program", "Bachelor\'s" and "Doctorate"
        And user check the count is displayed under relavent category as "• 34 Programs", "• 13 Programs", "• 15 Programs" and "• 1 Program"
        And user clicks on "PG Program" category
        Then Relavent category of program card should be displayed and "PG Program" should not be displayed in other categories

Scenario: Validate navigation back to homepage when user scrolls
        Given user on upGrad homepage
        When user selects "Certification" from navigation tabs
        And user scroll vertically up and then scrolls down
        And user clicks on "Home" icon
        Then User should go to top of the Homepage

Scenario: Validate user navigates back to homepage
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on "Account" icon
        And user clicks on "Home" icon
        Then User should navigates to upGrad app homepage

Scenario: Validate homepage position is retained when navigates back from any program
        Given user on upGrad homepage
        When user scroll vertically till "Data Science" is found and selects any program
        And user goes back to homepage
        Then position of homepage should be retained with "Data Science"

Scenario: Validate Banner section functionality
        Given user on upGrad homepage
        When user clicks on Banner
        Then correct program page should be displayed

Scenario: Validate No Internet connection message with retry CTA
        Given user on upGrad homepage
        And user turn off the internet
        And user clicks on view program cta
        And Message "No Internet Connection!" with "RETRY" CTA should be visible
        And user turn on the Internet
        And click on Retry CTA
        Then View program page should appear

Scenario: Validate non-logged and logged in user clicks on Talk to us CTA
        Given user on upGrad homepage
        When user clicks on view program cta
        And correct program page should be displayed
        And user clicks on Talk to us CTA
        And user should navigates to Sign up Login page
        And user do sign up with phone number as "1234567890" and OTP recieved as "1234"
        Then user should redirects to phone dial up screen with phone number shown as "+91 80 6879 0001"

Scenario: To validate if user is able see sign up login page on clicking Download brochure button and user signs up
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "DOWNLOAD BROCHURE" is found
        And user clicks on "DOWNLOAD BROCHURE" report
        And user should navigates to Sign up Login page
        And user do sign up with phone number as "1234567890" and OTP recieved as "1234"
        Then user should be signed up successfully



Scenario: To validate if user is able see sign up login page on clicking Download brochure button and user logged in
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "DOWNLOAD BROCHURE" is found
        And user clicks on "DOWNLOAD BROCHURE" report
        And user should navigates to Sign up Login page
        And user clicks on email link
        And user logged in with email as "prajakta.karawde+student21@upgrad.com", password as "upgrad123" and OTP as "1234"
        Then user should be Logged in successfully on program page


Scenario: To validate if user is able see sign up login page on clicking Download syllabus button and user signs up
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "DOWNLOAD SYLLABUS" is found
        And user clicks on "DOWNLOAD SYLLABUS" report
        And user should navigates to Sign up Login page
        And user do sign up with phone number as "1234567890" and OTP recieved as "1234"
        Then user should be signed up successfully



Scenario: To validate if user is able see sign up login page on clicking Download syllabus button and user logged in
       Given user on upGrad homepage
       When user selects "PG Program" from navigation tabs
       And user clicks on view program cta
       And user scroll vertically till "DOWNLOAD SYLLABUS" is found
       And user clicks on "DOWNLOAD SYLLABUS" report
       And user should navigates to Sign up Login page
       And user clicks on email link
       And user logged in with email as "prajakta.karawde+student21@upgrad.com", password as "upgrad123" and OTP as "1234"
       Then user should be Logged in successfully on program page


Scenario: To validate if user is able see sign up login page on clicking Download career report button and user signs up
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "DOWNLOAD CAREER REPORT" is found
        And user clicks on "DOWNLOAD CAREER REPORT" report
        And user should navigates to Sign up Login page
        And user do sign up with phone number as "1234567890" and OTP recieved as "1234"
        Then user should be signed up successfully



Scenario: To validate if user is able see sign up login page on clicking Download career report button and user logged in
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "DOWNLOAD CAREER REPORT" is found
        And user clicks on "DOWNLOAD CAREER REPORT" report
        And user should navigates to Sign up Login page
        And user clicks on email link
        And user logged in with email as "prajakta.karawde+student21@upgrad.com", password as "upgrad123" and OTP as "1234"
        Then user should be Logged in successfully on program page


Scenario: To validate if user is able see sign up login page on clicking START APPLICATION button and user signs up
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user clicks on "START APPLICATION" CTA
        And user should navigates to Sign up Login page
        And user do sign up with phone number as "1234567890" and OTP recieved as "1234"
        Then user should be signed up successfully and Link "staging-mpc.upgrad.dev" should be open in browser


Scenario: To validate if user is able see sign up login page on clicking START APPLICATION button and user logged in
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user clicks on "START APPLICATION" CTA
        And user should navigates to Sign up Login page
        And user clicks on email link
        And user logged in with email as "prajakta.karawde+student21@upgrad.com", password as "upgrad123" and OTP as "1234"
        Then user should be logged in successfully and Link "staging-mpc.upgrad.dev" should be open in browser


Scenario: To validate if app is running on background if user clicks on home button
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user runs app in background for "10" secs
        Then user should be on the same page and on same tab after being in back ground


Scenario: GS_45 To validate program page displays program details section
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "DOWNLOAD BROCHURE" is found
        Then user should see table with duration in months, fees and start date

Scenario: GS_46 To validate certificate preview displayed in Dual certification section
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "DUAL CERTIFICATION" is found
        Then user should see certificate preview in certificate section

Scenario: GS_47 To validate Placement details displayed in Placement Support section
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "PLACEMENT SUPPORT" is found
        Then user should see placement details in placement support section

Scenario: GS_48 To validate company logos displayed in Learner section
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "Our Learners Works At" is found
        Then user should see company logos in our learner works at section

Scenario: GS_49, GS_50 To validate Linked in profile of instructor
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "Instructors" is found
        And when user clicks "INSTRUCTOR PROFILE" linkedin profile
        Then user should redirects to Linkedin page of Instructor

Scenario: GS_51 To validate list of images in upGrad advantage section
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "upGrad Advantage" is found
        Then user should see list of images in upGrad advantage section


Scenario: GS_52 GS_53 To validate list of semesters/courses displayed correctly with each semester displays correct info
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "Curriculum - Syllabus" is found
        And user verify if default selected option displays correct information
        And user clicks on "Choose Semester" report
        And user select "3" option
        Then user should see related info of semester/courses after selecting the value

Scenario: GS_54 To validate specialization and topics displays correctly
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user scroll vertically till "Specialisations" is found
        And user select "3" from specialisation chip section
        Then user should see related info topics covered in each selected section for option "3"


Scenario: GS_55 To validate list of reviews section under this program
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user clicks on view program cta
        And user go to Student review sections
        Then user see list of reviews


Scenario: GS_56 To validate Learner transformation section and images displayed correctly
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user scroll vertically till "Software Development & IT" is found and selects any program
        And user scroll vertically till "Learner Transformation" is found
        Then user should see learner images


Scenario: GS_57 To validate curriculam-Industry project section and details displayed correctly
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user scroll vertically till "Software Development & IT" is found and selects any program
        And user scroll vertically till "Curriculum-Industry Projects" is found
        Then user should see correct details under projects

Scenario: GS_58 To validate tools section and it's details displayed correctly
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user scroll vertically till "Software Development & IT" is found and selects any program
        And user scroll vertically till "Programming Languages and Tools" is found
        Then user should see correct details under program tools

Scenario: GS_59 To validate Program fee section and it's details displayed correctly
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user scroll vertically till "Software Development & IT" is found and selects any program
        And user scroll vertically till "Program Fee" is found
        Then user should see correct details under Program fee

Scenario: GS_60 GS_61 To validate Emi section and it's details displayed correctly
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user scroll vertically till "Software Development & IT" is found and selects any program
        And user scroll vertically till "Program Fee" is found
        And user should see correct details under Program fee
        And user clicked on "EMI OPTIONS"
        Then relavent details under EMI options should display


Scenario: GS_63 To validate video component section and it's details displayed correctly
        Given user on upGrad homepage
        When user selects "PG Program" from navigation tabs
        And user scroll vertically till "Software Development & IT" is found and selects any program
        And user scroll vertically till "Video Component" is found
        And user clicked on "Video play"
        Then video should opened in separate screen

Scenario: GS_64 GS_65 To validate If user is asked for sign up/login and user signed up
        Given user on upGrad homepage
        When user clicks on "Account" icon
        And  user clicks on "START LEARNING"
        And user should navigates to Sign up Login page
        And user do sign up with phone number as "1234567890" and OTP recieved as "1234"
        Then user should be signed up successfully on account page

Scenario: GS_66 GS_67 GS_68 To validate If user is asked for sign up/login and user logged in
        Given user on upGrad homepage
        When user clicks on "Account" icon
        And  user clicks on "START LEARNING"
        And user should navigates to Sign up Login page
        And user clicks on email link
        And user logged in with email as "prajakta.karawde+student21@upgrad.com", password as "upgrad123" and OTP as "1234"
        Then user should be Logged in successfully on account page

Scenario: GS_62 To validate No EMI option available for particular program
        Given user on upGrad homepage
        When user selects "Master's" from navigation tabs
        And user scroll vertically till "Software Development & IT" is found and selects any program
        And user scroll vertically till "Video Component" is found
        And user clicked on "Video play"
        Then video should opened in separate screen