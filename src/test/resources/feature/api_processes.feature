#language: en
  #author: Juan Salgado
Feature: Serenity Rest
  As a user of serenity rest, I want to use it for API verificationin the page of reqres.in

  @get
  Scenario Outline: GETS
    Given The access to requestin
    When I had proved all the GETS processes
      | okStatus   | notFoundStatus   |
      | <okStatus> | <notFoundStatus> |
    Then I had finished the process with an status code 200
    Examples:
      | okStatus | notFoundStatus |
      | 200      | 404            |

  @delete
  Scenario Outline: DELETES
    Given We almost finish
    When We try the only delete
      | responseStatus   |
      | <responseStatus> |
    Then We are done with a final status 204
    Examples:
      | responseStatus |
      | 204            |

  @post
  Scenario Outline: POSTS
    Given The page
    When I tried all posts
      | name   | job   | emailSuccessful   | passwordOne   | passwordTwo   | emailUnsuccessfulOne   | emailUnsuccessfulTwo   |
      | <name> | <job> | <emailSuccessful> | <passwordOne> | <passwordTwo> | <emailUnsuccessfulOne> | <emailUnsuccessfulTwo> |
    Then My work is done, and in the final test the result must be 400
    Examples:
      | name     | job    | emailSuccessful    | passwordOne | passwordTwo | emailUnsuccessfulOne | emailUnsuccessfulTwo |
      | morpheus | leader | eve.holt@reqres.in | pistol      | cityslicka  | sydney@fife          | peter@klaven         |

  @put
  Scenario Outline: PUT
    Given We are in the penultimate step
    When We add the info to this case
      | name   | jobOne   |
      | <name> | <jobOne> |
    Then Let's go to the final step with an status of 200
    Examples:
      | name     | jobOne        |
      | morpheus | zion resident |

  @patch
  Scenario Outline: PATCH
    Given The final stage
    When We add the info in the body
      | name   | jobOne   |
      | <name> | <jobOne> |
    Then We get a final status of 200
    Examples:
      | name     | jobOne        |
      | morpheus | zion resident |