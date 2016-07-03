package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import joyyir.atmpractice.Shared.Common;

public class AmountConfirmFragment extends Fragment {
    public int amount;
    private boolean manFlag, cheonFlag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        amount = 0;

        View view = inflater.inflate(R.layout.fragment_amount_confirm, container, false);
        manFlag = false;
        cheonFlag = false;

        Button btnCancel = (Button)view.findViewById(R.id.btnAmtCancel);
        Button[] btnArr = new Button[10];

        btnArr[0] = (Button)view.findViewById(R.id.btnAmt0);
        btnArr[1] = (Button)view.findViewById(R.id.btnAmt1);
        btnArr[2] = (Button)view.findViewById(R.id.btnAmt2);
        btnArr[3] = (Button)view.findViewById(R.id.btnAmt3);
        btnArr[4] = (Button)view.findViewById(R.id.btnAmt4);
        btnArr[5] = (Button)view.findViewById(R.id.btnAmt5);
        btnArr[6] = (Button)view.findViewById(R.id.btnAmt6);
        btnArr[7] = (Button)view.findViewById(R.id.btnAmt7);
        btnArr[8] = (Button)view.findViewById(R.id.btnAmt8);
        btnArr[9] = (Button)view.findViewById(R.id.btnAmt9);
        Button btnBack = (Button)view.findViewById(R.id.btnAmtBack);
        Button btnDel = (Button)view.findViewById(R.id.btnAmtDel);
        Button btnOk = (Button)view.findViewById(R.id.btnAmtOk);
        Button btnMan = (Button)view.findViewById(R.id.btnAmtMan);
        Button btnCheon = (Button)view.findViewById(R.id.btnAmtCheon);
        Button btnWon = (Button)view.findViewById(R.id.btnAmtWon);

        final EditText et = (EditText)view.findViewById(R.id.etAmt);
        final TextView tvAmountWon = (TextView)view.findViewById(R.id.text_amount_confirm_won);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new GetCardFragment());
            }
        });

        for(int i = 0; i <= 9; i++){
            final int idx = i;
            btnArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    et.getText().append(Integer.toString(idx));
                }
            });
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = et.length();
                if(length > 0)
                    et.getText().delete(length-1, length);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvAmountWon.setText("원");
                manFlag = cheonFlag = false;
                et.getText().clear();
            }
        });

        View.OnClickListener okAndWon = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et.getText().length() > 0)
                    amount = Integer.parseInt(et.getText().toString());
                else
                    amount = 0;
                if(manFlag) amount *= 10000;
                if(cheonFlag) amount *= 1000;
                Common.setTransferAmount(amount);
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new PasswordFragment());
            }
        };
        btnOk.setOnClickListener(okAndWon);
        btnWon.setOnClickListener(okAndWon);

        btnMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!cheonFlag && !manFlag){
                    tvAmountWon.setText("만원");
                    manFlag = true;
                }
            }
        });

        btnCheon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!cheonFlag && !manFlag){
                    tvAmountWon.setText("천원");
                    cheonFlag = true;
                }
            }
        });

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
