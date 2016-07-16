package nanborklabs.csstack.subjects;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import nanborklabs.csstack.Points.computingpoints;
import nanborklabs.csstack.R;

/**
 * Created by nandhu on 8/7/16.
 */
public class computingtechniqueFragment extends android.support.v4.app.Fragment {
    public View mView;
    ViewPager mViewPager;
    TextSwitcher mSwitcher;
    String text_sub[]={"Introduction","C Program Basics","Arrays & Strings","Function & pointers","Structures & Unions"};
    public PagerAdapter mAdapter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("CS_STACK","on attach view pager");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("CS_STACK","on detach VIEW PAGER");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("CS_STACK","on destroy VIEW PAGER");
        mAdapter=null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("CS_STACK","on destroy view View pager");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CS_STACK","on CREATE====in view pager fragment");


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.viewpager,container,false);
        mViewPager=(ViewPager)mView.findViewById(R.id.pager);
        mAdapter=new ViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(3);
        TextView title =(TextView)mView.findViewById(R.id.subject_title);
        title.setText(R.string.cp);
        setUpTextSwitcher();
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mSwitcher.setText(text_sub[position]);
                        break;
                    case 1:
                        mSwitcher.setText(text_sub[position]);
                        break;
                    case 2:
                        mSwitcher.setText(text_sub[position]);
                        break;
                    case 3:mSwitcher.setText(text_sub[position]);
                        break;
                    case 4:mSwitcher.setText(text_sub[position]);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        TabLayout tabLayout=(TabLayout)mView.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mViewPager);

        Log.d("CS_STACK","on CREATE====in view pager fragment");
        return mView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("CS_STACK","on start====in view pager fragment");
    }
    private void setUpTextSwitcher() {

        mSwitcher=(TextSwitcher)mView.findViewById(R.id.subtitle);
        mSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView=new TextView(getContext());
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(20);
                textView.setTextColor(ContextCompat.getColor(getContext(),R.color.colorPrimary));
                return textView;

            }
        });
        mSwitcher.setText(text_sub[0]);
        Animation in= AnimationUtils.loadAnimation(getContext(),android.R.anim.slide_in_left);
        Animation out=AnimationUtils.loadAnimation(getContext(),android.R.anim.slide_out_right);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);
    }
    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("CS_STACK","on view created====in view pager fragment");
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public computingpoints showpointsFragment;



        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            Log.d("CS_STACK","VIEW PAGER");

            if (showpointsFragment==null){
                showpointsFragment=new computingpoints();
            }
            else {
                Log.d("CS_STACK","show points fragment is not null");
            }


        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:

                    return "UNIT I";

                case 1:
                    return "UNIT II";

                case 2:
                    return "UNIT III";

                case 3:
                    return "UNIT IV";

                case 4:
                    return "UNIT V";


            }

            return null;


        }

        @Override
        public Fragment getItem(int position) {
            Log.d("CS_STACK","fragment returning from view pager");
            switch (position){
                case 0:
                    return  computingpoints.newInstance(position);

                case 1:
                    return  computingpoints.newInstance(position);
                case 2:
                    return  computingpoints.newInstance(position);
                case 3:
                    return  computingpoints.newInstance(position);
                case 4:
                    return  computingpoints.newInstance(position);

            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            Log.d("CS_STACK","view pager destroy item");



        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.d("CS_STACK","intantiate item view pager");

            return super.instantiateItem(container, position);

        }
    }


}
