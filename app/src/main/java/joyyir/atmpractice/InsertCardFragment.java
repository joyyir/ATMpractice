package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class InsertCardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert_card, container, false);

        Fragment newFragment = new DragInsertCardFragment();
        newFragment.setArguments(this.getArguments()); // nextFragmentName 넘기기

        MainActivity.getInstance().replaceFragment(R.id.ll_fragment_drag, newFragment);

        Button btnCancel = (Button)view.findViewById(R.id.btnInsertCardCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new MainFragment());
            }
        });

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
