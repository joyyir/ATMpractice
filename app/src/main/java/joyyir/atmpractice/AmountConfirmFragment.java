package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AmountConfirmFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amount_confirm, container, false);

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

        final EditText et = (EditText)view.findViewById(R.id.etAmt);

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
                et.getText().clear();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new PasswordFragment());
            }
        });

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
