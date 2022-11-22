Feature: Validating getNaceDetails API

  Scenario Outline: Verify whether the Nace order details of the order_id are successfully fetched
    Given Get Call to "<url>"
    Then Response Code "<responseMessage>" is validated

    Examples:
      | url                    | responseMessage |
      | /getNaceDetails/398481 | 200             |

  Scenario Outline:  Verify Response Body
    Given Get Call to "<url>"
    Then the Response Body is validated

    Examples:
      | url                     | 
      | /getNaceDetails/398481  | 