// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  host: 'http://localhost:8080/',
  firebaseConfig: {
    apiKey: 'AIzaSyANYYarKCCiFDrFBrnyrdchW3d65dCtqIw',
    authDomain: 'clearpay-faa65.firebaseapp.com',
    databaseURL: 'https://clearpay-faa65.firebaseio.com',
    projectId: 'clearpay-faa65',
    storageBucket: 'clearpay-faa65.appspot.com',
    messagingSenderId: '323623679972',
    appId: '1:323623679972:web:47796e959dbaff2398b9f1',
    measurementId: 'G-LRKV2R0LGR'
  },
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
