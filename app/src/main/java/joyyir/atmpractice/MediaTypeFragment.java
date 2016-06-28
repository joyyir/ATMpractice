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

public class MediaTypeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media_type, container, false);

        Button btnCancel = (Button)view.findViewById(R.id.btnMediaCancel);
        Button btnMediaCash = (Button)view.findViewById(R.id.btnMediaCash);

        Button[] unavailButtonArr = new Button[1];
        unavailButtonArr[0] = (Button)view.findViewById(R.id.btnMediaElec);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new GetCardAndReceiptFragment());
            }
        });

        btnMediaCash.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new InstSelectionFragment());
                    }
                };
                handler.sendEmptyMessageDelayed(0, Common.DELAY);
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new ProcessingFragment());
            }
        });

        View.OnClickListener unavailBtnListener = new Common.ToastClickListener("'현금카드'를 누르세요");

        for(int i = 0; i < 1; i++){
            unavailButtonArr[i].setOnClickListener(unavailBtnListener);
        }

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
