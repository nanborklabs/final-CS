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
public class Principlespoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;

    RecyclerView.ItemDecoration itemDecoration;

    public Principlespoints() {
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

        Principlespoints frag=new Principlespoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0: points.add("Characterstics of computers");
                points.add("Evolution of computer");

                points.add("computer genreation");
                points.add("Units of Data Storage");
                points.add("Programming Planning");
                url.add(0,"https://en.wikipedia.org/wiki/Computer#Modern_computers");
                url.add(1,"http://wikieducator.org/History_of_Computer_Development_%26_Generation_of_Computer#DEVELOPMENT_OF_COMPUTER");
                url.add(2,"http://wikieducator.org/History_of_Computer_Development_%26_Generation_of_Computer#GENERATION_OF_COMPUTER");
                url.add(3,"https://en.wikipedia.org/wiki/Computer_data_storage");
                url.add(4,"https://en.wikipedia.org/wiki/Logic_model#Program_planning");

                break;
            case 1:  points.add("basic computer Operation");
                points.add("classification of computer");
                points.add("Hardware components");
                points.add("bus architecutre and instruction sets");

                points.add("computer Ethics");
                points.add("Generation of Languages");
                points.add("Compiler & Intreprters");
                points.add("Virtual Machines");
                points.add("Procesural programming");
                points.add("Object Oriented Programming");
                points.add("object oriented programming");
                points.add("Scripting Languages");
                points.add("FUnctional Languages");
                points.add("Language Desgin");
                points.add("Language Syntax & semantics");
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
            case 2:  points.add("Roles of OS");
                points.add("Process Managment");

                points.add("Memory Managment");
                points.add("File Managment");

                points.add("Device Managment");
                points.add("UNIX");

                points.add("Ms-DOS");
                url.add(0,"https://en.wikibooks.org/wiki/A-level_Computing/AQA/Problem_Solving,_Programming,_Operating_Systems,_Databases_and_Networking/Operating_Systems/Role_of_the_operating_system");
                url.add(1,"https://en.wikipedia.org/wiki/Process_management_(computing)");
                url.add(2,"https://en.wikipedia.org/wiki/Memory_management");
                url.add(3,"https://en.wikipedia.org/wiki/File_manager");
                url.add(4,"https://en.wikipedia.org/wiki/Device_driver");
                url.add(5,"https://en.wikipedia.org/wiki/MS-DOS");
                url.add(6,"https://en.wikipedia.org/wiki/Unix");
                url.add(7,"www.google.com");
                break;
            case 3: points.add("File Based Approach");
                points.add("Evolutions of Data models");
                points.add("Data Independence");

                points.add("Data dictionary");
                points.add("Database administrator");
                url.add(0,"http://www.cs.cityu.edu.hk/~helena/cs34622000B/FileApproach.pdf");
                url.add(1,"https://en.wikipedia.org/wiki/Data_modela");
                url.add(2,"https://en.wikipedia.org/wiki/Data_independence");
                url.add(3,"https://en.wikipedia.org/wiki/Data_dictionary");
                url.add(4,"https://en.wikipedia.org/wiki/Database_administrator");

                break;
            case 4:   points.add("Computer Networks");
                points.add("Open Systems Interconnection");
                points.add("Topologies in Network Design");

                points.add("Swtiching Technologies");
                points.add("TCP/IP Network model");
                points.add("Networking devices");

                points.add("Internet");
                points.add("World wide web");
                url.add(0,"https://en.wikipedia.org/wiki/Computer_network");
                url.add(1,"https://en.wikipedia.org/wiki/OSI_model");
                url.add(2,"https://en.wikipedia.org/wiki/Network_topology");
                url.add(3,"https://en.wikipedia.org/wiki/Network_switch#Layer-specific_functionality");
                url.add(4,"https://en.wikipedia.org/wiki/Internet_protocol_suite");
                url.add(5,"https://en.wikipedia.org/wiki/Networking_hardware");
                url.add(6,"https://en.wikipedia.org/wiki/Internet");
                url.add(7,"https://en.wikipedia.org/wiki/World_Wide_Web");
                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

