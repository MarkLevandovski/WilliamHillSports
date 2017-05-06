$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("PlaceBet.feature");
formatter.feature({
  "line": 1,
  "name": "Place Bet Action",
  "description": "",
  "id": "place-bet-action",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Place bet as not registered user",
  "description": "",
  "id": "place-bet-action;place-bet-as-not-registered-user",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User selects \"football\" event",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User bet on Home team to win",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User sets \"0.05\" amount of the bet and clicks Place bet",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Error Message is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "PlaceBetStepDefinition.user_is_on_home_page()"
});
formatter.result({
  "duration": 36936280995,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "football",
      "offset": 14
    }
  ],
  "location": "PlaceBetStepDefinition.user_selects_event(String)"
});
formatter.result({
  "duration": 3716914103,
  "status": "passed"
});
formatter.match({
  "location": "PlaceBetStepDefinition.user_bet_on_home_team_to_win()"
});
formatter.result({
  "duration": 1230310182,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.05",
      "offset": 11
    }
  ],
  "location": "PlaceBetStepDefinition.user_sets_amount_of_the_bet(String)"
});
formatter.result({
  "duration": 359102992,
  "status": "passed"
});
formatter.match({
  "location": "PlaceBetStepDefinition.error_message_is_displayed()"
});
formatter.result({
  "duration": 63503468,
  "status": "passed"
});
});