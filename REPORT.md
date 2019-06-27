# Report of process of the bearch app

### In short
The App I made in the last few weeks, called Bearch, is intended for people searching for a band, or bands searching for a new member. In this App the user should be able to login and register. It should also have a filter function for the band and musicians. The bands and Members should all have an account and this account should be editable by the user himself.
![Screenshot_1561634246](https://user-images.githubusercontent.com/47153142/60263353-c2372180-98e0-11e9-88af-3cddb170b6d0.png)
### Functionality
In this app, there is a home screen with five buttons:
- My band (if user is in a band) / Request to: "some band"(if user requested to enter a band) / Create Band(if user is new and not in a band, or made a request to one)
- Search Bands 
- Search Musicians
- Profile (if user is logged in) / Login (if user is not logged in)
- Log out (if user is logged in) / Register (if user is not logged in)

Those all lead to different screens:

- My band -> the profile page of your band, where you as a member of the band are able to change the properties of the band
- Request to: "some band" -> Button is unclickable only shows that you're in await of response of the band
- Create band -> the page where the users are able to create their own band
- Search Bands -> the filter page where you can filter all the bands on their properties -> result after filtering all the bands on those properties -> if one band is clicked from listview, then show that band's profile
- Search Musicians -> the filter page where you can filter all the musicians on their properties -> result after filtering all the musicians on those properties -> if one musician is clicked from listview, then show that musicians profile
- Profile -> show profile of the current user. Here they can edit their own properties
- Log out -> sets all the user values to zero so that the user is logged out
- Login -> redirects to login page
- Register -> redirects to register page

### Large description functionality
Almost all the pages do get values from the database, which is why I've got quite a few different java activities. 
- I got the values I needed from the database with an Api. This Api was hosted on 000webhost.com but in a couple of days that server became very slow, so for production I used my local machine as host for those api files. I wrote all the api (PHP) files myself and they could be found in the api folder. I made requests to those api files with OkHttpRequests POST and GET requests. All the requests where user values where included were POST requests and others were GET. 
##### Explaination of all activities
- MainActivity : This is the homepage which checks if user is logged in and if a user is in a band an shows the options the user has in the app. If one of the buttons is clicked the other activities will start.

- CreateBandActivity : Here it is possible for the user to create a new band.

- BandActivity : This activity takes the values of the band the user joined and shows them editable in the view, it also makes it possible to change the profile-picture of the band. When the save button is hit, the api is requested to save the values in the database. Also the options see members/requests are here available and those starts the Requests/MembersActivity.

- RequestsActivity/MemberActivity : These activities show respectively the requests the band got from users and the members a band has got.

- FilterMusicianActivity/FilterBandActivity : These activities starts when one of the buttons (Search Bands/Musicians) is clicked from homescreen. In this activities are 4 filter options available (3 for band). If the button "Search" is hit than Band/MusicianResultActivity will start with those filter values.

- BandResultActivity/MusicianResultActivity : These activities starts when the filtering activities are finished and takes the values of the filter activity. It goes through the database tables with users and bands and shows all the results which matches with the filter values. The results of the filter matches are shown in a ListView. 

- BandDetail/MusicianDetail : These activities start when one of the bands or musicians is clicked from the Musician/Band ResultActivity and shows the profile of the clicked band/musician. If a band is clicked it alsof shows the option "make reaction" if the user is not already in a band or made a request to a band.

- LogInActivity/RegisterActivity/LogOutActivity : The most important functions for my app, here the user is able to login or make an account for the app. If the user is finished with the app the user can be logged out by hitting the "log out" button.

- ProfileActivity : This activity show the profile of the user with the option to edit the profile (including profile-picture)

### Challenges

- During the time I was building this app I found out that using the Google Maps Api was not free. So checking where the user was and calculating the distance between band and member was pretty impossible. I made it easy for myself by just giving the users a couple of options per Province (for now only in the Netherlands) to choose from. This is also the way of filtering bands and musicians, just by the nearest city they life to. 
- Another struggle I got was with the slow api, I spent a whole day on changing my api to localhost and setting up an remotemysql.com database.
- When I was trying to create the request function I found out that there was not a proper way to do this easily when users are allowed to join multiple bands or make multiple request (for now it's only possible to join one band). At this time it's also not possible to change the members of your band and the members are all showed as email-names because that were the only UNIQUE fields in the database.
- I also found out that when I allowed the user to change their email it also has to be updated in the member-propertie, request-propertie, and sharedPreferences so that'll give a lot of work extra so I made it impossible for the user to change their email and also did this for the bands to change their band-name. 
- My text also got pretty unreadable because I wanted images as background, so the images I got from unsplash.com now all got blurred a little bit more so the text is more readable. 
- Most of my troubles came with connecting the api proper to the database and to the app itself. I had to use Log.d() a lot because sometimes it was unclear what the server got from the app and what it should exactly respond. 

### Satisfaction

They app in this shape has a lot of parts that could be improved a lot if I'd more. The first thing I would change is the way of sending request and made it possible to request and join multiple bands and also make it possible to kick members or to leave the band self by the user. Also saving images would've been done otherwise if I had more time because I downgrade the images a lot by now. There are plenty of trade-offs because the filter is not very precise, the bands/users could have more properties, there isn't a contact form and not at all a chat function. There isn't also a way of posting a request for a new band member at your band.
