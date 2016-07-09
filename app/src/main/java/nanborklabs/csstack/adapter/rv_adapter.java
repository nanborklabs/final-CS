package nanborklabs.csstack.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import nanborklabs.csstack.R;

/**
 * Created by nandhu on 9/7/16.
 */
public class rv_adapter extends RecyclerView.Adapter<rv_adapter.ItemHolder> {


    public ArrayList<String> point;
    public Point_clicked callback;
    public View mView;

    public rv_adapter(ArrayList<String> points,Point_clicked callback) {
        this.callback = callback;
        this.point=points;
    }

    public static class ItemHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        rv_adapter.Point_clicked callback;

        public ItemHolder(View itemView, Point_clicked callback1) {
            super(itemView);
            mTextView=(TextView) itemView;
            this.callback=callback1;
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback !=null){
                        callback.point_clicked(getAdapterPosition());
                    }

                }
            });
        }
    }
    @Override
    public rv_adapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       mView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_points,parent,false);
        if (callback==null){
            Log.d("CS_STACK","callback is null");
        }
        return new ItemHolder(mView,callback);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.mTextView.setText(point.get(position));

    }



    @Override
    public int getItemCount() {
        return point.size();
    }


    public interface Point_clicked{
        void point_clicked(int position);
    }
}
