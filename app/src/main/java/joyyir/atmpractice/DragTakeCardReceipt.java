package joyyir.atmpractice;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import joyyir.atmpractice.Shared.Common;

public class DragTakeCardReceipt extends Fragment {
    private ImageView imgATMcardHole;
    private final String tagImgATMcardHole = "tagImgATMcardHole2";
    private View thisView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drag_take_card_receipt, container, false);
        thisView = view;

        LinearLayout llBottom = (LinearLayout)view.findViewById(R.id.ll_drag_take_card_receipt_bottom);
        LinearLayout llTopHole = (LinearLayout)view.findViewById(R.id.ll_drag_take_card_receipt_hole);

        imgATMcardHole = (ImageView)view.findViewById(R.id.imgDragTakeCardReceiptHole);


        imgATMcardHole.setTag(tagImgATMcardHole);

        imgATMcardHole.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // 태그 생성
                ClipData.Item item = new ClipData.Item( (CharSequence) view.getTag() );

                String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
                ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

                view.startDrag(data, // data to be dragged
                        new CanvasShadow(view),//shadowBuilder, // drag shadow
                        view, // 드래그 드랍할  Vew
                        0 // 필요없은 플래그
                );

                //view.setVisibility(View.INVISIBLE);
                return true;
                //return false;
            }
        });

        DragListener dragListener = new DragListener();
        //imgCard.setOnDragListener(new DragListener());
        llTopHole.setOnDragListener(dragListener);
        llBottom.setOnDragListener(dragListener);

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    class DragListener implements View.OnDragListener{
        final Drawable changedShape = (Drawable) getResources().getDrawable(R.drawable.red_border);

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            View v = (View) dragEvent.getLocalState();
            final ImageView imgCardReceiptHole = (ImageView) v.findViewById(R.id.imgDragTakeCardReceiptHole);

            switch(dragEvent.getAction()){
                // 이미지를 드래그 시작될때
                case DragEvent.ACTION_DRAG_STARTED:
                    //v.setVisibility(View.INVISIBLE);
                    imgCardReceiptHole.setImageResource(R.drawable.atm_card_hole);
                    Log.d("DragClickListener", "ACTION_DRAG_STARTED");
                    break;

                // 드래그한 이미지를 옮길려는 지역으로 들어왔을때
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d("DragClickListener", "ACTION_DRAG_ENTERED");
                    // 이미지가 들어왔다는 것을 알려주기 위해 배경이미지 변경
                    view.setBackground(changedShape);
                    break;

                // 드래그한 이미지가 영역을 빠져 나갈때
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d("DragClickListener", "ACTION_DRAG_EXITED");
                    view.setBackground(null);
                    break;

                // 이미지를 드래그해서 드랍시켰을때
                case DragEvent.ACTION_DROP:
                    Log.d("DragClickListener", "ACTION_DROP");

                    if (view == thisView.findViewById(R.id.ll_drag_take_card_receipt_bottom)) {
                        //ViewGroup viewgroup = (ViewGroup) v.getParent();
                        //viewgroup.removeView(v);

                        // 카드 들어가는 처리
                        Log.d("DEBUG", "카드 완전히 뽑음");
                        Common.takeCard();
                    }
                    else if(view == thisView.findViewById(R.id.ll_drag_take_card_receipt_hole)){
                        imgCardReceiptHole.setImageResource(R.drawable.atm_card_receipt);
                        Log.d("DEBUG", "원래 있던 자리인데?");
                    }
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d("DragClickListener", "ACTION_DRAG_ENDED");
                    view.setBackground(null); // go back to normal shape
                    if(!dragEvent.getResult())
                        imgCardReceiptHole.setImageResource(R.drawable.atm_card_receipt);

                default:
                    break;
            }
            return true;
        }
    }

    class CanvasShadow extends View.DragShadowBuilder {
        final Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.card_receipt);
        int mWidth, mHeight;

        public CanvasShadow(View view) {
            super(view);
            //mWidth = view.getWidth();//좌표를 가져와서 멤버 변수에 넣어둠.
            mWidth = image.getWidth();
            //mWidth = (int)(1.5 * view.getWidth());
            //mHeight = view.getHeight();//좌표를 가져와서 멤버 변수에 넣어둠.
            mHeight = image.getHeight();
            //mHeight = (int)(1.5 * (view.getWidth() * image.getHeight()) / image.getWidth());
        }

        @Override
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
            //섀도우의 크기와 중심점의 좌표를 지정하는 메소드임
            shadowSize.set(mWidth/10, mHeight/10);//사이즈 지정
            shadowTouchPoint.set(mWidth/30, mHeight/30);//중심점 지정
        }

        @Override
        public void onDrawShadow(Canvas canvas) {
            Rect src = new Rect(0, 0, mWidth, mHeight);
            Rect dst = new Rect(0, 0, mWidth / 10, mHeight / 10);
            canvas.drawBitmap(image, null, dst, null);
            //super.onDrawShadow(canvas);
            //canvas.drawBitmap(image, 0, 0, null);
        }
    }
}
