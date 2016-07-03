package joyyir.atmpractice;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import joyyir.atmpractice.Shared.Common;

public class PasswordFragment extends Fragment {
    private String password;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_password, container, false);
        password = "";

        Button btnCancel = (Button)view.findViewById(R.id.btnPasswordCancel);
        Button[] btnArr = new Button[10];

        btnArr[0] = (Button)view.findViewById(R.id.btnPassword0);
        btnArr[1] = (Button)view.findViewById(R.id.btnPassword1);
        btnArr[2] = (Button)view.findViewById(R.id.btnPassword2);
        btnArr[3] = (Button)view.findViewById(R.id.btnPassword3);
        btnArr[4] = (Button)view.findViewById(R.id.btnPassword4);
        btnArr[5] = (Button)view.findViewById(R.id.btnPassword5);
        btnArr[6] = (Button)view.findViewById(R.id.btnPassword6);
        btnArr[7] = (Button)view.findViewById(R.id.btnPassword7);
        btnArr[8] = (Button)view.findViewById(R.id.btnPassword8);
        btnArr[9] = (Button)view.findViewById(R.id.btnPassword9);
        Button btnBack = (Button)view.findViewById(R.id.btnPasswordBack);
        Button btnDel = (Button)view.findViewById(R.id.btnPasswordDel);

        final EditText et = (EditText)view.findViewById(R.id.etPassword);

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
                    password += Integer.toString(idx);
                    Log.i("DEBUG", "current password: " + password);
                    et.getText().append("*");
                    if(password.length() == 4){
                        Handler handler = new Handler(){
                            @Override
                            public void handleMessage(Message msg) {
                                super.handleMessage(msg);
                                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new TransferConfirmFragment());
                            }
                        };
                        handler.sendEmptyMessageDelayed(0, Common.DELAY);
                        MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new ProcessingFragment());
                    }
                }
            });
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = et.length();
                if(length > 0) {
                    password = password.substring(0, password.length()-1);
                    Log.i("DEBUG", "current password: " + password);
                    et.getText().delete(length - 1, length);
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password = "";
                et.getText().clear();
            }
        });

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
