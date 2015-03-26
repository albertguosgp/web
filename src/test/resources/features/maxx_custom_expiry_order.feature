Feature: Maxxtrader custom expiry order
  User Story:
  As a FX trader, I want Maxxtrader to add a timezone dropdown list into custom expiry order panel. At the same time I want order expiry time shown in order blotter
  to be timezone + local time format so that I have a clear view when order will be expired in desired time zone.

  Scenario: Send order in custom expiry date
    Given Maxxtrader start
    And User select "Custom" option in "Expiry" dropdown list
    And Current Singapore time is 2015-03-15T17:40:36+08:00
    When User select Sing in "Timezone" dropdown list
    Then User should see "Timezone" and "Date and Time" calendar
      | Sing | 2015-03-15T17:40:36+08:00 |
    When User select NY in "Timezone" dropdown list
    Then User should see "Timezone" and "Date and Time" calendar
      | NY | 2015-03-15T05:40:36-04:00 |
    When User select LDN in "Timezone" dropdown list
      | LDN | 2015-03-15T09:40:36+00:00 |
    Then User should see "Timezone" and "Date and Time" calendar

  Scenario: Order display in order blotter
    Given Maxxtrader start
    And A working order existing with expiry date 2015-03-15T09:40:36+00:00
    When User check order blotter
    Then expiry column should show 2015-03-15T09:40:36+00:00 LDN