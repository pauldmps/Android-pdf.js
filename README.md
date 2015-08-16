Noitice: I have stopped devlopment of this project (as pdf.js is unstable and not fit enough for production level) and moved to PlugPDF SDK. I will not reply to any questions or issues from now on. Feel free to fork the repo and make it better.

Android-pdf.js
==============

Mozilla pdf.js implementation for android.


This project is a fork of http://www.bitbucket.org/butelo/pdfviewer. All credits goes to the original author.

This project is modified in order to open any pdf file from external sd card of the device into the webview in the app. 
Feel free to include the code in your project. 


Usage:

        Uri path = Uri.parse(Environment.getExternalStorageDirectory().toString() + "/data/test.pdf");
        webView.loadUrl("file:///android_asset/pdfviewer/index.html?file=" + path);
        
        Update the 'path' variable to point to a valid pdf in the android filesystem.
        
        
License:

    Copyright 2014 Mozilla Foundation

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
