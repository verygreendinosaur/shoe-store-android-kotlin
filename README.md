# shoe-store-android-kotlin
'Shoe Store' Project App for Udacity Android Kotlin Developer Nanodegree


## Project Rubric
Steps
1. Open the starter project from the github repo in Android Studio [DONE]
2. Add the navigation libraries to the app build.gradle file [DONE]
3. Add the safe-arg plugin to the main and app build.gradle file [DONE]
4. Set DataBindingUtil in build.gradle [DONE]
5. Use DataBindingUtil to inflate every layout [DONE]
6. Create a new navigation xml file [DONE]
7. Create a new Login destination. [DONE]

[DONE] Include email and password labels
[DONE] Include email and password fields
[DONE] Create buttons for creating a new login and logging in with an existing account
[DONE] Clicking either button should navigate to the Welcome Screen.

8. Create a new Welcome screen destination that includes: [DONE]

[DONE] A new layout
[DONE] At least 2 textviews and use any text you would like
[DONE] A navigation button with actions to navigate to the instructions screen

9. Create a new Instruction destination that includes: [DONE]

[DONE] A new layout
[DONE] At least 2 textviews with appropriate information
[DONE] A navigation button with actions to navigate to the shoe list screen

10. Create a class that extends ViewModel [DONE]

[DONE] Use a LiveData field that returns the list of shoes

11. Create a new Shoe List destination that includes: [DONE]

[DONE] A new layout
[DONE] A ScrollView
[DONE] A LinearLayout inside the ScrollView for Shoe Items
[DONE] A FloatingActionButton with an action to navigate to the shoe detail screen

12. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration [ ]
13. In MainActivity, add a Logout menu to return to the login screen [ ]
14. Create a new Shoe Detail destination that includes: [ ]

[ ] A new layout
[ ] A TextView label and EditView for the Shoe Name, Company, Shoe Size and Description
[ ] A Cancel button with an action to navigate back to the shoe list screen
[ ] A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model

15. Make sure you can’t go back to onboarding screens In the Shoe List screen: [ ]

[ ] Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
[ ] Observe the shoes variable from the ViewModel
[ ] Add a new layout item into the scrollview for each shoe.