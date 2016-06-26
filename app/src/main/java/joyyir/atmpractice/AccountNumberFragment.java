package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AccountNumberFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_number, container, false);

        Button[] btnArr = new Button[10];

        btnArr[0] = (Button)view.findViewById(R.id.btnAccNum0);
        btnArr[1] = (Button)view.findViewById(R.id.btnAccNum1);
        btnArr[2] = (Button)view.findViewById(R.id.btnAccNum2);
        btnArr[3] = (Button)view.findViewById(R.id.btnAccNum3);
        btnArr[4] = (Button)view.findViewById(R.id.btnAccNum4);
        btnArr[5] = (Button)view.findViewById(R.id.btnAccNum5);
        btnArr[6] = (Button)view.findViewById(R.id.btnAccNum6);
        btnArr[7] = (Button)view.findViewById(R.id.btnAccNum7);
        btnArr[8] = (Button)view.findViewById(R.id.btnAccNum8);
        btnArr[9] = (Button)view.findViewById(R.id.btnAccNum9);
        Button btnBack = (Button)view.findViewById(R.id.btnAccNumBack);
        Button btnDel = (Button)view.findViewById(R.id.btnAccNumDel);
        Button btnAccOk = (Button)view.findViewById(R.id.btnAccNumOk);

        final EditText et = (EditText)view.findViewById(R.id.etAccNum);

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

        btnAccOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new AmountConfirmFragment());
            }
        });

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
