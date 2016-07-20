package nanborklabs.csstack.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ViewUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import java.util.ArrayList;

import nanborklabs.csstack.R;
import nanborklabs.csstack.Utild;

/**
 * Created by nandhu on 9/7/16.
 */
public class rv_adapter extends RecyclerView.Adapter<rv_adapter.ItemHolder> {


    public ArrayList<String> point;
    public Point_clicked callback;
    public View mView;
    public int last_pos=-1;
    public int Animated_item_count;
    private Context c;
    public rv_adapter(ArrayList<String> points, Point_clicked callback, Context  context) {
        this.callback = callback;
        this.point=points;
        this.c=context;
        Animated_item_count=points.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTextView;
        rv_adapter.Point_clicked callback;

        public ItemHolder(final View itemView, Point_clicked callback1) {
            super(itemView);
            mTextView=(TextView) itemView.findViewById(R.id.points_text);
            itemView.setOnClickListener(this);
            callback=callback1;
            final CardView cardView= (CardView)itemView.findViewById(R.id.card_view);

        }

        @Override
        public void onClick(View v) {
            callback.point_clicked(v,getAdapterPosition());
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
        runEnterAnim(holder.mTextView,position);
        holder.mTextView.setText(point.get(position));

    }

    private void runEnterAnim(View holder, int position) {
        Log.d("Animation",""+position);

        if (position>=Animated_item_count){
            Log.d("Animation","postion one");
            return;
        }
        if (position>last_pos){

            Log.d("Animation","inside if");
            last_pos=position;
            holder.setTranslationY(Utild.getScreenHeight(c));
            holder.animate().translationY(0)
                    .setInterpolator(new DecelerateInterpolator(3.f))
                    .setDuration(700)
                    .start();
        }
    }


    @Override
    public int getItemCount() {
        return point.size();
    }


    public interface Point_clicked{
        void point_clicked(View v,int position);
    }
}
