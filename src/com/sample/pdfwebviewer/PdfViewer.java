package com.sample.pdfwebviewer;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("NewApi")
public class PdfViewer extends Activity{
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

	    setContentView(R.layout.webview);
		
	    
		webView = (WebView) findViewById(R.id.webView1);
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);

		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN) //required for running javascript on android 4.1 or later
		{
		settings.setAllowFileAccessFromFileURLs(true);
		settings.setAllowUniversalAccessFromFileURLs(true);
		}
		settings.setBuiltInZoomControls(true);
		
		webView.setWebChromeClient(new WebChromeClient());
		Uri path = Uri.parse(Environment.getExternalStorageDirectory().toString() + "/data/test.pdf");
		
		try {
			InputStream ims = getAssets().open("pdfviewer/index.html");
			String line = getStringFromInputStream(ims);
			if(line.contains("THE_FILE")) {
				line = line.replace("THE_FILE", path.toString());
				
				FileOutputStream fileOutputStream = openFileOutput("index.html", Context.MODE_PRIVATE);
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
        webView.loadUrl("file://" + getFilesDir() + "/index.html");     
	}
	

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pdf_viewer, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    	switch (item.getItemId()) {
		case R.id.action_settings:		
				
			return true;
		
		        
		case R.id.action_next:
			

			webView.loadUrl("javascript:onNextPage()");
	    	return super.onOptionsItemSelected(item);
			
		
		case R.id.action_previous:
			
			
			webView.loadUrl("javascript:onPrevPage()");
	    	return super.onOptionsItemSelected(item);

			

		default:
	    	return super.onOptionsItemSelected(item);
		}
    }
 // convert InputStream to String
 	private static String getStringFromInputStream(InputStream is) {
  
 		BufferedReader br = null;
 		StringBuilder sb = new StringBuilder();
  
 		String line;
 		try {
  
 			br = new BufferedReader(new InputStreamReader(is));
 			while ((line = br.readLine()) != null) {
 				sb.append(line);
 			}
  
 		} catch (IOException e) {
 			e.printStackTrace();
 		} finally {
 			if (br != null) {
 				try {
 					br.close();
 				} catch (IOException e) {
 					e.printStackTrace();
 				}
 			}
 		}
  
 		return sb.toString();
  
 	}
 
}

