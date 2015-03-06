package example.com.chooseclick.drawer;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;


import java.util.ArrayList;
import java.util.List;

import example.com.chooseclick.R;

public class drawerFragment extends Fragment{


    public drawerFragment(){

    }

    private RecyclerView drawer;
    private RecyclerView.LayoutManager drawerLayoutManager;
    private drawerAdapter drawerAdapter;
    private FrameLayout fragContainer;
    private AutoCompleteTextView searchFriend;
    String[] dummyComments = {"Özcan Candağ","Erdem Ürüt","Tutku Sıla Vural","Özge Aksoy",
            "Merve Kaya","Gizem Ergin","Hüseyin Can Dayan","deneme","deneme","deneme","deneme"};

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View layout = inflater.inflate(R.layout.fragment_navigation_drawer,container,false);

        fragContainer = (FrameLayout)layout.findViewById(R.id.containerDrawerImage);

        searchFriend = (AutoCompleteTextView)layout.findViewById(R.id.drawer_search_friend);
        searchFriend.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,dummyComments));

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 11;
        Bitmap blurTemplate = BitmapFactory.decodeResource(getResources(), R.drawable.dota2, options);
        Drawable d = new BitmapDrawable(getActivity().getResources(),blurTemplate);
        fragContainer.setBackground(d);

        drawer = (RecyclerView)layout.findViewById(R.id.drawerList);
        drawer.setHasFixedSize(true);
        drawerAdapter = new drawerAdapter(getActivity(),dummyDataforDrawer());
        drawerLayoutManager=new LinearLayoutManager(getActivity());
        drawer.setLayoutManager(drawerLayoutManager);
        drawer.setAdapter(drawerAdapter);

        return layout;
    }

    public List<drawerInformation> dummyDataforDrawer(){
        List<drawerInformation> dummyData = new ArrayList<>();

        int[] dummyImages = {R.drawable.dmc,R.drawable.dota1,R.drawable.dota2,
                R.drawable.dota2,R.drawable.dota1,R.drawable.dota1,R.drawable.dota2,
                R.drawable.dota2,R.drawable.dota2,R.drawable.dota2,R.drawable.dota2};
        String[] dummyNames = {"Özcan Candağ","Erdem Ürüt","Tutku Sıla Vural","Özge Aksoy",
                "Merve Kaya","Gizem Ergin","Hüseyin Can Dayan","deneme","deneme","deneme","deneme"};

        for(int i =0;i<dummyImages.length;i++){
            drawerInformation current = new drawerInformation();
            current.iconId=dummyImages[i];
            current.title=dummyNames[i];
            dummyData.add(current);
        }

        return dummyData;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }


}
