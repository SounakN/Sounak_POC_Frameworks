Feature: SEO AUTOMATION REQUIREMENTS
  Validate different SEO related requirements on various pages of upGrad

  @SEO_Automation
  Scenario: Verify presence of "title" and "meta name description" on various pages
    Given User verifies the presence of the title and meta name description with Sheet "MetaName"

  Scenario Outline: Verify presence of "title" and "meta name description" on various pages
    Given User launches direct "<URL>"
    And opens the page source of "<Page>" to search for "title"
    And "meta name description" on the page source and confirm their presence
    Examples:
      | Page                                                             | URL                                                            |
      | data-science-course                                              | datascienceVerticalPageURL                                     |
      | landing-page                                                     | landingpage_URL                                                |
      | mba-course                                                       | mbacourse_URL                                                  |
      | data-science-course                                              | datasciencecourse_URL                                          |
      | doctor-of-business-administration-dba-courses                    | doctorofbusinessadministrationdbacourses_URL                   |
      | software-engineering-course                                      | softwareengineeringcourse_URL                                  |
      | machine-learning-course                                          | machinelearningcourse_URL                                      |
      | digital-marketing-courses                                        | digitalmarketingcourses_URL                                    |
      | management-program                                               | managementprogram_URL                                          |
      | llm-course                                                       | llmcourse_URL                                                  |
      | ba-business-analytics-course                                     | babusinessanalyticscourse_URL                                  |
      | supply-chain-management                                          | supplychainmanagement_URL                                      |
      | mba-liverpool-business-school                                    | mbaliverpoolbusinessschool_URL                                 |
      | mba-imt-deakin-university                                        | mbaimtdeakinuniversity_URL                                     |
      | mba-business-analytics-nmims                                     | mbabusinessanalyticsnmims_URL                                  |
      | mba-from-golden-gate-university                                  | mbafromgoldengateuniversity_URL                                |
      | executive-mba-ssbm                                               | executivembassbm_URL                                           |
      | advanced-general-management-programme-imt-ghaziabad              | advancedgeneralmanagementprogrammeimtghaziabad_URL             |
      | management-pgdm-bimtech                                          | managementpgdmbimtech_URL                                      |
      | mba-digital-finance                                              | mbadigitalfinance_URL                                          |
      | mba-deakin-university                                            | mbadeakinuniversity_URL                                        |
      | data-science-masters-degree-ljmu                                 | datasciencemastersdegreeljmu_URL                               |
      | data-science-pgd-iiitb                                           | datasciencepgdiiitb_URL                                        |
      | executive-pgp-in-data-science-business-analytics-maryland        | executivepgpindatasciencebusinessanalyticsmaryland_URL         |
      | data-science-professional-certificate-bdm-iimk                   | datascienceprofessionalcertificatebdmiimk_URL                  |
      | data-science-ms-uoa                                              | datasciencemsuoa_URL                                           |
      | data-science-pgc-iiitb                                           | datasciencepgciiitb_URL                                        |
      | data-analytics-certificate-program-caltech                       | dataanalyticscertificateprogramcaltech_URL                     |
      | data-science-and-business-analytics-certification-training       | datascienceandbusinessanalyticscertificationtraining_URL       |
      | python-bootcamp                                                  | pythonbootcamp_URL                                             |
      | advanced-certificate-program-in-data-science-bootcamp-iiitb      | advancedcertificateprogramindatasciencebootcampiiitb_URL       |
      | data-analytics-360-certificate-course-ecornell                   | dataanalytics360certificatecourseecornell_URL                  |
      | doctor-of-business-administration-ssbm                           | doctorofbusinessadministrationssbm_URL                         |
      | dba-from-golden-gate-university                                  | dbafromgoldengateuniversity_URL                                |
      | software-engineering-mcs-ljmu                                    | softwareengineeringmcsljmu_URL                                 |
      | full-stack-developer-course-pgd-iiitb                            | fullstackdevelopercoursepgdiiitb_URL                           |
      | full-stack-development-bootcamp                                  | fullstackdevelopmentbootcamp_URL                               |
      | cybersecurity-certificate-program-caltech                        | cybersecuritycertificateprogramcaltech_URL                     |
      | cyber-security-certification-pgc-iiitb                           | cybersecuritycertificationpgciiitb_URL                         |
      | tech-academy-fsd                                                 | techacademyfsd_URL                                             |
      | devops-certification-pgc-iiitb                                   | devopscertificationpgciiitb_URL                                |
      | blockchain-certification-pgc-iiitb                               | blockchaincertificationpgciiitb_URL                            |
      | cloud-computing-certification-pgc-iiitb                          | cloudcomputingcertificationpgciiitb_URL                        |
      | big-data-certification-pgc-iiitb                                 | bigdatacertificationpgciiitb_URL                               |
      | technology-leadership-certificate-course-ecornell                | technologyleadershipcertificatecourseecornell_URL              |
      | advanced-programme-in-e-vehicle-technology                       | advancedprogrammeinevehicletechnology_URL                      |
      | masters-in-ml-ai-ljmu                                            | mastersinmlailjmu_URL                                          |
      | machine-learning-ai-pgd-iiitb                                    | machinelearningaipgdiiitb_URL                                  |
      | machine-learning-nlp-pgc-iiitb                                   | machinelearningnlppgciiitb_URL                                 |
      | machine-learning-deep-learning-pgc-iiitb                         | machinelearningdeeplearningpgciiitb_URL                        |
      | digital-marketing-and-communication-pgc-mica                     | digitalmarketingandcommunicationpgcmica_URL                    |
      | brand-and-communication-management-certificate-program-mica      | brandandcommunicationmanagementcertificateprogrammica_URL      |
      | performance-marketing-ppc-program                                | performancemarketingppcprogram_URL                             |
      | leadership-and-management-certificate-program-wharton            | leadershipandmanagementcertificateprogramwharton_URL           |
      | product-management                                               | productmanagement_URL                                          |
      | human-resource-management-epgp-liba                              | humanresourcemanagementepgpliba_URL                            |
      | hrm-analytics-pcp-iimk                                           | hrmanalyticspcpiimk_URL                                        |
      | healthcare-management-epgp-liba                                  | healthcaremanagementepgpliba_URL                               |
      | master-certificate-integrated-supply-chain-management-msu        | mastercertificateintegratedsupplychainmanagementmsu_URL        |
      | finance-for-non-finance-executives-certificate-program-iitd      | financefornonfinanceexecutivescertificateprogramiitd_URL       |
      | operations-management-and-analytics-cp-iitd                      | operationsmanagementandanalyticscpiitd_URL                     |
      | management-academy-imt-joblink                                   | managementacademyimtjoblink_URL                                |
      | professional-certificate-effective-leadership-management-msu     | professionalcertificateeffectiveleadershipmanagementmsu_URL    |
      | strategic-human-resources-leadership-certificate-course-ecornell | strategichumanresourcesleadershipcertificatecourseecornell_URL |
      | digital-transformation-certificate-course-ecornell               | digitaltransformationcertificatecourseecornell_URL             |
      | executive-leadership-certificate-course-ecornell                 | executiveleadershipcertificatecourseecornell_URL               |
      | management-essentials-online-program                             | managementessentialsonlineprogram_URL                          |
      | law-llm-corporate-and-finance-jgu                                | lawllmcorporateandfinancejgu_URL                               |
      | llm-from-golden-gate-university                                  | llmfromgoldengateuniversity_URL                                |
      | law-llm-intellectual-property-technology-law-jgls                | lawllmintellectualpropertytechnologylawjgls_URL                |
      | law-llm-dispute-resolution-jgls                                  | lawllmdisputeresolutionjgls_URL                                |
      | business-analytics-epgp-liba                                     | businessanalyticsepgpliba_URL                                  |
      | ms-in-business-analytics-from-golden-gate-university             | msinbusinessanalyticsfromgoldengateuniversity_URL              |
      | master-certificate-business-analytics-msu                        | mastercertificatebusinessanalyticsmsu_URL                      |
      | business-analytics-certification                                 | businessanalyticscertification_URL                             |
      | advertising                                                      | advertising_URL                                                |
      | influencer-marketing                                             | influencermarketing_URL                                        |
      | seo-search-engine-optimisation                                   | seosearchengineoptimisation_URL                                |
      | performance-marketing                                            | performancemarketing_URL                                       |
      | sem-search-engine-marketing                                      | semsearchenginemarketing_URL                                   |
      | email-marketing                                                  | emailmarketing_URL                                             |
      | content-marketing                                                | contentmarketing_URL                                           |
      | social-media-marketing                                           | socialmediamarketing_URL                                       |
      | display-advertising                                              | displayadvertising_URL                                         |
      | marketing-analytics                                              | marketinganalytics_URL                                         |
      | web-analytics                                                    | webanalytics_URL                                               |
      | affiliate-marketing                                              | affiliatemarketing_URL                                         |
      | javascript                                                       | javascript_URL                                                 |
      | core-java                                                        | corejava_URL                                                   |
      | data-structures                                                  | datastructures_URL                                             |
      | react-js                                                         | reactjs_URL                                                    |
      | nodejs                                                           | nodejs_URL                                                     |
      | blockchain                                                       | blockchain_URL                                                 |
      | sql                                                              | sql_URL                                                        |
      | full-stack-development                                           | fullstackdevelopment_URL                                       |
      | big-data                                                         | bigdata_URL                                                    |
      | devops                                                           | devops_URL                                                     |
      | nft-non-fungible-tokens                                          | nftnonfungibletokens_URL                                       |
      | cyber-security                                                   | cybersecurity_URL                                              |
      | cloud-computing                                                  | cloudcomputing_URL                                             |
      | database-design                                                  | databasedesign_URL                                             |
      | cryptocurrency                                                   | cryptocurrency_URL                                             |
      | python                                                           | python_URL                                                     |
      | data-analysis                                                    | dataanalysis_URL                                               |
      | inferential-statistics                                           | inferentialstatistics_URL                                      |
      | hypothesis-testing                                               | hypothesistesting_URL                                          |
      | logistic-regression                                              | logisticregression_URL                                         |
      | linear-regression                                                | linearregression_URL                                           |
      | linear-algebra-for-analysis                                      | linearalgebraforanalysis_URL                                   |
      | artificial-intelligence                                          | artificialintelligence_URL                                     |
      | tableau                                                          | tableau_URL                                                    |
      | nlp-natural-language-processing                                  | nlpnaturallanguageprocessing_URL                               |
      | deep-learning                                                    | deeplearning_URL                                               |
      | mba-in-finance                                                   | mbainfinance_URL                                               |
      | mba-in-agriculture                                               | mbainagriculture_URL                                           |
      | consumer-behaviour                                               | consumerbehaviour_URL                                          |
      | supply-chain-management                                          | supplychainmanagement_URL                                      |
      | financial-analysis                                               | financialanalysis_URL                                          |
      | introduction-to-fintech                                          | introductiontofintech_URL                                      |
      | hr-analytics                                                     | hranalytics_URL                                                |
      | fundamentals-of-communication                                    | fundamentalsofcommunication_URL                                |
      | art-of-effective-communication                                   | artofeffectivecommunication_URL                                |
      | introduction-to-research-methodology                             | introductiontoresearchmethodology_URL                          |




  Scenario Outline: Verify absence of "noindex" and "nofollow" tags on any pages
    Given User launches direct "<URL>"
    And opens page source of "<Page>" to search "noindex" and "nofollow" and confirm their presence
    Examples:
      | Page                | URL                        |
      | mba-in-finance      | mbainfinance_URL           |
      | mba-in-agriculture  | mbainagriculture_URL       |
      | data-science-course | datascienceVerticalPageURL |
      | consumer-behaviour  | consumerbehaviour_URL      |


  @SEOAutomation_Google_1
  Scenario: Verify matching of URL and Cache based URL Part 1
    Given SEO verification from the Sheet "Set 1"

  @SEOAutomation_Google_2
  Scenario: Verify matching of URL and Cache based URL Part 2
    Given SEO verification from the Sheet "Set 2"

  @SEOAutomation_Google_3
  Scenario: Verify matching of URL and Cache based URL Part 3
    Given SEO verification from the Sheet "Set 3"

  @SEOAutomation_Google_4
  Scenario: Verify matching of URL and Cache based URL Part 4
    Given SEO verification from the Sheet "Set 4"

  @SEOAutomation_Google_5
  Scenario: Verify matching of URL and Cache based URL Part 5
    Given SEO verification from the Sheet "Set 5"

  @SEOAutomation_Google_6
  Scenario: Verify matching of URL and Cache based URL Part 6
    Given SEO verification from the Sheet "Set 6"

  @SEOAutomation_Google_7
  Scenario: Verify matching of URL and Cache based URL Part 7
    Given SEO verification from the Sheet "Set 7"

  @SEOAutomation_Google_8
  Scenario: Verify matching of URL and Cache based URL Part 8
    Given SEO verification from the Sheet "Set 8"

  @SEOAutomation_Google_9
  Scenario: Verify matching of URL and Cache based URL Part 9
    Given SEO verification from the Sheet "Set 9"



