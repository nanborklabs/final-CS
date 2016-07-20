package nanborklabs.csstack;


import android.animation.Animator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.wang.avi.AVLoadingIndicatorView;



public class WebViewFragment extends Fragment {


    public View mView;
    public WebView mWebView;
    private WebViewClient mClient;
    private ShareActionProvider mShareActionProvider;
    public AVLoadingIndicatorView mprogrees;
    int cx;
    int cy;
    public String urltoload="URL_TO_LOAD";



    public WebViewFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
         urltoload=getArguments().getString("URL");
            cx=getArguments().getInt("cx");
            cy=getArguments().getInt("cy");


        }
        if (urltoload==null){
            throw new NullPointerException("NO URL FOund");
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("WEBVIEW","yes in webview framgnet"+urltoload);
       mView=(View) inflater.inflate(R.layout.webview,container,false);

//        mView.setBackgroundColor(Color.BLUE);
//        mView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//              reveal();
//
//            }
//        });
        mWebView=(WebView)mView.findViewById(R.id.webview);
       // mLoadingView=(AnimatedCircleLoadingView)mView.findViewById(R.id.circle_loading_view);
        mClient=new WebViewClient();
        mWebView.setWebViewClient(mClient);
        WebSettings ws=mWebView.getSettings();
        mprogrees=(AVLoadingIndicatorView)mView.findViewById(R.id.avloadingIndicatorView);

        mWebView.loadUrl(urltoload);

        ws.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        return mView;
    }

    private void reveal() {
        Animator an = null;
        int end=Math.max(mView.getWidth(),mView.getHeight());
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
           an= ViewAnimationUtils.createCircularReveal(mView,cx,cy,0,end);
        }

        an.setDuration(3000);
        an.setInterpolator(new AccelerateInterpolator());
        an.start();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.webviewmenu,menu);
        MenuItem menuItem=menu.findItem(R.id.menu_item_share);
        mShareActionProvider=(ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        final Intent intent =new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"Check out the link : "+urltoload);

        mShareActionProvider.setShareIntent(intent);

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

    public class WebViewClient extends android.webkit.WebViewClient {


        public WebViewClient() {
            super();

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mprogrees.setVisibility(View.VISIBLE);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mprogrees.setVisibility(View.INVISIBLE);
//        mCircleLoadingView.stopOk();

        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);



//        mCircleLoadingView.setVisibility(View.VISIBLE);
//        mCircleLoadingView.startIndeterminate();
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
//        mCircleLoadingView.stopFailure();
        }
    }

}
