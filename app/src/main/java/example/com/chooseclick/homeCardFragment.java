package example.com.chooseclick;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class homeCardFragment extends Fragment {

    private RecyclerView homeCards;
    private RecyclerView.LayoutManager homeCardsLayoutManager;
    private homeCardAdapter myHomeCardsAdapter;

    public homeCardFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.homecard_fragment_layout,container,false);
        ((MainActivity) getActivity())
                .setActionBarTitle("ChooseClick");
        homeCards = (RecyclerView)layout.findViewById(R.id.homeCards);
        homeCards.setHasFixedSize(true);

        homeCardsLayoutManager = new LinearLayoutManager(getActivity());
        homeCards.setLayoutManager(homeCardsLayoutManager);

        myHomeCardsAdapter = new homeCardAdapter(getActivity(),dummyData());
        homeCards.setAdapter(myHomeCardsAdapter);

        homeCards.setItemAnimator(new DefaultItemAnimator());
        return layout;
    }

    public List<homeCard> dummyData(){
        List<homeCard> dummyData = new ArrayList<>();

        int[] dummyImages = {R.drawable.dmc,R.drawable.dota1,R.drawable.dota2,
                R.drawable.dota2,R.drawable.dota1,R.drawable.dota1,R.drawable.dota2};

        String[] dummyNames = {"Özcan Candağ","Erdem Ürüt","Tutku Sıla Vural","Özge Aksoy",
                "Merve Kaya","Gizem Ergin","Hüseyin Can Dayan"};

        String[] dummyComments = {"kaowkodgaskogsa","aopdkgwokgaw","pkoagopksdgokas","akopsdogass",
                "akopdkgopwkogaw","akgosokdgasga","akopsdpkogaskodga","aodskgkoasga","akosdgkoasgaskodg"};

        for(int i =0;i<dummyImages.length;i++){
            homeCard current = new homeCard();
            current.imagesID = dummyImages[i];
            current.userNames = dummyNames[i];
            current.comments=dummyComments;
            dummyData.add(current);
        }

        return dummyData;
    }
}
