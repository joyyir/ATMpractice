package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import joyyir.atmpractice.Shared.Common;

public class MediaType2Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media_type2, container, false);

        Button btnCancel = (Button)view.findViewById(R.id.btnMedia2Cancel);
        Button btnCard = (Button)view.findViewById(R.id.btnMedia2Card);

        Button[] unavailButtonArr = new Button[4];
        unavailButtonArr[0] = (Button)view.findViewById(R.id.btnMedia2Book);
        unavailButtonArr[1] = (Button)view.findViewById(R.id.btnMedia2Nothing);
        unavailButtonArr[2] = (Button)view.findViewById(R.id.btnMedia2Phone);
        unavailButtonArr[3] = (Button)view.findViewById(R.id.btnMedia2Elec);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new MainFragment());
            }
        });

        btnCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Common.setIsMediaSelected(true);
                Fragment newFragment = new InsertCardFragment();
                Bundle args = new Bundle();
                args.putString("nextFragmentName", "TransferTypeFragment");
                newFragment.setArguments(args);
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, newFragment);
            }
        });

        View.OnClickListener unavailBtnListener = new Common.ToastClickListener("'카드'를 누르세요");

        for(int i = 0; i < 4; i++){
            unavailButtonArr[i].setOnClickListener(unavailBtnListener);
        }

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
