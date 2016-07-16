package nanborklabs.csstack.Points;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import nanborklabs.csstack.R;
import nanborklabs.csstack.RecycelerviewDecorator;
import nanborklabs.csstack.RecyclerViewAnim;
import nanborklabs.csstack.UrLoad;
import nanborklabs.csstack.adapter.rv_adapter;

/**
 * Created by nandhu on 9/7/16.
 */
public class Pompoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;

    RecyclerView.ItemDecoration itemDecoration;

    public Pompoints() {
        super();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        url_to_load=null;
        points_to_show=null;
        mAdapter=null;callback=null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callback=(UrLoad)(getParentFragment().getContext());

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView=inflater.inflate(R.layout.points_showing,container,false);
        if (getArguments()==null){
            throw new NullPointerException("Arguments null");
        }
        else {
            //Arguments present , string array
            points_to_show=new ArrayList<>();
            points_to_show=getArguments().getStringArrayList("points");
            url_to_load=getArguments().getStringArrayList("url");

            mAdapter=new rv_adapter(points_to_show,this,getContext());
            loaded=true;
        }

        mRecyclerView=(RecyclerView)mView.findViewById(R.id.points_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerViewAnim.startIntroAnim(mRecyclerView,getContext());
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (points_to_show == null) {
            points_to_show = new ArrayList<>();
            points_to_show = getArguments().getStringArrayList("points");
        }
        if (url_to_load == null) {

            url_to_load = getArguments().getStringArrayList("url");
        }
        if (mAdapter == null) {

            mAdapter=new rv_adapter(points_to_show,this,getContext());
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            mRecyclerView.setAdapter(mAdapter);
        }

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void point_clicked(int position) {
        callback.loadUrl(url_to_load.get(position));
    }
    UrLoad callback;


    public static Fragment newInstance(int position) {

        Pompoints frag=new Pompoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0: points.add("Introduction");
                points.add("Manager Roles and Skills");
                points.add("Evolution");

                points.add("Approaches to Management");
                points.add("Types of Business Organisation");
                points.add("Companies-public, private");
                points.add("Organisation cultre");
                url.add(0,"https://en.wikipedia.org/wiki/Management");
                url.add(1,"https://en.wikipedia.org/wiki/Management#Topics");
                url.add(2,"https://en.wikipedia.org/wiki/Management#Historical_development");
                url.add(3,"https://en.wikipedia.org/wiki/Management#Policies_and_strategies_in_the_planning_process");
                url.add(4,"https://en.wikipedia.org/wiki/Types_of_business_entity");
                url.add(5,"https://en.wikipedia.org/wiki/Company#Types");
                url.add(6,"https://en.wikipedia.org/wiki/Organizational_culture");
//                url.add(7,);

                break;
            case 1:  points.add("Organisation chart");
                points.add("Organisation Structre");
                points.add("Line of Staff");
                points.add("Departmentalisation");
                points.add("Job designation");
                points.add("Human Resource Management");
                url.add(0,"https://en.wikipedia.org/wiki/Organizational_chart");
                url.add(1,"https://en.wikipedia.org/wiki/Organizational_structure");
                url.add(2,"https://en.wikipedia.org/wiki/Staff_and_line");
                url.add(3,"https://en.wikipedia.org/wiki/Departmentalization");
                url.add(4,"https://en.wikipedia.org/wiki/Corporate_titlehR");
                url.add(5,"https://en.wikipedia.org/wiki/Human_resource_management");

                break;
            case 2:   points.add("Organisation chart");
                points.add("Organisation Structre");
                points.add("Line of Staff");
                points.add("Departmentalisation");
                points.add("Job designation");
                points.add("Human Resource Management");
                url.add(0,"www");
                /*
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                url.add(8,);
                url.add(9,);
                url.add(10,);
                url.add(11,);
                */
                break;
            case 3: points.add("Foundations of Individual and  group Behaviour");
                points.add("Motivation Theories");
                points.add("leadership");

                points.add("Types and Theories of leadership");
                points.add("Communication and process");
                url.add(0,"https://en.wikipedia.org/wiki/Group_dynamics");
                url.add(1,"https://en.wikipedia.org/wiki/Motivation");
                url.add(2,"https://en.wikipedia.org/wiki/Leadership");
                url.add(3,"https://en.wikipedia.org/wiki/Business_communication");
                url.add(4,"https://en.wikipedia.org/wiki/Three_levels_of_leadership_model");

                break;
            case 4:   points.add("System and Process controlling");


                points.add("Productivity and Management");
                points.add("Control and perfomance");
                points.add("Reporting");
                url.add(0,"https://en.wikipedia.org/wiki/Control_(management)");
                url.add(1,"https://en.wikipedia.org/wiki/Workforce_productivity");
                url.add(2,"https://en.wikipedia.org/wiki/Organizational_effectiveness");
                url.add(3,"https://en.wikipedia.org/wiki/Business_reporting");

                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

