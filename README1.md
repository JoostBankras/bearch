# bearch, the app where you'll find a music-band that suits you

__name:__ Joost Bankras

__student number:__ 12377775

My final product of this minor will be an app for musicians who are looking for a band to play with. The app will allow the people who are in need of a band to see which bands nearby are looking for musicians so they can contact each other.

## Problem Statement

If you don't have loads of contacts in the music-world but have lots of talent playing an instrument, it can be very hard to get in contact with a band that suits your kind of music. Band members can be overwhelming so it is not easy to step up to someone and ask if you can play in their band. Besides it can be very maladroit to play in a band to have rehearsal 50 km's from home. Bands struggle with this too, it can be very hard to find a suited guitarist for example so we solve two problems.

## Solution

- an app, that'll connect all the bands with all the available musicians the app will contain a reaction option, if someone pushes that button it will send their account to the band who placed the request for musicians.

__features__
- a filter screen to select location, genre, instrument, age.
- a list of available bands or musicians
- the possiblity to make an offer for musicians
- make account and create a band
- reply on request for musicians
- send musicians request for your band
- add musicians to your band and see who is in your band

__optional features__
- make an own chatbox for messages
- filter within a radius from some place
- option for a band to be booked by this app

## Prerequisites

- Google maps API for getting distance : https://developers.google.com/maps/documentation/distance-matrix/intro
- a database for the API : https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase
- an API that handles all the requests for the login and database : https://github.com/anajetli/android_login_registration_via_api
- webhosting for the api : https://www.000webhost.com

__hardest part__
- the hardest part of this app will be filtering all the offers on location.

__similar__
- a site that works like this is  http://www.marktplaats.nl , on this site you can filter items by their location
- a site which helps you find musicians is http://www.bandledengezocht.nl/
