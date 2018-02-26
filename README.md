# BullyBot

Bullying with questions Bot for Slack 

BullyBot is a Slack bot which provides an option to research or study anything.
Bullying wiht questions is an activity where some people ask about a topic where a victim answer it with purpose to learn or research.
The victim haves to answer as soon as posible the questions !!!

Set up

1. First you have to create a Slack workspace. https://slack.com/create.

2. In your workspace you have to create a bot. https://yourworkspace.slack.com/apps/manage/custom-integrations.

3. Get the api token related to the bot that you have created. 

4. Edit the file name `application.properties` (in the project) with you api token. `slackBotToken= api_token`

5. Set your DB URL, User name and Passsword on the same file.

6. Run the application and your bot will be ready.


How Bully Bot works

Onece BullyBot is called into a Slack channel it allows to set a victim, with the command `@bullybot setup`. The victim is the person who wanted to learn or research something.

After that, all channel's members may ask any question what they wants `@victim question?`

The victim will have to answer that question in a thread with a commet

If the questions is correct the questioner will have to react with `+1` to that comment.

To remove a correct anwaser the questioner will have to remove the `+1` reacction. 

BullyBot collect all questions and Answers from the channel and it displays that information in a web page in order to get
metricts about how much the victim knows.
