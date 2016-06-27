package joyyir.atmpractice;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Jang Jun Yeong on 2016-06-26.
 */
public class Common {
    static final int DELAY = 2000; // 2초
    static String[] institutionNames = {"신한은행", "국민은행", "농협", "우리은행", "하나은행", "제주은행", "기업은행", "외환은행", "SC은행(제일)", "우체국", "한국씨티은행", "새마을금고", "부산은행", "대구은행", "수협"};

    static int receiverInstCode;
    static String receiverAccountNumber;
    static int transferAmount;

    static boolean isCardInserted = false;


    public static boolean isCardInserted() {
        return isCardInserted;
    }

    public static void setIsCardInserted(boolean isCardInserted) {
        Common.isCardInserted = isCardInserted;
    }

    public static String getInstitutionName(){
        return institutionNames[receiverInstCode];
    }

    public static void insertCard(){
        setIsCardInserted(true);
        MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new IllegalCardCaution());
    }

    public static void takeCard(){
        setIsCardInserted(false);
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new MainFragment());
            }
        };
        handler.sendEmptyMessageDelayed(0, Common.DELAY);
        MainActivity.getInstance().replaceFragment(R.id.ll_fragment_atm_screen, new GoodbyeFragment());
    }

    public static int getReceiverInstCode() {
        return receiverInstCode;
    }

    public static void setReceiverInstCode(int receiverInstCode) {
        Common.receiverInstCode = receiverInstCode;
    }

    public static String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public static void setReceiverAccountNumber(String receiverAccountNumber) {
        Common.receiverAccountNumber = receiverAccountNumber;
    }

    public static int getTransferAmount() {
        return transferAmount;
    }

    public static void setTransferAmount(int transferAmount) {
        Common.transferAmount = transferAmount;
    }
}
