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

public class TransferTypeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transfer_type, container, false);

        Button btnCancel = (Button)view.findViewById(R.id.btnTransferCancel);
        Button btnTransferAccount = (Button)view.findViewById(R.id.btnTransferAccount);

        Button[] unavailButtonArr = new Button[5];
        unavailButtonArr[0] = (Button)view.findViewById(R.id.btnTransferEvent);
        unavailButtonArr[1] = (Button)view.findViewById(R.id.btnTransferApt);
        unavailButtonArr[2] = (Button)view.findViewById(R.id.btnTransferMsg);
        unavailButtonArr[3] = (Button)view.findViewById(R.id.btnTransferAbroad);
        unavailButtonArr[4] = (Button)view.findViewById(R.id.btnTransferPension);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new GetCardAndReceiptFragment());
            }
        });

        btnTransferAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new MediaTypeFragment());
                    }
                };
                handler.sendEmptyMessageDelayed(0, Common.DELAY);
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new ProcessingFragment());
            }
        });

        View.OnClickListener unavailBtnListener = new Common.ToastClickListener("'계좌이체'를 누르세요");


        for(int i = 0; i < 5; i++){
            unavailButtonArr[i].setOnClickListener(unavailBtnListener);
        }

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
