# Wag! Challenge

Hi Wag! Team (and GitHub lurkers), thanks for the opportunity to do this challenge!

## Overview

- StackOverflow users are represented by the `StackOverflowUser` class.

- `StackOverflowUserFactory` provides methods for parsing JSON data from StackOverflow.

- `UserViewAdapter` is the `RecyclerView` adapter for StackOverflow users. It fetches the avatars.

## Third-party libraries

- Volley: I'm not sure if Volley counts as a third-party library, but I used it in place of `HttpsURLConnection` 
because that would require an `AsyncTask` and the ensuing boilerplate.
- Glide: Same reasoning as Volley; it is cleaner and faster to use than writing my own solution, and better optimized.

## Notes

- The emulator has scroll lag, but the app runs smooth as butter on a real device. At first I thought it was an issue
with the `UserViewAdapter::onBindViewHolder` call, but it occurs even when the method is empty, and no network
requests are being performed.

## Author

Nathan Matteson