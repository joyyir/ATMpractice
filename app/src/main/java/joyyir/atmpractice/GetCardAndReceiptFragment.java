package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GetCardAndReceiptFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_card_and_receipt, container, false);
        MainActivity.getInstance().replaceFragment(R.id.ll_fragment_drag, new DragTakeCardReceipt());
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
