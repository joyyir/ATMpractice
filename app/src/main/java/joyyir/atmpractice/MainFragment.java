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

public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button btnTransfer = (Button)view.findViewById(R.id.btnMainTransfer);
        btnTransfer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new FraudCautionFragment());
                    }
                };
                handler.sendEmptyMessageDelayed(0, 2500);
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new ReadingCardFragment());
            }
        });

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
