package com.sample.pdfwebviewer;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class PdfViewer extends Activity{
	private WebView webView;
	

//	inside this goes our pdf viewer, just a toy for this test. Requires  more work to make it production ready
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		 
		webView = (WebView) findViewById(R.id.webView1);
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
//		crash on tablet and unnecessary?
		settings.setAllowFileAccessFromFileURLs(true);
		settings.setAllowUniversalAccessFromFileURLs(true);
		settings.setBuiltInZoomControls(true);
		webView.setWebChromeClient(new WebChromeClient());
		webView.loadUrl("file:///android_asset/pdfviewer/index.html");
		
	}

//	reload on resume
	@Override
	protected void onResume() {
		super.onResume();
		webView.loadUrl( "javascript:window.location.reload( true )" );

	}
	
//	clear cache to ensure we have good reload
	@Override
	protected void onPause() {
		super.onPause();
		webView.clearCache(true);

	}
	

}
