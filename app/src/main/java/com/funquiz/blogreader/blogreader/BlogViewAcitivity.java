package com.funquiz.blogreader.blogreader;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class BlogViewAcitivity extends ActionBarActivity {
    protected String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_view_acitivity);

        Intent intent =getIntent();
        Uri blogUri= intent.getData();
        mUrl=blogUri.toString();

        WebView webView =(WebView) findViewById(R.id.webView);
        webView.loadUrl(mUrl);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.blog_view_acitivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_share) {
            sharePost();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sharePost() {
        Intent shareIntent= new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,mUrl); //properly show text
        startActivity((Intent.createChooser(shareIntent, getString(R.string.share_content))));
    }
}

