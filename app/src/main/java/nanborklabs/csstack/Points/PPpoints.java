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
public class PPpoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;
    RecyclerView.ItemDecoration itemDecoration;


    public PPpoints() {
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
    public void point_clicked(View v,int position) {
        callback.loadUrl(url_to_load.get(position));
    }
    UrLoad callback;

    public static Fragment newInstance(int position) {

        PPpoints frag=new PPpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0: points.add("Language Design");
                points.add("Compilation Vs Interpretation");
                points.add("Types");
                points.add("Binding");
                points.add("Scope");
                points.add("Static Vs Dynamic Binding");


//
                url.add(0,"https://en.wikipedia.org/wiki/Programming_language_theory");
                url.add(1,"http://stackoverflow.com/questions/3265357/compiled-vs-interpreted-languages");
                url.add(2,"https://en.wikipedia.org/wiki/List_of_programming_languages_by_type");
                url.add(3,"https://en.wikipedia.org/wiki/Language_binding");
                url.add(4,"https://en.wikipedia.org/wiki/Scope_(computer_science)");
                url.add(5,"http://stackoverflow.com/questions/19017258/static-vs-dynamic-binding-in-java");

                break;
            case 1: points.add("Expression");
                points.add("Assignment");
                points.add("Control flow");

                points.add("Input/Output");
                points.add("Exception Handling");
                points.add("state Transformation");

                points.add("Partial Function");
                points.add("Dynamic Typing");

                url.add(0,"https://en.wikipedia.org/wiki/Expression_(computer_science)");
                url.add(1,"https://en.wikipedia.org/wiki/Assignment_(computer_science)");
                url.add(2,"https://en.wikipedia.org/wiki/Control_flow");
                url.add(3,"https://en.wikipedia.org/wiki/Input/output");
                url.add(4,"https://en.wikipedia.org/wiki/Exception_handling");
                url.add(5,"https://en.wikipedia.org/wiki/Program_transformation");
                url.add(6,"https://en.wikipedia.org/wiki/Partial_function");
                url.add(7,"https://en.wikipedia.org/wiki/Dynamic_programming_language");

                break;
            case 2:  points.add("Call and Return/Subroutine");
                points.add("Parameter Passing");
                points.add("Function Declaration");

                points.add("Dynamic Arrays");
                points.add("Garbage Collection");
                url.add(0,"https://en.wikipedia.org/wiki/Subroutine");
                url.add(1,"https://en.wikipedia.org/wiki/Parameter_(computer_programming)#Argument_passing");
                url.add(2,"https://en.wikipedia.org/wiki/Function_prototype");
                url.add(3,"https://en.wikipedia.org/wiki/Dynamic_array");
                url.add(4,"https://en.wikipedia.org/wiki/Garbage_collection_(computer_science)");

                break;
            case 3:
                points.add("Imperative Programming");
                points.add("ADA");
                points.add("Perl");

                points.add("Object Oriented Programming");
                points.add("Smalltalk");
                points.add("Functional Programming");
                points.add("Haskell");


                url.add(0,"https://en.wikipedia.org/wiki/Imperative_programming");
                url.add(1,"https://en.wikipedia.org/wiki/Ada_(programming_language)");
                url.add(2,"https://en.wikipedia.org/wiki/Perl");
                url.add(3,"https://en.wikipedia.org/wiki/Object-oriented_programming");
                url.add(4,"https://en.wikipedia.org/wiki/Smalltalk");
                url.add(5,"https://en.wikipedia.org/wiki/Functional_programming");

                url.add(6,"https://en.wikipedia.org/wiki/Haskell_(programming_language)");


                break;
            case 4: points.add("Logic Programming");
                points.add("Event-Driven Programming");
                points.add("Concurrent Programming");

                points.add("Synchronization Strategies");
                points.add("Language Level Mechanism");
                points.add("Scripting Languages.");

                url.add(0,"https://en.wikipedia.org/wiki/Logic_programming");
                url.add(1,"https://en.wikipedia.org/wiki/Event-driven_programming");
                url.add(2,"http://www.emu.edu.tr/aelci/Courses/D-318/D-318-Files/plbook/concurre.htm");
                url.add(3,"http://c2.com/cgi/wiki?SynchronizationStrategies");
                url.add(4,"https://en.wikipedia.org/wiki/Low-level_programming_language");
                url.add(5,"https://en.wikipedia.org/wiki/Scripting_language");

                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}
