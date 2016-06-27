package joyyir.atmpractice;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MediaTypeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media_type, container, false);

        Button btnMediaCash = (Button)view.findViewById(R.id.btnMediaCash);

        Button[] unavailButtonArr = new Button[1];
        unavailButtonArr[0] = (Button)view.findViewById(R.id.btnMediaElec);

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

        View.OnClickListener unavailBtnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getContext().getApplicationContext(), "'현금카드'를 누르세요", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        };

        for(int i = 0; i < 1; i++){
            unavailButtonArr[i].setOnClickListener(unavailBtnListener);
        }

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
