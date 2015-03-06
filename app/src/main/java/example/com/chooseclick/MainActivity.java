package example.com.chooseclick;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import example.com.chooseclick.homeCard.homeCard;
import example.com.chooseclick.homeCard.homeCardAdapter;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private MessageFragment messageFragment;
    private ActionBar actionbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle abdt;
    private FloatingActionButton fab;
    private RecyclerView homeCards;
    private RecyclerView.LayoutManager homeCardsLayoutManager;
    private homeCardAdapter myHomeCardsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolBarAndDrawer();

        homeCards = (RecyclerView)findViewById(R.id.homeCards);
        homeCards.setHasFixedSize(true);

        homeCardsLayoutManager = new LinearLayoutManager(this);
        homeCards.setLayoutManager(homeCardsLayoutManager);

        myHomeCardsAdapter = new homeCardAdapter(this,dummyData());
        homeCards.setAdapter(myHomeCardsAdapter);

        homeCards.setItemAnimator(new DefaultItemAnimator());



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
    public void setUpToolBarAndDrawer() {
        toolbar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        actionbar=getActionBar();

        abdt = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }



        };

        drawerLayout.setDrawerListener(abdt);
        abdt.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame,new MessageFragment(),"deneme");
            transaction.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

