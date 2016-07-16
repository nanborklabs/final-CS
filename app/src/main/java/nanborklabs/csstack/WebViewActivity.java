package nanborklabs.csstack;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URI;

public class WebViewActivity extends AppCompatActivity {


    public WebView mWebView;
    private nanborklabs.csstack.WebViewClient mClient;
    private ShareActionProvider mShareActionProvider;

    public String urltoload="URL_TO_LOAD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        mWebView=(WebView)findViewById(R.id.webview);
        mClient=new nanborklabs.csstack.WebViewClient();
        WebSettings ws=mWebView.getSettings();
        ws.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        if (mWebView==null){
            Log.d("webview","webview is null");
        }
        else {
            Log.d("webview","webview is not null");
        }
       if (getIntent()!=null){

               urltoload=getIntent().getStringExtra("URL");
           mWebView.setWebViewClient(mClient);
           mWebView.loadUrl(urltoload);
           }
       }



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.webviewmenu,menu);
        MenuItem menuItem=menu.findItem(R.id.menu_item_share);
        mShareActionProvider=(ShareActionProvider)MenuItemCompat.getActionProvider(menuItem);
        final  Intent intent =new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"Check out the link : "+urltoload);

        mShareActionProvider.setShareIntent(intent);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_share:
                shareLink();
                break;
            case R.id.open_chrome:
                openBrowser();
            break;
            case R.id.fav:
                break;
        }
        return true;
    }

    private void shareLink() {

    }

    private void openBrowser() {
        final Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urltoload));
        startActivity(intent);
    }
}


