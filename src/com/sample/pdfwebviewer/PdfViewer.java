package com.sample.pdfwebviewer;


import android.annotation.SuppressLint;
import android.app.Activity;
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
        webView.loadUrl("file:///android_asset/pdfviewer/index.html?file=" + path);     
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
 
}

