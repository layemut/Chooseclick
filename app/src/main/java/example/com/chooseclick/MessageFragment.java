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


public class MessageFragment extends Fragment {
    private RecyclerView messageList;
    private RecyclerView.LayoutManager messageListAdapter;
    private MessageAdapter myMessageAdapter;

    public MessageFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.message_fragment_layout,container,false);

        ((MainActivity) getActivity())
                .setActionBarTitle("Mesajlar");
        messageList = (RecyclerView)layout.findViewById(R.id.messageList);
        messageList.setHasFixedSize(true);

        messageListAdapter = new LinearLayoutManager(getActivity());
        messageList.setLayoutManager(messageListAdapter);

        myMessageAdapter = new MessageAdapter(getActivity(),dummyData());
        messageList.setAdapter(myMessageAdapter);

        messageList.setItemAnimator(new DefaultItemAnimator());
        return layout;
    }
    public List<MessageInformation> dummyData(){
        List<MessageInformation> dummyData = new ArrayList<>();

        int[] dummyImages = {R.drawable.dmc,R.drawable.dota1,R.drawable.dota2,
                R.drawable.dota2,R.drawable.dota1,R.drawable.dota1,R.drawable.dota2};

        String[] dummyNames = {"Özcan Candağ","Erdem Ürüt","Tutku Sıla Vural","Özge Aksoy",
                "Merve Kaya","Gizem Ergin","Hüseyin Can Dayan"};

        String[] dummyMessages = {"kaowkodgaskogsa","aopdkgwokgaw","pkoagopksdgokas","akopsdogass",
                "akopdkgopwkogaw","akgosokdgasga","akopsdpkogaskodga","aodskgkoasga","akosdgkoasgaskodg"};

        for(int i =0;i<dummyImages.length;i++){
            MessageInformation current = new MessageInformation();
            current.senderProfilePic = dummyImages[i];
            current.senderName = dummyNames[i];
            current.senderMessage=dummyMessages[i];
            current.time="15:30";
            dummyData.add(current);
        }

        return dummyData;
    }
}
