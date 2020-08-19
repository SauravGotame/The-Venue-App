package e.sauravgt.thevenueapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import e.sauravgt.thevenueapp.Database.Common;
import e.sauravgt.thevenueapp.Model.Request;
import e.sauravgt.thevenueapp.ViewHolder.OrderViewHolder;

public class OrderStatus extends AppCompatActivity {



    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Request,OrderViewHolder> adapter;
    FirebaseDatabase database;
    DatabaseReference requests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        //Firebase
        database = FirebaseDatabase.getInstance();
        requests = database.getReference("Requests"); // find "Requests" from firebase databse

        recyclerView = (RecyclerView)findViewById(R.id.listOrders);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        loadOrders (Common.currentUser.getPhone());
    }

    private void loadOrders(String phone) {
        adapter = new FirebaseRecyclerAdapter<Request, OrderViewHolder>(
                Request.class,
                R.layout.order_layout,
                OrderViewHolder.class,
                requests.orderByChild("phone")
                .equalTo(phone)
        ) {
            @Override
            protected void populateViewHolder(OrderViewHolder viewHolder, Request model, int position) {
                   viewHolder.txtOrderId.setText(adapter.getRef(position).getKey());
                   viewHolder.txtOrderStatus.setText(convertCodeToStatus(model.getStatus()));
                   viewHolder.txtOrderAddress.setText(model.getDate()); // "Address" is equals to "Date". In the databse it is named as "Date" under Requests. Just named it different here
                   viewHolder.txtOrderPhone.setText(model.getPhone());
            }
        };
        recyclerView.setAdapter(adapter);
    }

    private String convertCodeToStatus(String status) {
        if(status.equals("0"))
            return "Booking Request Placed";
        else if (status.equals("1"))
            return "Booking Confirmed";   // All booking request will save as 0 by default. This can later be changed to 1 when it gets saved to the database
            else
                return "Booking Placed";
    }
}
