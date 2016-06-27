package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class InstSelectionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inst_selection, container, false);

        Button[] btnInstArr = new Button[40];

        Button btnInstCancel = (Button)view.findViewById(R.id.btnInstSelCancel);
        btnInstArr[0] = (Button)view.findViewById(R.id.btnInstShinhan);
        btnInstArr[1] = (Button)view.findViewById(R.id.btnInstKook);
        btnInstArr[2] = (Button)view.findViewById(R.id.btnInstNong);
        btnInstArr[3] = (Button)view.findViewById(R.id.btnInstWoori);
        btnInstArr[4] = (Button)view.findViewById(R.id.btnInstHana);
        btnInstArr[5] = (Button)view.findViewById(R.id.btnInstJeju);
        btnInstArr[6] = (Button)view.findViewById(R.id.btnInstGiup);
        btnInstArr[7] = (Button)view.findViewById(R.id.btnInstWhe);
        btnInstArr[8] = (Button)view.findViewById(R.id.btnInstSC);
        btnInstArr[9] = (Button)view.findViewById(R.id.btnInstPost);
        btnInstArr[10] = (Button)view.findViewById(R.id.btnInstCity);
        btnInstArr[11] = (Button)view.findViewById(R.id.btnInstNew);
        btnInstArr[12] = (Button)view.findViewById(R.id.btnInstBusan);
        btnInstArr[13] = (Button)view.findViewById(R.id.btnInstDaegu);
        btnInstArr[14] = (Button)view.findViewById(R.id.btnInstSu);

        Button[] unavailButtonArr = new Button[2];
        unavailButtonArr[0] = (Button)view.findViewById(R.id.btnInstNext);
        unavailButtonArr[1] = (Button)view.findViewById(R.id.btnInstFavorite);

        btnInstCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new MainFragment());
            }
        });

        for(int i = 0; i < 15; i++) {
            final int idx = i;
            btnInstArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Common.setReceiverInstCode(idx);
                    MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new AccountNumberFragment());
                }
            });
        }

        View.OnClickListener unavailBtnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getContext().getApplicationContext(), "사용불가", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        };

        for(int i = 0; i < 2; i++){
            unavailButtonArr[i].setOnClickListener(unavailBtnListener);
        }

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
