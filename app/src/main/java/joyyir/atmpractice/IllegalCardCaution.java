package joyyir.atmpractice;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import joyyir.atmpractice.Shared.Common;

public class IllegalCardCaution extends Fragment {
    public int amount;
    private boolean manFlag, cheonFlag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_illegal_caution, container, false);

        Button btnCancel = (Button) view.findViewById(R.id.btnIllegalCancel);
        Button btnOk = (Button) view.findViewById(R.id.btnIllegalOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new MainFragment());
                    }
                };
                handler.sendEmptyMessageDelayed(0, Common.DELAY);
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new ReadingCardFragment());
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new GetCardAndReceiptFragment());
            }
        });

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
