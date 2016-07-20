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
public class computingpoints extends  Fragment implements rv_adapter.Point_clicked{

    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;

    RecyclerView.ItemDecoration itemDecoration;

    public computingpoints() {
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

            mAdapter = new rv_adapter(points_to_show, this,getContext());
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
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
    public void point_clicked(View v,int position) {
        callback.loadUrl(url_to_load.get(position));
    }
    UrLoad callback;


    public static Fragment newInstance(int position) {

        computingpoints frag=new computingpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:   points.add("What is Computer?");
                points.add("Generation & classification");
                points.add("Numbering System");

                points.add("Algorithm");
                points.add("Pseudo code");
                points.add("Flow chart");
                url.add(0,"https://en.wikipedia.org/wiki/Computer");
                url.add(1,"https://en.wikipedia.org/wiki/Fifth_generation_computer#History");
                url.add(2,"https://en.wikipedia.org/wiki/Computer_number_format");

                url.add(3,"https://en.wikipedia.org/wiki/Algorithm");
                url.add(4,"https://en.wikipedia.org/wiki/Pseudocode");
                url.add(5,"https://en.wikipedia.org/wiki/Flowchart");

                break;
            case 1: points.add("Introduction to C");
                points.add("Compilation & Linking");
                points.add("Data types");

                points.add("I/O operation");
                points.add("Decision Making Statements");
                points.add("Looping Statements");

                url.add(0,"https://en.wikipedia.org/wiki/C_(programming_language)");
                url.add(1,"https://www.cs.cf.ac.uk/Dave/C/node3.html");
                url.add(2,"https://en.wikipedia.org/wiki/Data_type");
                url.add(3,"https://en.wikipedia.org/wiki/Input/output");
                url.add(4,"https://en.wikipedia.org/wiki/Conditional_(computer_programming)");
                url.add(5,"https://en.wikipedia.org/wiki/Control_flow#Loops");

                break;
            case 2:   points.add("Array");
                points.add("Types of Array");
                points.add("String Operations");

                points.add("Sorting Operations");
                points.add("Matrix Multiplications");

                url.add(0,"https://en.wikipedia.org/wiki/Array_data_structure");
                url.add(1,"https://en.wikipedia.org/wiki/Array_data_structure#Element_identifier_and_addressing_formulas");
                url.add(2,"https://en.wikipedia.org/wiki/String_operations");

                url.add(3,"https://en.wikipedia.org/wiki/Sorting");
                url.add(4,"https://en.wikipedia.org/wiki/Matrix_multiplication_algorithm");
                break;
            case 3:  points.add("Functions");
                points.add("Parameter Passing");
                points.add("Recursion");

                points.add("Pointers");
                points.add("Array pointer's");

                url.add(0,"https://en.wikipedia.org/wiki/Function_prototype#Uses");
                url.add(1,"https://en.wikipedia.org/wiki/Parameter_(computer_programming)");
                url.add(2,"https://en.wikipedia.org/wiki/Recursion");

                url.add(3,"https://en.wikipedia.org/wiki/Pointer_(computer_programming)");
                url.add(4,"https://en.wikipedia.org/wiki/Pointer_(computer_programming)#C_arrays");

                break;
            case 4:   points.add("Structures");
                points.add("Union");
                points.add("Storage Classes");

                points.add("PreProcessor Directives");
                url.add(0,"https://en.wikipedia.org/wiki/Structured_programming");
                url.add(1,"https://en.wikipedia.org/wiki/Union_type");
                url.add(2,"https://en.wikipedia.org/wiki/C_syntax#Storage_duration_specifiers");

                url.add(3,"https://en.wikipedia.org/wiki/C_preprocessor");

                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }
}
