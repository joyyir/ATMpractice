package joyyir.atmpractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import joyyir.atmpractice.Shared.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity {
    static public MainActivity self;
    static public MainActivity getInstance(){
        return self;
    }
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        self = this;
        backPressCloseHandler = new BackPressCloseHandler(this);

        setContentView(R.layout.activity_main);

        replaceFragment(R.id.ll_fragment_atm_screen, new MainFragment());
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }

    public void replaceFragment(int fragAreaId, Fragment newFragment) {
        // replace fragment
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(fragAreaId, newFragment);

        // Commit the transaction
        transaction.commit();
    }
}
