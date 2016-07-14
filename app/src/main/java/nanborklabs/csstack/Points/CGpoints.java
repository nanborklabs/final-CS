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
public class CGpoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;
    RecyclerView.ItemDecoration itemDecoration;



    public CGpoints() {
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
        itemDecoration=new RecycelerviewDecorator(ContextCompat.getDrawable(getContext(),R.drawable.divider));
        mRecyclerView.addItemDecoration(itemDecoration);
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

        CGpoints frag=new CGpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:  points.add("Basics");
                points.add("Input Primitives");
                points.add("OpenGL");

                points.add("Output Primitives");

                url.add(0,"https://en.wikipedia.org/wiki/Computer_graphics_(computer_science)");
                url.add(1,"https://en.wikipedia.org/wiki/Geometric_primitive");
                url.add(2,"https://en.wikipedia.org/wiki/OpenGL");

                url.add(3,"https://en.wikibooks.org/wiki/Computer_Graphics/Output_Primitive");


                break;
            case 1:
                points.add("2D Viewing");
                points.add("Window");
                points.add("View Port Transformation");

                points.add("2D Geometric Transormations");
                points.add("Clipping Alorithms");
                url.add(0,"https://en.wikipedia.org/wiki/2D_computer_graphics");
                url.add(1,"https://en.wikipedia.org/wiki/Window_(computing)");
                url.add(2,"https://en.wikipedia.org/wiki/Viewport");

                url.add(3,"https://www.cs.mtsu.edu/~jhankins/files/4250/notes/WinToView/WinToViewMap.html");
                url.add(4,"https://en.wikipedia.org/wiki/Line_clipping");


                break;
            case 2:   points.add("Projections");
                points.add("Three Dimensional Object Representations");
                points.add("Parallel & Perspective Polygons");

                points.add("3D Affine Transforamtions");
                points.add("3D Rotations using Quatemions");
                points.add("Viewing");

                points.add("Visible Surface Identification");
                points.add("Color models");
                url.add(0,"https://en.wikipedia.org/wiki/Graphical_projection");
                url.add(1,"https://en.wikipedia.org/wiki/3D_modeling#Representation");
                url.add(2,"http://www.math.utah.edu/~treiberg/Perspect/Perspect.htm#Parallelx");
                url.add(3,"https://en.wikipedia.org/wiki/Transformation_(function)");
                url.add(4,"https://en.wikipedia.org/wiki/Quaternions_and_spatial_rotation");
                url.add(5,"https://en.wikipedia.org/wiki/Viewing_frustum");
                url.add(6,"https://en.wikipedia.org/wiki/Hidden_surface_determination#Culling_and_Visible_Surface_Determination");
                url.add(7,"https://en.wikipedia.org/wiki/Color_model");
                break;
            case 3:  points.add("Multimedia");
                points.add("Animations");
                points.add("Compression & Types");
                points.add("Image Compression");

                points.add("Video Compression");
                points.add("File Format ");
                points.add("Multimedia Data structres-KD Trees , R-Trees");
              /*  url.add(0,);
                url.add(1,);
                url.add(2,);
                url.add(3,);
                url.add(4,);
                url.add(5,);
                url.add(6,);
                url.add(7,);
                */
                break;
            case 4:  points.add("Authoring Systemsi");
                points.add("Video on Demand");
                points.add("Virtual Reality");

                points.add("Augumented Reality");
                points.add("Content based Retrivel");
                //TODO:find and add urls-5 mins
                url.add(0,"https://en.wikipedia.org/wiki/Authoring_system");
                url.add(1,"https://en.wikipedia.org/wiki/Video_on_demand");
                url.add(2,"https://en.wikipedia.org/wiki/Virtual_reality");

                url.add(3,"https://en.wikipedia.org/wiki/Augmented_reality");
                url.add(4,"https://en.wikipedia.org/wiki/Content-based_image_retrieval");

                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}
