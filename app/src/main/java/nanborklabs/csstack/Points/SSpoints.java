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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import java.util.ArrayList;

import nanborklabs.csstack.R;
import nanborklabs.csstack.RecycelerviewDecorator;
import nanborklabs.csstack.RecyclerViewAnim;
import nanborklabs.csstack.UrLoad;
import nanborklabs.csstack.Utild;
import nanborklabs.csstack.adapter.rv_adapter;

/**
 * Created by nandhu on 9/7/16.
 */
public class SSpoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;

    RecyclerView.ItemDecoration itemDecoration;

    public SSpoints() {
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
        mAdapter=null;
        callback=null;
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
        itemDecoration=new RecycelerviewDecorator(ContextCompat.getDrawable(getContext(),R.drawable.divider));

        return mView;
    }

    private void startIntorAnimation() {


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

            mAdapter=new rv_adapter(points_to_show,this,getContext());
        }
        loaded = true;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(itemDecoration);

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

        SSpoints frag=new SSpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:
                points.add("Machine Instructions and Programs");
                points.add("Assemblers");
                points.add("Basic Assembler Functions");

                points.add("Assembler Features");
                points.add("Assembler Design Options");
                points.add("certificates");
                url.add(0,"https://en.wikipedia.org/wiki/Machine_code");
                url.add(1,"https://en.wikipedia.org/wiki/Assembly_language");
                url.add(2,"http://www.cs.princeton.edu/courses/archive/spr11/cos217/lectures/15AssemblyFunctions.pdf");

                url.add(3,"https://en.wikipedia.org/wiki/Assembly_language#Language_design");

                //TODO:find remaining links



                break;
            case 1: points.add("Loader");
                points.add("Linker");
                points.add("Machine-Independent Loader");

                points.add("Dynamic Linking");
                points.add("Object files");
                points.add("Symbols and Relocation");

                url.add(0,"https://en.wikipedia.org/wiki/Loader_(computing)#Dynamic_linkers");
                url.add(1,"https://en.wikipedia.org/wiki/Linker_(computing)");
                url.add(2,"https://en.wikipedia.org/wiki/Cross-platform");

                url.add(3,"https://en.wikipedia.org/wiki/Dynamic_linker");
                url.add(4,"https://en.wikipedia.org/wiki/Object_file");
                url.add(5,"https://en.wikipedia.org/wiki/Relocation_(computing)");
                break;
            case 2:      points.add("Macroprocessors");
                points.add("Machine-Independent Macro");
                points.add("Introduction to Virtual Machines");

                points.add("basic Interpretation");
                points.add("Threaded Interpretation");
                points.add("instruction set");

                points.add("binary translation");
                url.add(0,"https://en.wikipedia.org/wiki/General-purpose_macro_processor");
                url.add(1,"https://en.wikipedia.org/wiki/Macro_(computer_science)#Macros_for_machine-independent_software");
                url.add(2,"https://en.wikipedia.org/wiki/Virtual_machine");
                url.add(3,"https://en.wikipedia.org/wiki/Interpreter_(computing)");
                url.add(4,"https://en.wikipedia.org/wiki/Threaded_code");
                url.add(5,"https://en.wikipedia.org/wiki/Instruction_set");
                url.add(6,"https://en.wikipedia.org/wiki/Instruction_set");
                url.add(7,"https://en.wikipedia.org/wiki/Binary_translation");

                break;
            case 3:  points.add("Pascal P-Code VM");
                points.add("Java VM Architecture");
                points.add("Common Language infrastructre");

                points.add("Dynamic Class Loading");

                url.add(0,"https://en.wikipedia.org/wiki/P-code_machine");
                url.add(1,"https://en.wikipedia.org/wiki/Java_virtual_machine");
                url.add(2,"https://en.wikipedia.org/wiki/Common_Language_Infrastructure");
                url.add(3,"https://en.wikipedia.org/wiki/Dynamic_loading");

                break;
            case 4:
                points.add("Instruction Set Issues");
                points.add("Profiling");
                points.add("Grids");

                points.add("Code optimizations-");
                points.add("Garbage Collection");

                url.add(0,"https://en.wikipedia.org/wiki/Instruction_set#Instruction_set_implementation");
                url.add(1,"https://en.wikipedia.org/wiki/Profiling_(computer_programming)");
                url.add(2,"https://en.wikipedia.org/wiki/Grid_computing");

                url.add(3,"https://en.wikipedia.org/wiki/Code_optimization");
                url.add(4,"https://en.wikipedia.org/wiki/Garbage_collection_(computer_science)");
//                url.add(5,);
                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

