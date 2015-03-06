package example.com.chooseclick.homeCard;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import example.com.chooseclick.MessageFragment;
import example.com.chooseclick.R;

public class homeCardAdapter extends RecyclerView.Adapter<homeCardAdapter.MyViewHolder> {

    Context context;
    private LayoutInflater inflater;
    List<homeCard> dataSet = Collections.emptyList();

    public homeCardAdapter(Context context, List<homeCard> dataSet) {
        this.context=context;
        inflater = LayoutInflater.from(context);
        this.dataSet = dataSet;
    }

    @Override
    public homeCardAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.home_list_cards, viewGroup, false);
        MyViewHolder myHolder = new MyViewHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, int i) {
        final int position=i;
        final Runnable setVisibility = new Runnable() {
            @Override
            public void run() {
                viewHolder.postLikedImage.setVisibility(View.INVISIBLE);
            }
        };
        homeCard current = dataSet.get(i);
        ArrayAdapter<String> comments = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,
                current.comments);
        viewHolder.comments.setAdapter(comments);
        viewHolder.sharedImage.setImageResource(current.imagesID);
        viewHolder.userName.setText(current.userNames);
        viewHolder.commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHolder.comments.getVisibility()==View.INVISIBLE){
                    viewHolder.comments.setVisibility(View.VISIBLE);
                }else if(viewHolder.comments.getVisibility()==View.VISIBLE){
                    viewHolder.comments.setVisibility(View.INVISIBLE);
                }
            }
        });
        viewHolder.comments.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        viewHolder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.postLikedImage.setVisibility(View.VISIBLE);
                viewHolder.postLikedImage.postDelayed(setVisibility,2000);
            }
        });
        viewHolder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Başlık");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Deneme"+String.valueOf(position));
                context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size()-1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        ImageView sharedImage,postLikedImage;
        ListView comments;
        FloatingActionButton commentButton,likeButton,shareButton;

        public MyViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.nameTextView);
            sharedImage = (ImageView) itemView.findViewById(R.id.homeCardBaseImage);
            comments = (ListView)itemView.findViewById(R.id.comments);
            commentButton=(FloatingActionButton)itemView.findViewById(R.id.commentfab);
            likeButton=(FloatingActionButton)itemView.findViewById(R.id.likefab);
            postLikedImage=(ImageView)itemView.findViewById(R.id.postLikedImageView);
            shareButton=(FloatingActionButton)itemView.findViewById(R.id.sharefab);
        }
    }
}

