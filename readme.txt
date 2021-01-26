Birthdays App Readme
--------------------

Installation and running the project:

I think the project should be able to be run from Android Studio if opened in there. In fact I forgot to create a gitignore file when creating the repo in Github so there is also an apk that should be able to be installed in the build folder if required.


Technical Choices:

-> Retrofit was used as the networking component. Although I've used Volley a lot in the past Retrofit seems to be pretty much the standard these days and does require much less boiler plate code. Along with gson it boils down to not much code at all.

-> LiveData was used. Although this is probably not necessary for such a small app it can iron out potential problems of memory leaks and handles updates to the ui very nicely like after data has been downloaded without requiring additional classes like observers.

-> Room database. I was going to use this and ordinarily would have done so that there would be data there when the app opened (after the first time) to show the user and LiveData is also really good at updating this when the results are downloaded. However, after looking at the data downloaded I saw that there wasn't a primary id/string for each birthday and while I thought I could perhaps use the date string I wasn't sure about that and didn't want to spend loads of time investigating this. Thus, there is no data storage in the app and each time the app opens it downloads the data to display. There is a progress indicator though in the main activity to show that something is happening.


What I haven't done or would have liked to if I had had more time:

-> put more unit tests in. I wrote a unit test for the networking component but it doesn't run due to a threading issue. I have used this kind of thing before and wanted to investigate the problem but decided it was better to go on with actually doing the ui. I'd also have liked to put in some unit tests for the ui which I haven't done. Such as mock data for the recycler view; ensuring that when an item is clicked that it would show the detail activity; ensure the Birthday passed through to the BirthdayActivity was the one clicked on.

-> I haven't added sorting on the birthdays either which I think was part of the description of work required.


Contact details:

jon@7ontheleft.net

https://github.com/jongatwork