package joyyir.atmpractice;

import android.content.ClipData;
import android.content.ClipDescription;
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

public class DragInsertCardFragment extends Fragment {
    private ImageView imgATMcardHole, imgCard;
    private final String tagImgATMcardHole = "tagImgATMcardHole", tagImgCard = "tagImgCard";
    private View thisView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drag_insert_card, container, false);
        thisView = view;

        LinearLayout llBottom = (LinearLayout)view.findViewById(R.id.ll_drag_insert_card_bottom);
        LinearLayout llTopHole = (LinearLayout)view.findViewById(R.id.ll_drag_insert_card_top_hole);

        imgATMcardHole = (ImageView)view.findViewById(R.id.imgDragInsertCardHole);
        imgCard = (ImageView)view.findViewById(R.id.imgDragInsertCardCard);

        imgATMcardHole.setTag(tagImgATMcardHole);
        imgCard.setTag(tagImgCard);

        imgCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // 태그 생성
                ClipData.Item item = new ClipData.Item( (CharSequence) view.getTag() );

                String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
                ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

                view.startDrag(data, // data to be dragged
                        shadowBuilder, // drag shadow
                        view, // 드래그 드랍할  Vew
                        0 // 필요없은 플래그
                );

                //view.setVisibility(View.INVISIBLE);
                return true;
                //return false;
            }
        });

        //imgCard.setOnDragListener(new DragListener());
        llTopHole.setOnDragListener(new DragListener());
        llBottom.setOnDragListener(new DragListener());

        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    class DragListener implements View.OnDragListener{
        final Drawable changedShape = (Drawable) getResources().getDrawable(R.drawable.red_border);

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            View v = (View) dragEvent.getLocalState();

            switch(dragEvent.getAction()){
                // 이미지를 드래그 시작될때
                case DragEvent.ACTION_DRAG_STARTED:
                    v.setVisibility(View.INVISIBLE);
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

                    if (view == thisView.findViewById(R.id.ll_drag_insert_card_top_hole)) {
                        ViewGroup viewgroup = (ViewGroup) v.getParent();
                        viewgroup.removeView(v);

                        // 카드 들어가는 처리
                        Log.d("DEBUG", "카드 투입됨");
                        Common.insertCard();
                    }
                    else if(view == thisView.findViewById(R.id.ll_drag_insert_card_bottom)){
                        v.setVisibility(View.VISIBLE);
                        Log.d("DEBUG", "원래 있던 자리인데?");
                    }

                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d("DragClickListener", "ACTION_DRAG_ENDED");
                    view.setBackground(null); // go back to normal shape
                    if(!dragEvent.getResult())
                        v.setVisibility(View.VISIBLE);

                default:
                    break;
            }
            return true;
        }
    }
}
