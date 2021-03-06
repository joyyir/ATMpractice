package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import joyyir.atmpractice.Shared.Common;

public class FraudCautionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fraud_caution, container, false);

        Button btnOk = (Button)view.findViewById(R.id.btnFraudOk);
        Button btnCancel = (Button)view.findViewById(R.id.btnFraudCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Common.isCardInserted()) {
                    MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new GetCardFragment());
                }
                else{
                    MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new MainFragment());
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Common.isCardInserted()) {
                    MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new TransferTypeFragment());
                }
                else{
                    MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new MediaType2Fragment());
                }
            }
        });
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
