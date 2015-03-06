package example.com.chooseclick.drawer;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import example.com.chooseclick.R;


/**
 * Created by Windows on 22-12-2014.
 */
public class drawerAdapter extends RecyclerView.Adapter<drawerAdapter.MyViewHolder>{
    List<drawerInformation> data= Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    public drawerAdapter(Context context, List<drawerInformation> data){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;
    }

    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.drawer_row, parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        drawerInformation current=data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;
        RecyclerView friendList;
        public MyViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.drawer_nameView);
            icon= (ImageView) itemView.findViewById(R.id.drawer_profile);
            friendList=(RecyclerView)itemView.findViewById(R.id.drawerList);
        }
    }
}