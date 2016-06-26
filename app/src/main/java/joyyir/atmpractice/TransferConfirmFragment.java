package joyyir.atmpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TransferConfirmFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transfer_confirm, container, false);

        TextView tvInstName = (TextView) view.findViewById(R.id.text_transfer_confirm_inst_name);
        TextView tvAccount = (TextView) view.findViewById(R.id.text_transfer_confirm_account_number);
        TextView tvReceiverName = (TextView) view.findViewById(R.id.text_transfer_confirm_name);
        TextView tvAmount = (TextView) view.findViewById(R.id.text_transfer_confirm_amount);
        TextView tvAmount2 = (TextView) view.findViewById(R.id.text_transfer_confirm_amount2);
        TextView tvFee = (TextView) view.findViewById(R.id.text_transfer_confirm_fee);
        TextView tvSenderName = (TextView) view.findViewById(R.id.text_transfer_confirm_sender);

        tvInstName.setText(Common.getInstitutionName());
        tvAccount.setText(Common.getReceiverAccountNumber());
        tvAmount.setText(Integer.toString(Common.getTransferAmount()) + " 원");
        tvAmount2.setText(Integer.toString(Common.getTransferAmount()));

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
