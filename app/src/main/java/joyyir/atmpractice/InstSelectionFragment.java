package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class InstSelectionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inst_selection, container, false);

        Button[] btnInstArr = new Button[40];

        Button btnInstCancel = (Button)view.findViewById(R.id.btnInstSelCancel);
        btnInstArr[0] = (Button)view.findViewById(R.id.btnInstShinhan);

        btnInstCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new MainFragment());
            }
        });

        for(int i = 0; i < 1; i++) {
            final int idx = i;
            btnInstArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Common.setReceiverInstCode(idx);
                    MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new AccountNumberFragment());
                }
            });
        }

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
