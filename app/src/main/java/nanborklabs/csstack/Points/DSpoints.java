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
public class DSpoints extends Fragment  implements rv_adapter.Point_clicked{
    //the points to show in Recycler view
    public ArrayList<String> points_to_show;
    public ArrayList<String> url_to_load;
    RecyclerView.Adapter mAdapter;
    public boolean loaded;
    RecyclerView mRecyclerView;

    RecyclerView.ItemDecoration itemDecoration;

    public DSpoints() {
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

        DSpoints frag=new DSpoints();
        ArrayList<String> points=new ArrayList<>();
        ArrayList<String> url=new ArrayList<>();
        switch (position){
            case 0:  points.add("Asymptotic Notations");
                points.add("case Analysis");
                points.add("Stacks");
                points.add("Queues");
                points.add("Linked List");
                points.add("Doubly Linked List"); url.add(0,"https://en.wikipedia.org/wiki/Big_O_notation");
                url.add(1,"https://en.wikipedia.org/wiki/Proof_by_exhaustion");
                url.add(2,"https://en.wikipedia.org/wiki/Stack_(abstract_data_type)");
                url.add(3,"https://en.wikipedia.org/wiki/Queue_(abstract_data_type)");
                url.add(4,"https://en.wikipedia.org/wiki/Linked_list");
                url.add(5,"https://en.wikipedia.org/wiki/Doubly_linked_list");

                break;
            case 1: points.add("Trees");
                points.add("Binary Trees");
                points.add("Tree Traversal");
                points.add("Threaded Binary Trees");
                points.add("Graph  Representations");
                points.add("Graph Traversals");
                points.add("Connected Components"); url.add(0,"https://en.wikipedia.org/wiki/Tree_structure");
                url.add(1,"https://en.wikipedia.org/wiki/Binary_tree");
                url.add(2,"https://en.wikipedia.org/wiki/Tree_traversal");
                url.add(3,"https://en.wikipedia.org/wiki/Threaded_binary_tree");
                url.add(4,"https://en.wikipedia.org/wiki/Graph_(abstract_data_type)");
                url.add(5,"https://en.wikipedia.org/wiki/Graph_traversal");
                url.add(6,"https://en.wikipedia.org/wiki/Connected_component_(graph_theory)");

                break;
            case 2: points.add("AVL Trees");
                points.add("Red-Black Trees");
                points.add("Splay Trees");
                points.add("Binary Heap");
                points.add("Leftist Heap"); url.add(0,"https://en.wikipedia.org/wiki/AVL_tree");
                url.add(1,"https://en.wikipedia.org/wiki/Red%E2%80%93black_tree");
                url.add(2,"https://en.wikipedia.org/wiki/Splay_tree");
                url.add(3,"https://en.wikipedia.org/wiki/Binary_heap");
                url.add(4,"https://en.wikipedia.org/wiki/Leftist_tree");


                break;
            case 3:         points.add("Insertion sort");
                points.add("Merge sort");
                points.add("Quick sort");
                points.add("Heap sort");
                points.add("Sorting with Disks");
                points.add("k-way merging");
                points.add("Polyphase merge"); url.add(0,"https://en.wikipedia.org/wiki/Insertion_sort");
                url.add(1,"https://en.wikipedia.org/wiki/Merge_sort");
                url.add(2,"https://en.wikipedia.org/wiki/Quicksort");
                url.add(3,"https://en.wikipedia.org/wiki/Heapsort");
                url.add(4,"https://en.wikipedia.org/wiki/External_sorting");
                url.add(5,"https://en.wikipedia.org/wiki/Merge_algorithm#K-way_merging");
                url.add(6,"https://en.wikipedia.org/wiki/Polyphase_merge_sort");

                break;
            case 4:  points.add("Linear Search");
                points.add("Binary Search ");
                points.add("Hash Tables");
                points.add("Overflow Handling");
                points.add("Cylinder Surface Indexing");
                points.add("Hash Index");
                points.add("B-Tree Indexing"); url.add(0,"https://en.wikipedia.org/wiki/Linear_search");
                url.add(1,"https://en.wikipedia.org/wiki/Binary_search_algorithm");
                url.add(2,"https://en.wikipedia.org/wiki/Hash_table");
                url.add(3,"https://en.wikipedia.org/wiki/Hilbert_R-tree#Overflow_handling");
                url.add(4,"http://knowsh.com/NotesSearch/NotesDetail/130159/Files,-Query,-Query-Type,-Index-Techniques---Cylinder-surface-indexing,-Hashed-indexes,-Tree-indexing-B-Trees,-Trie-indexing");
                url.add(5,"http://interactivepython.org/runestone/static/pythonds/SortSearch/Hashing.html");
                url.add(6,"https://en.wikipedia.org/wiki/B-tree");

                break;
        }
        Bundle points_bundle=new Bundle();
        points_bundle.putStringArrayList("points",points);
        points_bundle.putStringArrayList("url",url);
        frag.setArguments(points_bundle);
        return frag;

    }

}

