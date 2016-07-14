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
        itemDecoration=new RecycelerviewDecorator(ContextCompat.getDrawable(getContext(),R.drawable.divider));
        mRecyclerView.addItemDecoration(itemDecoration);
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
        loaded = true;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

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

        cpluspoints frag=new cpluspoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:  points.add("Pointers");
                points.add("Array Pointers");
                points.add("Pointer to Functions");
                points.add("File Handling");
                /*url.add(0,);
             /*
             *   url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                 */
                break;
            case 1: points.add("Introduction");
                points.add("Procedure Vs object oriented programming");
                points.add("Data types");
                points.add("Control Structres");
                points.add("Array");
                points.add("Strings");
                points.add("User defined Types");
                /*url.add(0,);
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                */
                break;
            case 2: points.add("Classes");
                points.add("Objects");
                points.add("Operator Overloading");
                points.add("Inheritance");
                points.add("Polymorphism");
                points.add("Virtual Functions");
                /*url.add(0,);
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                */

                break;
            case 3:  points.add("Templates");
                points.add("Name Spaces");
                points.add("Casting");
                points.add("Exception Handling");
                /*url.add(0,);
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                break;
            case 4:    points.add("C++ Stream Classes");
                points.add("Formatted I/O");
                points.add("File Classes");
                points.add("Dynamic Memory Allocation");
                points.add("Standard Template Library"); url.add(0,);
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                */
                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

