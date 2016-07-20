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
public class cpluspoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;

    RecyclerView.ItemDecoration itemDecoration;

    public cpluspoints() {
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

        cpluspoints frag=new cpluspoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:  points.add("Pointers");
                points.add("Array Pointers");
                points.add("Pointer to Functions");

                points.add("File Handling");
                url.add(0,"https://en.wikipedia.org/wiki/Pointer_(computer_programming)");

                url.add(1,"https://en.wikipedia.org/wiki/Pointer_(computer_programming)#C_arrays");
                url.add(2,"https://en.wikipedia.org/wiki/Function_pointer");
                url.add(3,"https://en.wikipedia.org/wiki/C_file_input/output");


                break;
            case 1: points.add("Introduction");
                points.add("Procedure Vs Object Oriented Programming");
                points.add("Data Types");

                points.add("Control Structures");
                points.add("Strings");
                points.add("User Defined Types");
                url.add(0,"https://en.wikipedia.org/wiki/Object-oriented_programming");

                url.add(1,"https://en.wikipedia.org/wiki/Procedural_programming#Comparison_with_object-oriented_programming");
                url.add(2,"https://en.wikipedia.org/wiki/Data_type");
                url.add(3,"https://en.wikiversity.org/wiki/Control_structures");
                url.add(4,"https://en.wikipedia.org/wiki/String_(computer_science)");
                url.add(5,"https://en.wikipedia.org/wiki/Composite_data_type");

                break;
            case 2: points.add("Classes");
                points.add("Objects");
                points.add("Operator Overloading");
                points.add("Inheritance");

                points.add("Polymorphism");
                points.add("Virtual Functions");
                url.add(0,"https://en.wikipedia.org/wiki/C%2B%2B_classes");

                url.add(1,"https://en.wikipedia.org/wiki/C%2B%2B#Objects");
                url.add(2,"https://en.wikipedia.org/wiki/C%2B%2B#Operators_and_operator_overloading");
                url.add(3,"https://en.wikipedia.org/wiki/Inheritance_(object-oriented_programming)");
                url.add(4,"https://en.wikipedia.org/wiki/Polymorphism_(computer_science)");
                url.add(5,"https://en.wikipedia.org/wiki/Virtual_function#Example");

                break;
            case 3:  points.add("Templates");
                points.add("Name Spaces");
                points.add("Casting");
                points.add("Exception Handling");


                url.add(0,"https://en.wikipedia.org/wiki/Template_(C%2B%2B)");
                url.add(1,"https://en.wikipedia.org/wiki/Namespace");
                url.add(2,"https://en.wikipedia.org/wiki/Type_conversion");
                url.add(3,"https://en.wikipedia.org/wiki/Exception_handling");

                break;
            case 4:    points.add("C++ Stream Classes");
                points.add("Formatted I/O");
                points.add("File Classes");
                points.add("Dynamic Memory Allocation");
                points.add("Standard Template Library");
                url.add(0,"https://en.wikipedia.org/wiki/Input/output_(C%2B%2B)");

                url.add(1,"http://ee.hawaii.edu/~tep/EE160/Book/chap8/subsection2.1.3.2.html");
                url.add(2,"https://en.wikipedia.org/wiki/Class_implementation_file");
                url.add(3,"https://en.wikipedia.org/wiki/New_and_delete_(C%2B%2B)");
                url.add(4,"https://en.wikipedia.org/wiki/Standard_Template_Library");


                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

