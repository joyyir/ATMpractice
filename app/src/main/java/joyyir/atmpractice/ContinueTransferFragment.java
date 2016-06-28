package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import joyyir.atmpractice.Shared.Common;

public class ContinueTransferFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_continue_transfer, container, false);

        TextView tvAmount = (TextView) view.findViewById(R.id.text_continue_transfer_amount);

        Button btnSMS = (Button) view.findViewById(R.id.btnContSMS);
        Button btnFavorite = (Button) view.findViewById(R.id.btnContFavorite);
        Button btnContinue = (Button) view.findViewById(R.id.btnContCont);
        Button btnExit = (Button) view.findViewById(R.id.btnContExit);

        Button[] unavailButtonArr = new Button[1];
        unavailButtonArr[0] = btnContinue;

        final CheckBox cbSMS = (CheckBox) view.findViewById(R.id.cbContSMS);
        final CheckBox cbFavorite = (CheckBox) view.findViewById(R.id.cbContFavorite);

        tvAmount.setText(Integer.toString(Common.getTransferAmount()) + " 원");

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbSMS.isChecked())
                    cbSMS.setChecked(false);
                else
                    cbSMS.setChecked(true);
            }
        });

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbFavorite.isChecked())
                    cbFavorite.setChecked(false);
                else
                    cbFavorite.setChecked(true);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new ReceiptSelectionFragment());
            }
        });



        View.OnClickListener unavailBtnListener = new Common.ToastClickListener("'종료'를 누르세요");

        for(int i = 0; i < 1; i++){
            unavailButtonArr[i].setOnClickListener(unavailBtnListener);
        }

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
