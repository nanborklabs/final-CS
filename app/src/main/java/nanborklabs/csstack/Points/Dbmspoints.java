package nanborklabs.csstack.Points;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nanborklabs.csstack.R;
import nanborklabs.csstack.adapter.rv_adapter;

/**
 * Created by nandhu on 9/7/16.
 */
public class Dbmspoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;



    public Dbmspoints() {
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
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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

            mAdapter=new rv_adapter(points_to_show,this);
            loaded=true;
        }
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.points_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
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

            mAdapter = new rv_adapter(points_to_show, this);
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

            mAdapter = new rv_adapter(points_to_show, this);
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

    }


    public static Fragment newInstance(int position) {

        Dbmspoints frag=new Dbmspoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:  points.add("Data");
                points.add("Evolution of Database");
                points.add("DBMS");
                points.add("Data models");
                points.add("Database Architecture");
                points.add("Challenges in Database Systems"); url.add(0,"https://en.wikipedia.org/wiki/Data";);
                url.add(1,"https://en.wikipedia.org/wiki/Database";);
//                url.add(2,)todo:1 min;
                url.add(3,"https://en.wikipedia.org/wiki/Data_model";);
                url.add(4,"https://en.wikipedia.org/wiki/Shard_(database_architecture)#Database_architecture");
                url.add(5,"http://data-informed.com/how-to-address-top-challenges-of-database-management/";);
                url.add(6,);
                url.add(7,);
                break;
            case 1: points.add("ER Diagrams");
                points.add("Relational Model");
                points.add("- Keys");
                points.add("- Relational Algebra");
                points.add("Normalisation");
                points.add("BCNF");
                points.add("Join Dependencies"); url.add(0,"https://en.wikipedia.org/wiki/Entity%E2%80%93relationship_model";);
                url.add(1,"https://en.wikipedia.org/wiki/Key-value_database";);
                url.add(2,"https://en.wikipedia.org/wiki/Relational_algebra";);
                url.add(3,"https://en.wikipedia.org/wiki/Database_normalization";);
                url.add(4,"https://en.wikipedia.org/wiki/Boyce%E2%80%93Codd_normal_form";);
                url.add(5,"https://en.wikipedia.org/wiki/Join_dependency";);

                break;
            case 2: points.add("Introduction to SQL");
                points.add("- Data Constraints");
                points.add("Triggers");
                points.add("Database Security");
                points.add("Embedded SQL");
                points.add("Dynamic SQL");
                points.add("Views"); url.add(0,"https://en.wikipedia.org/wiki/SQL";);
                url.add(1,"http://www.w3schools.com/sql/sql_constraints.asp";);
                url.add(2,"https://en.wikipedia.org/wiki/Database_trigger";);
                url.add(3,"https://en.wikipedia.org/wiki/Database_security";);
                url.add(4,"https://en.wikipedia.org/wiki/Embedded_SQL";);
                url.add(5,"https://docs.oracle.com/cd/B10501_01/appdev.920/a96590/adg09dyn.htm#22315";);
                url.add(6,"https://en.wikipedia.org/wiki/View_(SQL)";);

                break;
            case 3:  points.add("Introduction to Transactions");
                points.add("Transaction Systems");
                points.add("ACID Properties");
                points.add("Two Phase Commit Protocol");
                points.add("Recovery with SQL");
                points.add("Locking Protocols");
                points.add("Deadlocks & Managing Deadlocks");
                points.add("SQL Support for Concurrency"); url.add(0,"https://en.wikipedia.org/wiki/Database_transaction";);
                url.add(1,"https://en.wikipedia.org/wiki/Transaction_processing_system";);
                url.add(2,"https://en.wikipedia.org/wiki/ACID";);
                url.add(3,"https://en.wikipedia.org/wiki/Two-phase_commit_protocol";);
                url.add(4,"https://msdn.microsoft.com/en-us/library/ms187495.aspx";);
                url.add(5,"https://en.wikipedia.org/wiki/Lock_(computer_science)";);
                url.add(6,"https://en.wikipedia.org/wiki/Deadlock";);
                url.add(7,"http://blog.sqlauthority.com/2012/11/15/sql-server-concurrency-basics-guest-post-by-vinod-kumar/";);
                break;
            case 4:   points.add("Indexing & Hashing Techniques");
                points.add("Query Processing & Optimization");
                points.add("Sorting & Joins");
                points.add("Database tuning");
                points.add("Spatial");
                points.add("Temporal Databases");
                points.add("Data Visualisation");
                points.add("Mobile Databases");
                points.add("OODB & XML Databases"); url.add(0,"http://www.tutorialspoint.com/dbms/dbms_hashing.htm";);
                url.add(1,"https://en.wikipedia.org/wiki/Query_optimization";);
                url.add(2,"https://en.wikipedia.org/wiki/Join_(SQL)";);
                url.add(3,"https://en.wikipedia.org/wiki/Database_tuning";);
                url.add(4,"https://en.wikipedia.org/wiki/Spatial_database";);
                url.add(5,"https://en.wikipedia.org/wiki/Temporal_database";);
                url.add(6,"https://en.wikipedia.org/wiki/Data_visualization";);
                url.add(7,"https://en.wikipedia.org/wiki/Mobile_database";);
                url.add(8,"https://en.wikipedia.org/wiki/XML_database";);
                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

