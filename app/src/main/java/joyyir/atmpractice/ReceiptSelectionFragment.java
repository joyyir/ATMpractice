package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ReceiptSelectionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receipt_selection, container, false);

        TextView tvAmount = (TextView) view.findViewById(R.id.text_receipt_selection_amount);
        final CheckBox cbCont = (CheckBox) view.findViewById(R.id.cbReceiptCont);
        Button btnCont = (Button) view.findViewById(R.id.btnReceiptCont);
        Button btnPrint = (Button) view.findViewById(R.id.btnReceiptPrint);
        Button btnOmit = (Button) view.findViewById(R.id.btnReceiptOmit);

        tvAmount.setText(Integer.toString(Common.getTransferAmount()) + " 원");

        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbCont.isChecked())
                    cbCont.setChecked(false);
                else
                    cbCont.setChecked(true);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new GetCardAndReceiptFragment());
            }
        };
        btnOmit.setOnClickListener(listener);
        btnPrint.setOnClickListener(listener);

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
