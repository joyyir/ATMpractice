package joyyir.atmpractice;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import joyyir.atmpractice.Shared.Common;

public class MainFragment extends Fragment {
    View thisView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        thisView = view;

        Button btnTransfer = (Button)view.findViewById(R.id.btnMainTransfer);

        Button[] unavailButtonArr = new Button[9];
        unavailButtonArr[0] = (Button)view.findViewById(R.id.btnMainWithdrawal);
        unavailButtonArr[1] = (Button)view.findViewById(R.id.btnMainReceipt);
        unavailButtonArr[2] = (Button)view.findViewById(R.id.btnMainUpdateBook);
        unavailButtonArr[3] = (Button)view.findViewById(R.id.btnMainExchange);
        unavailButtonArr[4] = (Button)view.findViewById(R.id.btnMainInquery);
        unavailButtonArr[5] = (Button)view.findViewById(R.id.btnMainCreditCard);
        unavailButtonArr[6] = (Button)view.findViewById(R.id.btnMainMobile);
        unavailButtonArr[7] = (Button)view.findViewById(R.id.btnMainTax);
        unavailButtonArr[8] = (Button)view.findViewById(R.id.btnMainOther);

        btnTransfer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(Common.isCardInserted()) {
                    MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new FraudCautionFragment());
                }
                else{
                    Toast toast = Toast.makeText(getContext().getApplicationContext(), "먼저 카드를 넣으세요", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });

        View.OnClickListener unavailBtnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Common.isCardInserted()){
                    Toast toast = Toast.makeText(getContext().getApplicationContext(), "'계좌이체'를 누르세요", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(getContext().getApplicationContext(), "먼저 카드를 넣으세요", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        };

        for(int i = 0; i < 9; i++){
            unavailButtonArr[i].setOnClickListener(unavailBtnListener);
        }

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        Button btnMainUpdateBook = (Button) thisView.findViewById(R.id.btnMainUpdateBook);
        Button btnMainExchange = (Button) thisView.findViewById(R.id.btnMainExchange);
        final Drawable redButton = (Drawable) getResources().getDrawable(R.drawable.main_red_button);
        final Drawable normalButton = (Drawable) getResources().getDrawable(R.drawable.main_normal_button);

        if(Common.isCardInserted()){
            btnMainUpdateBook.setVisibility(View.INVISIBLE);
            btnMainExchange.setBackground(redButton);
            btnMainExchange.setText("취소");
        }
        else{
            MainActivity.getInstance().replaceFragment(R.id.ll_fragment_drag, new DragInsertCardFragment());
            btnMainUpdateBook.setVisibility(View.VISIBLE);
            btnMainExchange.setBackground(normalButton);
            btnMainExchange.setText("LINEPAY");
        }
    }


}
