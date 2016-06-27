package joyyir.atmpractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static public MainActivity self;

    static public MainActivity getInstance(){
        return self;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        self = this;

        setContentView(R.layout.activity_main);

        replaceFragment(R.id.ll_fragment_atm_screen, new MainFragment());
    }

    public void replaceFragment(int fragAreaId, Fragment newFragment) {
        // replace fragment
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(fragAreaId, newFragment);

        // Commit the transaction
        transaction.commit();
    }
}
