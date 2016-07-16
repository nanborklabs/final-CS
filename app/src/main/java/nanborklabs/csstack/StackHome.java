package nanborklabs.csstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ViewUtils;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;

import nanborklabs.csstack.subjects.AIFrag;
import nanborklabs.csstack.subjects.CGFrag;
import nanborklabs.csstack.subjects.CNFrag;
import nanborklabs.csstack.subjects.ComputerarchFragment;
import nanborklabs.csstack.subjects.CplusFragment;
import nanborklabs.csstack.subjects.DaaFrag;
import nanborklabs.csstack.subjects.DatastructresFrag;
import nanborklabs.csstack.subjects.DbmsFrag;
import nanborklabs.csstack.subjects.FlatFrag;
import nanborklabs.csstack.subjects.JavaFrag;
import nanborklabs.csstack.subjects.MPFrag;
import nanborklabs.csstack.subjects.MobileFrag;
import nanborklabs.csstack.subjects.OSFrag;
import nanborklabs.csstack.subjects.OoadFrag;
import nanborklabs.csstack.subjects.PCDFrag;
import nanborklabs.csstack.subjects.POMFrag;
import nanborklabs.csstack.subjects.PPFrag;
import nanborklabs.csstack.subjects.Parallel;
import nanborklabs.csstack.subjects.SEFrag;
import nanborklabs.csstack.subjects.SSFrag;
import nanborklabs.csstack.subjects.SecurityFrag;
import nanborklabs.csstack.subjects.computingtechniqueFragment;
import nanborklabs.csstack.subjects.prinicplesofCEFragment;

public class StackHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,UrLoad {


    NavigationView left_side;
    NavigationView right_side;
    boolean right_click;
    boolean left_click;
    Fragment subjectFragment;
    public int year_selected;
    public boolean introAnimation;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_home);
      toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState==null){
            introAnimation=true;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        left_side= (NavigationView) findViewById(R.id.nav_view);
        right_side=(NavigationView)findViewById(R.id.right_side);
        left_side.setNavigationItemSelectedListener(this);
        right_side.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.stack_home, menu);

        //Start intoro animation
        if (introAnimation){
            introAnimation=false;
            startIntroAnim();
        }
        return true;
    }

    private void startIntroAnim() {
        int size=toolbar.getHeight();
        toolbar.setTranslationY(-size);
        toolbar.animate().translationY(0)
                .setDuration(400)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setStartDelay(500);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){


            case R.id.first:
                // Handle the camera action
                left_click = true;
                right_side.getMenu().clear();
                right_side.inflateMenu(R.menu.first_year);
                year_selected=1;
                break;


            case R.id.second:
                left_click = true;
                right_side.getMenu().clear();
                right_side.inflateMenu(R.menu.second_year);
                year_selected=2;
                break;
            case  R.id.third:
                left_click = true;
                right_side.getMenu().clear();
                right_side.inflateMenu(R.menu.third_year);
                year_selected=3;
                break;
            case  R.id.fourth:
                left_click = true;
                right_side.getMenu().clear();
                right_side.inflateMenu(R.menu.fourth_year);
                year_selected=4;
                break;
            case R.id.nav_share:
                left_click = true;
                break;

            case  R.id.nav_send:
                left_click = true;
                break;


            //Right side click events

            case R.id.cp:
                right_click = true;
                Log.d("COM_CSTACK", "CP CLICKED");
                subjectFragment = new computingtechniqueFragment();

                break;

            case  R.id.pcp:
                right_click = true;
                subjectFragment = new prinicplesofCEFragment();
                break;
            case  R.id.cplus:
                right_click = true;
                subjectFragment = new CplusFragment();
                break;
            case R.id.ca:
                right_click = true;
                subjectFragment = new ComputerarchFragment();
                break;
            case  R.id.ds:
                right_click = true;
                subjectFragment = new DatastructresFrag();
                break;
            case R.id.dbms:
                right_click = true;
                subjectFragment = new DbmsFrag();
                break;
            case R.id.daa:
                right_click = true;
                subjectFragment = new DaaFrag();
            case R.id.jip:
                right_click = true;
                subjectFragment = new JavaFrag();
                break;
            case  R.id.os:
                right_click = true;
                subjectFragment = new OSFrag();
                break;
            case R.id.se:
                right_click = true;
                subjectFragment = new SEFrag();
                break;
            case R.id.cn:
                right_click = true;
                subjectFragment = new CNFrag();
                break;
            case  R.id.mp:
                right_click = true;
                subjectFragment = new MPFrag();
                break;
            case  R.id.ss:
                right_click = true;
                subjectFragment = new SSFrag();
                break;
            case R.id.flat:
                right_click = true;
                subjectFragment = new FlatFrag();
                break;
            case  R.id.ooad:
                right_click = true;
                subjectFragment = new OoadFrag();
                break;
            case R.id.ai:
                right_click = true;
                subjectFragment = new AIFrag();
                break;
            case R.id.pcd:
                right_click = true;

                subjectFragment = new PCDFrag();
                break;
            case  R.id.cg:
                right_click = true;
                subjectFragment = new CGFrag();
                break;
            case  R.id.paradigms:
                right_click = true;
                subjectFragment = new PPFrag();
                break;
            case  R.id.pom:
                right_click = true;
                subjectFragment = new POMFrag();
                break;
            case  R.id.mobile:
                right_click = true;
                subjectFragment = new MobileFrag();
                break;

            case R.id.parallel:
                right_click = true;
                subjectFragment = new Parallel();
                break;
            case R.id.security:
                right_click = true;
                subjectFragment = new SecurityFrag();
                break;
            default:
                return true;
        }


        if (right_click) {

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            Log.d("COM_CSTACK", "inside if");
            drawer.closeDrawer(GravityCompat.END);
            //       subjectFragment=new TestFragment();
            Log.d("CS_STACK","GOING TO trasact fragment");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frag_holder, subjectFragment)
                    .commit();
            right_click=false;


        }


        if (left_click) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            drawer.openDrawer(GravityCompat.END);
            left_click = false;
        }


        return true;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("year_selected",year_selected);
        Log.d("CS_STACK","Save instance state---avtivity");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("CS_STACK","on Resotre Instance state--------activity");
        int year=savedInstanceState.getInt("year_selected");
        Log.d("CS_STACK------>",""+year);
        if (year==0){
            year=1;
        }
        switch (year){
            case 1:
                right_side.inflateMenu(R.menu.first_year);
                break;
            case 2:
                right_side.inflateMenu(R.menu.second_year);
                break;
            case 3:
                right_side.inflateMenu(R.menu.third_year);
                break;
            case 4:
                right_side.inflateMenu(R.menu.fourth_year);
                break;

        }
    }

    @Override
    public void loadUrl(String url) {
        Log.d("CS_STACK",url);
        final Intent intent=new Intent(this,WebViewActivity.class);
        intent.putExtra("URL",url);
        startActivity(intent);


    }
}
