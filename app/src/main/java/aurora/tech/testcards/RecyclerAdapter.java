package aurora.tech.testcards;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerAdapterViewHolder> {
    private Context mContext;
    private List<Services> svList;
    public ArrayList<Services> svToSend;

    public RecyclerAdapter(Context mContext, List<Services> svList) {
        this.mContext = mContext;
        this.svList = svList;
        svToSend = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards_list_item, null);
        RecyclerAdapter.RecyclerAdapterViewHolder rcv = new RecyclerAdapter.RecyclerAdapterViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapterViewHolder holder, int pos) {
        Services srv = svList.get(pos);
        holder.servName.setText(srv.getServiceTitle());
        if (srv.getServiceID() == 300) {
            holder.servIcon.setVisibility(View.GONE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            holder.servName.setLayoutParams(layoutParams);
        }else{
            holder.servIcon.setVisibility(View.VISIBLE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            holder.servName.setLayoutParams(layoutParams);
        }
        holder.servIcon.setImageDrawable(mContext.getResources().getDrawable(srv.getServiceImage()));
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

                if (svList.get(pos).getServiceID() == 300) {
                    Log.d("OFFRoad", "Clickec item is name = " + svList.get(pos).getServiceTitle());
                    Intent i = new Intent(mContext, ThirdActivity.class);
                    mContext.startActivity(i);
                } else {

                    if (holder.cardRoot.getCardBackgroundColor().getDefaultColor() == -1) {
                        holder.cardRoot.setCardBackgroundColor(Color.parseColor("#E8EC473C"));
                        svToSend.add(svList.get(pos));

                    } else {
                        holder.cardRoot.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        svToSend.remove(svList.get(pos));
                    }
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return svList.size();
    }

    public class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView servIcon;
        private TextView servName;
        private ItemClickListener itemClickListener;
        private CardView cardRoot;

        public RecyclerAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            servIcon = itemView.findViewById(R.id.servIcon);
            servName = itemView.findViewById(R.id.servName);
            cardRoot = itemView.findViewById(R.id.cardRoot);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(view, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic) {
            this.itemClickListener = ic;
        }
    }
}
/*
 private void setToggleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {

                        cardView.setCardBackgroundColor(Color.parseColor("#E8EC473C"));

                    } else {
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    }
                }
            });
        }


    }
 */